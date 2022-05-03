[[What is IOC or dependency Injection]]

# What is dependency injection
[[springboot vs spring]]


### Why Dependency Injection is introduced
1. This solves the issue of testability
2. since now we are not doing the bean creation, we can easily mock that class and write unit testases
3. for better understanding, check the springboot [[Complete Sprinboot project REST API with MySQL]]
4. in the above mentioned guide we will be using dependency injection 
	1. in employeeService --> calling employeerepository
	2. employeeController --> employeeService 

