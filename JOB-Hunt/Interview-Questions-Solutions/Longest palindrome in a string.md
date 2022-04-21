# Longest palindrome in a string
#java 
#coding 
#dynamicprogramming

```

S = "aaaabbaa"
**Output:** aabbaa
**Explanation**: The longest Palindromic
substring is "aabbaa".
```


## Optimal Solution  -->pending
https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/

- To reduce time complexity , we will be storing the results of sub-problems 
- [ ] [[Dynamic Programming]]







## Solution 1
-  find all the possible subtring
- traverse only once and find all the substring 
- check palindrome or not
- if palindrome , check the length
- if length is greater than the last length , put it in maxLength and also store that string print to console
- 

```java
 class palindronmicString {

    public static void main(String[] args) {

        String s1= "aaaabbaa";

        int maxlength=0;

        String longestPalindromicStringtest="";

        for (int i = 0; i < s1.length(); i++) {

  

            //for eacj substring

            // i need to check palindrome or not and if i tis palindrome i will store the length

             int currentlength=0;

           if(checkPalindrome(s1.substring(i, s1.length()))){

  
  

                currentlength=s1.substring(i, s1.length()).length();

  

                if (currentlength>maxlength) {

                    maxlength=currentlength;

                    longestPalindromicStringtest=s1.substring(i, s1.length());

                }

           };

        }

  

        System.out.println(maxlength);

        System.out.println(longestPalindromicStringtest);

    }

    public static boolean checkPalindrome(String str) {

  

        StringBuilder stringbuilder=new StringBuilder(str);

  

        String reversedString= stringbuilder.reverse().toString();

  

       if (reversedString.equals(str)) {

           return true;

       }else{

           return false;

       }

  

    }

}
```