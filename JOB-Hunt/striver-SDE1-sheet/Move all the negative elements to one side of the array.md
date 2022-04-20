# Move all the negative elements to one side of the array

#dsalgo
#java 


## Solution 1 :
1. Elements are stored in array
2. I will sort the array using `Arrays.sort()`


## Solution 2 :
1. Lets say : ``[1,3,-4,-5,6,7-8]``
2. create another array of same size and traverse the original array
3. if there is any negative number i will start storing from start, and if there is any positive number i will start  storing from end or reverse
4. OR : i will traverse , take negative and store it in anoter array , similar way take positive store it in the same array but after negative are done.

## Solution 3 :   [[Two Pointer Approach]] 
- to do this in constant time 
- we need to use two pointer approach
- Left and right
- loop from left<=right
- if left is negative and right is positive --> increase the left counter and decrease the right counter
- if left is negative and right is negative --> left ++
- if left is positive and right is positive --> left , right --
- if left is positive and right is negative --> swap --> increase the left and decrease the right 


```java

 while (left<=right) {

  

            if (arr[left]<0 && arr[right]<0) {

                left++;

            }

  

            else if(arr[left]>0 && arr[right]<0 ) {

                //swap

                int temp=arr[left];

                arr[left]=arr[right];

                arr[right]=temp;

                left++;

                right--;

            }

  

            else if (arr[left] > 0 && arr[right] >0){

                right--;

  

            }

            else {

            left++;

            right--;

            }

  

  

        }
```

```
https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/
```

