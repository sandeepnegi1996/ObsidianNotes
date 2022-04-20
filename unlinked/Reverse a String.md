# Reverse a String
```background

input : abcd
output : dcab
```



## Solution 1
- use inbuilt functions
- Create string builder and add the string to it
- apply reverse on string builder
- and then again change it back to string 


## Solution 2
- convert this to an array
- and then take two pointer low and high and swap start one to the end one 
- similar way we can swap the characters and reverse the whole string array and then convert it back to string


## Solution 3 
- We can store all the char to a stack
- and then pop the elements once we are poping it will be reversed


```java
import java.util.Stack;

  

class Test{

    public static void main(String[] args) {

        String str="auygdjashbdkjasbdjkasbd";

  
  

        // Solution 1

        StringBuilder stringbuilder=new StringBuilder(str);

  

        String reversedString= stringbuilder.reverse().toString();

  

        System.out.println(reversedString);

  
  

        //Solution 2

  

        char[] arr= str.toCharArray();

  

        char[] arr2= str.toCharArray();

  
  

        int start=0;

        int end=arr.length-1;

  

        while (start<=end) {

  

            //swap

            char temp=arr[start];

            arr[start]=arr[end];

            arr[end]=temp;

  

            start++;

            end--;

        }

  

        for (char c : arr) {

  

            System.out.print(c);

        }

System.out.println();

        //Solution 3

  

        Stack<Character> stck=new Stack<>();

  

        for (char c : arr2) {

            stck.push(c);

        }

  

        for (int i = 0; i < arr2.length; i++) {

            System.out.print(stck.pop());

        }

  
  

    }

}
```