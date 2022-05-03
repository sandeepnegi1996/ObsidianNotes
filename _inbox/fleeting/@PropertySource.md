# 📑 @PropertySource

- **🏷️Tags** : #25-04-2022, #review, #reading_list

## 🔗 Links
[baeldun](https://www.baeldung.com/properties-with-spring)

## Overview
1. we can use @Value to read property and inject to method, setter methods, data members or field or constructor
2. `@PropertySource` will be used on top of class to mention the properties files, it will be used in conjunction with `@Configuration`



## Usage
1. Example
2. 
```java

@Configuration
@PropertySource("classpath:foo.properties")
public class Test {

}

```

2. In real life we will having different property file for different environment, lets
` application-dev.properties` similar way for q and p.

in that case we will use placeholder to dynamically selet the right file at run time

```java
@PropertySource({ "classpath:persistence-${envTarget:mysql}.properties" })

```

3. We can mention multiple properties on top of class
```java

@PropertySource("classpath:foo.properties")
@PropertySource("classpath:bar.properties") 
public class PropertiesWithJavaConfig { 
//...
}

```


##  Environment-Specific Properties files
1. lets say we have different environment, for `dev,qua-prod` in this case there is out of the box feature from spring boot where we can create files like `application-dev.properties` and `application-prod.properties` in the src/main/resources folder, and then set a spring profile with the same environment name in that case these files will take precendence.
2. [ ] [[what is spring profile]]

## Hierarchial Properties
1. for hierarchial properties yml files are more prefreable and easy to manage

```properties
database.url=jdbc:postgresql:/localhost:5432/instance 
database.username=foo database
password=bar 
secret: foo

```



