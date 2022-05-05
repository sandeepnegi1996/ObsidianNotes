# 📑 find smallest and largest substring lexicographically

- **🏷️Tags** : #05-05-2022,  #pending #completed #permanent

#### 🔗 Links


## Key Takeaways

## Overview
- input : 
- welcometojava
3

**Sample Output 0**

ava
wel


-> here welcomtojava --> is a string 
3 --> a size of substring.

1. we need to find a smallest and largest substring lexicographically

- here first we have found a substring
- then used the compareTo method to compare the string
- then used the maximum and minimum approach to find the smallest and largest substring
`compareTo` --> `s1> s2 --> positive , s1< s2 --> negative` and `s1==s2 `, 0

```java 
public static String getSmallestAndLargest(String s, int k) {

        String smallest = s;

        String largest = "";

        String currentSubString;

        for (int i = 0; i <= s.length()-k; i++) {

        currentSubString= s.substring(i,i+k);

        if (currentSubString.compareTo(smallest)<0) {

            smallest= currentSubString;

        }

         if (currentSubString.compareTo(largest)>=0) {

            largest=currentSubString;

        } 

        }

        return smallest + "\n" + largest;

    }

```