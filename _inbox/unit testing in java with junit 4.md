# 📑 unit testing in java with junit 4

- **🏷️Tags** : #22-05-2022,  #pending #completed #permanent

#### 🔗 Links
project link 
[github](https://github.com/sandeepnegi1996/java-hello-world-with-maven)
[sandeepnegi1996/junit_testing: This is the project for learning the junit working (github.com)](https://github.com/sandeepnegi1996/junit_testing)


## Key Takeaways

## Overview
- here we will write testcase for a normal class
- we are using junit 4 with simple maven project

### Repository
[sandeepnegi1996/junit_testing: This is the project for learning the junit working (github.com)](https://github.com/sandeepnegi1996/junit_testing)

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



#### Project Status   
[![Java CI with Maven](https://github.com/sandeepnegi1996/junit_testing/actions/workflows/maven.yml/badge.svg?branch=master)](https://github.com/sandeepnegi1996/junit_testing/actions/workflows/maven.yml)  

# Junit5 with Java   
  
1. This project is build just to test the working of the junit5 with the java project  

  
1. first create a project using maven choosing archtetype to be quickstart  
2. Second Create a class in the project with some data in our case it is out Dog with getters and setters  
3. now click on the default package and create the jnuit test cases   
4. Above option will automatically create the class  
5. we just have to add the test cases to our class  
6. @BeforeAll --> will run before any test case will run --> its name should be before  
7. @AfterAll  --> will run at the last of the test cases --> Its name should be after  
8. @BeforeEach      --> will run before every test cases       --> Its name should be setUp  
9. @AfterEach       --> will run after every test cases        --> Its name should be tearDown  
10. @Test        --> is used to create a test case          --> just put this above any of the function  
11. one scenario should be tested in one test   
12. run the tests with coverage and intellj will show you all the lines covered and not covered   
13. Always cover all the lines of the code   
14. by default mocked object returns null for all of its methods  
15. `when` -> when we mock a object and use that so that mocked object will basically internally is going to call some methods   
    1. this part you can mock with a when method   
    2. ```java  
@Mock  
Nest mMockAddress;  
  
@Mock  
Career mMockCareer;  
when(mMockCareer.increaseSalary(1000)).thenReturn(true);  
when(mMockCareer.increaseSalary(0)).thenReturn(false);  
  
```  
16. `verify` ->  below mentioned test will pass when the verify method is called 3 times and is being called with an int value  
```java  
  
verify(mMockCareer, times(3)).increaseSalary(anyInt());  
```  
  
17. Below mentioned test case will pass if the method increaseSalary is called 1 time with 1000 as value  
```java  
  
verify(mMockCareer, times(1)).increaseSalary(1000);  
```  
  
17. `captor` -> here we have captured that when the method is being called by the mocked object what is passed as an arguement   
    1. and then we have use assertTrue to read the value from captor and verify it against the value received  
  
```java  
@Captor  
ArgumentCaptor<List<Integer>> captor  
  
        verify(mMockCareer, times(1)).increaseSalary(captor.capture());  
        assertTrue(captor.getValue().contains(1000));  
```  
18. `spy` -> we can use all the cool stuff when , verify, captur with non mocked object   
  
```java  
private Nest mSpyAddress;  
  
@Before  
public setup() {  
        mSpyAddress = Mockito.spy(new Nest())  
@Test  
public testAddress() {  
        when(mSpyAddress.getStreetName()).thenReturn(“Has no name”);        assertEquals(mSpyAddress.getStreetName(), “Has no name”);        verify(mSpyAdress,times(1)).getStreetName();  
```  
#### How to create a test case  
  
1. Add the annotaion @Test above any funciton with void return type  
2. In this function we will compare some values using **assert.Equals** like there are other methods that can be used.  
  
3. Common Assert that will be used  
   1. `AssertEquals`  
   2. `AssertNotEquals`  
   3. `Assertions.assertNotEquals();`  
   4. `Assertions.assertNull();`  
  
4. Example of negative test  
```java  
// adding negative testcases  
   //below mentioned testcase will pass when the expected and actual name is not correct and that is what we are testing   // we have given actual as tommy and expected it to be sheru so this should not be equal   @Test   @DisplayName("Verify wrong dog name")   void myDogNameIncorrentTest() {      myDog= new Dog("tommy","stray");      String dogNameActual= myDog.getName();      String expected="sheru";      Assertions.assertNotEquals(expected,dogNameActual);  
   }  
          
```  
  
4. Example of positive Test   
this test will pass when the values are equal  
```java  
   @Test   @DisplayName("verify breed name")   public void myDogBreedValidTest() {      myDog=new Dog("tommy","bernard");      String breed=myDog.getBreed();//    assertEquals("Breed not same","bernard",breed);  
  
      Assertions.assertEquals("bernard",breed);         }  
  
```  
  
    ```java        assertEquals("Error name is different","tommy",mdogName);    ```  
6. full example of the test case is   
```java  
       public void myDogBreedTest() {                 String breed=myDog.getBreed();  
      assertEquals("Breed not same","bernard",breed);         }  
```  
  
7. ```java  
    @Test    @DisplayName("Verify the the myDog object is null")    void verifyDogObjectIsNull() {        myDog=null;        Assertions.assertNull(myDog);    }  
    @Test    @DisplayName("Verify that the myDog object is not null")    void verifyMyDogNotNull() {        Assertions.assertNotNull(myDog);}  
```


#### Examples  
```java

```


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




### Tests for the above mentioned Class

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

