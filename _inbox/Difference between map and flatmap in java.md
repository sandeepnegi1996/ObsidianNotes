# 📑 Difference between map and flatmap in streams

- **🏷️Tags** : #02-05-2022, #review, #java 

#### 🔗 Links
[baeldung](https://www.baeldung.com/java-difference-map-and-flatmap)


## Key Takeaways

## Overview
- Streams : represents a sequence of objects
- Optional : classes that represent a value is present or absent


### map and flatmap in Streams
- map is used with normal list 
- flatmap is used with list of list 
	- flatmap will basically flatten the list ,

```java

  

import java.util.*;

import java.util.stream.Collectors;

  

class test7

{

    public static void main(String[] args) {

       List<String> list=Arrays.asList("a","b");

  

       List<String> finalList =  list.stream()

                                .map(String::toUpperCase)

                                .collect(Collectors.toList());

  

        // finalList.forEach(e->System.out.println(e));

  
  

        List<List<String>> listOfListStrings=Arrays.asList(

                                            Arrays.asList("a"),

                                            Arrays.asList("b")

  
  

                                            );

  

        System.out.println(listOfListStrings);

  

        List<String> flattedned= listOfListStrings.stream()

                        .flatMap(Collection::stream)

                        .map(String::toUpperCase)

                        .collect(Collectors.toList());

  

                        System.out.println(flattedned);

  
  
  
  

    }

}


```


```Output :

[[a], [b]]   --> before flattening
[A, B]       --> after flattening

```



### flat map
is used to flatten the nested list of objects

```java
List<List<List<String>>> listOfListStrings=Arrays.asList(

                                             Arrays.asList(

                                           Arrays.asList("a"),

                                             Arrays.asList("b")

                                        )

  
  

                                            );

  

        System.out.println(listOfListStrings);

  

        List<String> flattedned= listOfListStrings.stream()

                        .flatMap(Collection::stream)

                        .flatMap(Collection::stream)

                        .collect(Collectors.toList());

  

                        System.out.println(flattedned);

```