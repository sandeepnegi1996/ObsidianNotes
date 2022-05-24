# 📑 how to use mockito

- **🏷️Tags** : #22-05-2022,  #pending #completed #permanent
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
3. 