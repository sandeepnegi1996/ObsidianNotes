# 📑 Types of Memory in java

- **🏷️Tags** : #23-04-2022, #review, #reading_list #prep2025 

## 🔗 Links
https://www.geeksforgeeks.org/how-many-types-of-memory-areas-are-allocated-by-jvm/


- [ ] [[how string constant pool works under the hood]]

## Overview
1. JVM converts byte code into machine code 
2. *JVM is run-time engine* to run java application, *JVM calls the main method*
3. JVM is part of JRE

## JVM does these operations
1. Loading code
2. Verification
3. Execute
4. run-time environment [[what is run-time environment ]]

![[Pasted image 20220423113220.png]]

## Classloader 
- it is part of JVM and is used to load the class
1. Loading 
2. Linking 
3. Initialization


## Memory Areas Allocated in JVM
- So all the operations perform by JVM needs some memory, so memory is divided into 5 parts those are

 1. Class (Method) Area
 2. Heap
 3. Stack
 4. Program Counter Register
 5. Native Method Stack


## Class (Method ) Area --> pending
- stores class code
- Variable Code
- Method code and Constructor
- *Store everything which is there in class*
- class-level data of every class

## Heap : Shared Memory
1.  Allocate memory to object at run-time
2. class Object, Arrays , list etc
3. also called as shared memory, here threads will share the same data.
4. 

## Stack
1. each thread will have its own private JVM stack
2. [[Multithreading and multiprocessing]]
3. for each method call a new frame is inserted in the stack, 
4. Frame is destroyed when method completes
5. Each thread that is executing a method , have its own counter register and java stack

## Program Counter Register :
1. Each thread that is executing a method , have its own counter register and java stack
2. non native method has Program Counter Register that will store the available JVM instructions 
3. where as in native method the value of Program Counter is undefined


## Native Method Stack
1. memory which is assined to each thread when it is created 


## Key Takeaways
1. **Local Variables are stored in frame during run time** 
2. **Static variables are stored in Method Area**
3. **Arrays and object are stored in heap (Shared Memory)**



















