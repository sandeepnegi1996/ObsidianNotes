# random-password-generator  
  [[backend developer projects]]
[project link](https://github.com/sandeepnegi1996/random-password-generator.git)  
  
CONTENTS OF THIS FILE  
---------------------  
* Introduction  
* Features  
* Todo  
* How to Run  
  
INTRODUCTION  
------ - This project is inspired by the same backend developer project portfolio [[backend developer projects]]  
- This project will generate random password only with alphabets, user needs to enter a number and it will create password  
  
FEATURES  
------------  
- hassle free way of creating a random password, use this service to create password  
  
  
TODO  
----------  
1. [x] Create basic hello world program  
2. [x] Give option to the user to enter the number of characters in the password  
3. [x] Generate random word for the given length  
4. [x] More features and issues are added in the issues section, follow that and provide yout inputs  
  
  
How to Run  
------------  
1. `javac RandomPasswordGenerator.java`  
2. `java RandomPasswordGenerator`  
  
Learnings ---------  
###### Random Number   
```java  
Random r = new Random();  
int x    = r.nextInt(25);  
  
//above code will generate random number from 0 to 25   
  
```  
###### ASCII Values  
1. ASCII Value : `a --> 97`  
2. ASCII Value : `A --> 65`  
  
###### convert character to string :   
```java  
  
// Method #1  
String stringValueOf = String.valueOf('c'); // most efficient  
  
// Method #2  
String stringValueOfCharArray = String.valueOf(new char[]{x});  
  
// Method #3  
String characterToString = Character.toString('c');  
  
// Method #4  
String characterObjectToString = new Character('c').toString();  
  
// Method #5  
// Although this approach seems very simple,   
// this is less efficient because the concatenation  
// expands to a StringBuilder.  
String concatBlankString = 'c' + "";  
  
// Method #6  
String fromCharArray = new String(new char[]{x});  
  
```