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
- Time complecity is O(n)
- O(n) + O(n) = finding count + Putting the element in the array







## [[Dutch National Flag Approach]]
1. ![[1_K9D3B2gTTsg87BgQoYF7fw.png]]

## Solution 3
1. Store the elements in priority Queue
2. and then pop the elements from the priority queue
3. or store it back to the same array
4. [ ] [[Priority Queue in java]]