# 📑 Merge 2 sorted arrays without using Extra space.

- **🏷️Tags** : #05-05-2022,  #pending #completed #permanent

#### 🔗 Links


## Question
	Given two sorted arrays arr1[] of size N and arr2[] of size M. Each array is sorted in non-decreasing order. Merge the two arrays into one sorted array in non-decreasing order without using any extra space.


	**Input:**
	
	N = 4, M = 5
	arr1[] = {1, 3, 5, 7}
	arr2[] = {0, 2, 6, 8, 9}
	**Output:** 0 1 2 3 5 6 7 8 9
	**Explanation:** Since you can't use any 
	extra space, modify the given arrays
	to form 
	arr1[] = {0, 1, 2, 3}
	arr2[] = {5, 6, 7, 8, 9}

###  Solution 1  --> with extra space
1. arr1 i will add in the arraylist
2. arr2 i will also add in the same arraylist
3. Collections.sort(arrlist)
4. complete list will be sorted

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        int arr1[] = {1, 3, 5, 7};
	      int arr2[] = {0, 2, 6, 8, 9};
	      
	      List<Integer> arrlist=new ArrayList<>();
	      
	      for(int i=0;i<arr1.length;i++) 
	        arrlist.add(arr1[i]);
	        
	        
	     
	     
	      for(int i=0;i<arr2.length;i++) 
	        arrlist.add(arr2[i]);
	        
	     
	     Collections.sort(arrlist);
	        
	        
	     arrlist.forEach(System.out::println);
    }
}

```




### Solution 2 --> without Extra Space
- make first array smaller 
- second array bigger
- i need to use some kind of two pointer approach to solve this 
- 
