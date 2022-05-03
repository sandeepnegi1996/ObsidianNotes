# What is hashCode() in java
#java 



## Hashing 
- Take a data and feed that to an algorithm and produce some integer 


## Java Concept
- hashcode is always int
- If two objects are equal then their hashcode will be equal
- But vice-versa is not true


## hashcode()
- hashcode function in java returns hashcode of the object
- hashCode() func is basically present in Object class so anyone can overide it
- #pending 
[[Functions in Object Class in java ]]


## Why java uses hashcode() to compare object
- it is 20 times faster than comparing the object using equals method 
- HashMap internally organize the elements in an array-based data structure

## Types of hashcode
1. hashCode() : Java Integer class , overrides the hashcode method from the Objet class
2. hashCode(int val) : This one is for hashcode of the int parameter


### Examples
1. When objects are equal hashCode is also equal

```java

		String s1="100";
		String s2="100"; 
		
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		Output 
		48625
		48925
```


2. When Objects are not equal hashCode is also not equal
```java
		String s1="100";
		String s2="500"; 
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		Output : 
		48625
		52469


```

pending
[[How HashMap stores data internally]]