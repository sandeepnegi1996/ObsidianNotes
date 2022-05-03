# 📑 multithreading with examples in java

- **🏷️Tags** : #03-05-2022, #review, #reading_list

#### 🔗 Links
[coding with john](https://www.youtube.com/watch?v=r_MbozD32eo)
[computerphile](https://www.youtube.com/watch?v=7ENFeb-J75k)

## Key Takeaways

## Multithreading in java
- all the threads works independently 
- if one thread blows up it will not affect other thread , means if there is some exception in one thread other threads will keep on running.
- Threre is no particular order in which thread will run since our OS will decide this.
- *Better way of creating thread is Runnable interface* since we can extends other classes with runnable interface.
- If we use Thread and then we cannot extend another class 
- ` t1.join();`   --> this will wait for the thread to complete , so there are cases when one thread wants to wait for another thread to complete 
- `t1.isAlive()` --> this will give boolean values if the thread is alive

```java
class test {

    public static void main(String[] args) {

        System.out.println("hello world");

  

        for (int i = 0; i < 5; i++) {

        MyMultithreading  m1=new MyMultithreading(i);

        Thread t1=new Thread(m1);

        t1.start();

  

        }

        throw new RuntimeException();

  

    }

}

  
  

class MyMultithreading implements Runnable {

  

    private int threadNumber;

  

    public MyMultithreading(int threadNumber) {

        this.threadNumber=threadNumber;

    }

  

    @Override

    public void run() {

       for (int i = 1; i <=5; i++) {

           System.out.println("from thread : "+threadNumber+" value: "+i);

        // if (threadNumber==3) {

        //     throw new RuntimeException();

        // }

  

        try {

            Thread.sleep(1000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

    }

  

    System.out.println("getting out of thread");

    }

  

}

```


###  Thread Priority 
1. We can set thread priority but execution order is not guaranteed 
2. Thread Scheduler is part of OS and JVM does not have control over it 


###  How to synchronize the ArrayList in java ?
1. [[what is synchronized and non synchronized Collections in java ]]
2.  Arraylist -> non synchronized collection and should not be used in concurrent environment without explicit synchronization 
	1. Collections.synchronizedList() :  returns synchronized list backed by the specified list
	2. CopyOnWriteArrayList : thread-safe variant of ArrayList


#### Collections.synchronizedList() to Synchronize the ArrayList
- here we need explicit synchronized block
```java

import java.util.*;

public class Main {
    public static void main(String[] args) {
      
      List<String> listofString=Collections.synchronizedList(new ArrayList<String>());
      
      listofString.add("sandty");
      listofString.add("dhruv");
      
      
      synchronized(listofString) 
      {
        listofString.forEach(System.out::println);
      }
      
        
    }
}
```


#### CopyOnWriteArrayList : thread safe variant of ArrayList
- here we don't need explicit synchronized block
- it is thread safe variant of ArrayList
- 



## Notes from computerphile
- proess --> series of instruction
- OS keep track of instructions, memory, etc
- separate process have separate memory and CPU 
- lighter weight threads
- multiple threads : 
- OS is basically taking threads and running on different cores based on requirements
- program running in serial fashion we have more control
- but in paralle we don't have any control
-  so both the threads can update the value and we cannot decide when one should updat ehte variable
- we can control this with the `lock` and `synchronize the block`
- lock the variable once we want to take action on it and then unlock the variable once operation is done, this is similar to a `token` if we have  a token then only we can make a change
- Our end goal not is to reduce the number of times we are using lock
- writing needs to be regulated in multithreading



