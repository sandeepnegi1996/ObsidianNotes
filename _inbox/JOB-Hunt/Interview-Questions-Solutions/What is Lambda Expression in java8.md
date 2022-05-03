# What is Lambda Expression in java8

## Overview
- only one abstract method it can have other default methods or static method
- **Lambda expression implement the only abstract method in the interface**
- *lambda expression can represent the instance of the functional interface*
- 




### Simplest Functional Interface Example
[[What is functional Interface]]
```java

interface FuncInterface
{
	void abstractFun(int x);
}

class Test
{
	public static void main(String args[])
	{
		
		FuncInterface fobj = (int x)->System.out.println(2*x);

		// This calls above lambda expression and prints 10.
		fobj.abstractFun(5);
	}
}


```


### forEach with Lambda Expression
```java
import java.util.ArrayList;
class Test
{
	public static void main(String args[])
	{
		
		List<Integer> arrL = new ArrayList<Integer>();
		arrL.add(1);
		arrL.add(2);
		arrL.add(3);
		arrL.add(4);

		
		arrL.forEach(n -> System.out.println(n));

		
		//inside forEach multiple lines of lambda expression is there 
		arrL.forEach(n -> { 
		if (n%2 == 0) 
			System.out.println(n);
		});
	}
}

```

##  Block Lambda Expression
1. lambda expressions can have multiple lines
2. lambda expression can have single line

```java

FuncInterface obj = (x) -> {
	if(x>0) {
		System.out.println("hello world")
	}
} 

```

## Lambda Expression as an argument to a function
1. lambda expression can also be passed to a function arguement ,since it represenets the instance of the functional interface we can call the particular method of the interface.

```java

  

 interface Calculator {

  int multiply  (int n);

}

  
  

class test {

    public static void main(String[] args) {

        //lambda expression

        Calculator cal= (n) -> {

            int y=6*n;

            return y;

        };

  

        //calling the implemented method

         System.out.println(cal.multiply(6));

  

        //passing lambda expression as an arguement

        displayData(cal);

    }

  

    public static void displayData(Calculator c) {

  

        System.out.println(c.multiply(5));

    }

}

```
