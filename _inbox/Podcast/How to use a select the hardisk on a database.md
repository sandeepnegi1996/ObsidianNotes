# How to use a select the hardisk on a database

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