# 📑 What is Scope in beans

- **🏷️Tags** : #08-05-2022,  #pending #completed #permanent

#### 🔗 Links


## Key Takeaways

## Overview
- scope of a bean defines the life cycle and visibility of that bean in the contexts 
- 6 types of scopes
	- singleton
	- prototype
	- request
	- session
	- application
	- websocket

- last 4 are only available in a `web-aware `application
- [[what is web-space application in spring framework]]
- 


### Singleton
1. container will create single instance of that bean.
2. all request for that bean will return same object
3. any modification to the object will be reflected in all the references for that bean
4. this is the default scope

```java
@Bean
@Scope("singleton")
public Person personSingleton() { 

	return new Person();

}

```

- in the below mentioned example we can see when the object is modifed that is reflected in other objects

```java

@Test
public void givenSingletonScope_whenSetName_thenEqualNames() {
    ApplicationContext applicationContext = 
      new ClassPathXmlApplicationContext("scopes.xml");

    Person personSingletonA = (Person) applicationContext.getBean("personSingleton");
    Person personSingletonB = (Person) applicationContext.getBean("personSingleton");

    personSingletonA.setName(NAME);
    Assert.assertEquals(NAME, personSingletonB.getName());

    ((AbstractApplicationContext) applicationContext).close();
}


```


- scopes.xml
```java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans 
    http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="personSingleton" class="org.baeldung.scopes.Person" scope="singleton"/>    
</beans>

```


### Prototype
- give different instance everytime
- @Scope("prototype")
- 