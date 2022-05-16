# What is stream API in java with examples

## Motivation
- Understanding why we should use Streams over conventional for loop or for each
- since it can ramp up our programming game like crazy
- [[best java online compiler]]
- [[What are the features introduced in Java 8]]



## What is Stream 
- introduced in java8
- used for bulk data operation
- it will not modify the original list or collection
- it is not a Data structure, it takes input from array, Collection , I/O channel
- stream operations can be pipelined together (all the intermediate operations only)
- Terminal operations is used to mark the end of the stream and return the result
- stream can be sequetial stream() or parallel (parallelStream())

### Intermediate Operations
1. *map*
2. filter
3. sorted

### Terminal Operations 
1. collect : accumulate elements into a collection
2. forEach
3. *reduce* : reduce to single result value


Note: learn about `Integer.parseInt(n)`

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



