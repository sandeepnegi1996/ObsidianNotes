# 📑 method references in java

- **🏷️Tags** : #02-05-2022, #review, #reading_list

#### 🔗 Links


## Key Takeaways
- 

## Overview
- due to java 8 and lambda expression, now we don;t have to use anonymous classes ,
- [[Anonymous class in java before java 8]]
- *method references is a lambda expression , they are used to create simple lambda expressions by referencing existing methods*
- it uses `::` operator always 

1. Static methods
2. instance method of particular object
3. instance methods of an arbitary object of a particular type
4. Constructor



### References to a Static Method
1. with static methods
	1. in the below mentioned code the first we passed the lambda expression and then we ahve done the same thing using metod reference

	`StringUtils::capitalize`

```java
List<String> messages= Arrays.asList("hello","baeldung","readers");
		String str="";
		messages.forEach(word->{
			
			System.out.println(StringUtils.capitalize(word));
			
			
		});
		
		System.out.println("this is using method references");
		
		messages.forEach(StringUtils:: capitalize);

```



### References to an Instance method of particular object
```java
createBicyclesList().stream()
  .sorted((a, b) -> bikeFrameSizeComparator.compare(a, b));
```

Instead, we can use a method reference to have the compiler handle parameter passing for us:

```java
createBicyclesList().stream()
  .sorted(bikeFrameSizeComparator::compare);
```


### Reference to an Instance Method of an arbitary object of particular type
- method reference will take care of arguements
- 
```java

List<Integer> numbers=Arrays.asList(1,34,123,5345,12,3,4,4,5,654);
		
		 numbers.stream()
		.sorted((a,b)->a.compareTo(b))
		.collect(Collectors.toList());
		
		 numbers.stream()
		 .sorted(Integer::compareTo);
		
```


