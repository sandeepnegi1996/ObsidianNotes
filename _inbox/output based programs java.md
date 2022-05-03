# 📑 output based programs java

- **🏷️Tags** : #02-05-2022, #review, #reading_list

#### 🔗 Links


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