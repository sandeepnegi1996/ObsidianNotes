# 📑 what is active MQ

- **🏷️Tags** : #09-05-2022,  #pending 

#### 🔗 Links
https://www.openlogic.com/blog/what-apache-activemq


## Key Takeaways

## Overview
- ActiveMQ is a popular open source messaging service that is build on top of java nad it works as a message-oriented middleware (MoM).
- *ActiveMQ is designed to send messges between two or more applications*
- similar to message oriented middleware
- 

## Usage
- it is similar to *message broker*
-   it can be used to as a bridge between multiple components that be hosted on separate servers or can be written in differnent programming


### UseCase
1. lets say we are sending the request from the frontend to the backend and there is some failure on the backend service and now the requests will fail
2. in the case if there is some queue in between we can call it message message is there in that case immediately request will not be processed but it will be stored in the queue and then it will be processed


##### Before
1. Frontend --> backend

##### After message broker
1. Frontend --> ActiveMQ --> backend 


### when to use ActiveMQ
1. *if we have a system where the request must be send no matter what happen, now or laterm in that case we should use a messgae broker, like activeMQ* 
2. sometimes what happens is there is burst of request in the system in that case we need some mechanism to handle all the request, since may be due to this backend is down, in that case also it will be useful


## What are Apache ActiveMQ Brokers ?
1. apache active mq is basically an implementation of java messaging servicce that is JMS.
2. The single node which allows clients to connect to it and use these messgaing concepts is called an AciveMQ Broker

#### Other JMS Providers 
1. RabbitMQ
2. SonicMQ
3. Windows Azure Messaging


## ActiveMQ architecture Overview
1. it consisits of data pattern called as *messgaes,queue,topics*'
2. broker will take the object in the json or xml format and in the payload and help in transfer of the information


### How ActiveMQ Mesages Work
1. once the messge is received in the broker they can be either queue or topic

##### Queue
1. *producer produces mesasges and push them into queue and then those messages are polled and collected by consumer one message at a time*






