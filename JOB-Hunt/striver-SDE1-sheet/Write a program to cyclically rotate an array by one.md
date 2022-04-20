# Write a program to cyclically rotate an array by one

## Problem Statement
```java

A[] = {1, 2, 3, 4, 5}

**Output:**
5 1 2 3 4

```

 
## Solution 1:  Extra space same as original array
1. Lets say i use one array of the same size 
2. i will take the last element and store it in another array 
3. and then i will traverse from the first to the second last element and store it in second array
4. Print the second array


## Solution 2 : only one space extra 
1. take a variable and store last element in that array
2. now traverse the array from the last and move element by one to right
3. then put back the element in the temp to start


## Solution 3 : 
1. From the last ttraverse and swap with adjacent element till you reach the first element
2. 