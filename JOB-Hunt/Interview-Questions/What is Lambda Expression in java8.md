# What is Lambda Expression in java8

- Functional interface : only one abstract method it can have other default methods or static method
- Lambda expression implement the only abstract method in the interface



### Simplest Functional Interface Example
```

interface FuncInterface
{
	void abstractFun(int x);
}

class Test
{
	public static void main(String args[])
	{
		
		FuncInterface fobj = (int x)->System.out.println(2*x);

		// This calls above lambda expression and prints 10.
		fobj.abstractFun(5);
	}
}


```


### forEach with Lambda Expression
```
import java.util.ArrayList;
class Test
{
	public static void main(String args[])
	{
		
		ArrayList<Integer> arrL = new ArrayList<Integer>();
		arrL.add(1);
		arrL.add(2);
		arrL.add(3);
		arrL.add(4);

		
		arrL.forEach(n -> System.out.println(n));

		
		//inside forEach multiple lines of lambda expression is there 
		arrL.forEach(n -> { 
		if (n%2 == 0) 
			System.out.println(n);
		});
	}
}

```
