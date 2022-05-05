# What is Immutable class in java
[[JAVA-interviews]]
[[Create custom immutable class with string and arraylist]]
[[Create custom immutale class with string and Address Object]]

#### Links 
[java revisted](https://javarevisited.blogspot.com/2013/03/how-to-create-immutable-class-object-java-example-tutorial.html#axzz7SJcx9ypJ)

## Key takeaways
1. We cannot modify the member fields once initialized

## Overview
- why we create immutable class, since immutable class or immutable data is thread safe  and it will help us in multithreading and concurrency
- immutable objects benefits in concurrency
- immutable objects : make sure , we are able to share the data among threads without exteral synchronization
- it offers safe publications of object state.
-
- [[multithreading with examples in java]]
- once the object is created we cannot modify the content.
- Example: Wrapper classes (Integer,Boolean,Byte,Short,String)
- enum classes are immutable
- 
- 

## what is immutable class in java
1. once object created we cannot modify the object
2. if we make any changes to immutable object a new object is created which
3. Examples can be String
4. with String , modification will produce new object and with StringBuffer will not produce new object when we make any modification since it is of mutable object 

## Disadvantage 
1. since we cannot modify immutable objects it will be garbage collected once not required this will pose some performance issue on the garbage collector
2. 

## What is the use of Immutable class
- [ ] [[What is the use of immutable class]]

## How to create Immutable Class in Java?
- state of object cannot be mofied and if some modification is there i should result in a new immutable object.
- 

### Properties
1. class --> final --> child classes can't be created
2. data members --> private, and final
3. parameterized constructor will initialize all the fields 
4. no setters --> since we don;t want anyone to change the value
5. only getters 


#### Example1 : Class with two String data members
- Immutable class with immutable fields
```java

final class EmployeeData {
  
  private final String name;
  private final String designation;
  
  //constructor 
  
  EmployeeData(String name,String designation) {
    this.name=name;
    this.designation=designation;
  }
  
  //no setter method 
  
  
  //only getter method
  public String getName() {
    return name;
  }
  
  public String getDesignation() {
    return designation;
  }
  
  
}

```


#### Example 2 : Immutable class with Mutable Class
- Immutable class with Date Class and Date class is mutable 
- to preserve immutability in this case, we need to return a copy of the original object 
- and to assign a value we will create new object everytime 
- return --> clone  , assign --> new object

```java

final class DateImmutableClass {
  
  
  private final Date oldDate;
  
  
  // this is like deep copy 
  public DateImmutableClass(Date oldDate) {
    
    this.oldDate=new Date(oldDate.getTime());  
  }
  
  
  
  public Date getoldDate() {
     return  (Date) oldDate.clone();
  }
}

```

#### Immutable class with ArrayList
- constructor :` Collections.unmodifiableList(listArg)`
- get : return `Collections.unmodifiableList(this.list);`
- 
```java

final class test {
  
  
  private final ArrayList<String> list;
  
  test(ArrayList<String> listArg) {
    list=Collections.unmodifiableList(listArg);
    
  }
  
  
  // another way
  public List<String> get() {
    return Collections.unmodifiableList(this.list);
  }
  
}

```


























