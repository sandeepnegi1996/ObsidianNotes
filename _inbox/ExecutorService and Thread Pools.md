# 📑 ExecutorService and Thread Pools

- **🏷️Tags** : #04-06-2022,  #pending #completed #permanent

#### 🔗 Links


## Key Takeaways

## Overview
- it is ok to create one or two threads and manage it by your own but it will be issue for thousands of threads and to manage that
- Executors : *Framework for creating and managing threads*


## Executors Framework
1.  **Thread Creation** : creates pool of threads
2. **Thread Management** : it manages life cycle of threads , so we don't need to worry while submitting a task to the thread , whether the thread is busy or dead.
3. **Task Submission and Execution**


### Executor Interface
- These interfaces will be used for creating and managing threads.

1. **Executor**  :  simple interface , method execute to launch a task by Runnable Object
2. **ExecutorService** :  sub interface of Executor it has additional submit method , which can take Callable or Runnable Object, Callable is same as Runnable, just the method `call` will return some value.
3. **ScheduledExecutorService**  :   Sub interface of Executor Service this adds the functionality of Schedule.

### Shutting down the Executor Service
1. **shutdown()**  : will wait for current task to finish , and then shutdown
2. **shutdownNow()** : this will immediately shutdown 

#### Example with Single Thread
1. Here we have seen the basic use of the Executor Service
2. ExecutorService it uses single worker thread for executing tasks.
3. if that thread is busy and we submitted some task then we have to wait for that time period
4. executor service will keep listening for new tasks until we shut it down explicitly.
5. if there are multiple task we submit to single thread using executor service in that case it will wait for the previous to complete but the submit will work but the execution will take time 

```java

package io.vertx.example;  
  
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
  
public class ExecutorExample {  
  
    public static void main(String[] args) {  
        System.out.println("Inside  : " + Thread.currentThread().getName());  
  
  
        System.out.println("Creating Executor Service...");  
        ExecutorService executorService= Executors.newSingleThreadExecutor();  
  
        System.out.println("Creating Runnable...");  
        Runnable runnable1 = ( ) -> {  
  
            try {  
                Thread.sleep(3000);  
            } catch (InterruptedException e) {  
                throw new RuntimeException(e);  
            }  
            System.out.println("Inside : " + Thread.currentThread().getName());  
        };  
  
  
        System.out.println("Creating Runnable 2 Example ....");  
        Runnable runnable2 = ( ) -> {  
  
            System.out.println("Inside : "+ Thread.currentThread().getName());  
  
        };  
  
  
        System.out.println("submitting runnable 1");  
        executorService.submit(runnable1);  
  
        System.out.println("Submitting runnable 2");  
        executorService.submit(runnable2);  
  
  
        executorService.shutdown();  
    }  
}

```



### Executor Service Example with multiple threads and Tasks

```java
package io.vertx.example;  
  
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
  
public class ExecutorsExample {  
  
    public static void main(String[] args) {  
  
        ExecutorService executorService= Executors.newFixedThreadPool(5);  
  
        Runnable runnable1 = ( ) -> {  
  
            try {  
                Thread.sleep(3000);  
            } catch (InterruptedException e) {  
                throw new RuntimeException(e);  
            }  
  
            System.out.println("Inside : " + 
           Thread.currentThread().getName());  
         };  
  
  
        Runnable runnable2 = ( ) -> {  
  
            try {  
                Thread.sleep(4000);  
            } catch (InterruptedException e) {  
                throw new RuntimeException(e);  
            }  
  
            System.out.println("Inside : " + 
             Thread.currentThread().getName());  
        };  
  
  
        Runnable runnable3 = ( ) -> {  
  
            try {  
                Thread.sleep(2000);  
            } catch (InterruptedException e) {  
                throw new RuntimeException(e);  
            }  
            System.out.println("Inside : " + 
                  Thread.currentThread().getName());  
        };  
  
        executorService.submit(runnable1);  
  
        executorService.submit(runnable2);  
  
        executorService.submit(runnable3);  
  
        executorService.shutdown();  
    }  
}

```



### Thread Pool Working 
1. A thread pool is a bunch of worker threads managed by Executor
2. Creating a thread is expensive that's why we wants to limit the creation of threads and management by our self
3. **Blocking Queue**  : When task is submitted to Executor Service it will be inserted in blocking Queue if no threads are available to take the task

Example
1. Three tasks are there and there is only one thread in Thread Pool and that case all the three tasks are stored in blocking Queue and wait for their turn


 