# What are the exceptions in java ?
#coding 
#java 
#interview 



## Exceptions
- unexpected event, that occurs and disrupt the normal flow of a program (**isko recover kar saktein hain **)
- Exceptions can be caught and handled
- When exception occured, it creates an object 
	- This object has name,description and state of the program when the exception occured


### Reasons for exception
1. Invalid user input
2. Device failure
3. Loss of network connection
4. Code errors


## Error
- irrecoverable conditions ( **bhai isko recover nhi kr sakte**)

### Reasons of Error
- memory leaks
- stack overflow error 


![[Pasted image 20220418113706.png]]


## Types of Exceptions 

![[Pasted image 20220418113747.png]]


### Checked exceptions
- These are checked by compiler at compile time

### Unchecked Exceptions
- These are not checked at compile time so it will be thrown at run time


### User defined exceptions
- the build in exceptions is not able to descibe the situation in that case we can create user defined excpetions for meaningful error reporting.




# How JVM Handles Exceptions
- Whenever a exception is thrown in the method it will create  a exception object with name (this is the method name where exception occured) and desciption (exception discripiotn) and current state (call stack).
- Now this will be handed over to  the JVM
- JVM will go through the list of methods inside the call stack to find the method that can handle the exception.
- if it found appropiate handler than it is fine, if not able to find in that case it will be forwarding it to   [[default exception handler in java]]
- default exception handler will print name, description, call stack and it will also terminate the program abnormally **bhai default handler , bichare ko kya pta kaise handle krna hai toh usme apni taraf sae puri jaan lagai aur result print krwa diya**



### Examples

1.  simplest example
code

```java
class exceptionprep {

    public static void main(String[] args) {

        exceptionprep.test();

   
    public static void test() {

        String str=null;

    System.out.println(str.length());

    }

}
```

-  her the output is : method name, exception name and call stack 
```
Exception in thread "main" java.lang.NullPointerException
        at exceptionprep.test(exceptionprep.java:10)
        at exceptionprep.main(exceptionprep.java:5)
```


2. Exception Propagation

```java
 class exceptionPropagation {

    public static void main(String[] args) {

        int a=1;

        int b=0;

  

        try {

            int i=computeDivision(a, b);

        } catch (ArithmeticException e) {

            //TODO: handle exception

  

            System.out.println(e.getMessage() +"  exception handled in main");

        }

    }

  

    public static int divideByZero(int a, int b) {

        return a/b;

    }

  
  

    public static int computeDivision(int a, int b) {

        int res=0;

  

        try{

            res=divideByZero(a, b);

        }

        catch( NumberFormatException e) {

            System.out.println("exception catched in compute division");

        }

  

        return res;

    }

  
  

}
```


- Output 
- exception occured in method divide by zero but there it is not handled so it propogates to the calling method, there also is not able to handle so it propagates to main method, there we can see Airthmetic Exception and hence it is handled there. :) 
```
/ by zero exception handled in main
```


## [[How to handle real life exceptions in java]]