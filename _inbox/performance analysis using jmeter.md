# 📑 performance analysis using jmeter

- **🏷️Tags** : #07-05-2022,  #pending #completed #permanent

#### 🔗 Links
[code affine](https://www.codeaffine.com/2012/02/10/performance-analysis-of-resthttp-services-with-jmeter-and-yourkit/)

## Key Takeaways

## Overview
- usually system does not work well under load , assume we are using jmeter for the performance testing of rest api.
- how to find bottleneck


### How to test using jmeter
1. we launch SUT *System under test*
2. and then we run a test plan in jmeter simulating more users and have listeners to capture the results,to find the execution time of request , maximum and minimum and averrage and throughput and so on.
3. based on this we can system works well under load or not


### How profiling tools works
1. so jmeter is sending request to SUT and SUT lets say it is running on a VM with some CPU and some memory will be used
2. then we will have our profiler agent on that machine to send the telemetry data like , CPU or memory of that particular machine to our tool in this case it is *YOURKIT* which is a profiling tool.
3. it is recommended to run SUT ,and JMeter and Yourkit on three different machines.
4. [[how CPU Utilization works]]
5. [[How memory Utilization works]]


### Example
1. Lets say this is normal endpoint with one endpoint get and the resource list is of size 50000
2. in this case what will happen, each request usually takes around 1s to complete
```java
`@Path``(` `"/resources/{id}"` `)`

`public` `class` `ExampleResourceProvider {`

 

  `private` `List<ExampleResource> resources;`

   

  `[...]`

 

  `@Override`

  `@GET`

  `@Produces``( MediaType.TEXT_PLAIN )`

  `public` `String getContent(` `@PathParam``(` `"id"` `) String id ) {`

    `ExampleResource found = NOT_FOUND;`

    `for``( ExampleResource resource : resources ) {`

      `if``( resource.getId().equals( id ) ) {`

        `found = resource;`

      `}`

    `}`

    `return` `found.getMessage();`

  `}`

```

