# 📑 What is !@Qualifier in springboot

- **🏷️Tags** : #03-05-2022, #review, #reading_list

#### 🔗 Links
[baeldung](https://www.baeldung.com/spring-qualifier-annotation)

## Key Takeaways
- it is used to remove the ambiguity if there are multiple componets implementing interface and spring is getting confused which one it wanted to inject
```java
public class FooService 
{ 
	@Autowired 
	@Qualifier("fooFormatter") 
	private Formatter formatter; 

}

```

## Overview
- Here we will be learning about Qualifier in java
- sometimes autowired is not able to understand which bean it needs to inject
- *if more than one bean of same type is available in the spring container spring throws NoUniqueBeanDefinitonException, it indicates that more than one bean is available to autowiring*
- 


### Example 
- lets say we have two classes implementing same interface and in this case when we inject it to a service, spring framework will throw `NoUniqueBeanDefinitionException` spring basically doesn't know which bean needs to be injected, 
- `@Qualifier` is present here for our rescue which will help us to choose a particular bean.
- 

```java
@Component("fooFormatter")
public class FooFormatter implements Formatter {
 
    public String format() {
        return "foo";
    }
}

@Component("barFormatter")
public class BarFormatter implements Formatter {
 
    public String format() {
        return "bar";
    }
}

@Component
public class FooService {
     
    @Autowired
    private Formatter formatter;
}
```


#### Avoid ambiguity

```java
public class FooService 
{ 
	@Autowired 
	@Qualifier("fooFormatter") 
	private Formatter formatter; 

}

```
