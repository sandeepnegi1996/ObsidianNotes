[[spring boot interview questions]]


# Motivation
1. Sometimes I am confused how the `application.properties `works and how it is used and how it is priotized and how we can use them while creating the build for different environment. 


Read this blogopst too 

[Properties with Spring and Spring Boot | Baeldung](https://www.baeldung.com/properties-with-spring)



### Things to Learn
1. Simple Example of application.properties
2. How to consume the values in application
3. Create different config for different Env and use them while building the project



#### Create and modify the port number on which tomcat will run 
1. create a file in `src/main/resources/application.properties`
2. add a property `server.port=9091`
3. in the below screenshot we can see that the tomcat is initialized on 9091
4. 

![[Pasted image 20240312110643.png]]


#### How to consume a property from application.properties file
1. create a new property such as `student.postgres.db=postgresdburl`
2. consume it using `@Value`

Example 
1. properties file 
```properties
server.port=9091  
student.postgres.db=postgresdburl
```

2. java code using @Value

```java
@Value("${student.postgres.db}")  
private String jdbcUrl;
```


#### Create Environment Specific properties files
1. `application-local.properties`
2. `application-dev.properties`

- just add an entry in the application.properties file such as `spring.profiles.active=local`
- above line will now load the local properties file instead of application.properties file

Example
1. `application.properties`
```properties
server.port=9091  
student.postgres.db=postgresdburl  
spring.profiles.active=local
```

2. Now lets see `application-local.properties`
```properties
server.port=9092
```


![[Pasted image 20240312113704.png]]




#### Passing a property file in a test case using @TestPropertySource 

1. we can use the annotation `@TestPropertySource`
2. and provide the file name and then we can read the values from that file 

Example code 

```java
@ExtendWith(SpringExtension.class)  
@SpringBootTest(classes = StudentServicesApplication.class,webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT)  
@TestPropertySource("/application-test.properties")  
public class StudentControllerIT {  
  
    @LocalServerPort  
    private int port;  
  
    @Value("${jdbc.url}")  
    private String jdbcUrl;
```




#### Hierarchical Property Storage 
1. if there are some properties that are hierarchial in that case yaml file is better to be used so that we can manage the properties properly 

example 

1. Properties
```properties
database.url=jdbc:postgresql:/localhost:5432/instance
database.username=foo
database.password=bar
secret: foo
```

2. YAML

```yaml
database:
	url: jdbc:postgresql:/localhost:5432/instance
	password: foo
	password: bar
secret: foo	
```



#### Pass different environment specific properties file in springboot 

