# 📑 backend developer projects

- **🏷️Tags** : #06-06-2022,  #pending #completed #permanent

#### 🔗 Links


## Key Takeaways

## Overview
- projects for backend developer



### Backend Projects

#### Beginner Level
1. Simple CLI Java Application
	1. [x] Dice Roller Program : it should ask user to roll a dice or exit, it should return a number from 1 to 6 any random number [[Dice-Roller CLI App]]
	2. [x] Save contact information, initally only name and mobile number later, use should be able to save, name, adress, mobile number, email adress, this is more kind of phone book but it will be modern phone book. [[Modern Phone Book CLI App  ]]
	3. [x] [[Random password Generator]]  
		1.  ask user to enter the length of password and generate password 


#### Medium Level 
1. Build some API with sample Data, such as movies or songs or anything else
	1. later add the CRUD functionality to it 
	2. Initially Do not add the database
	3. Add the database later

- public API github link : [github](https://github.com/public-apis/public-apis)

2. Build API by using Third Party API in your projects

3. Build a webscraper

4. Build a cypher

5. Build an API that can render some templates

6. Integrate CRUD API with database,
	1. Relational or non relational

7. Implement Basic Auth
	1. Username and password
	2. JWT autentication
	3. Implement OAuth Service 

8. Email Service Integration to CRUD API

9. Deployment for Backend API
	1. use docker or some github actions or some other free services.

10. Build API using GraphQL

11. Chat Server using Sockets

12. Web server 

13. Chat bot



# A weather API with a twist

Internet is filled with [weather APIs](https://www.weatherapi.com/), so finding one that provides the information you need should not be hard. After that find some other geographical information you’d like to add, such as [the size of the population](https://countriesnow.space/) for that city and write some code that will merge the data.

In comparison with the previous two projects this one should be easy to structure. Just provide a single endpoint for the client to specify the city name, then perform both requests (bonus points if you can do them in parallel) and merge both responses in a single JSON response before returning to the client.

This practice should give you an idea of what it’s like to query external resources in the form of APIs, as opposed to writing your own ones.

Finally, if you’re feeling extra confident by now, you might want to look into adding caching to the API. After all, some of the data you’re retrieving is not going to update regularly. Consider using the same database you used before for this, since you’ll feel more comfortable with it. However, if you like bonus points, figure out how to add [Redis](http://redis.io/) into your project and use it as the caching layer.

And with that, it concludes all the API-related practice you need, at least for the time being. If you feel like you’d like to know more about the world of microservices, check out [this list of articles on the subject written by me](https://deleteman123.medium.com/list/microservices-1bdacffee603).

Now, let’s look at what else you can do in the back-end world.

# Writing a chat server and a chat client

This is quite the jump, I know, but there is a good point for it: chat doesn’t work over regular HTTP because with that protocol communication is not efficient.

Through working on these two projects you’ll become very familiar with sockets, a very interesting and powerful way of communicating 2 or more services together.

Now, don’t be scared, I know the idea of writing a full chat server can seem quite big, however, let me assure you: it’s not.

If by any chance you’re using Node.js, check out [Socket.io](https://socket.io/) to know everything you need to. That page will not only give you all the tools you need, but it’ll also give you the examples you can start with and tinker until you understand how they work.

If you’re using Python, you can take a look at [this tutorial](https://pythonprogramming.net/sockets-tutorial-python-3/) covering sockets with Python 3. And if you’re using something different, just do a quick google search for “sockets in <enter your programming language here>” and you’ll find plenty of information.

# Finally, let’s tie it all together

Or as together as possible, after all some of the applications covered here aren’t compatible with one another.

But taking as many of the concepts covered until now as we can, let’s try to create a hangman-type game. You can make it quite interesting and it can all live in your terminal:

1.  Use your CLI experience to create a command-line client that asks for your name, lets you input new letters on your turn and shows you the result of your actions.
2.  Use an API to validate the input against the current phrase. You can keep the central logic of the game inside the API and just write a dummy client that sends requests and shows the appropriate response.

That alone should be enough to keep you busy for a while, but if you’re feeling confident, you can use sockets to add multiplayer capabilities and share the real-time state of all players by exchanging the game state of each individual player through the broadcasting capabilities provided by the sockets.

Fun, isn’t it?

And that’s it, if you went through all these example applications you’ve experienced 90% of what it’s like to be a back-end developer. That means you’re more than ready to apply for that position and be very comfortable at job interviews.

Do you think I’ve left any key skill out from my list? Share a type of application that would include it in the comments and let’s discuss!

_More content at_ [**_plainenglish.io_**](http://plainenglish.io/)_. Sign up for our_ [**_free weekly newsletter_**](http://newsletter.plainenglish.io/)_. Get exclusive access to writing opportunities and advice in our_ [**_community Discord_**](https://discord.gg/GtDtUAvyhW)_._


