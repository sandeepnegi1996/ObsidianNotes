# 📑 How to use Mockito ?

- **🏷️Tags** : #22-05-2022,  #pending 
[[unit testing in java with junit 4]]
#### 🔗 Links
[java code geeks](https://www.javacodegeeks.com/2015/11/getting-started-with-mockito.html)

## Key Takeaways

## Overview
- use mockito
- mocks, Spies, Partial Mocks and stubbing behavior
- Mockito fits perfectly with TDD


## Why Mock
1. when we do unit test we wanted to test in isolation
2. we just wanted to verify our own code the current class under test .
3. so if we are testing a class and that class is calling some other classes functionality
so there is a possibility that the other class code is buggy and it will fail our test case.
4. imagine there is class that is calling database to get the details and the databse is not present or database is down so in that case our test case will fail
5. imagine there is service which is calling some remote service and due to which our test case is failing , since it took too long to receive the response from that service 
6. [[what is a collaborator in java]]
7. what if we wants to test boundary values returned from a collaborator
8. All these issues which can be solved by mocks.

- *Mocks acts as a substitute for the classes with which we are collaborating they take their place and behave exactly how we tell them to behave*
- Mocks execute fast , it does not require external resources
- Mocks will return that value that we want it to return throw an exception that we wants it to throw
- Mocks make sure our own code works, regardless of the behavior of the collaborators.


 
## Introduction to Mockito
1. Mocking has two phases
	1. Stubbing 
	2. Verification


### Stubbing
- *specifying behavior of our mocks*
-  it basically controls what we want our mock to do
- forcing to return a particular value or throw a particular exception it allows us to perform different behaviors under different conditions.

### Verification
- *verifying interactions with our mock*
- it ensure that exactly the values that we expect are passed to our collaborators


### Limitations of Mockito
- you can't mock, final classes and final methods
- you can't mock static method
- you can't mock equals and hashCode() method


## 2.1 A Quick Example of Stubbing 
1. lets say we are writing one service that will call the method `getDegreeC()` and this method will get the data from the sensor and then based on the value return i wanted to return hot, mild cold
2. so in our test case how we will be able to check all the three scenarios since we cannot change the room temperature to fall into different catergories, so we will mock it to return different values

`when(sensor.getDegreesC()).thenReturn(15.0)`

## 2.2 A Quick Example of Verificatoin --> pending
1. imagine a class which does some calculation and is responsible for notifying an observer when it has finished it calculation.

`verify(observer).notify();`


- this tells mockito that the notify method must be called once and only once otherwise the unit test should fail.
- 
## 3. How to use mockito with maven
1. this can be easily google and figured out I will just add the dependdency.

```XML

<dependency>
<groupId>org.mockito</groupId>
<artifactId>mockito-all</artifactId>
    <version>1.9.5</version>
    <scope>test</scope>
   </dependency>

```


- Gradle

```XML
dependencies {
    testCompile "org.mockito:mockito-all:1.9.5"
}

```


## 4. Use Mockito with Junit 
1. `@RunWith(MockitoJunitRunner.class` --> this will be added on the class
2. 

 ####  Example1 
```java

import java.util.List;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
 
@RunWith(MockitoJUnitRunner.class)
public class MyTest {
     
    @Mock
    private List<String> mockList;

	   @Test
	public void test() {
	 String expected = "Hello, World!";
	 when(mockList.get(0)).thenReturn(expected);
 
	 String actual = mockList.get(0);
	 assertEquals(expected, actual);
	 System.out.println(actual);

	}

}
```

- `@Mock` --> this annotation tells Mockito that `mockList` is to be treated as a mock
- `@RunWith` --> this annotation tell that go through all the members of the MyTest which are annotated with `@Mock ` and initialize them
- here if we try to get any other values from the mockList we will get the null value since we have stubbed only the value at 0 index. consider like no list is created all the list does is what is inside the method and what we have added using stubbing.
- 


## Example 2 
1. TemperatureService 

```java

package hello;

  

public class TemperatureService {

  

    //this method basically return some temperature any random value

    public int temperatureSensorData() {

        double temp= Math.random();

        return (int)temp;

    }

}

```


2. TemperatureServiceTest

```java

  

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;

  

import org.junit.Test;

import org.junit.runner.RunWith;

import org.mockito.Mock;

import org.mockito.runners.MockitoJUnitRunner;

  

import hello.TemperatureService;

  

@RunWith(MockitoJUnitRunner.class)

public class TemperatureServiceTest {

  

    @Mock

    private TemperatureService tempService;

  

    @Test

    public void test_TemperatureGreater_GreaterThan_100() {

  

        //here we are stubbing the value from the service which is greater than 101

        when(tempService.temperatureSensorData()).thenReturn(101);

        int actual=101;

        int expected=tempService.temperatureSensorData();

        //here we are comparing the actual and the expected values

        assertEquals(expected,actual);

  
  
  

    }

  

    @Test

    public void test_TemperatureService_LessThan_100() {

  

        when(tempService.temperatureSensorData()).thenReturn(99);

  

        int actual=99;

        int expected=tempService.temperatureSensorData();

  

        assertEquals(expected,actual);

    }

  

    @Test

    public void test_TemperatureService_LessThan_50() {

        //when and then

  

        when(tempService.temperatureSensorData()).thenReturn(34);

  

        int actual=34;

        int expected=tempService.temperatureSensorData();

        assertEquals(expected, actual);

    }

}

```

### How to throw exception using mockito

```java
when(tempService.temperatureSensorData())

        .thenThrow(new NumberFormatException("temperature is not appropiate"));

```

## 5. Mockito Best Practices

Mockito encourages standard best practices in unit testing and design in general, namely:

-   Mockito does not have a provision for mocking static methods because Mockito encourages object oriented design and dependency injection over procedural code.
-   Mockito does not have a provision for mocking private methods because public methods should be black boxes and from the standpoint of testing private methods don’t exist.
-   Mockito packages and encourages the usage of Hamcrest Matchers, which will be covered in subsequent tutorials.
-   Mockito encourages adherence to the [Law of Demeter](https://en.wikipedia.org/wiki/Law_of_Demeter) and does not encourage mocking chained methods.
-   You should not stub or verify on a mock which is shared between different threads. You may call the methods of a shared mock, however.
-   You can’t verify the `toString()` method of a mock, due to the fact that it may be called by the test environment itself, making verification impossible.
-   If your test cases use the Given When Then notation you can use the stubbing methods from `org.mockito.BDDMockito` so that `when(mock.method()).thenReturn(something)` becomes `given(mock.method()).willReturn(something)` as it will read nicely in your test format.
-   It is possible to use Mockito without the Mockito annotations, however it is much easier and neater to use the annotations so that is what we will do in these tutorials.
-   You can ‘spy’ on any class, including the class under test if your testing requires that you modify the behaviour of a particular method of the class for the purposes of the test. Mockito explicitly recommends that spies should be only used carefully and occasionally, for instance when constrained by dealing with legacy code. This will be covered in a future tutorial.
-   In the event that the real call into a spied method could generate an error condition or cannot be called for some other reason Mockito recommends using the do* family of methods for stubbing. This will be covered in a future tutorial.
-   Mockito will allow you to use argument matchers in place of real arguments with the limitation that if one argument uses a matcher, all must use matchers. Argument matchers will be covered in a later tutorial but should probably be used sparingly.
-   Mockito provides a `verifyNoMoreInteractions()` method to verify that a particular mock has no more interactions but recommends that it is used very sparingly and only when appropriate.
-   Mockito provides the `Answer` interface to allow for stubbing with callbacks, however it recommends against using it and encourages you to do simple stubbing using the `thenReturn()` and `doThrow()` methods. We will cover Answers in a later tutorial.
-   If using `ArgumentCaptor` for argument validation you should use it only in the verification phase, and not the stubbing phase. `ArgumentCaptor` will be covered in a future tutorial.
-   Mockito recommends to use Partial Mocks very carefully, mainly when dealing with legacy code. Well designed code should not require the use of partial mocks.
-   Mockito provides a `reset()` method for resetting your mock in the middle of a test method, however it recommends against using it as it is a code smell that your test may be overly long and complex.

There are more features and practices, but these are the main ones which Mockito tells you to watch out for. We will cover all of the above and more in depth in the coming tutorials.

