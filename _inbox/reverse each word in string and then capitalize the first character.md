# 📑 reverse each word in string and then capitalize the first character

- **🏷️Tags** : #02-05-2022, #review, #reading_list

#### 🔗 Links


## Key Takeaways

## Overview
- this question was asked to manish in the interview 


### Solution 1
1. split each word using split function and convert string to string array
	1. use split method
2. reverse each word 
	1. Create a function for this which will take input reverse and return 
3. Capitalize first char
	1.  use substring to get the first char --> convert to uppercase
	2. and then take the remaining characters 
	3. concetenate both of them to one and form one string
4. concatenate all the words and return the string

```java

class test {

    public static void main(String[] args) {

        String str="hello world";

  

        String[] stringArray=str.split(" ");

        String finalString="";

        for(String s: stringArray) {

  

             finalString+=capitalizeFirstCharacter(reverseWord(s))+" ";

        }

        System.out.println(finalString);

    }

  

    public static String capitalizeFirstCharacter(String s) {

  

       return  s.substring(0,1).toUpperCase() + s.substring(1);

    }

  

    public static String reverseWord(String s) {

  

        StringBuilder stringbuilder=new StringBuilder();

        stringbuilder.append(s);

  

        return stringbuilder.reverse().toString();

    }

}

```