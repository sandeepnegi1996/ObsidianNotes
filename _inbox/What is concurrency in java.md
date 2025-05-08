# 📑 What is concurrency in java

- **🏷️Tags** : #03-05-2022, #review, #reading_list

#### 🔗 Links
[how to in java](https://howtodoinjava.com/java-concurrency-tutorial/)

## Key Takeaways
- Important Topics
- [[multithreading with examples in java]]

## Overview
1. concurrency : run several programs or parts of programs in parallel
2. it helps in achieving high performance and throughput
3. modern computers have many cores, means a programs can use this cores to run the part of its instruction to achieve the results faster.
4. java concurrency : backbone -> threads -> lightweight ->threads have their own callstack but they can access shared data of other threads in the same process.


###  Concurrency simple or tough
1. we know that using concurrency will help us in having better performance high throughput but implementing concurreny is not that much simple.
2. Concurrent Applications : has more complex design as compared to single threaded application
3. more attention : required in areas where we are sharing data
4. it is hard to debug concurrent application
5.  we need to understand in which case we require concurrent application or single threaded application


##  Basics of Java Concurrency
###  Evolution
- JDK 1.8 is largely known for Lambda changes, but it also had few concurrency changes as well. Two new interfaces and four new classes were added in **java.util.concurrent** package e.g. `CompletableFuture` and `CompletionException`.


### Thread Safety
- thread safe code is that it will work even if many threads are executing it simultaneously

#### What is correctness in thread safety ?
-  class is thread -safe when it continues to behave correctly when accesed from multiple threads.
- thread safe classes will have their own synchronization so that clients need not to provide their own thread safety
- each thread is having its own call stack means that information is not shared among other threads.

### Object Level lock vs Class Level lock in java 
1. synchronized block of code can only be executed by one thread at a time.
2. synchronization is the process: which keeps concurrent threads to be in sync
3. method : synchronized : the threads holder the `monitor` or `lock` for that method 
4. another thread will not be able to access the synchronized block under one thread has locked it 
5. *synchronized keyword* : can be used with class, method,blocks
6. when ever threads comes to synchronized block it acquire a lock and once completed it will remove the lock
7. *synchronized block cannot be used with constructor*
8. 

#### Object level lock in java
1.  it is used for non static method
2. to make instance level data thread safe
3. we can use synchronized block or we can use synchronized keyword with the name of the method

```java
public class DemoClass

{
	public synchronized void demoMethod(){}
}

or 

public class DemoClass 
{
	public void demoMethod() {

		synchronized(this) { }


		}
}


	public class DemoClass
{

	private final Object lock=new Object() ;

	public void demoMethod() {

		synchronized(lock) {
		
		}
	}
}

```


#### Class Level Lock in java
- it is used for static data thread safe, since there is only one copy of static data, and we don;t want it to be exploited by other threads.

```java

`public` `class` `DemoClass`

`{`

  `//Method is static`

  `public` `synchronized` `static` `void` `demoMethod(){`

  `}`

`}`

`or`

`public` `class` `DemoClass`

`{`

  `public` `void` `demoMethod()`

  `{`

    `//Acquire lock on .class reference`

    `synchronized` `(DemoClass.``class``)`

    `{`

      `//other thread safe code`

    `}`

  `}`

`}`

`or`

`public` `class` `DemoClass`

`{`

  `private` `final` `static` `Object lock =` `new` `Object();`

  `public` `void` `demoMethod()`

  `{`

    `//Lock object is static`

    `synchronized` `(lock)`

    `{`

      `//other thread safe code`

    `}`

  `}`

`}`

```

