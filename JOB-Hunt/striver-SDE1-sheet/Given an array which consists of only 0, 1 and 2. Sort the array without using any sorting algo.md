# Given an array which consists of only 0, 1 and 2. Sort the array without using any sorting algo

## Solution 1
- Sort the array using Arrays.sort
- Arrays.parallelsort


## Solution 2 
- Count number of 1's and 2's 
- Add the count of 1's and 2's and subtract from length to get count 0
- Zero : index : 0 to zeroCounter-1
- One : index : zeroCounter to (zeroCounter+oneCounter-1)
- Two : index : zeroCounter + one Counter   to  end of Array

