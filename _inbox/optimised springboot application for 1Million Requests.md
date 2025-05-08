

# How I Optimized a Spring Boot Application to Handle 1M Requests/Second 🚀


](https://medium.com/@mohitbajaj1995?source=post_page---byline--0cbb2f2823ed---------------------------------------)

Discover the exact techniques I used to scale a Spring Boot application from handling 50K to 1M requests per second. I’ll share the surprising bottlenecks I uncovered, the reactive programming patterns that made the biggest difference, and the configuration tweaks that unlocked massive performance gains.

![](https://miro.medium.com/v2/resize:fit:560/0*1JmsmM9GmCUR1Lf5.png)

> My articles are open to everyone; non-member readers can read the full article by clicking this [**Link**](https://medium.com/@mohitbajaj1995/how-i-optimized-a-spring-boot-application-to-handle-1m-requests-second-0cbb2f2823ed?sk=e0f53b53eaac7073f24a187d8c114587)
> 
> If this article helped you, feel free to 👏 clap to help others discover this content, share with your fellow devs, and let me know your thoughts in the comments.

Last year, our team faced what seemed like an impossible challenge: our Spring Boot application needed to handle a 20x increase in traffic, from 50,000 requests per second to a staggering 1 million. With only three months to deliver and a limited hardware budget, I wasn’t sure if we could pull it off.

Spoiler alert: we did it. Our application now comfortably handles peak loads of 1.2 million requests per second with sub-100ms response times, running on roughly the same infrastructure cost as before.

In this guide, I’ll walk you through exactly how we accomplished this, sharing the real bottlenecks we found, the optimizations that made the biggest difference, and the surprising lessons we learned along the way.

# Measuring the Starting Point ⏱️

Before making any changes, I established clear performance baselines. This step is non-negotiable; without knowing your starting point, you can’t measure progress or identify the biggest opportunities for improvement.

Here’s what our initial metrics looked like:

// Initial Performance Metrics  
Maximum throughput: 50,000 requests/second  
Average response time: 350ms  
95th percentile response time: 850ms  
CPU utilization during peak: 85-95%  
Memory usage: 75% of available heap  
Database connections: Often reaching max pool size (100)  
Thread pool saturation: Frequent thread pool exhaustion

I used a combination of tools to gather these metrics:

- **JMeter**: For load testing and establishing basic throughput numbers
- **Micrometer + Prometheus + Grafana**: For real-time monitoring and visualization
- **JProfiler**: For deep-dive analysis of hotspots in the code
- **Flame graphs**: To identify CPU-intensive methods

With these baseline metrics in hand, I could prioritize optimizations and measure their impact.

# Uncovering the Real Bottlenecks 🔍

Initial profiling revealed several interesting bottlenecks:

1. **Thread pool saturation**: The default Tomcat connector was hitting its limits
2. ==**Database connection contention**== : HikariCP configuration was not optimized for our workload
3. ==**Inefficient serialization**====: Jackson was consuming significant CPU during request/response processing==
4. **Blocking I/O operations**: Especially when calling external services
5. **Memory pressure**: Excessive object creation causing frequent GC pauses

Let’s tackle each of these systematically.

# Reactive Programming: The Game Changer ⚡

The most impactful change was adopting reactive programming with Spring WebFlux. This wasn’t a drop-in replacement; it required rethinking how we structured our application.

I started by identifying services with heavy I/O operations:

// BEFORE: Blocking implementation  
@Service  
public class ProductService {  
    @Autowired  
    private ProductRepository repository;  
      
    public Product getProductById(Long id) {  
        return repository.findById(id)  
                .orElseThrow(() -> new ProductNotFoundException(id));  
    }  
}

> **And converted them to reactive implementations:**

// AFTER: Reactive implementation  
@Service  
public class ProductService {  
    @Autowired  
    private ReactiveProductRepository repository;  
      
    public Mono<Product> getProductById(Long id) {  
        return repository.findById(id)  
                .switchIfEmpty(Mono.error(new ProductNotFoundException(id)));  
    }  
}

> **The controllers were updated accordingly:**

// BEFORE: Traditional Spring MVC controller  
@RestController  
@RequestMapping("/api/products")  
public class ProductController {  
    @Autowired  
    private ProductService service;  
      
    @GetMapping("/{id}")  
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {  
        return ResponseEntity.ok(service.getProductById(id));  
    }  
}

// AFTER: WebFlux reactive controller  
@RestController  
@RequestMapping("/api/products")  
public class ProductController {  
    @Autowired  
    private ProductService service;  
      
    @GetMapping("/{id}")  
    public Mono<ResponseEntity<Product>> getProduct(@PathVariable Long id) {  
        return service.getProductById(id)  
            .map(ResponseEntity::ok)  
            .defaultIfEmpty(ResponseEntity.notFound().build());  
    }  
}

This change alone doubled our throughput by making more efficient use of threads. Instead of one thread per request, WebFlux uses a small number of threads to handle many concurrent requests.

# Database Optimization: The Hidden Multiplier 📊

Database interactions were our next biggest bottleneck. I implemented a three-pronged approach:

# 1. Query Optimization

I used Spring Data’s `@Query` annotation to replace inefficient auto-generated queries:

// BEFORE: Using derived method name (inefficient)  
List<Order> findByUserIdAndStatusAndCreatedDateBetween(  
    Long userId, OrderStatus status, LocalDate start, LocalDate end);

// AFTER: Optimized query  
@Query("SELECT o FROM Order o WHERE o.userId = :userId " +  
       "AND o.status = :status " +  
       "AND o.createdDate BETWEEN :start AND :end " +  
       "ORDER BY o.createdDate DESC")  
List<Order> findUserOrdersInDateRange(  
    @Param("userId") Long userId,   
    @Param("status") OrderStatus status,  
    @Param("start") LocalDate start,   
    @Param("end") LocalDate end);

I also optimized a particularly problematic N+1 query by using Hibernate’s `@BatchSize`:

@Entity  
public class Order {  
    // Other fields  
      
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)  
    @BatchSize(size = 30) // Batch fetch order items  
    private Set<OrderItem> items;  
}

# 2. Connection Pool Tuning

The default HikariCP settings were causing connection contention. After extensive testing, I arrived at this configuration:


spring:  
  datasource:  
    hikari:  
      maximum-pool-size: 30  
      minimum-idle: 10  
      idle-timeout: 30000  
      connection-timeout: 2000  
      max-lifetime: 1800000

The key insight was that more connections isn’t always better; we found our sweet spot at 30 connections, which reduced contention without overwhelming the database.

# 3. Implementing Strategic Caching

I added Redis caching for frequently accessed data:

@Configuration  
@EnableCaching  
public class CacheConfig {  
    @Bean  
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {  
        RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig()  
            .entryTtl(Duration.ofMinutes(10))  
            .disableCachingNullValues();  
              
        return RedisCacheManager.builder(connectionFactory)  
            .cacheDefaults(cacheConfig)  
            .withCacheConfiguration("products",   
                RedisCacheConfiguration.defaultCacheConfig()  
                    .entryTtl(Duration.ofMinutes(5)))  
            .withCacheConfiguration("categories",   
                RedisCacheConfiguration.defaultCacheConfig()  
                    .entryTtl(Duration.ofHours(1)))  
            .build();  
    }  
}

Then applied it to appropriate service methods:

@Service  
public class ProductService {  
    // Other code  
      
    @Cacheable(value = "products", key = "#id")  
    public Mono<Product> getProductById(Long id) {  
        return repository.findById(id)  
            .switchIfEmpty(Mono.error(new ProductNotFoundException(id)));  
    }  
      
    @CacheEvict(value = "products", key = "#product.id")  
    public Mono<Product> updateProduct(Product product) {  
        return repository.save(product);  
    }  
}

This reduced database load by 70% for read-heavy operations.

# Serialization Optimization: The Surprising CPU Saver 💾

Profiling showed that 15% of CPU time was spent in Jackson serialization. I switched to a more efficient configuration:

@Configuration  
public class JacksonConfig {  
    @Bean  
    public ObjectMapper objectMapper() {  
        ObjectMapper mapper = new ObjectMapper();  
          
        // Use afterburner module for faster serialization  
        mapper.registerModule(new AfterburnerModule());  
          
        // Only include non-null values  
        mapper.setSerializationInclusion(Include.NON_NULL);  
          
        // Disable features we don't need  
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);  
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);  
          
        return mapper;  
    }  
}

