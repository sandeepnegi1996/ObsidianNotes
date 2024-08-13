[[001_interviews MOC]]  [[spring boot interview questions]]

[[What is IOC or dependency Injection]]

# What is dependency injection


[[springboot vs spring]]


### Core
1. create beans that is managed by SpringContainer that is applicationContext
2. and now we can inject these beans inside another classes.
3. we can inject by constructor or setters or using @Autowired


### Why Dependency Injection is introduced
1. This solves the issue of testability
2. since now we are not doing the bean creation, we can easily mock that class and write unit testases
3. for better understanding, check the springboot [[Complete Sprinboot project REST API with MySQL]]
4. in the above mentioned guide we will be using dependency injection 
	1. in employeeService --> calling employeerepository
	2. employeeController --> employeeService 



### Lombok @RequiredArgsConstructor  -> Constructor Based Dependency Injection
[[What is setter injector and constructor injection]]
```java
@RequiredArgsConstructor
public class ClassWithFinalMembers
{
	private final String stringObject; // standard getters 
	
}
```

the above code will have one constructor and that constructor will have the field stringObject and will set that field and this will be done unders the hood since lombok
will create that constructor 