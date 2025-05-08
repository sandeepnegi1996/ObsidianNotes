# 📑 what is Predicate and a Function

- **🏷️Tags** : #20-05-2022,  #pending #completed #permanent

#### 🔗 Links


## Key Takeaways

## Overview
-  There are some predined functional interfaces in java like Predicate,Consumer and Supplier


### Predicate 
- functinal interface 
- functions like test -->  which will return boolean value
- function
	- test
	- negate
	- or
	- isEqual
```java

// Java program to illustrate Simple Predicate

import java.util.function.Predicate;
public class PredicateInterfaceExample1 {
	public static void main(String[] args)
	{
		// Creating predicate
		Predicate<Integer> lesserthan = i -> (i < 18);

		// Calling Predicate method
		System.out.println(lesserthan.test(10));
	}
}


```


#### Predicate Chainning
```java

// Java program to illustrate Predicate Chaining

import java.util.function.Predicate;
public class PredicateInterfaceExample2 {
	public static void main(String[] args)
	{
		Predicate<Integer> greaterThanTen = (i) -> i > 10;

		// Creating predicate
		Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
		boolean result = greaterThanTen.and(lowerThanTwenty).test(15);
		System.out.println(result);

		// Calling Predicate method
		boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
		System.out.println(result2);
	}
}


```

