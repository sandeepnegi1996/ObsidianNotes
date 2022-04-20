# TreeSet
- *Most popular implementation of Set *
- it is inherited from SortedSet
- unique elements will be stored
- sorting is done in assending order
- insertion order is not maintained and s
- not thread safe
- internally it uses , self-balancing binary search tree or more specifically red-black tree.
- 
Child of SortedSet

```java
SortedSet<String> sortedTreeSet=new TreeSet<>();
        
        sortedTreeSet.add("A");
        
        sortedTreeSet.add("B");
        
        sortedTreeSet.add("C");
        
        sortedTreeSet.add("A");
        
        sortedTreeSet.forEach(e-> System.out.println(e));
    

```

Learn  more on treeSet

https://www.baeldung.com/java-tree-set

