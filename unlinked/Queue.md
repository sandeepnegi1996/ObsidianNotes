# 📑 Queue

[[Datastructure]]

- **🏷️Tags** : #24-04-2022, #review, #reading_list 

## 🔗 Links
[GFG-priorityQueue](https://www.geeksforgeeks.org/priority-queue-class-in-java/)
[priorityQueue with comparator](https://www.geeksforgeeks.org/implement-priorityqueue-comparator-java/)
[baeldung](https://www.baeldung.com/cs/priority-queue#implementation)

---
## Key Takeaways
1. PriorityQueue is most efficient with heap data structure
3. insertion and removal both takes log(n)
4. we can sort the elements in any way using Comparator with Objects
5. allows duplicate elements

## Queue
1. Queue Interface
2. first in first out --> FIFO
3. Priority Queue
4. ArrayDeque
5. ![[Pasted image 20220424020322.png]]
---
### Priority Queue
1. implements Queue
2. Allows Duplicate elements
3. elements of the queue are needs to be processed according to the priority
4. it internally uses min-max heap
5. TreeSet and Priority Queue  Differnece, Priority Queue can have duplicate elements and TreeSet cannot.
6. null cannot be stored
7. *Priority Queue is not thread Safe so java provides `PriorityBlockingQueue` class that implements `BlockingQueue`*

- Example : here we are making the priority Queue to store the elements in reverseOrder of primitive type

```java
 PriorityQueue<Integer> queue=new PriorityQueue<>(Collections.reverseOrder());
      
      queue.add(1);
      queue.add(2);
      
      
      for(Integer a: queue) {
        System.out.println(a);
      }
```

- Example 2 :  Sort the Student object using Comparator with Priority Queue
1. Student Class
2. StudentCGPAComparator
3. while creating a priority Queue we need to pass the comparator 
4. then store the elements and then print them
5. It should be sorted based on the StudentCGPA
```java
import java.io.*;

import java.util.*;

  
  

class Student {

    private String name;

    private int CGPA;

    Student(String name,int CGPA) {

      this.name=name;

      this.CGPA=CGPA;

    }

    public String getName() {

      return name;

    }

    public int getCGPA() {

      return CGPA;

    }

    @Override

    public String toString() {

      return "Student name: "+ name +" CGPA: "+CGPA;

    }

  }

  
  

  class StudentCGPAComparator implements Comparator<Student> {

  

    @Override

     public int compare(Student s1,Student s2) {

  

        if(s1.getCGPA()>s2.getCGPA()) {

            return 1;

        }

        else if (s1.getCGPA()<s2.getCGPA()) {

            return -1;

        }

        else {

            return 0;

        }

    }

  

  }

 class Test {

    public static void main(String[] args) {

      System.out.println("hello world");

      PriorityQueue<Student> queue=new PriorityQueue<>(new StudentCGPAComparator());

     Student s1=new Student("rana",1);

     Student s2=new Student("dhruv",2);

     Student s3=new Student("amit",3);

     Student s4=new Student("sandeep",4);

  

    queue.add(s1);

    queue.add(s2);

    queue.add(s3);

    queue.add(s4);

    queue.stream().forEach(s -> System.out.println(s));

}

}

```


---
###  Priority Queue Deep Understanding 
1. when programs are chosen based on priority ,if there is a system that works with multiple programs with different priority
2. Each Queue item has one additional piece of information that is namely priority
3. in regular queue elements are removed in FIFO.

#### Applications
1. Algorithm : such as Dijkstra , path, prims , heap sort
2. Data Compression
3. Operating System : to select next process
4. Bandwidth Management : select important packets so that it reaches destination

![[Pasted image 20220424110605.png]]


4. in above example, A,B,Z, --> these are values and numbers are priority so `1` here is having highest priority.
5. operations , add,peek,remove

####  Characteristics 
1. element with higher priority will be removed from the top first
2. two element with same priority will be arranged using the FIFO , principle.
3. elements can be only removed from one end
![[Pasted image 20220424111240.png]]

#### Implementation
1. Heap Data structure is the most efficient way to implement a Priority Queue.
2. add --> log(n)
3. peek --> O(1)
4. remove --> log(n)


####  Heap Data Structure
1. So for all the examples we will be using max-heap'
3. it is binary tree only 
4. *Parent bada hai from both the child*
![[Pasted image 20220424111709.png]]


#####  Insertion in Priority Queue
1. Insert the element at the last node 
2. compare it with parent and then if our new element is greater than parent and then swap them


Step 1 :
![[Pasted image 20220424112407.png]]

Step 2 and Step 3 : swapped two times with the parent
![[Pasted image 20220424112436.png]]


##### Removing 
- this will also take log(n)
Step1 :
![[Pasted image 20220424112853.png]]


Step 2:
![[Pasted image 20220424112919.png]]

now we can see parent is greater than child