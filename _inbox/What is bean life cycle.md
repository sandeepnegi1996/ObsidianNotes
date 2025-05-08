# 📑 What is bean life cycle

- **🏷️Tags** : #10-05-2022,  #pending #completed #permanent

#### 🔗 Links


## Key Takeaways
- container started , bean instantainted, injected, init , method, destroy
- XML,programmatically using interface and then using annotations such as @PreDestroy and @PostConstruct
- 

## Overview
- life cycle : when and how the object is created, behaved and died
- life cycle of bean : when it is instantiated, what action it performs until it lives and when and how it is destroyed
- life cycle is managed by spring container



## How container works
1. so when application is started 
2. container is started
3. it creates and register beans in the application context or container
4. dependencies are injected
5. finally the beans are destroyed when the container is closed

```
container Started --> bean instantiated --> dependencies injected --> init --> custom method --> destroy 
```


1. init method - can be used to execute something when the container is started
2. destroy method : can be used to execute something when the container is closed


## Ways to implement the life cycle of a bean


### By XML
1.  create a bean and write init and destroy method in this
2. give any implementation in this method 
3. we have to create spring.xml file and register the bean with the method , init and destroy
4. now we have to create one driver class to run this


1. bean 
```java
package beans;
 
public class HelloWorld {
 
    // This method executes
    // automatically as the bean
    // is instantiated
    public void init() throws Exception
    {
        System.out.println(
            "Bean HelloWorld has been "
            + "instantiated and I'm "
            + "the init() method");
    }
 
    // This method executes
    // when the spring container
    // is closed
    public void destroy() throws Exception
    {
        System.out.println(
            "Container has been closed "
            + "and I'm the destroy() method");
    }
}
```


2. Spring.xml

```XML



<!DOCTYPE
    beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN"
        "http://www.springframework.org/dtd/spring-beans-2.0.dtd">
             
<beans>
    <bean id="hw" class="beans.HelloWorld"
            init-method="init" destroy-method="destroy"/>
     
</beans>
```


3. Driver class

```java



// Java program to call the
// bean initialized above
 
package test;
 
import org.springframework
    .context
    .ConfigurableApplicationContext;
 
import org.springframework
    .context.support
    .ClassPathXmlApplicationContext;
 
import beans.HelloWorld;
 
// Driver class
public class Client {
 
    public static void main(String[] args)
        throws Exception
    {
 
        // Loading the Spring XML configuration
        // file into the spring container and
        // it will create the instance of
        // the bean as it loads into container
 
        ConfigurableApplicationContext cap
            = new ClassPathXmlApplicationContext(
                "resources/spring.xml");
 
        // It will close the spring container
        // and as a result invokes the
        // destroy() method
        cap.close();
    }
}
```

```output 


Bean HelloWorld has been instantiated and I’m the init() method   
Container has been closed and I’m the destroy() method
```



### By Programming Approach
1. for this we have to implement two interfaces such as `InitializingBean` and `DisposableBean` and override the `afterPropertiesSet` and `destroy` 

steps
1. class that implement
```java
// Java program to create a bean
// in the spring framework
package beans;

import org.springframework
	.beans.factory.DisposableBean;

import org.springframework
	.beans.factory.InitializingBean;

// HelloWorld class which implements the
// interfaces
public class HelloWorld
	implements InitializingBean,
DisposableBean {

	@Override
	// It is the init() method
	// of our bean and it gets
	// invoked on bean instantiation
	public void afterPropertiesSet()
throws Exception
	{
		System.out.println(
			"Bean HelloWorld has been "
			+ "instantiated and I'm the "
			+ "init() method");
	}

	@Override
	// This method is invoked
	// just after the container
	// is closed
	public void destroy() throws Exception
	{
		System.out.println(
			"Container has been closed "
			+ "and I'm the destroy() method");
	}
}



```

2. spring.xml
```xml
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN"
			"http://www.springframework.org/dtd/spring-beans-2.0.dtd">
			
<beans>
	<bean id="hw" class="beans.HelloWorld"/>
	
</beans>


```

3. Same Driver class
```java
// Java program to call the
// bean initialized above

package test;

import org.springframework
	.context
	.ConfigurableApplicationContext;

import org.springframework
	.context.support
	.ClassPathXmlApplicationContext;

import beans.HelloWorld;

// Driver class
public class Client {

	public static void main(String[] args)
		throws Exception
	{

		// Loading the Spring XML configuration
		// file into the spring container and
		// it will create the instance of the bean
		// as it loads into container
		ConfigurableApplicationContext cap
			= new ClassPathXmlApplicationContext(
				"resources/spring.xml");

		// It will close the spring container
		// and as a result invokes the
		// destroy() method
		cap.close();
	}
}


```


### By using annotation
1. by this we need to create two method init and destroy
2. init should be annotated by @PostConstruct
3. destroy should be annotated but @PreDestroy
4. create bena and write two methods and add the annotaiton and then do the same step spring.xml and then create context and bass the xml and close the container

```java
// Java program to create a bean
// in the spring framework
package beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// HelloWorld class
public class HelloWorld {

	// Annotate this method to execute it
	// automatically as the bean is
	// instantiated
	@PostConstruct
	public void init() throws Exception
	{
		System.out.println(
			"Bean HelloWorld has been "
			+ "instantiated and I'm the "
			+ "init() method");
	}

	// Annotate this method to execute it
	// when Spring container is closed
	@PreDestroy
	public void destroy() throws Exception
	{
		System.out.println(
			"Container has been closed "
			+ "and I'm the destroy() method");
	}
}


```