For our most performance-critical endpoints, I replaced Jackson with Protocol Buffers:

syntax = "proto3";  
package com.example.proto;  
  
message ProductResponse {  
  int64 id = 1;  
  string name = 2;  
  string description = 3;  
  double price = 4;  
  int32 inventory = 5;  
}

@RestController  
@RequestMapping("/api/products")  
public class ProductController {  
    // Jackson-based endpoint  
    @GetMapping("/{id}")  
    public Mono<ResponseEntity<Product>> getProduct(@PathVariable Long id) {  
        // Original implementation  
    }  
      
    // Protocol buffer endpoint for high-performance needs  
    @GetMapping("/{id}/proto")  
    public Mono<ResponseEntity<byte[]>> getProductProto(@PathVariable Long id) {  
        return service.getProductById(id)  
            .map(product -> ProductResponse.newBuilder()  
                .setId(product.getId())  
                .setName(product.getName())  
                .setDescription(product.getDescription())  
                .setPrice(product.getPrice())  
                .setInventory(product.getInventory())  
                .build().toByteArray())  
            .map(bytes -> ResponseEntity.ok()  
                .contentType(MediaType.APPLICATION_OCTET_STREAM)  
                .body(bytes));  
    }  
}

This change reduced serialization CPU usage by 80% and decreased response sizes by 30%.

