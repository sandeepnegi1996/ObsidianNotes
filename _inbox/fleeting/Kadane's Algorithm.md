# Kadane Algorithm
#dsalgo 
#pending 

## Problem : find largest sum in the contigous sub array

1. iterative dynamic programming algorithm
2. 




## Solution
1. we will take current sum and maxsum
2. if current sum is negative make it as zero
3. if currentsum>maxSum : then maxSum=currentSum
```java
 int arr[]={-3, -4, 5, -1, 2, -4, 6, -1};

  

        int maxSum=Integer.MIN_VALUE;

        int currentSum=0;

        for (int i = 0; i < arr.length-1; i++) {

            currentSum=currentSum+arr[i];

  

            if (currentSum>maxSum) {

                maxSum=currentSum;

            }

  

            if (currentSum<0) {

                currentSum=0;

            }

        }

  

        System.out.println(maxSum);

  

    }
```