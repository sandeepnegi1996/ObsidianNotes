# What are the features introduced in Java 8


```

Links : https://www.journaldev.com/2389/java-8-features-with-examples


```
 ## Interfaces Default and Static Methods
- Earlier there was not default and static method in interface only public abstract methods so lets say i want to add some new functionality to a interface a, i need to go individually to all the classes that are implementing that interface and then add the implmentaion.
- This is solved by Default and Static Methods implmentation in Interface



#### Static Method 
- Cannot be overriden
- Availble only inside interface 
- If we wanted to call it outside, we have to use InterfaceName.functionaName()

- Example
```
static String producer() { 
return "N&F Vehicles"; 
}

```

- Vehicle.producer() --> where Vehicle is the Interface name 


#### Default Methods
- Can be overriden
- Accesible from the instance of the implementing class

```
default String getOverview() { 
return "ATV made by " + producer(); 
}
```

```
Vehicle vehicle=new VehicleImpl();
vehicle.getOverview();
```



## Java Stream API for Bulk Data Operations
#pending 

## Functional Interfaces and Lambda Expression
#pending
- Interface with only one abstract method is functional interface
- lambda expression can be used to provide implmentation of the method in functional interface

```
Runnable r1 = () -> {

            System.out.println(``"My Runnable"``);

        };

```

## Java Time API

## Collection API Improvement







## Method References
#pending 



## ```Optional <T>```
#pending 
- Earlier Developers needs to carefully handle the null pointer exception and that tends out to be some boiler plate code
- Optional --> helps to handle  NPE 
	- acts as a container
	- return the object if it is not null
	- in build api are there if the object is null

- Earlier
```
User user = getUser(); 
if (user != null) { 
Address address = user.getAddress();
if (address != null) { 
String street = address.getStreet(); 
if (street != null) {
return street; 
} 
} 
} 
return "not specified";
```