# Thread Pool and Connection Tuning: The Configuration Magic 🧰

With WebFlux, we needed to tune Netty’s event loop settings:

spring:  
  reactor:  
    netty:  
      worker:  
        count: 16  # Number of worker threads (2x CPU cores)  
      connection:  
        provider:  
          pool:  
            max-connections: 10000  
            acquire-timeout: 5000

For the parts of our application still using Spring MVC, I tuned the Tomcat connector:

server:  
  tomcat:  
    threads:  
      max: 200  
      min-spare: 20  
    max-connections: 8192  
    accept-count: 100  
    connection-timeout: 2000

These settings allowed us to handle more concurrent connections with fewer resources.

# Horizontal Scaling with Kubernetes: The Final Push 🚢

To reach our 1M requests/second target, we needed to scale horizontally. I containerized our application and deployed it to Kubernetes.

FROM openjdk:17-slim  
COPY target/myapp.jar app.jar  
ENV JAVA_OPTS="-XX:+UseG1GC -XX:MaxGCPauseMillis=100 -XX:+ParallelRefProcEnabled"  
ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar

Then configured auto-scaling based on CPU utilization:

apiVersion: autoscaling/v2  
kind: HorizontalPodAutoscaler  
metadata:  
  name: myapp-hpa  
spec:  
  scaleTargetRef:  
    apiVersion: apps/v1  
    kind: Deployment  
    name: myapp  
  minReplicas: 5  
  maxReplicas: 20  
  metrics:  
  - type: Resource  
    resource:  
      name: cpu  
      target:  
        type: Utilization  
        averageUtilization: 70

We also implemented service mesh capabilities with Istio for better traffic management:

apiVersion: networking.istio.io/v1alpha3  
kind: VirtualService  
metadata:  
  name: myapp-vs  
spec:  
  hosts:  
  - myapp-service  
  http:  
  - route:  
    - destination:  
        host: myapp-service  
    retries:  
      attempts: 3  
      perTryTimeout: 2s  
    timeout: 5s

This allowed us to handle traffic spikes efficiently while maintaining resilience.

# Measuring the Results: The Proof 📈

After all optimizations, our metrics improved dramatically:

// Final Performance Metrics  
Maximum throughput: 1,200,000 requests/second  
Average response time: 85ms (was 350ms)  
95th percentile response time: 120ms (was 850ms)  
CPU utilization during peak: 60-70% (was 85-95%)  
Memory usage: 50% of available heap (was 75%)  
Database queries: Reduced by 70% thanks to caching  
Thread efficiency: 10x improvement with reactive programming

The most satisfying result? During our Black Friday sale, the system handled 1.2 million requests per second without breaking a sweat no alerts, no downtime, just happy customers.

# Key Lessons Learned 💡

