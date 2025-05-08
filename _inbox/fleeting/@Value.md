# 📑 @Value

- **🏷️Tags** : #25-04-2022, #prep2025, #reading_list

## 🔗 Links
[baeldung](https://www.baeldung.com/spring-value-annotation#setting-up-the-application)

## Key Takeaways
- @Value is use to inject values from properties files to fields,constructor,setters
- we can inject multiple values into array also
- we can inject into hashmap 
- we can give some default values
- values are assigned during bean creation

## Overview 

1. `@Value` can be used to inject values from `.properties` files into Spring-Managed beans , it can be applied at the fields (data members) , constructor , setter ,methods

## History 
1. Before this lets say i have build a maven project and i want to externalize some values to be fetched from the .properties files in that case we need to get the instance of Properties and then we need to call System.getProperty to get the property values from the .properties files, but with this we can use @Value and can fetch values from properties files and inject in spring-managed bean.


## Setting up application
1. create properties files and add key value pair
```properties
value.from.file=Value got from the file
priority=high
listOfValues=A,B,C

```

2. [ ] Configure `@PropertySource` in our configuration class with the properties file name. [[@PropertySource]]
3. Default property files in spring is `application.properties`

## Usage
1. value from file 
```java
@Value("${value.from.file}") 
private String valueFromFile;

```


2. 
```java
@Value("${priority}") 
private String prioritySystemProperty;

```

3. Injecting multiple values into array
```java
@Value("${listOfValues}")

private String[] valuesArray; 
```

4. @Value with maps
	1. define key value property `valuesMap={key1: '1', key2: '2', key3: '3'}`
	2.
```java
@Value("${valuesMap}")
private Map<String,Integer> valuesMap;

```

5. @Value with constructor and setter methodexamples
- here `normal` is the default value given to the key priority and `@PropertySource` is used on the class 

```java
@Component
@PropertySource("classpath:values.properties")
public class PriorityProvider
	{ private String priority; 
	@Autowired
	public PriorityProvider(@Value("${priority:normal}") String priority) {
	this.priority = priority; 
} 
```

6. Similar way we can also use this with setter method
7. How to give default values with @Value 
```java
@Value("${car.type:Sedan}")
private String type;

```


###  System Variables
1. We can also acess system variables which are stored as properties by the Spring at application start.

```java

@Value("${number.of.processors}")
private int processors;

@Value("${java.home}")
private String javaHomePath;

```