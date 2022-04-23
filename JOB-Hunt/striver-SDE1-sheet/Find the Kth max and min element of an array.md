# Find the Kth max and min element of an array
#pending
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
2. Min = print the value at k-1 index
3. Max = length-k
4. Reverse Order Sort  `Collections.sort(arr,Collections.reverseOrder())`
5. 

## Solution 2
1. first find minimum 
2. and then again find a minimum 
3. so if k ka value is 2 we will find the minimum by traversing the array twice
4. Similary if k value is 3 three time we are going to find the array min.
5. Time complexity will be `k*n`


## Solution 3 
*applicable only when elements are distinct*
- use TreeSet : since elements are distinct no element will be lost 
- and element will be sorted inside the TreeSet
- now we need to find the element at a particular index



## Heap Solution --> 2nd optimal
1.  Create a max heap, which will store the elements in sorted order
2. from Max to min , since it is max-heap it will store from max- min
3. Now remove k-1 values from max heap 
4. print the top of the remaining max-heap
5. Priority Queue will work similar to Max or min heap
6. `poll` remove the element
7. `peek`
8. revereseOrder `Collections.reverseOrder()`
9. Insertion will take `nlog(n)`

```java

static int kthLargest(ArrayList < Integer > arr, int size, int K)  {

  PriorityQueue < Integer > pq = new PriorityQueue < Integer > 
                                  (Collections.reverseOrder());
                              
  for (int i = 0; i < size; i++) {
    pq.add(arr.get(i));
  }
  int l = K - 1;
  while (l > 0) {
    pq.poll();
    l = l - 1;
  }
 
  return pq.peek();
}
```

## Quick Select -->pending
## Code
```java
```