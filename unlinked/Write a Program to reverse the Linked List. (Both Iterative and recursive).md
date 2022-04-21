# Write a Program to reverse the Linked List. (Both Iterative and recursive)

## Solution 1:
1.  create three pointer
2. prev, curr, next
3. as we travel we will move foward and remove ther back link and assign it to previous node 

```java
class LinkedList {
    static Node head;
    static class Node {

        int data;

        Node next;

        Node(int d)

        {

            data=d;

            next=null;

        }

    }

  

    Node reverse(Node node) {

        Node prev=null;

        Node current=node;

        Node next=null;

        while (current!=null) {

            next=current.next;

            current.next=prev;

            prev=current;

            current=next;

        }

        node=prev;
        return node;

    }

  

    void printList(Node node) {

        while (node!=null) {

            System.out.print(node.data+" -> ");

            node=node.next;

        }

    }
  
    public static void main(String[] args) {

        LinkedList list=new LinkedList();

        list.head=new Node(1);

        list.head.next=new Node(2);

        list.head.next.next=new Node(3);

        // list.printList(head);


       head= list.reverse(head); //this will give the head , new head pass that to the print list head

        list.printList(head);
    }    

}

```

## Solution 2 
1. Traverse the linked list 
2. store the elements in the stack complete element
3. then point the head to the temp location end location
4. then pop the elements from the stack and store it in temp.next
5. temp=temp.next

```java
    static void reverseLL()

    {  

        // Create a stack "s"

        // of Node type

        Stack<Node> s = new Stack<>();

        Node temp = head;

        //pushing all the elements to the stack

        while (temp.next != null)

        {

            // Push all the nodes

            // in to stack

            s.add(temp);

            temp = temp.next;

        }

        head = temp;

        //taking elements out of stack and then aligning in reverse order

        while (!s.isEmpty())

        {

            // Store the top value of

            // stack in list

            temp.next = s.peek();

            // Pop the value from stack

            s.pop();

            // update the next pointer in the

            // in the list

            temp = temp.next;

        }

        temp.next = null;

    }
```