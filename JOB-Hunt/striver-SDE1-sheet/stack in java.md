# Stack in java
#coding 
#java 
#stack #ds
- Linear data structure
- Order of operation LIFO (Last in first out)
- FILO (first in last out)


## 4 basic operations 
1. push
2. pop
3. peek
4. isEmpty

![[Pasted image 20220417224450.png]]


## Time Complexity
- push, pop, peek,isEmpty --> all take O(1) time , we don't need to run any loops on this 


## Real Life Examples
- Undo Features in photoshop, editor
	- Recent files plugin in obsidian
- Backtracking : here we need to store the previous state, to store the previous state we can use stack
- for all the method calls in a program stack is being used
- Browsers : when we use `ctrl +shift +t  ` 
	- to open the previously opened tab there it is using the stack to keep track of old tabs
- Browser : history is stored in tab datastructure so that last one is at top
- Mobile Phone : call log


## Example
- Example : here we have stored array elements in stack by push opeation
	- and then pop the elements from the stack one by one since stack is LIFO , elements are reversed
```java
 Stack<Integer> reversedArrayStack=new Stack<>();

  

        for (int i : inputArray) {

  

            reversedArrayStack.push(i);

        }

  
  

        for (int i = 0; i < inputArray.length; i++) {

            System.out.print(reversedArrayStack.pop()+ " ");

        }
```