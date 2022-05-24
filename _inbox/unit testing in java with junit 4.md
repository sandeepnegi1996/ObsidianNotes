# 📑 unit testing in java with junit 4

- **🏷️Tags** : #22-05-2022,  #pending #completed #permanent

#### 🔗 Links
project link 
[github](https://github.com/sandeepnegi1996/java-hello-world-with-maven)

## Key Takeaways

## Overview
- here we will write testcase for a normal class
- we are using junit 4 with simple maven project

## Best Practices
1. use same structure as for java files for the test files
2. Test case naming should be : given_when_then

Example 
```java
public class CircleTest {
    @Test

    public void givenDoubleMaxValueAsRadius_whenCalculateArea_thenReturnAreaAsInfinity() 
    {

    }

}

```
3. single unit test case should test single thing 
4. Mock external services using `mockito`
5.  Atleast 80% code coverage
	1. since we cannot provide 100% code coverage we should atleast focus on 80% code coverage
	2. Use tools like `JaCoCo` and `Cobertua` along with maven or Gradle to generate code coverage report

6. unit test execution should be part of CI-CD pipelines to avoid certain malfunctions.
7. *Never connect external sources to your unit such as database connecctions use mockito in this case*
8. [[how to use mockito ]]
## Types of test case
1. Test with normal assert statement
2. Test with expected , here we are checking whether this test is throwing this exception or not
3. Test with timeout , here we are checking whether the is running in that particular time or not.


### Class that we wants to test 
```java 

package hello;

  

public class Calculator {

    public int multiply(int a, int b) {

        return a*b;

    }

  

    public double divide(int a, int b) {

        return a/b;

    }

}

```

### Tests for the above mentioned Class
```java

import static org.junit.Assert.assertEquals;

  

import org.junit.AfterClass;

import org.junit.Before;

import org.junit.BeforeClass;

import org.junit.Test;

  

import hello.Calculator;

  

public class CalculatorTest {

  

    private Calculator calculator;

  

    @BeforeClass

    public static void initBeforeClass() {

        System.out.println("this is before class");

    }

  

    @Before

    public void setUp() {

        calculator=new Calculator();

    }

  
  

    @Test

    public void test_PostiveNumber_Multiplication() {

  

        int answer=calculator.multiply(5, 7);

        assertEquals("multiply postitive number",35,answer);

  
  

    }

  
  

    @Test

   public void test_Two_NegativeValues_Multiplication() {

        assertEquals(35, calculator.multiply(-5,-7));

    }

  
  

    @Test

    public void test_OnePostivie_And_OneNegative_Multiplication() {

         assertEquals(-35, calculator.multiply(5,-7));

     }

  
  

     @Test()

     public void test_Multiply_With_Zero() {

         assertEquals(0, calculator.multiply(0, 5));

     }

  
  
  
  
  

     //test for the exceptions

     //fails if the method does not throw the exception

     //testing divide function in case of arithmetic exception

     @Test(expected = ArithmeticException.class)

     public void test_ArithmeticDivisionException() {

  

        int a=5;

        int b=0;

        calculator.divide(a,b);

     }

  
  

     //test for the timeout

     //fails if the method takes longer then the mentioned time

     @Test(timeout = 1000)

     public void test_timeout_Computations(){

         int sum=0;

         for (int i = 0; i < 1000000; i++) {

             sum+=i;

         }

     }

  
  

     //test division method

     @Test

     public void test_divisionRoundFigure() {

        //  assertEquals(5, calculator.divide(10, 2));

         assertEquals(5, calculator.divide(10, 2),0.0);

     }

  

     //test for not round figure

     //here you can see delta is the number which is extra to the particlar division

     @Test

     public void test_NotRoundFigure() {

         assertEquals(5, calculator.divide(11,2), 0.5);

     }

  

     @AfterClass

     public static  void destroyAfterClass() {

         System.out.println("After class ends this will run");

     }

  
  

}

```







