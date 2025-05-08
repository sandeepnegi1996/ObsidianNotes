# 📑 What is inside @SpringBootApplication annotation

- **🏷️Tags** : #08-05-2022,  #pending #completed #permanent

#### 🔗 Links


## Key Takeaways

## Overview
- `@SpringBootApplication` annotation is basically used with the main class to enable a host of features
- `@Configuration`  : this will do java based configuration
- `@EnableAutoConfiguration` : it enable the auto configuration feature in spring boot
- `@ComponentScan` : enable component scanning
- SpringApplication Class is used to bootstrap and launch the spring application with java main method.
- The SpringApplication class creates the application context from the classpath and launch the application



## @Configuration
1. Enables the java based configuration over XML Configuration

## @ComponentScan
1. it will scan the current and sub packages for the annoted classes and do the bean creation for them
2. it will scan all the beans and register them in the application context
3. 


## @EnableAutoConfiguration
1. Spring Boot looks for auto-configuration beans on its classpath and automatically applies them
2. it enables the auto configuration feature of springboot for you
3. check the jars in the classpath and create and regiser the beans in the application context
4. plus this will also bootstrap sprinboot applicaiton so that you can run the application directly like a java program, it will open in the embedded tomcat server and we can go to the browser and hit the endpoint.
5. 



#### Example code 
```java
package com.hashcodehub.springboot.studentservices;  
  
import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;  
  
@SpringBootApplication  
public class StudentServicesApplication {  
  
   public static void main(String[] args) {  
      SpringApplication.run(StudentServicesApplication.class, args);  
   }  
  
}
```
