# Find first and last positions of an element in a sorted array
: wherever there is sorted

```

Problem:
Given a sorted array **arr** containing **n** elements with possibly duplicate elements, the task is to find indexes of first and last occurrences of an element **x** in the given array.

n=9, x=5
arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
**Output:**  2 5
**Explanation**: First occurrence of 5 is at index 2 and last
             occurrence of 5 is at index 5.


```


## Optimal Solution 1 
- Binary Search : 
- https://www.geeksforgeeks.org/find-first-and-last-positions-of-an-element-in-a-sorted-array/
- find the element using binary search for both the cases
- for first index 
	- when we found the element, we will move to left and make the index=mid
- for last index
	- when we found the elment , res=mid and we move to the right


####  code to find the left index 
```java
int left=0;

       int right=arr.length-1;

       int leftres=-1;

        int x=5;

       while (left<=right) {

        int mid=(left + right)/2;

  

        if (x>arr[mid]) {

            left=mid+1;

        }

        else if (x<arr[mid]) {

            right=mid-1;

  

        }

  

        else {

            leftres=mid;

            right=mid-1;

        }

       }
```

#### code to find the right index
```java
  int arr[] ={ 1, 3, 5, 5, 5, 5, 67, 123, 125 };

        int left=0;

        int right=arr.length-1;

        int rightRes=-1;

         int x=5;

        while (left<=right) {

         int mid=(left + right)/2;

         if (x>arr[mid]) {

             left=mid+1;

         }

         else if (x<arr[mid]) {

             right=mid-1;

         }

         else {

            rightRes=mid;

             left=mid+1;

         }

        }

  

        System.out.println(rightRes);
```

## Solution 1
1. Start loop from start and find the element index
2. start the loop from the end and find the element index

```java
int arr[] ={ 1, 3, 5, 5, 5, 5, 67, 123, 125 };

  

        int firstIndex=0;

       for (int i = 0; i < arr.length; i++) {

           if (arr[i]==5) {

               firstIndex=i;

               break;

           }

       }

       int lastindex=0;

       for (int i = arr.length-1; i >=0 ; i--) {

  

        if (arr[i]==5) {

            lastindex=i;

            break;

        }

       }

  
  

       System.out.println(firstIndex+" "+lastindex);
```


## Solution 2
1. store everything in the hasmap for the keyvalue pair
2. later traverse the map and find the value of element
3. then find the index of element from array and add value from the hashmap this will give the last index of the element

```java
int arr[] ={ 1, 3, 5, 5, 5, 5, 67, 123, 125 };

       Map<Integer,Integer> map=new TreeMap<>();

  

       for (int i = 0; i < arr.length; i++) {

  

           int c=arr[i];

  

           if (map.containsKey(c)) {

               int counter=map.get(c);

               map.put(c, ++counter);

               counter=0;

           }

           else{

               map.put(c, 1);

           }

       }

  

       int valueofKey5=map.get(5);

       System.out.println(valueofKey5);
```