1. **Measurement is everything**: Without proper profiling, I would have optimized the wrong things.
2. **Reactive isn’t always better**: We kept some endpoints on Spring MVC where it made more sense, using a hybrid approach.
3. **The database is usually the bottleneck**: Caching and query optimization delivered some of our biggest wins.
4. **Configuration matters**: Many of our improvements came from simply tuning default configurations.
5. **Don’t scale prematurely**: We optimized the application first, then scaled horizontally, which saved significant infrastructure costs.
6. **Test with realistic scenarios**: Our initial benchmarks using synthetic tests didn’t match production patterns, leading to misguided optimizations.
7. **Optimize for the 99%**: Some endpoints were impossible to optimize further, but they represented only 1% of our traffic, so we focused elsewhere.
8. **Balance complexity and maintainability**: Some potential optimizations were rejected because they would have made the codebase too complex to maintain.

==Performance optimization isn’t about finding one magic bullet; it’s about methodically identifying and addressing bottlenecks across your entire system.== With Spring Boot, the capabilities are there; you just need to know which levers to pull.

What performance challenges are you facing with your Spring applications? Share your thoughts in the comments

[

## Stop Using @KafkaListener Like This: Spring Boot’s Hidden Anti-Pattern 🛑

### @KafkaListener in Spring Boot makes it super easy to read messages from Kafka. You just add one annotation, connect it…

medium.com



](https://medium.com/@mohitbajaj1995/stop-using-kafkalistener-like-this-spring-boots-hidden-anti-pattern-780a2274f379?source=post_page-----0cbb2f2823ed---------------------------------------)

[

## 10 Advanced Coding Practices Java Seniors Live By

### Discover the battle-tested coding practices that separate senior Java developers from the rest. This advanced guide…

medium.com



](https://medium.com/@mohitbajaj1995/10-advanced-coding-practices-java-seniors-live-by-a7c30515b1b1?source=post_page-----0cbb2f2823ed---------------------------------------)

[

Spring Boot

](https://medium.com/tag/spring-boot?source=post_page-----0cbb2f2823ed---------------------------------------)

[

Spring

](https://medium.com/tag/spring?source=post_page-----0cbb2f2823ed---------------------------------------)

[

Java

](https://medium.com/tag/java?source=post_page-----0cbb2f2823ed---------------------------------------)

[

Software Development

](https://medium.com/tag/software-development?source=post_page-----0cbb2f2823ed---------------------------------------)

[

Microservices

](https://medium.com/tag/microservices?source=post_page-----0cbb2f2823ed---------------------------------------)

1.3K

43

[

![Mohit Bajaj](https://miro.medium.com/v2/resize:fill:96:96/0*U5BCklPusD0Zngsf.jpg)



](https://medium.com/@mohitbajaj1995?source=post_page---post_author_info--0cbb2f2823ed---------------------------------------)

[

## Written by Mohit Bajaj

](https://medium.com/@mohitbajaj1995?source=post_page---post_author_info--0cbb2f2823ed---------------------------------------)

[569 Followers](https://medium.com/@mohitbajaj1995/followers?source=post_page---post_author_info--0cbb2f2823ed---------------------------------------)

·[112 Following](https://medium.com/@mohitbajaj1995/following?source=post_page---post_author_info--0cbb2f2823ed---------------------------------------)

I learn. I code. And I share.

Follow

## Responses (43)

[](https://policy.medium.com/medium-rules-30e5502c4eb4?source=post_page---post_responses--0cbb2f2823ed---------------------------------------)

![sandeep negi](https://miro.medium.com/v2/resize:fill:26:26/1*wqvjvsRIQVNoOtg1-0iXZA.jpeg)

sandeep negi

What are your thoughts?﻿

Cancel

Respond

[

![Chirag Patel](https://miro.medium.com/v2/resize:fill:26:26/1*lrFwvTsuubj56IEf-XypTQ.jpeg)



](https://medium.com/@wakeupchirag?source=post_page---post_responses--0cbb2f2823ed----0-----------------------------------)

[

Chirag Patel



](https://medium.com/@wakeupchirag?source=post_page---post_responses--0cbb2f2823ed----0-----------------------------------)

[

Mar 13

](https://medium.com/@wakeupchirag/its-great-articles-62d2a637ce01?source=post_page---post_responses--0cbb2f2823ed----0-----------------------------------)

Its great articles!!  
  
I have two queries if anyone can help.  
1. How @Query helps to optimize performance rather than auto generated method query  
2.@Cacheable works for reactive return types like Mono or Flux?   
Thanks!!...more

51

1 reply

Reply

[

![Jonathan Valencia](https://miro.medium.com/v2/resize:fill:26:26/1*PwlDxyRSMGnP_l4XdxWHeA.png)



](https://medium.com/@alexisvalenciav?source=post_page---post_responses--0cbb2f2823ed----1-----------------------------------)

[

Jonathan Valencia



](https://medium.com/@alexisvalenciav?source=post_page---post_responses--0cbb2f2823ed----1-----------------------------------)

[

Mar 17

](https://medium.com/@alexisvalenciav/you-got-me-right-here-417fd0449917?source=post_page---post_responses--0cbb2f2823ed----1-----------------------------------)

==Performance optimization isn’t about finding one magic bullet; it’s about methodically identifying and addressing bottlenecks across your entire system.==

You got me right here!. It's really important to understand our systems, their configurations and to pay special attention in infrastructure. Everything is part of our system. Making informed decisions makes a big difference.

Thank you for sharing.

53

Reply

[

![Lucas Fernandes 👨‍💻](https://miro.medium.com/v2/resize:fill:26:26/1*RXkvakwaf00dtfz9oglq6w@2x.jpeg)



](https://medium.com/@lucas.rj.fernandes?source=post_page---post_responses--0cbb2f2823ed----2-----------------------------------)

[

Lucas Fernandes 👨‍💻

he

](https://medium.com/@lucas.rj.fernandes?source=post_page---post_responses--0cbb2f2823ed----2-----------------------------------)

[

Mar 4

](https://medium.com/@lucas.rj.fernandes/great-article-concepts-and-examples-74ff90c6eecb?source=post_page---post_responses--0cbb2f2823ed----2-----------------------------------)

Great article !!! Concepts and examples 👏👏👏

22

1 reply

Reply

See all responses

## More from Mohit Bajaj

![Advanced Spring Boot Concepts Every Java Developer Should Know](https://miro.medium.com/v2/resize:fit:543/0*HnV3wJS6g3egxbMD.png)

[

![Mohit Bajaj](https://miro.medium.com/v2/resize:fill:16:16/0*U5BCklPusD0Zngsf.jpg)



](https://medium.com/@mohitbajaj1995?source=post_page---author_recirc--0cbb2f2823ed----0---------------------10e4d2de_6062_41fa_97bc_0491976ec3bb--------------)

[

Mohit Bajaj

](https://medium.com/@mohitbajaj1995?source=post_page---author_recirc--0cbb2f2823ed----0---------------------10e4d2de_6062_41fa_97bc_0491976ec3bb--------------)

[

## Advanced Spring Boot Concepts Every Java Developer Should Know

### Spring Boot’s simplicity often overshadows its power to handle complex enterprise requirements. In this article, lets see the glimpse of 7…



](https://medium.com/@mohitbajaj1995/advanced-spring-boot-concepts-every-java-developer-should-know-511b054a46cc?source=post_page---author_recirc--0cbb2f2823ed----0---------------------10e4d2de_6062_41fa_97bc_0491976ec3bb--------------)

Apr 11

[

51

1





](https://medium.com/@mohitbajaj1995/advanced-spring-boot-concepts-every-java-developer-should-know-511b054a46cc?source=post_page---author_recirc--0cbb2f2823ed----0---------------------10e4d2de_6062_41fa_97bc_0491976ec3bb--------------)

![Top 7 Powerful Open-Source Tools That Are Changing the Game (2025)](https://miro.medium.com/v2/resize:fit:543/1*vD6q_W04-RX5tiNHNg3m9g.png)

[

![Mohit Bajaj](https://miro.medium.com/v2/resize:fill:16:16/0*U5BCklPusD0Zngsf.jpg)



](https://medium.com/@mohitbajaj1995?source=post_page---author_recirc--0cbb2f2823ed----1---------------------10e4d2de_6062_41fa_97bc_0491976ec3bb--------------)

[

Mohit Bajaj

](https://medium.com/@mohitbajaj1995?source=post_page---author_recirc--0cbb2f2823ed----1---------------------10e4d2de_6062_41fa_97bc_0491976ec3bb--------------)

[

## Top 7 Powerful Open-Source Tools That Are Changing the Game (2025)

### Upgrade your tech stack with these next-gen GitHub projects That are quietly redefining What’s possible



](https://medium.com/@mohitbajaj1995/top-7-powerful-open-source-repos-that-are-changing-the-game-quietly-2025-5e37953c2111?source=post_page---author_recirc--0cbb2f2823ed----1---------------------10e4d2de_6062_41fa_97bc_0491976ec3bb--------------)

Apr 17

[

62





](https://medium.com/@mohitbajaj1995/top-7-powerful-open-source-repos-that-are-changing-the-game-quietly-2025-5e37953c2111?source=post_page---author_recirc--0cbb2f2823ed----1---------------------10e4d2de_6062_41fa_97bc_0491976ec3bb--------------)

![Stop Using Spring Boot to Build Microservices.⏱️](https://miro.medium.com/v2/resize:fit:543/1*-9PGxKiDMWV1Rl0Xw4Udyw.png)

[

![Mohit Bajaj](https://miro.medium.com/v2/resize:fill:16:16/0*U5BCklPusD0Zngsf.jpg)



](https://medium.com/@mohitbajaj1995?source=post_page---author_recirc--0cbb2f2823ed----2---------------------10e4d2de_6062_41fa_97bc_0491976ec3bb--------------)

[

Mohit Bajaj

](https://medium.com/@mohitbajaj1995?source=post_page---author_recirc--0cbb2f2823ed----2---------------------10e4d2de_6062_41fa_97bc_0491976ec3bb--------------)

[

## Stop Using Spring Boot to Build Microservices.⏱️

### Spring Boot was built for rapid monolithic and enterprise web applications. But when you break your architecture into fine-grained…



](https://medium.com/@mohitbajaj1995/stop-using-spring-boot-to-build-microservices-%EF%B8%8F-a6166967f7e3?source=post_page---author_recirc--0cbb2f2823ed----2---------------------10e4d2de_6062_41fa_97bc_0491976ec3bb--------------)

Apr 15

[

39

5





](https://medium.com/@mohitbajaj1995/stop-using-spring-boot-to-build-microservices-%EF%B8%8F-a6166967f7e3?source=post_page---author_recirc--0cbb2f2823ed----2---------------------10e4d2de_6062_41fa_97bc_0491976ec3bb--------------)

![Zig for Go Programmers: Features and Insights](https://miro.medium.com/v2/resize:fit:543/0*C1TwQo5du03QeYOl.png)

[

![Stackademic](https://miro.medium.com/v2/resize:fill:16:16/1*U-kjsW7IZUobnoy1gAp1UQ.png)



](https://medium.com/stackademic?source=post_page---author_recirc--0cbb2f2823ed----3---------------------10e4d2de_6062_41fa_97bc_0491976ec3bb--------------)

In

[

Stackademic

](https://medium.com/stackademic?source=post_page---author_recirc--0cbb2f2823ed----3---------------------10e4d2de_6062_41fa_97bc_0491976ec3bb--------------)

by

[

Mohit Bajaj

](https://medium.com/@mohitbajaj1995?source=post_page---author_recirc--0cbb2f2823ed----3---------------------10e4d2de_6062_41fa_97bc_0491976ec3bb--------------)

[

## Zig for Go Programmers: Features and Insights

### As a Go developer, I’ve found my programming journey remarkably comfortable. Go’s simplicity, strong typing, and pragmatic approach to…



](https://medium.com/stackademic/zig-for-go-programmers-features-and-insights-c600077d4dee?source=post_page---author_recirc--0cbb2f2823ed----3---------------------10e4d2de_6062_41fa_97bc_0491976ec3bb--------------)

Mar 1

[

208

7





](https://medium.com/stackademic/zig-for-go-programmers-features-and-insights-c600077d4dee?source=post_page---author_recirc--0cbb2f2823ed----3---------------------10e4d2de_6062_41fa_97bc_0491976ec3bb--------------)

[

See all from Mohit Bajaj

](https://medium.com/@mohitbajaj1995?source=post_page---author_recirc--0cbb2f2823ed---------------------------------------)

## Recommended from Medium

![Stop Using Lombok: Time to Move On?](https://miro.medium.com/v2/resize:fit:543/1*0b2Bmma1QGEE6zhOYOdHQw.png)

[

![Javarevisited](https://miro.medium.com/v2/resize:fill:16:16/1*ceHirGi683U9Xn6tAlr0jQ.jpeg)



](https://medium.com/javarevisited?source=post_page---read_next_recirc--0cbb2f2823ed----0---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

In

[

Javarevisited

](https://medium.com/javarevisited?source=post_page---read_next_recirc--0cbb2f2823ed----0---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

by

[

Vikrant Dheer

](https://medium.com/@vikrantdheer?source=post_page---read_next_recirc--0cbb2f2823ed----0---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

[

## Stop Using Lombok: Time to Move On?

### Huge thanks to the lot of amazing supporters this week! Your generosity and support fuel my ongoing efforts to create insightful and…



](https://medium.com/javarevisited/stop-using-lombok-time-to-move-on-595a79cbd10f?source=post_page---read_next_recirc--0cbb2f2823ed----0---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

Mar 11

[

443

35





](https://medium.com/javarevisited/stop-using-lombok-time-to-move-on-595a79cbd10f?source=post_page---read_next_recirc--0cbb2f2823ed----0---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

![This new IDE from Google is an absolute game changer](https://miro.medium.com/v2/resize:fit:543/1*f-1HQQng85tbA7kwgECqoQ.png)

[

![Coding Beauty](https://miro.medium.com/v2/resize:fill:16:16/1*ViyWUoh4zqx294no1eENxw.png)



](https://medium.com/coding-beauty?source=post_page---read_next_recirc--0cbb2f2823ed----1---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

In

[

Coding Beauty

](https://medium.com/coding-beauty?source=post_page---read_next_recirc--0cbb2f2823ed----1---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

by

[

Tari Ibaba

](https://medium.com/@tariibaba?source=post_page---read_next_recirc--0cbb2f2823ed----1---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

[

## This new IDE from Google is an absolute game changer

### This new IDE from Google is seriously revolutionary.



](https://medium.com/coding-beauty/new-google-project-idx-fae1fdd079c7?source=post_page---read_next_recirc--0cbb2f2823ed----1---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

Mar 12

[

4.8K

279





](https://medium.com/coding-beauty/new-google-project-idx-fae1fdd079c7?source=post_page---read_next_recirc--0cbb2f2823ed----1---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

![Stop Writing If-Else Trees: Use the State Pattern Instead](https://miro.medium.com/v2/resize:fit:543/1*vF0QEUbReZDxGevlHfGimg.png)

[

![Maxim Gorin](https://miro.medium.com/v2/resize:fill:16:16/1*UVQjiN0-zoWW0jO63B6jew.png)



](https://medium.com/@maxim-gorin?source=post_page---read_next_recirc--0cbb2f2823ed----0---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

[

Maxim Gorin

](https://medium.com/@maxim-gorin?source=post_page---read_next_recirc--0cbb2f2823ed----0---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

[

## Stop Writing If-Else Trees: Use the State Pattern Instead

### Tired of messy conditionals? Learn how the State pattern makes your code cleaner, smarter, and easier to scale.



](https://medium.com/@maxim-gorin/stop-writing-if-else-trees-use-the-state-pattern-instead-1fe9ff39a39c?source=post_page---read_next_recirc--0cbb2f2823ed----0---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

Apr 10

[

1.3K

39





](https://medium.com/@maxim-gorin/stop-writing-if-else-trees-use-the-state-pattern-instead-1fe9ff39a39c?source=post_page---read_next_recirc--0cbb2f2823ed----0---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

![This One Kafka Design Pattern Changed Everything for Us](https://miro.medium.com/v2/resize:fit:543/0*CbsAL2YW604Vrtde.jpg)

[

![The Quantum Yogi](https://miro.medium.com/v2/resize:fill:16:16/1*UER9Z-I88mwjoU6WO7o4NA.jpeg)



](https://medium.com/@kanishksinghpujari?source=post_page---read_next_recirc--0cbb2f2823ed----1---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

[

The Quantum Yogi

](https://medium.com/@kanishksinghpujari?source=post_page---read_next_recirc--0cbb2f2823ed----1---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

[

## This One Kafka Design Pattern Changed Everything for Us

### When we first adopted Kafka, we treated it like a message queue. Producers dumped events, consumers picked them up, and life went on —…



](https://medium.com/@kanishksinghpujari/this-one-kafka-design-pattern-changed-everything-for-us-22ad33ab2e3a?source=post_page---read_next_recirc--0cbb2f2823ed----1---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

Apr 6

[

334

23





](https://medium.com/@kanishksinghpujari/this-one-kafka-design-pattern-changed-everything-for-us-22ad33ab2e3a?source=post_page---read_next_recirc--0cbb2f2823ed----1---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

![Stop Using @KafkaListener Like This: The Spring Boot Anti-Pattern Nobody Talks About🔥](https://miro.medium.com/v2/resize:fit:543/1*7Jfei2SZKFbnvRr2Idwb4Q.png)

[

![Himanshu](https://miro.medium.com/v2/resize:fill:16:16/1*lqWoNSYgFmzjkOSfTNE8gg.png)



](https://medium.com/@himanshu675?source=post_page---read_next_recirc--0cbb2f2823ed----2---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

[

Himanshu

](https://medium.com/@himanshu675?source=post_page---read_next_recirc--0cbb2f2823ed----2---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

[

## Stop Using @KafkaListener Like This: The Spring Boot Anti-Pattern Nobody Talks About🔥

### @KafkaListener is one of the most convenient features in Spring Boot. With just a single annotation, you can start consuming Kafka messages…



](https://medium.com/@himanshu675/stop-using-kafkalistener-like-this-the-spring-boot-anti-pattern-nobody-talks-about-88cdd695455a?source=post_page---read_next_recirc--0cbb2f2823ed----2---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

Apr 16

[

317

11





](https://medium.com/@himanshu675/stop-using-kafkalistener-like-this-the-spring-boot-anti-pattern-nobody-talks-about-88cdd695455a?source=post_page---read_next_recirc--0cbb2f2823ed----2---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

![JDK 24 is Here! Game-Changing Features Every Java Developer Must Know](https://miro.medium.com/v2/resize:fit:543/1*Yb4XcitkslWe2OYOvxfIAg.png)

[

![Amrit Pandey](https://miro.medium.com/v2/resize:fill:16:16/1*B1tf6Pa5k1Vi1Xg2FtvKEg.jpeg)



](https://medium.com/@amritpandey?source=post_page---read_next_recirc--0cbb2f2823ed----3---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

[

Amrit Pandey

](https://medium.com/@amritpandey?source=post_page---read_next_recirc--0cbb2f2823ed----3---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

[

## JDK 24 is Here! Game-Changing Features Every Java Developer Must Know

### 7 new features in JDK 24 that you should know.



](https://medium.com/@amritpandey/jdk-24-is-here-game-changing-features-every-java-developer-must-know-c34754286d02?source=post_page---read_next_recirc--0cbb2f2823ed----3---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

Mar 26

[

189

4





](https://medium.com/@amritpandey/jdk-24-is-here-game-changing-features-every-java-developer-must-know-c34754286d02?source=post_page---read_next_recirc--0cbb2f2823ed----3---------------------1c23523e_b200_4014_9ca0_c7356b140169--------------)

[

See more recommendations

](https://medium.com/?source=post_page---read_next_recirc--0cbb2f2823ed---------------------------------------)

[

Help

](https://help.medium.com/hc/en-us?source=post_page-----0cbb2f2823ed---------------------------------------)

[

Status

](https://medium.statuspage.io/?source=post_page-----0cbb2f2823ed---------------------------------------)

[

About

](https://medium.com/about?autoplay=1&source=post_page-----0cbb2f2823ed---------------------------------------)

[

Careers

](https://medium.com/jobs-at-medium/work-at-medium-959d1a85284e?source=post_page-----0cbb2f2823ed---------------------------------------)

[

Press

](mailto:pressinquiries@medium.com)

[

Blog

](https://blog.medium.com/?source=post_page-----0cbb2f2823ed---------------------------------------)

[

Privacy

](https://policy.medium.com/medium-privacy-policy-f03bf92035c9?source=post_page-----0cbb2f2823ed---------------------------------------)

[

Rules

](https://policy.medium.com/medium-rules-30e5502c4eb4?source=post_page-----0cbb2f2823ed---------------------------------------)

[

Terms

](https://policy.medium.com/medium-terms-of-service-9db0094a1e0f?source=post_page-----0cbb2f2823ed---------------------------------------)

[

Text to speech

](https://speechify.com/medium?source=post_page-----0cbb2f2823ed---------------------------------------)