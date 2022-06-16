# 📑 Java Callable and Future Tutorial

- **🏷️Tags** : #04-06-2022,  #completed 

#### 🔗 Links
[callicoder](https://www.callicoder.com/java-callable-and-future-tutorial/)

## Key Takeaways

## Overview
- objects of Runnable interface are very convenient to create a task but it is limited by the fact that the task can not return a result.
- what if we want to return a result from our task, in that case we should use `Callable` which is similar to `Runnable` , it just return a result and throw a checked exception.
- Callable interface --> single method call 

---

### Implementing Callable

1. First way using a class and implements Callable interface and override the call method
```java
public class CallableEXample implements Callable {  
  
    @Override  
    public Object call() throws Exception {  
  
        Random generator =new Random();  
  
        Integer randomNumber = generator.nextInt(5);  
  
        Thread.sleep(1000);  
  
        return randomNumber;  
    }  
}

```


2. Second way using lambda expression
3. Thrid way

```java

//third way of creating callable object  
Callable<String> callable = new Callable<String>() {  
  
    @Override  
    public String call() throws Exception {  
        return "just testing";  
    }  
};  
  
  
//second way of creating callable object using lambda expression  
Callable<String> exampleTest= () -> {  
    return "inside example callable";  
};

```


---

### Executing Callable Tasks using Executor Service and storing results in Future.

1. Callable tasks can be submit to executor service for execution.
2. for the callable results , what is the mechanism 
3. since the executor service submit method needs to store the result of the callable tasks to some variable once the result is available it stores the results in the `Future`
4. We can fetch the result from the future once the result is available 
5. `Future` is similar `Promise` in other languages such as javascript.

-  here you can see first one callable for task
- executor service with one thread
- submit the task and store the result in Future
- submit method immediately give the future whether the task is finished or not
- we can complete our other tasks meanwhile we don't need to wait for the task to the completed
- while the task is not completed --> `future.isDone` will give false
- once the task is completed it will be true 
- get method of future can be used to obtain the result

---

#### Example
```java
public class CallableFutures {  
    public static void main(String[] args) throws ExecutionException, InterruptedException {  
  
        Callable<String> callable2= () -> {  
            Thread.sleep(5000);  
            return "inside example callable";  
        };  
  
  
        ExecutorService executeMyTask= Executors.newSingleThreadExecutor();  
  
        Future<String> futureResultTask  =  executeMyTask.submit(callable2);  
  
        System.out.println("Executed after task submittion");  
  
  
        while(!futureResultTask.isDone()) {  
            System.out.println("result not obtained");  
        }  
  
        System.out.println(futureResultTask.get());  
          
  
    }  
}

```


---


### Cancelling a Future
1. using ` Future.cancel() `

### InvokeAll
1. submit multiple tasks and wait for all of them to be complete.
2. This code has list of tasks 
3. List of futures
4. and then call `invokeAll`
5. print result at end 

```java
public class CallableFutures {  
    public static void main(String[] args) throws ExecutionException, InterruptedException {  
  
        Callable<String> callable1 = () -> {  
            Thread.sleep(3000);  
            return "callable 1";  
  
        };  
  
        Callable<String> callable2= () -> {  
            Thread.sleep(5000);  
            return "callable 2";  
        };  
  
        Callable<String> callable3 = () -> {  
            Thread.sleep(4000);  
            return "callable 3 ";  
        };  
  
  
  
  
  
        ExecutorService executeMyTask= Executors.newFixedThreadPool(3);  
  
  
        List<Callable<String>> taskList= Arrays.asList(callable1,callable2,callable3);  
  
        List<Future<String>> futureResultList  =  executeMyTask.invokeAll(taskList);  
  
        System.out.println("Executed after task submittion");  
  
  
        //result is printed only when all the tasks are completed  
        for( Future<String> current : futureResultList) {  
  
            System.out.println(current.get());  
        }  
  
  
        executeMyTask.shutdown();  
  
  
    }  
}
```