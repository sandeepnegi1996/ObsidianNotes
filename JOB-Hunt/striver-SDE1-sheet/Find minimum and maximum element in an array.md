# Find minimum and maximum element in an array

## Solution 1
- Sort the array 
- Print the first and last element, first element is minimum and last element will be maximum


## Solution 2
- traverse and find the minimum 
- Traverse and find the maximum

## Solution 3 
-  it is related to solution 1 only, 
- but here we will create a list out of array and then use stream to sort the array
- kind of an overkill but this will also do the job
- *We cannot convert primitive type array to a list for this we need to create an array of wrapper class and then convert it to list *


Side Note
- *Sort in reverse Order : Arrays.sort(array, Collections.reverseOrder())*
- *Arrays.sort(int[] a, int fromIndex, int toIndex)*
- - *Arrays.parallelSort(array)*
	- parallel sort will break the array into pieces and then sort and merge it , 
	- it leverage different threads to do the sort

```java
import java.util.Arrays;

import java.util.List;

import java.util.stream.Collectors;

  

class Test {

    public static void main(String[] args) {

        //Solution 1

  

        int[] arr= {5,6,3,4,7,1};

  

         Arrays.sort(arr);

  

         System.out.println("Maximum is " +arr[0]);

         System.out.println("Minimum is "+arr[arr.length-1]);

  
  

        //Solution 2

  

         int absoluteMin=Integer.MIN_VALUE;

         int absoluteMax=Integer.MAX_VALUE;

  

         int min=0;

         int max=0;

  

         for (int i = 0; i < arr.length; i++) {

  

             if (arr[i]>absoluteMin) {

                 max=arr[i];

                 absoluteMin=max;

             }

  

             if (arr[i]<absoluteMax) {

                 min=arr[i];

            absoluteMax=min;

             }

         }

  

         System.out.println(max+" "+min);

  

        //learning we cann

  

             Integer[] arrWrapper={5,6,7,1,2};

  

             List<Integer> list= Arrays.asList(arrWrapper);

  

            List<Integer> sortedList= list.stream().sorted().collect(Collectors.toList());

  

             sortedList.forEach(e->System.out.print(e+" "));

            System.out.println(sortedList.get(0));

            System.out.println(sortedList.get(arrWrapper.length-1));

  
  
  
  

  

    }

}
```