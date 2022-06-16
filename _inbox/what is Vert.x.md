# 📑 What is Vert.x with Demo

- **🏷️Tags** : #30-05-2022,  #pending #completed #permanent

#### 🔗 Links
[medium-article ](https://medium.com/@Project_A_Ventures/vert-x-learnings-about-a-reactive-framework-1b2e2debc2da)

## Key Takeaways

## Overview
- framework that provide tools for building reactive application on the JVM


## what is Vert.x ?
1. Each Vert.x application consists of Verticle 
2. Each Verticle can be deployed and scale independently
3. Communication between verticles happens over Event Bus
4. Each Verticle can be build using different programming language such as Java, Javascript, Scala , Kotlin etc

5. Vert.x is unopiniated and you can build the application the way you wanted.
6. Ideal use case is with [[event driven microservices architecture]] 
7. we can also build monolithic application using Vert.x or we can include it in the spring project.

*Vert.x is event-driven and non-blocking*

8. we need to define event handlers that are called by Vert.x when a certain event occurs.
9. to pass the event to the handlers Vert.x uses a thread which is called event-loop.
10. *never execute any blocking code in your handler* since this would also blockl the event-loop and slow down the whole application.

#### Example of blocking code
1. calling a database and then waiting for the response.
2. Vert.x solution for this is to use some popular non blocking client code
3. wrapping the blocking code in a special handler.


## Pros and Cons
1. non blocking code is better performant since we are using lesser number of threads
2. Fewer threads means less overhead and better CPU Usage and better scaling on many parallel requests
3. non blocking code is difficult to read and write and debug.
4. each vericle is thread safe by default since they are only accessed by single thread.
5. *make sure no blocking code is written and also take care of nested callbacks*
6. *Make sure you are not using any library that uses blocking code*

8. Less developers to be familiar with reactive programming and hence ever developer should atleast check this type of coding style to that is reactive programming.


## Verticles
1. piece of code that Vert.x engine execute
2. Being polygot verticles can be written in any of the supported languages.
3. *an application will have many verticles running in the same Vert.x instance and communicate each other using events via the event bus*

## Event Bus
1. nerve system of Vert.x
2. *Being reactive verticles will remain dormant until they receive an event*
3. for communication between verticles event bus will be used and the message can be string or complex json object
4. mesage handling is async
5. message are queued to the event bus and control is returned to the sender.
6. Later dequeued to the listening verticle.
7. Response is send using *Future* and *Callback*


## Documentation
[doc](https://vertx.io/docs/)
[vertx examples](https://github.com/vert-x3/vertx-examples)


## Community
1. https://vertx.io/blog/
2. https://groups.google.com/g/vertx?pli=1

## Demo

### Simple Vert.x Maven Project
Use that as a template for setting up a Maven project with Vert.x.

[simple vertx project](https://github.com/vert-x3/vertx-examples/tree/4.x/maven-simplest)

```java
package io.vertx.example;  
import io.vertx.core.Vertx;  
public class HelloWorldEmbedded {  
  
  public static void main(String[] args) {  
  
    Vertx.vertx()  
            .createHttpServer()  
            .requestHandler(req -> req.response().end("Testing simple Vertx Application"))  
            .listen(8080);  
  }  
  
}

```



### Vert.x Simple Maven Verticle Project

- here we have to extends `AbstractVerticle`
- Override the method start 

You can run it directly in your IDE by creating a run configuration that uses the main class `io.vertx.core.Launcher`, passes in the arguments `run io.vertx.example.HelloWorldVerticle`, and specify using the classpath of module `maven-verticle`.

The pom.xml uses the Maven shade plugin to assemble the application and all it’s dependencies into a single "fat" jar.

To build a "fat jar"

	mvn package

To run the fat jar:

	java -jar target/maven-verticle-4.3.1-fat.jar


```java
package io.vertx.example;  
  
import io.vertx.core.AbstractVerticle;  
  
public class HelloWorldVerticle extends AbstractVerticle {  
  
  @Override  
  public void start() {  
    // Create an HTTP server which simply returns "Hello World!" to each request.  
    // If a configuration is set it get the specified name    String name = config().getString("name", "World");  
    vertx.createHttpServer()  
            .requestHandler(req -> req.response().end("From Deployed Verticle " + name + "!"))  
            .listen(8080);  
  }  
}

```


- we can change the port number using listen 

```java

vertx.createHttpServer()  
        .requestHandler(req -> req.response().end("testing myself"))  
        .listen(9090);

```

[project link](https://github.com/sandeepnegi1996/simple-vertx-verticle-maven)



### Vert.x project with multiple verticles 

- here one project will have multiple verticles inside the project 
- we can use the command 
		mvn clean package
above command will create the fat jar for each module


- Main Project Pom File.

```xml

<?xml version="1.0" encoding="UTF-8"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0"  
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
  <modelVersion>4.0.0</modelVersion>  
  
  <groupId>io.vertx</groupId>  
  <artifactId>maven-verticles-examples</artifactId>  
  <version>4.3.1</version>  
  
  <packaging>pom</packaging>  
  
  <modules>    
    <module>maven-verticle</module>  
    <module>maven-verticle-groovy</module>  
    <module>maven-verticle-groovy-compiled</module>  
  </modules>  
</project>

```





