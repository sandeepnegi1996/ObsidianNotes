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




