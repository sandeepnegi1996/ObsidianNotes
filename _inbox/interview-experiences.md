### Interview Unifyed technical round 2
1.  what is eurekha server how you will do the deployment of the microservices
2. How to store session data in angular
3. what is router and interceptor in angular
	1. how to do nested routing and how to do logging with interceptor
4. how to make http calls in angular
5. life cycle hooks of angular
6. how to avoid cross site scripting attack in angular 
7. what is accessibility and 503 compliance in forntend
8. what is position in frontend'

##### database
1. what are views can we write on views or read possible only
2. how to add a new column to exisitng table in database
3. what is relationship in daabase
4. what is locking in database
5. what are procedures
6. what is cursor
7. what is Elastic search and Redis and how rabbit mQ works




### wissen interview 
1. Is it possible to have Employee class as a key in hashmap
	1. what we need to do to achive this , hashcode and equals
	2. will it be possible to store the elements are retreive
	3. what you will write in equals and hashcode method

2. Why we make class immutable 
3. 	class A {
	public void synchronized m1() {Thread.sleep(5000);}
	}

- what if we create two object of Class A and run the m1 method what will be the output in this case
- they will run at same time, can we make it run one after the another

4. How to sort Student Class -->
	1. stream, comparator and comparable 
2. what is the issue with immutable data , that is performacne issue
3. what is shared lock


		Parent --> walk and run
		                                 --> run --> walk()

		Child --> walk and run with super keyword

		Parent P=new Child() 
		p.run()

4. List of interger , sum of squares of odd numbers using stream and reduce 
5. chmod 764 file1
6. Database : BookAthor
		Book unique | author repeated

	author name who has written more than 10 books

7. find the string with longest and even lenfgth out of big string
8. find the pair in arraty with given differene 
9. find unique number : in -> 1123 --> 123 




				class A {
				public void synchronized m1() {Thread.sleep(5000);}
				}
				Harish Aggarwal1:20 PM
				walk()
				class Parent
				Parent p = new Child();
				p.run();
				Harish Aggarwal1:25 PM
				sum of the squares of all the odd numbers in the array
				Harish Aggarwal1:37 PM
				chmod 764 file1
				Harish Aggarwal1:39 PM
				the names of the authors who have written more than 10 books.
				Harish Aggarwal1:55 PM
				Be not afraid of greatness, some are born great, some achieve greatness, and some have greatness thrust upon them.
				You1:56 PM
				s.split();
				Harish Aggarwal1:58 PM
				111 -> 1
				121 -> 2
				123 -> 3
				You2:00 PM
				-342
				-3-4-2
			





### Unifyed (Gurgaon) Full stack developer role interview 
1. Scopes of beans in spring boot
2. Types of dependecy injection, constructor and setters
	1. which one is better then the other one 
3. What is transactions in database
4. What are joins 
	1. write query for outer, innner, joins
5. Traverse a json and show the data in the component in angular 



### TATA 1Mg interview experience 
1. explain oops concepts in details
2. overloading and overriding 
3. LinkedList vs ArrayList
4. Internal Working of HashSet
5. Concurrent HashMap
6. Singleton Design DPattern
7. Create Immutable class with fields such as string and arraylist 
	1. but make sure we are not able to modify the arratylist
8. How to share object
	1. copy object or cloning
2. how to change port in spring boot
3. Qualifier
4. 

### 1100-1200: coding round
	furthest from zero, compare absolute values but return the actual value
	find the median of the sub array
	Create the schema 
	![[Screenshot (27).png]]
	check the question on the schema

	driviz discussion 

```code


1. Customers >>> 1mil.
2. Order-Shipping -> 1to1
3. Order -> Payment -> 1 to many 

Teacher -> Class
Teacher -> ClassID
Class -> TeacherID

TeacherClass
TeacherID ClassID TeacherClassID
T1 C1
T2 C2

Entity:
Individual IDs
1. Customer - FirstName: String, LastName: String, Email: String, Phone, Addresses<List>, Password<encrypted>
2. Order - OrderItem<List>, Status, CustomerID, AddressID
3. OrderItem - Item, Quantity, OrderID
4. Item - Name, Description, Qty, SoldBy
5. Payment - Method, Amount, Currency, CreatedAt, Status, OrderID
5. Address - HouseNo, City, State, Pin

Customer

Non-Functional
1. AES-256 Password Encryption - secret based
2. 

Customer, Order -> ON CustomerID
Customer Left Outer Join Order -> ON CustomerID


```

![[Screenshot (27) 1.png]]
