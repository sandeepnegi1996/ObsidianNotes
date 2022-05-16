# 📑 System Design  Horizontal Vs Vertical Scaling

- **🏷️Tags** : #12-05-2022,  #pending #completed #permanent

#### 🔗 Links
[gaurav sen](https://www.youtube.com/watch?v=xpDnVSmNFX0&list=PLMCXHnjXnTnvo6alSjVkgxV-VH6EPyvoX&index=1)

## Key Takeaways

## Overview
- expose code using API
- return the response to the request
- setting a server that runs our code
- we need database, lets say if there is some power loss 
- we can host our application on cloud such as AWS., Azure


### Why we wants to deploy our application in Cloud
1. since if we deploy on cloud we will not manage the underlining hardware and all the things will be managed by cloud service provider, i need not to worry about the power or any other kind of hardware failure i am paying them and they will make the hardware works as expected


### In case of more number of requests
1. Solution 1 : buying bigger machine  --> vertical scaling
2. Slolution 2 : buying more machines  --> horizontal scaling



### Pros and Cons
1. Hz Scaling : some load balancer is required
	1. network calls that will be slow
	2. consistency is an isssue data
	3. we can add n numbers of systems 
1. Vertical Scaling : single point of failure
	1. intermprocess communitcation in the same suyste
	2. hardware limitiation we can increase the scale infiinitely
