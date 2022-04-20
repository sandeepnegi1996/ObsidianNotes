# Find the Kth max and min element of an array

## Kth smallest element
```
arr[] = 7 10 4 3 20 15
K = 3
**Output :** 7
**Explanation :**
3rd smallest element in the given 
array is 7.

```


## Solution 1
1. sort the array
2. print the value at k-1 index

## Solution 2
1. first find minimum 
2. and then again find a minimum 
3. so if k ka value is 2 we will find the minimum by traversing the array twice
4. Similary if k value is 3 three time we are going to find the array min.


## Solution 3 
- use TreeSet : since elements are distinct no element will be lost 
- and element will be sorted inside the TreeSet
- now we need to find the element at a particular index

```java
```