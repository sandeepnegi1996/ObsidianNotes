# How to handle real life exceptions in java

1. it is managed by 5 keywords
	1. try : if something can throw exception, put it in try block
	2. catch : catch the exception
	3. throw : manually throw an exception
	4. throws : jo throw kiya tha usse mention krna padega with throws
	5. finally :  yae hamesha run karega after try block


## throw Vs throws
- throw is used to throw an exception it can be build in or user defined
- throws is used to delegate the exception


### throws
- If there is a program that can throw an exception so , compiler knows it can throw an exception and it will throw warning, and it is compulsory to handle that checked exception, otherwise we will have compile time errors

*throws keyword is required only for checked exception*
- *since checked exception can be caught during compile time and it helps to delegate that *
- throws keyword is just to convice it will not handle the abnormally abstruction of program
- how we can handle exception
	- try and catch
	- throws

- with throws we can delegate the exception to the caller method,
	- **isko matlab hota hai topi pehnana, bhai mtlb apna apna dekh lo jo call kr rha hai apna dekho maine toh bol diya tha  ki mai handle nhi kr rha hun exception**


## throw example

```java


class ThrowExcep
{
	static void fun()
	{
		try
		{
			throw new NullPointerException("demo");
		}
		catch(NullPointerException e)
		{
			System.out.println("Caught inside fun().");
			throw e; // rethrowing the exception
		}
	}

	public static void main(String args[])
	{
		try
		{
			fun();
		}
		catch(NullPointerException e)
		{
			System.out.println("Caught in main.");
		}
	}
}

```


### throws example
```java

 class throwvsthrows {

  
  

    static void fun()  {

        System.out.println("inside fun");

        throw new IllegalAccessException("from fun");

    }

    public static void main(String[] args) {

  

    }    

}
```

here the output is :
```
error: unreported exception IllegalAccessException; must be caught or declared to be thrown
        throw new IllegalAccessException("from fun");
```


- once i declarared throws there will be no compile time error 
- Above mentioned error during compile time will be gone, now the error will only come when we run it , and the parent method that is main needs to handle that
```java
 class throwvsthrows {

  
  

    static void fun() throws IllegalAccessException{

        System.out.println("inside fun");

        throw new IllegalAccessException("from fun");

    }

    public static void main(String[] args) {

  

    }    

}
```