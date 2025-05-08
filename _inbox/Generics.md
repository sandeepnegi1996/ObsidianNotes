
# 📑 Generics

- **🏷️Tags** : #28-04-2025,  #pending #prep2025 

#### 🔗 Links
https://www.youtube.com/watch?v=K1iu1kXkVoA&t=3s&ab_channel=CodingwithJohn

## Key Takeaways
1. Generics can be used to do things in a common way where we don't want to repeat something 

## Overview


### Simple Problem
1. build a printer that will print interger values 
	1. solution is simple create class with one interger variable and then print that particular variable 
2. but lets say we wanted to extend this to different types of Printer such as Double Printer, String Printer, CatPrinter in this case we have to use Generics Lets see a code sample 

```java
package com.hashcodehub.springboot.studentservices.generics;  
  
public class Printer<T> {  
  
     T value;  
  
    public Printer(T value) {  
        this.value= value;  
    }  
    public void print() {  
        System.out.println(value);  
    }}
```


- how to call this Printer Class

```java

package com.hashcodehub.springboot.studentservices.generics;  
  
public class MainClassGeneric {  
    public static void main(String[] args) {  
  
        Printer<Integer> printer = new Printer<Integer>(23);  
        printer.print();  
  
        Printer<Double> doublePrinter =  new Printer<Double>(23.4);  
        doublePrinter.print();  
  
        Printer<String> stringPrinter = new Printer<String>("this is string printer using generics ");  
        stringPrinter.print();  
  
        Dog c1 =new Dog("shitzo");  
  
        Printer<Dog> catPrinter = new Printer<>(c1);  
        catPrinter.print();  
  
  
  
    }}
```

### Bounded Generics 

1. when we use generic with the other classes and interface so that we set some boundations on the generics 

### simple method with two different generic type 

```java
private static <T,V> void printAnything(T anything, V secondAnything) {  
    System.out.println(anything+"!!!!");  
    System.out.println(secondAnything+"****");  
}
```


## Deep dive generics 
https://www.baeldung.com/java-generics


1. Java Throws incompatiable type error in below mentioned code 
```java
List list = new LinkedList();  
list.add(new Integer(1));  
  
Integer i =  list.iterator().next();
```

here we have defined linkedlist of generic type means it is type of object it can hold any object that is fine when we are storing something but when we are extracting and storing the values in a integer java throws compilation error 
`java: incompatible types: java.lang.Object cannot be converted to java.lang.Integer`
so there is an issue with the type safety.

**core idea of generics**
`It would be much easier if programmers could express their intention to use specific types and the compiler ensured the correctness of such types. This is the core idea behind generics.`

with this line `List<Integer> list = new LinkedList();` we make sure that the list is of Integer type that it can hold integer values.

## **3. Generic Methods**[](https://www.baeldung.com/java-generics#generic-methods)

- Generic methods have a type parameter (the diamond operator enclosing the type) before the return type of the method declaration.
- Type parameters can be bounded (we explain bounds later in this article).
- Generic methods can have different type parameters separated by commas in the method signature.
- Method body for a generic method is just like a normal method.

Here’s an example of defining a generic method to convert an array to a list:

```java
public <T> List<T> fromArrayToList(T[] a) {   
    return Arrays.stream(a).collect(Collectors.toList());
}
```

## **Bounded Generics** 
1. upper bound -> restriction -> means T can be anything which is subClass of Number this restriction is just to enforce the type safety.

```java
public <T extends Number> List<T> fromArrayToList(T[] a) {
    ...
}

```






