# 📑 find duplicate in an array of N+1 Integers

- **🏷️Tags** : #25-04-2022, #review, #reading_list

## 🔗 Links
[solution](https://takeuforward.org/data-structure/find-the-duplicate-in-an-array-of-n1-integers/)


##  Problem
1. Array of size N+1 and array store numbers from 1 to N means one element will be repeasted we need to find that element and print it.

```code
**Input:** arr=[1,3,4,2,2]

**Output:** 2

```


## Solution 1
1. Sort the array (nlogn)
2. now traverse the array  compare adjacent elements
3. if element is equal, break and return element
4. if element not equal continue searching
5. Time complexity : `nlogn + n ` space 
6. Space Complexity : `O(1)` since no space is required

## Solution 2 
1. take hashmap and store the key as 1 to n and put value as 0
2. then again check array and incease count
3. later find the one with duplicate

##  Solution 3
1. take first element, check that in arra
2. then take second element, check that in array
3. Similar way two loops will do the job here
4. Time Complexity `n2`
5. 





## Solution 4 : only work when only single element is dupliocated
1. This will only work if only one element is repeated
	1. Sum of n terms : n=5 --> `n(n+1)/2` --> 5(6)/ 2  --> 15
	2. Sum of array elements is : 12
	3. Substract both of them : 15-12 = 3


## Solution 5 : Optimal : multiple duplicate 
1. since all the values are from 1 to N
2. means all the values can act as a index
3. so what we will do for , for each values we will be adding a flag --> that is negative sign in the arary and then one i traverse and find the negative elemtn means that element is negative
4. since all the elements are positive this approach will work 

```
Input: [2, 3, 3, 1]* Index 0:  
    Absolute value = 2  
    Put a minus sign to a[2] => [2, 3, -3, 1]* Index 1:  
    Absolute value = 3  
    Put a minus sign to a[3] => [2, 3, -3, -1]* Index 2:  
    Absolute value = 3  
    As a[3] is already negative, it means 3 is a duplicate
```


##  Solution 6 : 
1. Runner Technique: use two points fast and slow 
