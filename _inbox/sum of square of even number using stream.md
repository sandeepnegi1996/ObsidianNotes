# 📑 sum of square of even number using stream

- **🏷️Tags** : #05-05-2022,  #pending #completed #permanent

#### 🔗 Links


## Key Takeaways

## Overview

```java
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Optional<Integer> sum = list.stream()

                                   .filter( e -> e%2==0 )

                                   .map(e -> e*e)

                                   .reduce((a,b) -> a+b);

```