# 📑 List

- **🏷️Tags** : #24-04-2022, #review, #reading_list, #pending 

## 🔗 Links
[stackoverflow](https://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist-in-java)

![[Pasted image 20220424003233.png]]
## What are Different Classes under List Interface

1.  ArrayList
2. LinkedList
3. Vector
4. Stack


## Key takeaways
1.  **TL;DR** due to modern computer architecture, `ArrayList` will be significantly more efficient for nearly any possible use-case - and therefore `LinkedList` should be avoided except some very unique and extreme cases.
2. LinkedList is never used in comparison to ArrayList (read so many article)
3. LinkedList adding an element at start and end will take O(1) other places it takes O(n)

3. 


### ArrayList
1. dynamic array to store elements
2. *allow duplicate elements*
3. maintains the *insertion order*
4. Accessing element taken O(1)
5. Adding an element O(n) worst case
6. read intensive i will arraylist
7. ArrayList takes less space then LinkedList
8. Internally ArrayList uses Array of size 10. from Java 1.4 to 1.8
10. Non - synchronized
11. [ ] [[How to Synchronize in ArrayList]]
12. [ ] [[ensure capacity on arrayList]]
13. [ ] [[what is eden space in java]]
- Example to store elements in arraylist and how to read them

```java
List<Integer> arrlist=new ArrayList<>();
       
       arrlist.add(1);
       
       arrlist.add(2);
       
       arrlist.add(3);
       
       arrlist.add(4);
       
    //   one way to traverse
      Iterator itr=arrlist.iterator();
       
      while(itr.hasNext()) {
          System.out.println(itr.next());
      }
    
    //using for each
    
    for(Integer a: arrlist) {
        System.out.print(a+" ");
    }
    System.out.println();
    
    //using stream
    
    arrlist.stream()
            .forEach(e -> System.out.print(e+" "));
    

```




####  Real Life Usecases of ArrayList
1. If we want to fetch some records from the database, 
	1. Ex, lets say we wants to fetch `Employee` table data from the database in this case we can store that information in ArrayList

2. Where there is no insertion in the middle + no removal from the middle or in between
	1. since with arraylist whatever we add it will be added in the last and internally it uses Array so it becomes constlier when we wants to add something in middle or remove something in between using arraylist.



####  Memory Comparison with LinkedList and ArrayList
Here Blueones are LinkedList and orange one are ArrayList
![[Pasted image 20220424010856.png]]





###  LinkedList
1. Adding an element O(n) -->in middle 
	1. i need to travel the whole linkedlist
	2. *Adding an element at start and end will take O(1)*
2. Accessing an element O(n) 
3. It takes more memory than LinkedList
4. Internally LinkedList uses doubly-linked list
5. remove will be easier in LinkedList
6. non synchronized 
```java
1.  LinkedList<String> al=new LinkedList<String>();  
2.  al.add("Ravi");  
3.  al.add("Vijay");  
4.  al.add("Ravi");  
5.  al.add("Ajay");  
6.  Iterator<String> itr=al.iterator();  
7.  while(itr.hasNext()){  
8.  System.out.println(itr.next());  
9.  }  
10.  }
```


### Vector
1. similar to ArrayList , store elements as dynamic array
2. *synchronized*


### Stack
1. Stack is subclass  of vector
2. ![[stack in java]]







