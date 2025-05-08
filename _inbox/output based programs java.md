# 📑 output based programs java

- **🏷️Tags** : #02-05-2022, #review, #reading_list

#### 🔗 Links

### Sapiens MCQ test
1. ![[Pasted image 20220511131953.png]]
2. ![[Pasted image 20220511132018.png]]
3. ![[Pasted image 20220511222939.png]]
4. ![[Pasted image 20220511223042.png]]
5. ![[Pasted image 20220511223133.png]]
6. ![[Pasted image 20220511223207.png]]
7. ![[Pasted image 20220511223253.png]]
8. ![[Pasted image 20220511223306.png]]
9. ![[Pasted image 20220511223333.png]]
10. ![[Pasted image 20220511223354.png]]
11. ![[Pasted image 20220511223412.png]]
12. ![[Pasted image 20220511223425.png]]
13. ![[Pasted image 20220511223447.png]]
14. ![[Pasted image 20220511223517.png]]
15. ![[Pasted image 20220511223532.png]]
16. ![[Pasted image 20220511223559.png]]
17. ![[Pasted image 20220511223618.png]]
18. ![[Pasted image 20220511223718.png]]
19. ![[Pasted image 20220511223728.png]]
20. ![[Pasted image 20220511223742.png]]
21. ![[Pasted image 20220511223819.png]]
22. ![[Pasted image 20220511223840.png]]
23. ![[Pasted image 20220511223852.png]]
24. ![[Pasted image 20220511223909.png]]
25. ![[Pasted image 20220511223931.png]]
27. ![[Pasted image 20220511224039.png]]
28. ![[Pasted image 20220511224051.png]]
29. ![[Pasted image 20220511224107.png]]
30. ![[Pasted image 20220511224132.png]]
31. ![[Pasted image 20220511224141.png]]
32. 
33. 
34. 
35. 
36. 
37. 
38. 
39. 
40. 
41. 
42. 
43. 

### Null pointer exception
#### Try to print the string assigned with null value
- output is null
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
  
  
      String str=null;
       System.out.println(str);
    }
}

```


#### run the equals method in string that contains null value
- null pointer exception at run time 

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
  
  
      String str=null;
       System.out.println(str.equals("asjhdbas"));
    }
}

```



### break keyword
```java
class test7

{

    public static void main(String[] args) {

  

        if(true)

            break;

  

    }

}

```


	Output : this will not compile since break requires a loop or a switch 


### Integer comparison
```java
    //sthis works similar to string pool constant

  

        // case1

         Integer n1=100;

         Integer n2=100;

  

        System.out.println(n1==n2);    //true

  

        //case 2

        Integer x1=200;

        Integer x2=new Integer(200);

  

        System.out.println(x1==x2);     //false

```


### Character ascii value in print
```java
  System.out.println('a'+'b'); //add the ascii value --> that is 97+98 =195

```