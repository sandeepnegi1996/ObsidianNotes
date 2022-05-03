# print the middle of a linked list


## Solution 1: Optimal
- use two pointer apprach, fast and slow 
- fast jumps twice and slow jumps single times 
- later when fast reaches end we can print the element at the slow location

```java
 // Java program to find middle of linked list

	/* Function to print middle of linked list */
	void printMiddle()
	{
		Node slow_ptr = head;
		Node fast_ptr = head;
		
			while (fast_ptr != null && fast_ptr.next != null)
			{
				fast_ptr = fast_ptr.next.next;
				slow_ptr = slow_ptr.next;
			}
			System.out.println("The middle element is [" +
								slow_ptr.data + "] \n");
		
	}


```

## Solution 2:
1. Traverse the linkeded list , find the length of it
2. then again travel for n/2 time, lets say length=6 
3. no travel to third location using while loop and print that element.
