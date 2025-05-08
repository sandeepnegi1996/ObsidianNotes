
#### Content 
JAVA & GCP COURSE CONTENT


##### Day 1: Introduction to Java & GCP
•	Overview of Java and its features
•	Java installation and setup (JDK, IDEs like IntelliJ or Eclipse)

##### Day 2: Java Basics
•	Variables, data types, operators
•	Control structures (if-else, switch-case, loops)
•	Functions and methods in Java
•	Introduction to object-oriented programming (OOP)

##### Day 3: OOP in Java - Part 1
•	Classes and objects
•	Constructors
•	Methods and parameters
•	Access modifiers (public, private, protected)
##### Day 4: OOP in Java - Part 2
•	Inheritance
•	Polymorphism
•	Encapsulation and Abstraction
•	Interfaces and abstract classes

##### Day 5: Collections Framework
•	Introduction to collections
•	List, Set, Map, and Queue
•	Iterators and enhanced for loop
•	Working with generics

###### Day 6: Java Exception Handling
•	Try-catch-finally
•	Custom exceptions
•	Throws and throw keywords
•	Best practices for exception handling

Day 7: Java Streams API
•	Introduction to streams in Java
•	Stream operations (filter, map, collect, reduce)
•	Lambda expressions
•	Functional interfaces

Day 8: Java I/O and Serialization
•	Reading and writing files (FileReader, FileWriter)
•	BufferedReader, BufferedWriter
•	Serialization and Deserialization in Java
•	Working with directories


##### Day 9: Introduction to Google Cloud Platform (GCP)
•	Introduction to GCP and its services (Compute Engine, App Engine, Kubernetes Engine, Cloud Storage)
•	Setting up GCP account and configuring gcloud CLI
•	Overview of GCP services and tools
•	GCP regions, zones, and projects
•	Setting up Google Cloud SDK (gcloud CLI)
•	Google Cloud Console overview

Day 10: Compute Engine & Virtual Machines
•	Introduction to Compute Engine
•	Creating and managing virtual machines (VMs)
•	SSH into VMs
•	Configuring firewall rules

Day 11: Google Cloud Storage
•	Introduction to Cloud Storage
•	Creating and managing Cloud Buckets
•	Uploading and downloading objects
•	Access control and permissions (IAM roles)

Day 12: GCP Networking Basics
•	Virtual Private Cloud (VPC)
•	Subnets, Routes, and Firewalls
•	Load balancing in GCP
•	Cloud DNS setup and management

Day 13: Google Kubernetes Engine (GKE)
•	Introduction to Kubernetes
•	Creating and managing clusters in GKE
•	Pods, Deployments, Services
•	Helm charts and Kubernetes tools

Day 14: Cloud SQL and Databases
•	Introduction to Cloud SQL
•	Creating and managing databases (PostgreSQL, MySQL)
•	Connecting Java applications to Cloud SQL
•	Database migrations and backups

Day 15: Google App Engine (GAE)
•	Introduction to Google App Engine
•	Setting up Java applications in GAE
•	Deploying apps to App Engine
•	Managing App Engine instances

Day 16: GCP Identity and Access Management (IAM)
•	Introduction to IAM
•	Users, roles, and permissions
•	Service accounts
•	Managing IAM policies in GCP

Day 17: GCP Monitoring and Logging
•	Introduction to Stackdriver
•	Monitoring GCP resources (Compute Engine, App Engine, etc.)
•	Setting up logs and alerts
•	Analyzing logs with Cloud Logging

Day 18: Java Application Development on GCP
•	Integrating Java applications with GCP services (Storage, Cloud SQL)
•	Authentication with GCP services

Day 19: GCP Big Data and Analytics Services
•	Introduction to BigQuery
•	Running SQL queries on BigQuery
•	Using Java SDK to interact with BigQuery


Day 20: GCP Machine Learning Basics
•	Introduction to AI and ML services in GCP
•	TensorFlow on GCP
•	Cloud ML APIs (Vision, Speech, Natural Language)
•	Integrating Java with ML APIs

Day 21: Java & GCP Best Practices
•	Java performance optimization tips
•	Cost optimization on GCP
•	Security best practices on GCP
•	Application monitoring and debugging

Day 22: Final Project and Review
•	Work on a final project integrating Java with various GCP services
•	Presentation of the project
•	Review and Q&A session




# Trainings


