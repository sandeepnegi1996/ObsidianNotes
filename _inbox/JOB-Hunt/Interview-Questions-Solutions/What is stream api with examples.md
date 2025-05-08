# What is stream API in java with examples

[[JAVA-interviews]] [[More Java Interview Questions 2024]]

#java #interview-prep 

links : importan Questions
[Java 8 Interview Sample Coding Questions (javaconceptoftheday.com)](https://javaconceptoftheday.com/java-8-interview-sample-coding-questions/)

## Motivation
- Understanding why we should use Streams over conventional for loop or for each
- since it can ramp up our programming game like crazy
- [[best java online compiler]]
- [[What are the features introduced in Java 8]]


### pending 
- [x] //TODO : what is chars()   [[#what is chars and mapToObj in java]]
- [x] //TODO : what is mapToObj  [[#what is mapToObj ?]]
- [ ] //TODO : groupingBy   
- [ ] //TODO : Function.identity  
- [ ] //TODO :Collectors.counting()
- [ ] //method reference and lambda
- [ ] BiConsumer in java 

## What is Stream 
- introduced in java8
- used for bulk data operation
- it will not modify the original list or collection
- **it is not a Data structure, it takes input from array, Collection , I/O channel**
- stream operations can be pipelined together (all the *intermediate operations* only)
- *Terminal operations* is used to mark the end of the stream and return the result
- stream can be sequential stream() or parallel (parallelStream())
- we cannot use primitive type datastrucutre with streams -> with the help of IntStream,LongStream,DoubleStream-> we can use primitive types with streams
- 

### Intermediate Operations
1. *map*
2. filter
3. sorted

### Terminal Operations 
1. collect : accumulate elements into a collection
2. forEach
3. *reduce* : reduce to single result value


Note: learn about `Integer.parseInt(n)`

##### what is chars and mapToObj in java 
- chars() it is used with String and it will convert the String to Stream of integer -> basically integer Stream -> then we can use mapToObj to map it to any 

```java
  
 String inputString1 = "Hello I am a Software Engineer";  
 //chars() -> it converted the given string to integer of stream  
 IntStream intergerStream = inputString1.chars();  
  
int sumOfCharStream= intergerStream.sum();  
 System.out.println(sumOfCharStream);  
 //Integer::min  
  
 //convert ing to stream of characters // mapToObj is an intermediate operation and it will run the passed method on each of the stream elements  
 Stream<Character> characterStream=  inputString.chars().mapToObj(ch -> (char)ch);  
  
  
inputString.chars().mapToObj(ch ->String.valueOf((char) ch)).forEach((str) -> System.out.println(str));
```

#### what is mapToObj ?
1. mapToObj -> signify that the stream chnages from `IntStream to Stream<T>`

2. in the below mentioned example we are coverting the IntStream which we have recived from `inputString.chars()` to `Stream<Character>`
3. 
` Stream<Character> characterStream=  inputString.chars().mapToObj(ch -> (char)ch);  `

- so when we wanted to process stream of integers we should use specialized stream that is `IntStream` rather then `Stream<Integer>` because in the later one there is autoboxing and unboxing taking place., this can help us in improving performance. 
- 

## Coding problems with Streams


```java
package org.example;  
  
import java.util.Arrays;  
import java.util.List;  
import java.util.Map;  
import java.util.function.Function;  
import java.util.stream.Collectors;  
  
/**  
 * Hello world! * */public class App {  
    public static void main( String[] args )  
    {  
  
        List<Integer> listOfInteger= Arrays.asList(1,2,3,4);  
  
        //1. filter all the even number from the list and store it in a list  
      List<Integer> evenList=   listOfInteger.stream()  
                                              .filter(n -> n%2==0)  
                                             .collect(Collectors.toList());  
  
  
      //2. multiple all the elements in the list by 2  
            //stream            //map            //collect  
       List<Integer> multipliedByTwo =  listOfInteger.stream()  
                        .map(n ->n*2)  
                                .collect(Collectors.toList());  
  
//        System.out.print(multipliedByTwo);  
  
  
        //separate odd and even numbers using streams -> partioningBy        Map<Boolean,List<Integer>> partionedMap= listOfInteger.stream().collect(Collectors.partitioningBy(n -> n%2==0));  
  
//        System.out.println(partionedMap);  
  
  
        //remove duplicates from list       List<Integer> duplicateListElement =  Arrays.asList(1,1,2,2,3,3,3,4,5);  
  
       List<Integer> distinctElementsOnlyList =  duplicateListElement.stream().distinct().collect(Collectors.toList());  
  
       System.out.println(distinctElementsOnlyList);  
  
       //find frequencey of each string using java8 streams  
  
        String inputString = "Hello I am a Software Engineer";  
  
         Map<Character,Long> frequenceyMap = inputString.chars().mapToObj(c -> (char)c)  
                                            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));  
  
        System.out.println(frequenceyMap);  
  


  
  
  
  
  
    }  
}
```










## Examples
1.map
```java
List<Point> originalPoints = Arrays.asList(new Point(1, 2), 
										   new Point(3, 4), 
										   new Point(5, 6), 
										   new Point(7, 8)); 
										   
System.out.println("Original vertices: " + originalPoints); 
List<Point> scaledPoints = originalPoints .stream()
										  .map(n -> new Point(n.X * 2, n.Y * 2)) 
                                          .collect(Collectors.toList()); 
                                          
    System.out.println("Scaled vertices: " + scaledPoints);
```

2. reduce  : help to reduce to single result value
- applies binary operation on each element
- first arguement : return value of previous operation
- second arguement : current stream element



```java
List<Integer> arrList= Arrays.asList(1,2,3,4,5);

  

      int ans=arrList.stream().reduce(0,(sum,i)-> (sum+i));

        System.out.println(ans);

  

     arrList.stream()

                .map(e -> e*5)

                .collect(Collectors.toList())

                .forEach(e -> System.out.print(e+"  "));
```



#### Another example of reduce  IMP
- Longest String in the list
```java
  List<String> arrList= Arrays.asList("sandy","amit","driviz","dhruv","vikky","rahul","dhani");

     String longestString= arrList.stream()

            .reduce("",(word1,word2) -> (
                word1.length() > word2.length() ? word1:word2));
                System.out.println(longestString);


    }
```

#### Maximum number in the list 

```java
Integer[] arr={1,2,3,4,5};
        List<Integer> list=Arrays.asList(arr);
        
       
       //find the maximum using reduce
       
     int max=  list.stream()
            .reduce(0, (a,b) ->  {
              // a<b ? b:a
              
              if(a<b) {
                return b;
              }else{
                return a;
              }
              
              
              } );
       
       
       System.out.println(max);

```


#### find minimum without any default value
- so in the case we not giving any default value with reduce we have to choose the return type to Optional


```java
//find the minimum using reduce
       
     Optional<Integer> max=  list.stream()
            .reduce( (a,b) ->  {
              // a<b ? b:a
              
              if(a>b) {
                return b;
              }else{
                return a;
              }
              
              
              } );
       
       
       System.out.println(max.get());
    }

```





4. filter
 
```java
List<Employee> richGuys=empList.stream()
				.filter(e -> e.getSal()>15)
				.collect(Collectors.toList());
```

2. sorted
```java
List<Employee> richGuysSorted=empList.stream()
				.filter(e -> e.getSal()>15)
				.sorted(Comparator.comparing(employee -> employee.getSal()))
				.collect(Collectors.toList());
```

3. forEach
```java
		empList.forEach(e-> System.out.println(e))
```

4. map
```java
	List<Integer> listtest= empList.stream
		.map(e-> e.getSal()+10)
		.collect(Collectors.toList());
```

5. collect : using collect with `Collectors.toSet`, we can also collect list to a Map
```java
Set<String> setOfStringStartsWithC 
                      = listOfString.stream()
                                    .filter(s -> s.startsWith("C"))
                                    .collect(Collectors.toSet());
```

## Problem Statement

-  list of employee with id,name and salary
1. get all the employee whose salary is above 15 
2. store it in separate list and print it 

### Conventional Way of Doing
- Traverse List
- Write if and filter on that 
- Store it in separate list 
- Print separate list 

#### Code 

```java
		for( Employee e:empList) {
		
			if(e.getSal()>15) {
				richGuys.add(e);
			}
		}

Sysout.out.println(richGuys);

```


#### Do this with Stream

```java
List<Employee> richGuys=empList.stream()
				.filter(e -> e.getSal()>15)
				.collect(Collectors.toList());
```

here we have used filter method and given the method to it that how we wants to filter and then we have used collect method to produce the list out of that stream

- There are bunch of other method in stream and we can combine the methods of stream

### Example  : sorted
filter and sorted --> first filter with sal > 15 and then sort with the salary 

```java

		List<Employee> richGuysSorted=empList.stream()
				.filter(e -> e.getSal()>15)
				.sorted(Comparator.comparing(employee -> employee.getSal()))
				.collect(Collectors.toList());
```

Streams will not modify the original list or data structure 




