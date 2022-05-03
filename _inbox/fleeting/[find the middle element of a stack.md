# 📑 [find the middle element of a stack

- **🏷️Tags** : #24-04-2022, #review, #reading_list

## 🔗 Links


### Solution 1
1. push element to stack
2. remove the element and add it to arraylist
3. and then check the mid of the arraylist
```java
Stack<Integer> stack=new Stack<>();

  

        List<Integer> list=new ArrayList<>();

        stack.push(1);

        stack.push(2);

        stack.push(3);

        stack.push(4);

        stack.push(5);

  

        stack.push(6);

  

  

       while (!stack.isEmpty()) {

           System.out.print(stack.peek()+" ");

            list.add(stack.pop());

       }

  

       System.out.println();

  

       int length=list.size();

  

       System.out.println(list.get(length/2));

```




### Solution 2 --> optimal solution
https://www.youtube.com/watch?v=ua1bPxSV_H0
doubly linked list 