[Home](https://dev.java/) > [Tutorials](https://dev.java/learn) > Objects, Classes, Interfaces, Packages, and Inheritance

# Objects, Classes, Interfaces, Packages, and Inheritance

If you've never used an object-oriented programming language before, you will need to learn a few basic concepts before you can begin writing any code. This section will introduce you to objects, classes, inheritance, interfaces, and packages. Each discussion focuses on how these concepts relate to the real world, while simultaneously providing an introduction to the syntax of the Java programming language.

### In this tutorial

[What is an Object?](https://dev.java/learn/oop/#object)[What is a Class?](https://dev.java/learn/oop/#class)[What is Inheritance?](https://dev.java/learn/oop/#inheritance)[What is an Interface?](https://dev.java/learn/oop/#interface)[What is a Package?](https://dev.java/learn/oop/#package)


## What is an Object?

- An object is a software bundle of related state and behavior.

- Objects share two characteristics: they all have state and behavior. Dogs have state (name, color, breed, hungry) and behavior (barking, fetching, wagging tail). Bicycles also have state (current gear, current pedal cadence, current speed) and behavior (changing gear, changing pedal cadence, applying brakes).


- Take a minute right now to observe the real-world objects that are in your immediate area.

- For each object that you see, ask yourself two questions: "What possible states can this object be in?" and "What possible behavior can this object perform?"

- so state is also an attributes of the object and behavior is also the functions that an object can perform.

- Make sure to write down your observations. As you do, you'll notice that real-world objects vary in complexity; your desktop lamp may have only two possible states (on and off) and two possible behaviors (turn on, turn off)

- Lets take an example of Car -> 
	- State 
		- brand, color, engine , seater , tank capacity, boot space  , number of gears , windows, 
	- Behavior
		- Drive
		- Listen to music 
		-  Charging
		- open or close the boot 
		- change gears 
		- apply brakes 
		- accelerate 
		- clean windsheld
		- open windows

- from the above example lets take an example of engine -> engine itself is a complete object -> since the engine has other properties, how many CC , how many cylinders in the engine. ****

![A software object](https://dev.java/assets/images/oop/01_object.png)

A software object

-  An object stores its state in **_fields_** (**variables** in some programming languages) and exposes its **behavior** through _methods_ (**functions** in some programming languages). 

- Methods operate on an object's internal state and serve as the primary mechanism for object-to-object communication. Hiding internal state and requiring all interaction to be performed through an object's methods is known as _data encapsulation_ — a fundamental principle of object-oriented programming.
- 

Consider a bicycle, for example:

![A bicycle modeled as a software object](https://dev.java/assets/images/oop/02_bicycle.png)

A bicycle modeled as a software object

- By attributing state (current speed, current pedal cadence, and current gear) and providing methods for changing that state, the object remains in control of how the outside world is allowed to use it. 

- **example, if the bicycle only has 6 gears, a method to change gears could reject any value that is less than 1 or greater than 6.**

Bundling code into individual software objects provides a number of benefits, including:

1. Modularity: The source code for an object can be written and maintained independently of the source code for other objects. Once created, an object can be easily passed around inside the system.
2. Information-hiding: By interacting only with an object's methods, the details of its internal implementation remain hidden from the outside world.
3. Code re-use: If an object already exists (perhaps written by another software developer), you can use that object in your program. This allows specialists to implement/test/debug complex, task-specific objects, which you can then trust to run in your own code.
4. Pluggability and debugging ease: If a particular object turns out to be problematic, you can simply remove it from your application and plug in a different object as its replacement. This is analogous to fixing mechanical problems in the real world. If a bolt breaks, you replace it, not the entire machine.

 

## What is a Class?

- You must have seen  thousands of other bicycles in existence, all of the same model.
- Each bicycle was built from the same set of blueprints and therefore contains the same components. 
- In object-oriented terms, we say that your bicycle is an instance of the _class of objects_ known as bicycles. A _class_ is the blueprint from which individual objects are created.

The following `Bicycle` class is one possible implementation of a bicycle:

```java
class Bicycle {

    int cadence = 0;
    int speed = 0;
    int gear = 1;

    void changeCadence(int newValue) {
         cadence = newValue;
    }

    void changeGear(int newValue) {
         gear = newValue;
    }

    void speedUp(int increment) {
         speed = speed + increment;   
    }

    void applyBrakes(int decrement) {
         speed = speed - decrement;
    }

    void printStates() {
         System.out.println("cadence:" +
             cadence + " speed:" + 
             speed + " gear:" + gear);
    }
}
```



- The fields `cadence`, `speed`, and `gear` represent the object's state, and the methods (`changeCadence()`, `changeGear()`, `speedUp()` etc.) define its interaction with the outside world.


- Here is a `BicycleDemo` class that creates two separate `Bicycle` objects and invokes their methods:



```java
class BicycleDemo {
    public static void main(String[] args) {

        // Create two different 
        // Bicycle objects
        Bicycle bike1 = new Bicycle();
        Bicycle bike2 = new Bicycle();

        // Invoke methods on 
        // those objects
        bike1.changeCadence(50);
        bike1.speedUp(10);
        bike1.changeGear(2);
        bike1.printStates();

        bike2.changeCadence(50);
        bike2.speedUp(10);
        bike2.changeGear(2);
        bike2.changeCadence(40);
        bike2.speedUp(10);
        bike2.changeGear(3);
        bike2.printStates();
    }
}
```


The output of this test prints the ending pedal cadence, speed, and gear for the two bicycles:

```shell
cadence:50 speed:10 gear:2
cadence:40 speed:20 gear:3
```

 

## What is Inheritance?

Different kinds of objects often have a certain amount in common with each other. Mountain bikes, road bikes, and tandem bikes, for example, all share the characteristics of bicycles (current speed, current pedal cadence, current gear). Yet each also defines additional features that make them different: tandem bicycles have two seats and two sets of handlebars; road bikes have drop handlebars; some mountain bikes have an additional chain ring, giving them a lower gear ratio.

Object-oriented programming allows classes to inherit commonly used state and behavior from other classes. In this example, `Bicycle` now becomes the superclass of `MountainBike`, `RoadBike`, and `TandemBike`. In the Java programming language, each class is allowed to have _one_ direct superclass, and each superclass has the potential for an unlimited number of subclasses:

![A hierarchy of bicycle classes](https://dev.java/assets/images/oop/03_inheritance.png)

A hierarchy of bicycle classes

The syntax for creating a subclass is simple. At the beginning of your class declaration, use the extends keyword, followed by the name of the class to inherit from:

```java
class MountainBike extends Bicycle {

    // new fields and methods defining 
    // a mountain bike would go here

}
```

Copy

This gives `MountainBike` all the same fields and methods as `Bicycle`, yet allows its code to focus exclusively on the features that make it unique. This makes code for your subclasses easy to read. However, you must take care to properly document the state and behavior that each superclass defines, since that code will not appear in the source file of each subclass.

 

## What is an Interface?

As you have already learned, objects define their interaction with the outside world through the methods that they expose. Methods form the object's interface with the outside world; the buttons on the front of your television set, for example, are the interface between you and the electrical wiring on the other side of its plastic casing. You press the "power" button to turn the television on and off.

In its most common form, an interface is a group of related methods with empty bodies. A bicycle's behavior, if specified as an interface, might appear as follows:

```java
interface Bicycle {

    //  wheel revolutions per minute
    void changeCadence(int newValue);

    void changeGear(int newValue);

    void speedUp(int increment);

    void applyBrakes(int decrement);
}
```


To implement this interface, the name of your class would change (to a particular brand of bicycle, for example, such as `ACMEBicycle`), and you would use the `implements` keyword in the class declaration:

```java
class ACMEBicycle implements Bicycle {

    int cadence = 0;
    int speed = 0;
    int gear = 1;

   // The compiler will now require that methods
   // changeCadence, changeGear, speedUp, and applyBrakes
   // all be implemented. Compilation will fail if those
   // methods are missing from this class.

    void changeCadence(int newValue) {
         cadence = newValue;
    }

    void changeGear(int newValue) {
         gear = newValue;
    }

    void speedUp(int increment) {
         speed = speed + increment;   
    }

    void applyBrakes(int decrement) {
         speed = speed - decrement;
    }

    void printStates() {
         System.out.println("cadence:" +
             cadence + " speed:" + 
             speed + " gear:" + gear);
    }
}
```


Implementing an interface allows a class to become more formal about the behavior it promises to provide. Interfaces form a contract between the class and the outside world, and this contract is enforced at build time by the compiler. If your class claims to implement an interface, all methods defined by that interface must appear in its source code before the class will successfully compile.

Note: To actually compile the `ACMEBicycle` class, you will need to add the `public` keyword to the beginning of the implemented interface methods. You will learn the reasons for this later in the sections on [Classes and Objects](https://dev.java/learn/classes-objects/), [Interfaces](https://dev.java/learn/interfaces/) and [Inheritance](https://dev.java/learn/numbers-strings/strings/).

 

## What is a Package?

A package is a namespace that organizes a set of related classes and interfaces. Conceptually you can think of packages as being similar to different folders on your computer. You might keep HTML pages in one folder, images in another, and scripts or applications in yet another. Because software written in the Java programming language can be composed of hundreds or thousands of individual classes, it makes sense to keep things organized by placing related classes and interfaces into packages.

The Java platform provides an enormous class library (a set of packages) suitable for use in your own applications. This library is known as the "Application Programming Interface", or "API" for short. Its packages represent the tasks most commonly associated with general-purpose programming. For example, a [`String`](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/String.html) object contains state and behavior for character strings; a [`File`](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/io/File.html) object allows a programmer to easily create, delete, inspect, compare, or modify a file on the filesystem; a [`Socket`](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/net/Socket.html) object allows for the creation and use of network sockets; various GUI objects control buttons and check boxes and anything else related to graphical user interfaces. There are literally thousands of classes to choose from. This allows you, the programmer, to focus on the design of your particular application, rather than the infrastructure required to make it work.

[The Java Platform API Specification](https://docs.oracle.com/en/java/javase/23/docs/api/index.html) contains the complete listing for all packages, interfaces, classes, fields, and methods supplied by the Java SE platform. Load the page in your browser and bookmark it. As a programmer, it will become your single most important piece of reference documentation.

### In this tutorial

[What is an Object?](https://dev.java/learn/oop/#object)[What is a Class?](https://dev.java/learn/oop/#class)[What is Inheritance?](https://dev.java/learn/oop/#inheritance)[What is an Interface?](https://dev.java/learn/oop/#interface)[What is a Package?](https://dev.java/learn/oop/#package)



