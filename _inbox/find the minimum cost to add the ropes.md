# 📑 find the minimum cost to add the ropes

- **🏷️Tags** : #07-05-2022,  #pending #completed #permanent

#### 🔗 Links


### Problem
1. array of roles length is given we need to add the ropes with the minimum cost

Example : 1 
```
1,3,4,6

1+3 --> 4

4,4,6

4+4  --> 8

8,6 --> 14

total cost of adding ropes : 4+8+14 , this cost should be minimum


```




### Solution 1
1. we will add two minimum to get the minimum cost
2. then minimum sum should be store somewhere from where it is easier to get again two minimum element and it will reorder the list for the element
3. take two minimum add then back to priority Queue it will reorder automatically
4. then again get the two top values and then again put the same back to the array
5. 