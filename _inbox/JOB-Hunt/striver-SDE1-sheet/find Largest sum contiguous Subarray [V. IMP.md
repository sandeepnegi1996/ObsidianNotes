# find Largest sum contiguous Subarray

## [[Kadane's Algorithm]]
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


## Solution 2 : n2 solution
1. find all the possible arrays calculate current sum 
2. if current sum > maxSum
3. change maxSum
4. return maxsum
```java

int arr[]={-3, -4, 5, -1, 2, -4, 6, -1};

  

        int maxSum=Integer.MIN_VALUE;

        for (int i = 0; i < arr.length-1; i++) {

            int currentSum=0;

            for (int j = i; j < arr.length-1; j++) {

  

                currentSum=currentSum+arr[j];

                if (currentSum>maxSum) {

                    maxSum=currentSum;

                }

            }

        }
```