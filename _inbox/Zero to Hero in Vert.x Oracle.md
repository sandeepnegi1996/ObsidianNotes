# 📑 Zero to Hero in Vert.x Oracle
[[what is Vert.x]]
- **🏷️Tags** : #30-05-2022,  #pending #completed #permanent

#### 🔗 Links
[oracle youtube link ](https://www.youtube.com/watch?v=3_CRKfs4Zzo&ab_channel=OracleDevelopers)

## Key Takeaways

## Overview
- hornetQ --> netty
- nodejs  --> single threaded --> non blocking
- red hat --> basically owner of VERT.X
-  used by many companies


## Event Loop
1. Single threaded event loop
2. don't block the event loop


## Verticles
1. Do All the work

## Event Bus
- core to vert.x
- talking of vertx


## Things to remember
1. vertx is modular
2. vertx.-web
3. vertx mongo-client
4. vertx-jdbc-client


## Project
1. clone the starter project 
2. change the pom.xml
	1. group id and artifact id 
	2. properties
3. vertx-core 
4. and vertx-unit
5. like we have nodemon in node js similar thing we can do with vertx so that whatever changes we do we will be able to see it immediately
6. redeploy shell script 

vertx-web 
vertx-client 

## Write a test case
in reactive world --> we send the request and then we will also send the method to be ran when the request is completed 
- in this case we will send the request and then send the lambda so that this lambda will run once the request is completed
- in this case if we succeded we will do something and if we fail we are going to do something.

- each verticle works on its own thread and it is asynchronous
- 

## Event Bus
1. for communication between verticles we will be using Event bus 
Vertx Future  --> will return the result to the calling thread



 


