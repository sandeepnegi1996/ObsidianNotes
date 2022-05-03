# 2022-04-15
#interview 
#developer
#questions 


- Create a Tiny url backend from scratch

Functionality :
user1 : l take a URL and shorten the url
Other users : will use the same url may be one time or possibly multiple times

Ratio : 30 and 70

30% : create
70 % users

Size of the url in characters : 1000 character

Size of 1 char : 4 byte ?
1000 X 4 = 4000 

4000 is the total size of the url in bytes 

means 4Kb 

Lets image we wants to create a system of low latency
and in  1 second we are getting one millon requests


1s --> 10lakh requests 

3 lakh will be write 
7 lakh will be read

Write

1 write : 4kb x 3 lakh = 12 lakh kb --> 1.2 Gb write in one second 

Read :
4kb X 7 lakh : 28 lakh --> 2.8 Gb read in one second



### Database Size

- 1 minute : Write : 1.2gb X 60 = 72 gb in one minute will be used 
- 1 minute Read :  2.8 gb x 60 = 168 gb in one minute

- 1 hour

-1 Day


- [ ] [[How to use a select the hardisk on a database]]

so based on the read and write i will select the size of the datbase

- Table is fixed in this case and there there is no additional information we need to store

- [ ] [[How to choose the relational or non -relational database]]


- [ ] [[ How to separate read and write in database for relational]]

-  how to reduce the read and write in the database.
- [ ] [[How to separate read and write in a database in case of non-relational database]]
- [ ] [[How to do scaling of the database]]

### HOT URL :
- some url must be used multiple times, means there are some url which is used by many people. some url will be used more number of times.


- for each query we are making call the datbase.

- [ ]  [[How redis works, and what is eviction policy]]
- [ ] [[Load balancing on databse , redis on each instance how it works]]
 


### Monilithic or microservice
- read will be more on backend server , and write will be less

- so lets say we do horizontal scalling , we are scaling both the read and write on each instance on horizontal scaling.

- [ ] [[Read and write microservice, how to break monilithic service to microservice]]

- login service will be used less 
- payment service should be scaled since payment service can be used more

- what we need to think is how to save costnig
- [ ] -[[How to save costing while we are developing a infrastructure]]

- [ ] [[What if two tiny url collide ]]

- [[Backend generate url and it collides with the exising data]]


- [[Usecases of system design]]
- [[Tech blogs of big tech companies]]

- [ ] [[How postgres will update an entry what happens in the background]]

- [ ] [[ Design from database to Service ]]

- [ ] [[LLD and HLD]]
- [ ] [[Why you are using Kafka  vs other queues]]
- [ ] [[How to choose a database for the non structural]]
- [ ] [[Why we wants to code in this particular language ]]











