# 📑 find subarray with sum is equal to zero

- **🏷️Tags** : #28-04-2022, #review, #reading_list

#### 🔗 Links


## Key Takeaways

## Overview

## Solution 1 : bruteforce
1. Find all the possible subarrays and then find the sum and then check if the sum=0;


## Solution 2 : 
1. Find the sum of elements and store in set (`Hashing`)
2. and then if the same sum is there in the array we can make sure that there is a sub array whose sum is 0
3. and if `a[i]==0` or `sum=0` or `set contains sum` in these three cases sum=0;

```java

 int arr[]= {1, 4, -2, -2, 5, -4, 4};

  

        int sum=0;

        Set<Integer> set=new HashSet<>();

        boolean isSumZero=false;

        for (int i = 0; i < arr.length; i++) {

            sum=sum+arr[i];

            set.add(sum);

            if (arr[i]==0 || sum==0 || set.contains(sum)) {

                isSumZero=true;

                break;

  
  

            }

        }


```