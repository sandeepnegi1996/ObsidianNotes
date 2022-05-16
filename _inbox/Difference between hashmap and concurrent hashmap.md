# 📑 Difference between hashmap and concurrent hashmap

- **🏷️Tags** : #10-05-2022,   #completed #permanent

#### 🔗 Links
[hashmap and concurrent hashmap](https://www.geeksforgeeks.org/difference-hashmap-concurrenthashmap/)

## Key Takeaways

## Overview
- HashMap is under traditional collections
- ConcurrentHashMap is a class under Concurrent Collections
- 

### when to use when
1. *ConcurrentHashMap* is *internally synchronized and hence most suitable for multithreaded* applciation
2. HashMap is suitable for single threaded application


### Differences
1. hashmap is non synchronised
2. hashmap is not thread safe, concurrent hashmap is thread safe in nature
3. hashmap performance is high since any number of threads can perform operations at a time , sometimes in concurrent hashmap the performance is low since threads have to wait to perform any operations
4. *if onethread is iterating the hashmap and other thread try to add /modify the contents of the Object in that case we will get Run-time exception saying `ConcurrentModificationExceptio `* 
5. in concurrenthashmap we won't get any exception while performing any modification at the time of iteration. since only writing operation is synchronized and reading we don't need to synchronise
6. in hashmap  single null key and value is allowed but in ConcurrentHashMap null key and values are not allowed it will throw `NullPointerException`
7. *In ConcurrentHashMap only add the delete are synchronized and read is not sycnhronized hence it is more usefuyl in multhreaded application since there we want the read to be fast and write operation should be synchronzed*
8. *we can make hashmap synchronized by wrapping it in Collections.synchronizedMap(hashmap)*
9. if we are using hashmap for caching than concurrent hashmap beats hashmap is all the cases and when the writer threads number increases. 


#### values that are not allowed in ConcurrentHashMap
- null values will throw NPE in ConcurrentHashMap

#### In Concurrent HashMap which operations are synchronized and which are not
1. reading is not synchronized
2. add/deleting is synchronized

####  can we make hashmap synchronized
1. yes by wrapping it in Collections.synchronizedMap(hashmap)


#### ConcurrentModificationException in hashmap
- one for loop is working in main main thread
- at that time one more thread that we ahve created that also started working on the data hence this is causing the ConcurrentModificationException
```java
import java.util.HashMap;

import java.util.Map;

  

public class hashmaptest extends Thread {

    static Map<Integer,String> l=new HashMap<>();

    public void run() {

        try {

            Thread.sleep(2000);

            l.put(103, "D");

        } catch (InterruptedException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

    }

    public static void main(String[] args) throws InterruptedException {

        l.put(100, "A");

        l.put(101, "B");

        l.put(102, "C");

        hashmaptest t=new hashmaptest();

        t.start();

        for(Object o:l.entrySet()) {

            Object s=o;

            System.out.println(s);

            Thread.sleep(1000);

        }
        System.out.println(l);

  

    }

}

  

```



#### NO ERROR IN CONCURRENT HASHMAP
1. sine concurrentHashMap is thread safe there is no error 

```java
import java.util.HashMap;

import java.util.Map;

import java.util.concurrent.ConcurrentHashMap;

  

public class hashmaptest extends Thread {

  

    static ConcurrentHashMap<Integer,String> l=new ConcurrentHashMap<>();

  
  

    public void run() {

  

        try {

             Thread.sleep(2000);

            l.put(103, "D");

        } catch (InterruptedException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

    }

    public static void main(String[] args) throws InterruptedException {

        l.put(100, "A");

        l.put(101, "B");

        l.put(102, "C");

  

        hashmaptest t=new hashmaptest();

        t.start();

  

        for(Object o:l.entrySet()) {

            Object s=o;

            System.out.println(s);

            Thread.sleep(1000);

        }

  

        System.out.println(l);

  
  
  
  
  

    }

}

  
  

class HashMapDemo extends Thread {

  
  

}

```


#### ConcurrentHashMap NPE at run time for null key and values
1. ConcurrentHashMap will throw null pointer exception at run time for the null key and values.

```java
 ConcurrentHashMap<Integer,Integer> map=new ConcurrentHashMap<>();

  

        map.put(null, 2);

```

