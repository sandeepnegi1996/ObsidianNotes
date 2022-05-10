# 📑 What is @PostConstruct and @PreDestroy

- **🏷️Tags** : #08-05-2022,  #pending

#### 🔗 Links
[javaguides](https://www.javaguides.net/2018/10/spring-postconstruct-and-predestroy-example.html)


## Key Takeaways

## Overview
1. what is the business logic we will write in this  ?????
2. method level annotaton
3. `@PostConstruct` and `@PreDestroy` annotation these does not belong to Spring. It is located in J2ee library - `common-annotation.jar`
4. this is kind of lifecyle hooks
5. these are best practices for receing lifecycle callbacks in a modern SpringApplication.
6. 



## @PostConstruct
- used on a method, that needs to be executed after dependency injection is done to perform any initialization
- basically used for initialization
- only one method can be used with this annotation
- we can open databae connection in this method


## @PreDestroy
- when the instance is in the process of being removed by the container we can use this annotation on a method as a callback
- it can be used to clear the resources or some data structre or memory
- we can close the database connection in this method 

#### Example
1. mailService class 
2. inside that we have two methods which are annotated by @PostContruct and @PreDestroy so when the bean is injected the method is mentioned with @PostContruct will run 
3. and when the contect is closed before that the method with @PreDestroy will run
4. 