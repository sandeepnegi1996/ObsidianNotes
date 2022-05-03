# Find the Union and Intersection of the two sorted arrays

```

input :
Arrray1 : 1 2 3 4 5
Array 2: 1 2 3

Solution : 1,2,3,4,5

Count of element are : 5

```

in my opinion we need to find the union of the two arrays and there should not be any duplicate in the final array.

## Optimal Solution
#pending

## Solution 1
1. Create HashSet and add Array1 and Array2 to the HashSet ,
2. It will not store the duplicate entries and so we will be only left with the unique elements
3. And to optimize this and maintiatn the order of the elements we can use LinkedHashSet which is implementation of Set only but it will maintain the order of the elements in which they are stored.

```java
int a1[]={1,2,3};

        int a2[]={1,2,3,4,5};

  

        Set<Integer> sortedSet=new LinkedHashSet<>();

  

        for(int a:a1) {

            sortedSet.add(a);

        }

  

        for(int a:a2) {

            sortedSet.add(a);

        }

  

        sortedSet.stream().forEach(e->System.out.print(e+" "));
```


## Solution 2
1. We can store the elements in TreeMap and if the elements are repeating we will not icrease the value later we can treaverse and give the treemap

