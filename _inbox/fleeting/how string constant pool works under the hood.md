# 📑 **How string constant pool works under the hood**

- **🏷️Tags** : #23-04-2022, #review, #reading_list

## 🔗 Links
[baeldung](https://www.baeldung.com/java-string-constant-pool-heap-stack)
[scaler](https://www.scaler.com/topics/java/string-pool-in-java)

--- 
## Overview
1. String in java is considered as objects.
2. String is immutable in java, means when there is modification, a new object will be created in string pool constant.
3. primitive types are stored in stack and non primitive types are stored in heap 
4. *whenever we create a new string first JVM will check in the string pool constant*

![[Pasted image 20220423220707.png]]  

---

## String Constant Pool (Internal Working)
1. special memory area
2. when we create string literal , object is created in this pool and reference is stored in the stack
3. String constant pool internally uses `HashMap` that is why when we create same literals the reference points to same location
4. When the system load the classes. String literals go the application level pool.
5. since all literals are stored in the application level, means all the classes can access it and hence when we create `String s1="hello"   String s2="heelo"` they both points to same object.


Usually Stack stores --> short lived data --> local primitive variables, refernces to heap objects and method in execution

- Heap --> store --> objects created at run time 
- Heap --> shared --> it allows global access -->means all the threads can access the heap
- stack --> every thread have its own stack and it has private scope it menas only the owner of the thread can access them

![[Pasted image 20220423131831.png]]


- stack -> variables -> deallocate -> as soon as thread execution is finished
- Garbage Collector : reclaims the resources from the heap
- String Pool : Garbage Collector collects the un-referenced items from the main heap memory

---

## Ways to Create String
1. String literal
2. Using new keyword
3. String.intern() method


### String literal
```java
String s1="hello";
String s2="hello";
String s3="world"
```


- In the above code only two objects will be created in the string pool constant, and we already know the reason why.
![[Pasted image 20220423221135.png]]

### Using new keyword
1. Here we will force jvm to create new object with the same value in the heap even if there is same value stored in the String pool constant.

```java
String s1="hello";
String s2=new String("hello");
```

![[Pasted image 20220423221354.png]]


- If in this case i use an operator `==` to compare two strings it will be not be equal since both the reference variable are storing some different address.


### Using String.intern() method --> pending 
1. when we use new keyword object are created in heap memory instead of string pool but when we use intern keyword it will be created in the string pool.

```java
public class StringPoolExample {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello").intern();

        // str2 is explicitly added to the string pool
        System.out.println(str1 == str2); // true
    }
}
```

---

## Advantages of String pool
1. it allows caching of string
2. cache improves performance and reduce memory usage.
3. reusability

---


## Disadvantages
1. Everything in this world have advantages and disadvantages
2. When we modify string, it will create new object and thus posing a memory issue, since it is immutable and fast.
3. To overcome this  java comes with `StringBuffer` and `StringBuilder`















