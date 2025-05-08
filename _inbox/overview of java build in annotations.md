# 📑 overview of java build in annotations

- **🏷️Tags** : #19-05-2022,  #pending #completed #permanent

#### 🔗 Links


## Key Takeaways

## Overview
- annotation is java types that are preceded by an `@` symbol
- spring and hibernate are great examples of framework that rely heavily on annotations to enable various design techniques


### Functionality
1. we can add metadata to our source code 
2. inform the compiler about warnings and errors 
3. manipulate source code at compilation time 
4. modify or examine the behavior at runtime.


## Java Build in Annotations
1. `@Override`
2. `@SuppressWarnings`
3. `@Deprecated`
4. `@FunctionalInterface`
5. `@SafeVarags`
6. `@Native`



## Meta Annotations
- these can be applied to other annotation
1. `@Target`
2. `@Retention`
3. `@Inherited`
4. `@Documented`
5. `@Repeatable`









### @FunctionalInterface
- java 8 allows us to write code in more functional way
- if we intend a SAM --> Single Abstract Method Interface we can optionally mark it as such with `@FunctionalInterface`

- 
```java

import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Adder addref=(a,b)->(a+b);
        
        System.out.println(addref.add(4,5));
        
        
    }
}

@FunctionalInterface
interface Adder {
  
  int add(int a, int b);
}

```

- *if we try to add a new method in the Adder interface compiler will throw us warning*
- without the annotation we would have compiled it 

### @Native 
1. this annotation is added in java.lang.annotation package in java 8
2. it is only applicable to fields
3. *it indicates that the annotated fields is a constant that may be referenced from the native code.*

```java

public final class Integer { 

@Native public static final int MIN_VALUE = 0x80000000; 

}

```



- 














