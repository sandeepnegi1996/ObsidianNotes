# Detect loop in a linked list
#java 
#coding 
#dsalgo 
[[linked List]]

## Solution (optimal)
1. We can use two pointer, fast and slow
2. if they become equal there is a loop in the linked list

```java


	void detectLoop()
	{
		Node slow_p = head, fast_p = head;
		int flag = 0;
		while (slow_p != null && fast_p != null
			&& fast_p.next != null) {
			slow_p = slow_p.next;
			fast_p = fast_p.next.next;
			if (slow_p == fast_p) {
				flag = 1;
				break;
			}
		}
		if (flag == 1)
			System.out.println("Loop found");
		else
			System.out.println("Loop not found");
	}

	

```

## Solution 2 : Hashing
1. we can use HashSet and store the element of the linkedlist in the hashset
2. if it contains the new element it means loop is there, if does not contains the new element, loop is not there.

```java

	static boolean detectLoop(Node h)
	{
		HashSet<Node> s = new HashSet<Node>();
		while (h != null) {
			
			if (s.contains(h))
				return true;
			s.add(h);

			h = h.next;
		}

		return false;
	}

	


```

## Solution 3 : flagging
1. here we can add additional data to the Node, that is flag,
2. if the flag is 1 then it means we are revisiting it and there is a loop
3. otherwise give the flag as 1




