# whether one string is a rotation of another
```

given s1 = ABCD and s2 = CDAB, return true, 

given s1 = ABCD, and s2 = ACBD , return false)
```

## Solution 1
1. Take s1 and find all the strings with the rotation and store them in string array
2. check s2 is there in the string array or not , if it is there then they are rotation of each other otherwise no


## Solution 2
1. Length of both the strings should be equal
2. once i sort s1 and s2 and i compare both , should be equal
3. Optimal solution 
	1. take temp variable : temp=s1+s1;
	2. now check s2 is a substring of temp or not , if it is then it is rotation of each other , otherwise not a rotation of each other


```java
  String s1="ABCD";

        String s2="BCDA";

  

        String temp=s1+s1;

  

        if (temp.contains(s2)) {

            System.out.println("rotated array");

        }

        else {

            System.out.println("not a rotated array");

        }
```