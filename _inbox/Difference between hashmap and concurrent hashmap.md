# 📑 Difference between hashmap and concurrent hashmap

- **🏷️Tags** : #10-05-2022,   #completed #permanent
- 

#### 🔗 Links
[hashmap and concurrent hashmap](https://www.geeksforgeeks.org/difference-hashmap-concurrenthashmap/)

## Key Takeaways

## Overview
- HashMap is under traditional collections
- ConcurrentHashMap is a class under Concurrent Collections
- 

### when to use when
1. *`ConcurrentHashMap`* is *internally synchronized and hence most suitable for multithreaded* application 
2. `HashMap` is suitable for single threaded application


### Differences
1. HashMap is non synchronized
2. HashMap is not thread safe, concurrent HashMap is thread safe in nature
3. HashMap performance is high since any number of threads can perform operations at a time , sometimes in concurrent hashmap the performance is low since threads have to wait to perform any operations
4.  **HASHMAP**   ->   *if onethread is iterating the HashMap and other thread try to add /modify the contents of the Object in that case we will get Run-time exception saying `ConcurrentModificationException `* 
5. in `ConcurrentHashMap` we won't get any exception while performing any modification at the time of iteration. since only writing operation is synchronized and reading we don't need to synchronisation
6. in hashmap  single null key and value is allowed but in **ConcurrentHashMap null key and values are not allowed it will throw** `NullPointerException`

##### important Point 
1. In ConcurrentHashMap only **add** the delete are synchronized and read is not synchronized hence it is more useful in multhreaded application since there we want read operation to be fast and write operation should be synchronized
2. we can make HashMap synchronized by wrapping it in **Collections.synchronizedMap(hashmap)**    -. so why we are not using this Collections.synchronizedMap ?
3. if we are using HashMap for caching than concurrent HashMap beats HashMap is all the cases and when the writer threads number increases. 


#### values that are not allowed in ConcurrentHashMap
- null values will throw NPE in ConcurrentHashMap

#### In Concurrent HashMap which operations are synchronized and which are not
1. reading is not synchronized
2. add/deleting is synchronized

####  can we make hashmap synchronized
1. yes by wrapping it in Collections.synchronizedMap(hashmap)
#### NO ERROR IN CONCURRENT HASHMAP
1. sine concurrentHashMap is thread safe there is no error  
2. below shown code will not work with HashMap
```java
package com.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest extends Thread {

    static Map<Integer, String> l = new ConcurrentHashMap<>();

    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " is writing to the hashMap");
            l.put(103, "D");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Writing to hashMap
        l.put(100, "A");
        l.put(101, "B");
        l.put(102, "C");

        // Created and started another thread
        HashMapTest t = new HashMapTest();
        t.start();

        // Main thread is reading from the hashMap
        // At the same time another thread is writing, so we get ConcurrentModificationException
        for (Object o : l.entrySet()) {

            System.out.println(Thread.currentThread().getName()  + "  :  is reading from the hashmap");
            System.out.println(o);
            Thread.sleep(1000);
        }

        // printing the final ConcurrnetHashMap to make sure the update is done successfully
        System.out.println(l);
    }
}
```


#### ConcurrentHashMap NPE at run time for null key and values
1. ConcurrentHashMap will throw null pointer exception at run time for the null key and values.

```java
 ConcurrentHashMap<Integer,Integer> map=new ConcurrentHashMap<>();
        map.put(null, 2);
```


### Internal working of ConcurrentHashMap
1. ConcurrentHashMap is a thread safe implementation of hashtable in java, introduced to handle concurrent access more efficiently than Collections.synchronisedMap
2. it is designed to allow multiple threads to read and modify the map concurrently without locking the entire map.
3. it achieves better performance by partioning the data into segments , enabling thread-safe access without a single  global **lock** 
4. **Segmentation** :  the map is divided into multiple **segments** or **buckets** , each segment can be locked independently. allowing multiple threads to operate on a separate segments concurrently.
5. **locking mechanism** : only specific segment or buckets related to a key is locked during updates or writes reducing **contention**
6. **Non - Blocking Reads** : reads are lock free.
7. from java 8 and later , it uses a combination of **linkedList** [[linked List coding problems]] and **balanced trees** to handle collisions efficiently.
	1. ex : When  the number of entries in a bucket exceeds a threshold (Ex : 8) it switches from linkedin list to balanced trees.


### What is concurrency level in ConcurrentHashMap ? 
1. No. of threads that can modify the map simultaneously.
2. it basically means no. of segments in a map
3. default is 16.
4. it means 16 threads can simultaneously modify the 16 segments.

`ConcurrentHashMap<K,V> map = new ConcurrentHashMap<>()`

1. **Initial Capacity**:
    
    - This is the initial number of buckets (or segments) in the map.
    - Default: **16**.
    - It determines the initial size of the internal data structure.
2. **Load Factor**:
    
    - This is a measure of how full the map can get before it needs to resize.
    - Default: **0.75**.
    - When the number of elements exceeds `capacity * load factor`, the map resizes to accommodate more entries.
3. **Concurrency Level**:
    
    - This is the estimated number of concurrently updating threads.
    - Default: **16**.
    - It determines the number of segments the map is divided into, allowing multiple threads to operate on different segments without locking the entire map.


```java
ConcurrentHashMap<K, V> map = new ConcurrentHashMap<>(initialCapacity, loadFactor, concurrencyLevel);
```

```java
ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>(32, 0.8f, 16);
```


### How many threads can run at a time 
1. read  -> multiple threads can read since there is no locking mechanism 
2. write -> it depends on the concurrency level that is 16 , means 16 threads can run simultaneosuly on 16 different segement , if two threads attempt to modify the keys in the same segment , one will wait until the lock on the segment is released.
3. 
### Real Life Scenarios to use the ConcurrentHashMap with Example 



A `ConcurrentHashMap` is commonly used in real-life projects where thread-safe access to a shared map is required without the performance bottleneck of synchronizing the entire map. Below are some real-life use cases:

### 1. **Caching in Multi-Threaded Applications**
   - **Use Case**: Storing frequently accessed data (e.g., user sessions, configuration settings, or computed results) in a cache that is accessed and updated by multiple threads.
   - **Why ConcurrentHashMap**: It allows multiple threads to read and write to the cache concurrently without blocking each other.

   ```java
   ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();
   cache.put("user1", "session1");
   String session = cache.get("user1");
   ```

---

### 2. **Real-Time Analytics**
   - **Use Case**: Tracking metrics like page views, user clicks, or API request counts in a high-concurrency environment.
   - **Why ConcurrentHashMap**: It ensures thread-safe updates to counters or statistics without locking the entire map.

   ```java
   ConcurrentHashMap<String, Integer> analytics = new ConcurrentHashMap<>();
   analytics.merge("pageViews", 1, Integer::sum); // Increment page views safely
   ```

---

### 3. **Thread-Safe Lookup Tables**
   - **Use Case**: Maintaining a thread-safe lookup table for configurations, mappings, or routing information in a server application.
   - **Why ConcurrentHashMap**: It allows concurrent updates and lookups without blocking.

   ```java
   ConcurrentHashMap<String, String> routingTable = new ConcurrentHashMap<>();
   routingTable.put("serviceA", "192.168.1.1");
   String ip = routingTable.get("serviceA");
   ```

---

### 4. **Task Management in Multi-Threaded Systems**
   - **Use Case**: Managing tasks or jobs in a multi-threaded system where threads add, update, or remove tasks dynamically.
   - **Why ConcurrentHashMap**: It ensures thread-safe operations on the task map.

   ```java
   ConcurrentHashMap<Integer, String> taskMap = new ConcurrentHashMap<>();
   taskMap.put(1, "Task1");
   taskMap.remove(1);
   ```

---

### 5. **Distributed Systems**
   - **Use Case**: Storing shared state or metadata in distributed systems (e.g., distributed locks, leader election, or shared counters).
   - **Why ConcurrentHashMap**: It provides a thread-safe way to manage shared state across multiple threads in a distributed environment.

---

### 6. **Thread-Safe Event Processing**
   - **Use Case**: Maintaining a registry of event listeners or handlers in an event-driven system.
   - **Why ConcurrentHashMap**: It allows concurrent registration and invocation of event handlers.

   ```java
   ConcurrentHashMap<String, Runnable> eventHandlers = new ConcurrentHashMap<>();
   eventHandlers.put("onStart", () -> System.out.println("Started"));
   eventHandlers.get("onStart").run();
   ```

---

### Why Not Use `HashMap` or `Hashtable`?
- **`HashMap`**: Not thread-safe, so it can cause `ConcurrentModificationException` in multi-threaded environments.
- **`Hashtable`**: Thread-safe but synchronizes the entire map, leading to performance bottlenecks.

`ConcurrentHashMap` strikes a balance by allowing fine-grained locking (on segments or buckets), making it highly efficient for concurrent access.



## Related Topics 
[[use streams with hashmap]]
[[Difference between HashMap and HashSet]]