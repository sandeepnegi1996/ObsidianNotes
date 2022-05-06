# What is Immutable class in java,
# How to Create Immutable class in depth 
[[JAVA-interviews]]
[[Create custom immutable class with string and arraylist]]
[[Create custom immutale class with string and Address Object]]

#### Links 
[java revisted](https://javarevisited.blogspot.com/2013/03/how-to-create-immutable-class-object-java-example-tutorial.html#axzz7SJcx9ypJ)

[code pumpkin](https://codepumpkin.com/immutable-class-with-mutable-member-fields-in-java/)

## Key takeaways
1. We cannot modify the member fields once initialized
2. immutable data is thread safe
3. 
## Overview
- why we create immutable class, since immutable class or *immutable data is thread safe*  and it will help us in multithreading and concurrency
- immutable objects benefits in concurrency
*- immutable objects : make sure , we are able to share the data among threads without external synchronization*
- it offers safe publications of object state.
-
- [[multithreading with examples in java]]
- once the object is created we cannot modify the content.


### Immutable Objects Examples
- Example: Wrapper classes (Integer,Boolean,Byte,Short,String)
- enum classes are immutable
- String
- String Buffer 


## what is immutable class in java
1. once object created we cannot modify the object
2. if we make *any changes to immutable object a new object is created* which
3. Examples can be String
4. with String , modification will produce new object and with StringBuffer will not produce new object when we make any modification since it is of mutable object 

## Disadvantage : performance issue with immutable data
- since we cannot modify immutable objects it will be garbage collected once not required this will pose some performance issue on the garbage collector
- once modified a new objects needs to be created in case of immutable objects
- that poses an issue for the garbage collector that will collect the deferenced objects from the memeory
- Ex: we have immutable date objects, we increment date in our loop.
-  use of immutable is based on design : not advisable in case of counters
- advantage : immutable data can reduce the locks in multi-threaded app

[stackoverflow](https://stackoverflow.com/questions/71455345/performance-of-programs-using-immutable-objects)

- 

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


#### Example 2 : Immutable class with Mutable member fields in java --< MOST IMP
- immutable classes are good examples of hashmap keys ,as their state cannot be changed once created
-[most important link](https://codepumpkin.com/immutable-class-with-mutable-member-fields-in-java/)


##### Simplest Example
1. User class , with three String data members

```java
public final class User {
    private final String firstName;
    private final String lastName;
    private final String address;
     
    public User(String firstName, String lastNa++m++e,+++ String address) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAddress() {
        return address;
    }
}

```



2. We wants to store adress in a Separate Class that is third party librat
- lets assume this is a third party library and letss see its implementation
- this class is a normal class which has getters and setters we cannot modify this class
- 
```java
public class Address implements Cloneable{
    String firstLine;
    String secondLine;
    String city;
     
    public Address(String firstLine, String secondLine, String city) {
        super();
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.city = city;
    }
 
    public String getFirstLine() {
        return firstLine;
    }
 
    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }
 
    public String getSecondLine() {
        return secondLine;
    }
 
    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }
 
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
 
    @Override
    public String toString() {
        return "Address [firstLine=" + firstLine + ", secondLine=" + secondLine 
                + ", city=" + city + "]";
    }
}

```



##### User class changes : Change adress to Address type from string

```java
public final class User {
    private final String firstName;
    private final String lastName;
    private final Address address;
     
    public User(String firstName, String lastName,Address address) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public Address getAddress() {
        return address;
    }
}

```


- There is an issue with user class now, that it is not immutable since `Address` class is having setter method 


##### Lets break the immutability
```java
ublic class ImmutableDemo {
 
    public static void main(String s[]) {
         
        User u = new User("Sherlock", 
                          "Homes", 
                          new Address("221B", "Baker Street", "London"));
 
        // fetch address from the User object and store it in local variable address
        Address address = u.getAddress();
        System.out.println(address);
 
        // change address in local variable
        address.setFirstLine("001D");
        address.setSecondLine("Chandani Chawk");
        address.setCity("Delhi");
 
        // display address from User object
        System.out.println(u.getAddress());
    }
}

```


	output : 
	`Address [firstLine=221B, secondLine=Baker Street, city=London]`

`Address [firstLine=001D, secondLine=Chandani Chawk, city=Delhi]`

- now user class is not immutable, since for the same object we have modified the adress value , first we got the adress stored in a reference variable and then we have changed the value and again get the address.




### How to Achive immutability in this case ?

####  Option 1: 
- we will not provide setter method in adress class
- Cross Questions : Address class is from the jar and we don't have any control over it 


#### Option 2:
- we will create child class from the adress class
- and throw an exception when someone wants to usesetter method
- in the user class we will return the cloned child adress since Address implements Cloneable


```java

class ChildAddress extends Address{
     
    public ChildAddress(String firstLine, String secondLine, String city) {
        super(firstLine,secondLine,city);
    }
     
    public void setFirstLine(String firstLine) {
        throw new UnsupportedOperationException();
    }
     
    public void setSecondLine(String secondLine) {
        throw new UnsupportedOperationException();
    }
     
    public void setCity(String city) {
        throw new UnsupportedOperationException();
    }
}

```

- User class


```java
public final class User {
    String firstName;
    String lastName;
    ChildAddress address;
     
    public User(String firstName, String lastName, ChildAddress address) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public ChildAddress getAddress() throws CloneNotSupportedException {
        return (ChildAddress) address.clone();
    }
     
```

- Problem with this approach :
	- what if there is any member in the `Address` class that is also mutable and that case we need to overidde that class also and use that inside Address child class
	- this is an issue


#### Option 3
1.  in the user class, in getAdress we will return the deep cloned copy of the adress instance 
2. 


```java

public final class User {
    private final String firstName;
    private final String lastName;
    private final Address address;
     
    public User(String firstName, String lastName, Address address) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public Address getAddress() {
        return address.clone();
    }   
}

```


- clone method works since we are implementing Cloneable interface int he Address Class if that is not case we have to get the fields and then store it manually and return that 
- 


### Mutable Collections as a field in Immutable Object
- below mentioned code is not recommendable

```java
public final class User {
    String firstName;
    String lastName;
    ArrayList<Address> addressList;
     
    public User(String firstName, String lastName, ArrayList<Address> addressList) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressList = addressList;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public ArrayList<Address> getAddress(){
        return (ArrayList)addressList.clone();
    }
     
}

```


- in case of objects : normal classes we can use clone method it will do deep copy
- in case of Collections , clone method will not do deep copy it will do only shallow copy

*Write your own deep copy for arraylist*


##### Option1
1. write your own deep copy array list


##### copy - constructo to create deep cloned arraylist


##### Option 3
1. i n java we have unModifable Collections , which are basically wrapper aroung the normal collection and these will avoid, add or remove mehtod 
2. instead of returning normal list we will return unmodifiable list
3. 

### final Solution
```java
public final class User {
    String firstName;
    String lastName;
    ArrayList<Address> addressList;
     
    public User(String firstName, String lastName, ArrayList<Address> addressList) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressList = addressList;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public ArrayList<Address> getAddressList(){
        return (ArrayList)Collections.unmodifiableCollection(addressList);
    }
     
}

```
















#### Example 2.1 : Immutable class with Mutable Class
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

























