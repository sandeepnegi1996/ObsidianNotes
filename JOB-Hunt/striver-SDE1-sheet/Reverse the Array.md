# Reverse the Array

Input : any array
Output : reversed array

## Solution 1 
- Print the array in reverse

## Solution 2
- Take another array of same size
- Traverse original array from end and store the elements in the new array

## Solution 3
- In place reversal, 
- swap first element with last 
- and then second element with second last and so on 

## Solution 4 
- Using Stack
- Put the array elements in the stack and then take the elements out of the stack 
- Store it in a separate array or put it in the same array
- [[stack in java]]


### All Solutions 
```java 

import java.util.Stack;

class reverseArray {

    public static void main(String[] args) {

       int[] inputArray= {5,6,7,8,9,10};

    //    Solution 1

       print the array in reversed order

       for (int i = inputArray.length-1; i >=0; i--) {

           System.out.print(inputArray[i]+ " ");

       }

  

    // Solution 2 :

  

       int[] reversedArray=new int[inputArray.length];

       int indexCounter=0;

       for(int i=inputArray.length-1;i>=0;i--) {

           reversedArray[indexCounter]= inputArray[i];

           indexCounter++;

       }

  

       for ( int a:reversedArray) {

           System.out.print(a+" ");

       }

  
  

       // Solution 3:

  

       int low=0;

       int high=inputArray.length-1;

        int temp=0;

       while (low<=high) {

  

        //swap

          temp=inputArray[low];

          inputArray[low]=inputArray[high];

          inputArray[high]=temp;  

  

          low++;

          high--;

       }

  

       for (int i : inputArray) {

  

        System.out.print(i+" ");

       }

  
  

       //Solution 4

        Stack<Integer> reversedArrayStack=new Stack<>();

  

        for (int i : inputArray) {

  

            reversedArrayStack.push(i);

        }

  
  

        for (int i = 0; i < inputArray.length; i++) {

            System.out.print(reversedArrayStack.pop()+ " ");

        }

  

    }

}
```