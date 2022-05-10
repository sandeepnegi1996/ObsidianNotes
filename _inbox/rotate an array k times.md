# 📑 rotate an array k times

- **🏷️Tags** : #07-05-2022,  

#### 🔗 Links

## Problem statement
```
given an array of numbers we need to rotate the array k times


[1,2,3,4,5,6,7,8]

```


### Solution 1
1. use a temporary array and store the values in that array 
```java
import java.io.*; 
import java.util.*; 

public class HelloWorld {
    public static void main(String[] args) {
   
   
   int arr[]={1,2,3,4,5};
   
   int Arr[]=new int[arr.length];
  Arrays.fill(Arr,0);
   int k=2;
   
   for(int i=0;i<=k;i++) {
     
     Arr[i+k]=arr[i];
   }
   
   
   
   for(int i=0;i<k;i++) {
     Arr[i]=arr[k+1+i];
   }
   
   for(int a:Arr) {
     System.out.print(a+" ");
   }
   
   
   
       
    }
}


```

### Solution 2
1. use one temp variable and swap the values k times
```java

import java.io.*; 
import java.util.*; 

public class HelloWorld {
    public static void main(String[] args) {
   
   
   int arr[]={1,2,3,4,5};
  int k=2;
  
  
  for(int i=0;i<k;i++) {
    
    for(int j=arr.length-1;j>0;j--) {
      
      //swap
      //arr[j] an arr[j-1]
      
      int temp=arr[j];
      arr[j]= arr[j-1];
      arr[j-1]=temp;
    }
  }
  
  for (int a: arr) {
    
    System.out.print(a+" ");
    
  } 
   
   
   
       
    }
}






```

### Solution 3
- reverse the array and then divide the array into k and then reverse the invidual array

```

```
