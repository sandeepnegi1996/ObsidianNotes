# springboot vs spring

## Framework
1. framework makes development easier
2. it provider support for code libraries and various scripting langugages support/
3. code reusability 


## What is Spring 
- lightweight application framework
- provides support for struts , JSP , Hibernate
- written by *Rod Jonson in 2002*
- first released : 2003
- 
- [[What is dependency injection]] : with the help of dependency injection we were able to write loosely coupled application and that helped us in improving the test ability of our code.
- no in-memory database
-  Spring JDBC
-   Spring MVC
-   Spring Security
-   Spring AOP
-   Spring ORM
-   Spring Test
-
- earlier even if we wants to insert something to database. we need to write the same boiler plate code again and again, spring saved us from that headache using Spring JDBC
- 

## What is Spring Boot
- it is build on top of spring and which eliminates lot of boiler plate code 
- it makes easier to create *stand-alone application* 
- it helps to crate microservices, [[What is microservice architecture]]
	- it is a concept of dividing the application into loosely coupled services that implement business requirements
-  here Boot : bootstrap : basically it is providing bootstrap around spring so that we can build production grade application as fast as possible.
- REST API
- embedded tomcat server
- in memory database
- *starter dependency*
- *actuators* 
- *auto configuration*
- *spring cli*

- starting point of spring application

```java
@SpringBootApplication 
public class Application { 
	public static void main(String[] args) { 
		SpringApplication.run(Application.class, args); 
		}
		 
		 }
```

- it automatically scans for the classes in the samepackage

### Deployment in sprinboot
- springboot supports maven and gradle
- executable jar or war and running an application "in-place", since the tomcat server is embedded
- we can run the jar using `java -jar `
- we can specify active profiles when deploying.
-  [[Where is Database Configuration stored in Springboot application]]


- [ ] [[Complete Sprinboot project REST API with MySQL]]