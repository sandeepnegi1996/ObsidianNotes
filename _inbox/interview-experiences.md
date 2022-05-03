#### 1100-1200: coding round
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
