# 📑 Examples of reduce method in java

- **🏷️Tags** : #08-05-2022,  #pending 

#### 🔗 Links


## Key Takeaways

## Overview
- reduce is an accumulator 
- this will basically produce the end result with single value


#### find the sum of even numbers from the list
```java
  int sum=   list.stream()

            .filter(e -> e%2==0)

            .reduce(0,(a,b)-> a+b);

  
  

            System.out.println(sum);

```


#### Sum of square of even numbers
```java
int sum= list.stream()

                    .filter(e -> e%2==0)

                    .map(e  -> (e*e))

                    .reduce(0,(a,b) -> a+b);

  
  

            System.out.println(sum);

    }

```
