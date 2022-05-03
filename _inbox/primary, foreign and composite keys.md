# 📑 primary, foreign and composite keys

- **🏷️Tags** : #03-05-2022, #review, #reading_list

#### 🔗 Links
(https://www.youtube.com/watch?v=B5r8CcTUs5Y&ab_channel=EddieWoo)

## Key Takeaways

## Overview
- each table is basically represent an entity
- shopping order
	- order no |  customer  | adress |  product information |
			- 1               sandy   add1        info
			- 2             dhruv    add2        info

- lets say sandy manke more order we will be entering same informstion in the above table
- so we are mking reduntant data in this excel
- may be adress changes


- So we will divide the flat file into smaller tables


Table 1 : order    adn Table 2: Customer

Order : orderid and customer id 

Order : orderid --> PK
customer id : --> FK

Customer Table : customer id , Customer Name,  adressID 
Customer : customer id : primary  key 
Adress Id : FK


Adress : adress Id, street , pincode , state , country
Adress ID : PK



1. each customer can have multiple order
--> from custome to order : 1 to Many ( customer to order)

2. Each customer can have multiple adress
	1. means --> customer to adress --> 1 to Many relations 



(https://www.youtube.com/watch?v=s6MH7f3SnsY&ab_channel=GateSmashers)

### Relationship : 

1-1
1-M
M-M (M-N)


#### one to one
- ![[download.jpg]]

#### one to many
1. customer to order
2. one customer can have many order : relations is (1-M)
3. Customer table
4. order table
5. ![[download (1).jpg]]
6. here we can see that a customer can have many order
7. and in the relationaship table we can clearly see that one customer can have multiple order
8. so in the relationship table the customer id is FK and order id is primary PK
9. so what we can do we can combine this relationship table with order table since this table is having order id as PK and customer id can be repeated here.

10. now we need to understnad , group by and join to get the data.
11.  one to one we can reduce table
12. one to many we can reduce table
13. many to one we can reduce table
14. aways merge to many side 


####  Many to Many
1. ![[download (2).jpg]]
2. Student and Course
3. one student can take many course
4. and one course can have many students
5. roll number and course number combined can be a primary key
6. which is also called as composite keys
7. so in many to many we cannot reduce the table


###  Group By

###  Joins






