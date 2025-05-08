# 📑 use stream with map in java 

- **🏷️Tags** : #07-05-2022,  #completed #permanent

#### 🔗 Links
[baeldung](https://www.baeldung.com/java-maps-streams)

## Key Takeaways

## Overview
- Here we will be learning what is mentioned in the title `haha` , how to use the stream with maps in java.


### Basic idea
- Streams are sequence of elements which can be easilt obtained from a collection
- maps has a different structure with keys and values and without sequence ,

1. let say we have a hashmap and now we will get the keys and store them in one set
2. and similar way we will get the values store it in a collection

```java

 Map<Integer,Integer> map=new HashMap<>();

  

        map.put(1, 10);

        map.put(2, 11);

        map.put(3, 13);

        map.put(4, 14);

        //i wanted to store all the keys in a separate list

  

       Set<Map.Entry<Integer,Integer>> entries=  map.entrySet();

  
  

       Set<Integer> keySet=  map.keySet();

        Collection<Integer> values =map.values();

  
  

        System.out.println(entries);

        System.out.println(keySet);

  

        System.out.println(values);

  

        // now we can also apply streams to this since it is a collection which is a sequence

  

        Stream<Map.Entry<Integer,Integer>> entriesStream= entries.stream();

        Stream<Integer> valuesStream=values.stream();

        Stream<Integer> keyStream= keySet.stream();

```


### get the particular key for a value
1. find key of the book, effective java

```java

       Map<String, String> books = new HashMap<>();

       books.put("978-0201633610", "Design patterns : elements of reusable object-oriented software");

       books.put(

          "978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");

        books.put("978-0134685991", "Effective Java");

        //problem statement

        //find the key of the book whose name is "Effective Java"

  

    Optional<String> optionalIsbn =  books.entrySet().stream()

                                    .filter(e -> e.getValue().equals("Effective Java"))

                                    .map(Map.Entry::getKey)

                                    .findFirst();

  
  

        System.out.println(optionalIsbn.get());

```

### How to fetch multiple keys using hashmap and stream
```java
       Map<String, String> books = new HashMap<>();

       books.put("978-0201633610", "Design patterns : elements of reusable object-oriented software");

       books.put(

          "978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");

        books.put("978-0134685991", "Effective Java");

        books.put("978-0321356680", "Effective Java: Second Edition");

        //problem statement

        //get the multiple results from the map so fort he book name that start wiht Effective Java

  
  
  
  

        List<String> listOfBooks=  books.entrySet().stream()

                                    .filter(e -> e.getValue().startsWith("Effective"))

                                    .map(Map.Entry::getKey)

```

### How to fetch multiple values from hashmap using stream

```java

       Map<String, String> books = new HashMap<>();

       books.put("978-0201633610", "Design patterns : elements of reusable object-oriented software");

       books.put(

          "978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");

        books.put("978-0134685991", "Effective Java");

        books.put("978-0321356680", "Effective Java: Second Edition");

        //problem statement

        //get the multiple results from the map so fort he book name that start wiht Effective Java

  
  
  
  

        List<String> listOfBooks=  books.entrySet().stream()

                                    .filter(e -> e.getValue().startsWith("Effective"))

                                    .map(Map.Entry::getKey)

```