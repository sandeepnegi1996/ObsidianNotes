# 📑 What is Optional , with example

- **🏷️Tags** : #02-05-2022, #review, #pending

#### 🔗 Links
[java revisited ](https://javarevisited.blogspot.com/2017/04/10-examples-of-optional-in-java-8.html)

## Key Takeaways
Here are some of the key points about the` java.util.Optional` class which is worth remembering for future use:  
  
1) The Optional class is a container object which *may or may not contain a non-null value.* 
  
2) If a non-value is available then Optional.isPresent() method will return true and get() method of Optional class will return that value.  
  
3) The Optional class also provides methods to deal with the absence of value e.g. you can call Optional.orElse() to return a default value if a value is not present.  
  
5) You can also use the orElseThrow() method to throw an exception if a value is not present.  
  
6) There are multiple ways to create Optional in Java 8. You can create Optional using the static factory method Optional.of(non-null-value) which takes a non-null value and wrap it with Optional. It will throw NPE if the value is null. Similarly, the Optional.isEmpty() method return an empty instance of Optional class in Java.  
  
7) The biggest benefit of using Optional is that it improves the readability and conveys information which fields are optional, for example, if you have a Computer object you can put CD drive as optional because now day modern laptops like HP Envy doesn't have a CD or Optical drive.  
  
Earlier it wasn't possible to convey client which fields are optional and which are always available, but now, if a getter method returns Optional then the client knows that value may or may not be present.  
  
9) You can use the map() method to transform the value contained in the Optional object and flatMap() for both transformations and flattening which would be required when you are doing the transformation in a chain as shown in our Optional + flatMap example above.  
  
10) You can also use the filter() method to weed out any unwanted value from the Optional object and only action if Optional contains something which interests you.



## Overview
- null is bad, it can crash applications
- its creator called it a billon-dollar mistake, so we should avoid using it :)


### Why null is bad
- it can crash applications
- we should *not return null string when we can return empty string*
- never return *null collection when you can return an empty collection*
- Optional : is a new way to avoid null pointer exceptions 
- before `Optional` --> check this linke [how to avoid null before java 8](https://javarevisited.blogspot.com/2013/05/ava-tips-and-best-practices-to-avoid-nullpointerexception-program-application.html)


### Optional
- *Optional is a wrapper class that makes a field optional which means it may or may not have values*
- Optional will never have null values.
- Ex : lets say we have employee information and right now he/she is not assigned to any department at that time instead of returning a null for the department we can give some default values for the department.


### How to create optional object
1. best way of creating an optional; object is 
`Optional.ofNullable(p)`

- in this case of the person object is null the optional will basically return us empty object
- so here we are able to avoid null pointer exception
- when we are printing the `Optional` object here it will be an empty Object.

```java
		 Person p=null;

        Optional<Person> op=Optional.ofNullable(p);

        System.out.println(op);
```


###  Avoid NullPointerException in java 8
1. classical way of checking null is like this 
2. so here we have the person object and we retreived adress from it and then checking adress is null or not , if adress is not null we are printing the object

```java
Person p = new Person("Robin", new Address(block, city, state, country);
Address a = p.getAddress();

if(a != null){
 System.out.println(p);
}

```


####  Optional way of doing null check
- correct way of using optional
- *op.ifPresent()*
- *Optional.ofNullable()*
- if Present takes consumer as an argument
```java
	Person p=new Person("chaprana",new Adress("lalkurti"));

    Optional<Person> op=Optional.ofNullable(p);
    
    op.ifPresent(System.out::println);

```

##### more examples on if present
1. one way
```java
Optional<User> user = ...
user.ifPresent(theUser -> doSomethingWithUser(theUser));
```

2. best way
- [[method references in java]]
```java
Optional<User> user = ...
user.ifPresent(this::doSomethingWithUser);
```

3. old school or more detailed way of saying thing 
```java
Optional<User> user = ...
user.ifPresent(new Consumer<User>() {
    @Override
    public void accept(User theUser) {
        doSomethingWithUser(theUser);
    }
});
```

#### How to return a default value using optional --> pending
- in case of address is not present we will store empty value in adress
- *orElse()*
```java

Person p=getPerson();

Adress home=p.getAress().orElse(Adress.EMPTY);

```

#### use Optional with filter method --pending
- this will print only when addess is present and not print anything if address is not present


```java

Optional<Address> home = person.getAddress();

	home.filter(address -> "NewYork".equals(address.getCity())
    .ifPresent(() -> System.out.println("Live in NewYork"));
```

### orElse or orElseGet
```java

public T orElse(T other) 
public T orElseGet(Supplier<? extends T> other)

```

- here we can see `orElse` can take any any parameter of type T
- orElseGet --> takes only functional interface
- 

#### Example of orElse
```java

	String name=Optional.of("sandy").orElse(getRandomName());

```


####  Example of orElseGet()
```java
String name = Optional.of("sandy").orElseGet(() -> getRandomName());

```

- orElseGet is much better in terms of performance since it will