# 📑 What is observable

- **🏷️Tags** : #27-04-2022, #review, #reading_list

#### 🔗 Links

[](https://www.tektutorialshub.com/angular/angular-observable-tutorial-using-rxjs/)
## Key Takeaways

## Overview
1. Rx : reactive programming --> asynchronous data streams


### What is Data Stream
1. Stream is a data : which arris over a period of time 
2. It can be anything, like variables, user inputs, caches etc

- These are the places where mouse have clicked so it is a series of steps

*Series of steps or data is a stream , it tell us about steps, completion , failure*
![[Pasted image 20220427132818.png]]

![[Pasted image 20220427132923.png]]



###  Reactive Programming
1. it is all about, creating a stream, emitting value or error or complete signals 
2. do something with the stream data


### What is Rxjs
1. It  is a library for javascript, to work with asynchronous data streams


### Where Angular uses it 
1. Http request
2. Value Changes/Status Changes
3. Router and form modules
4. Custom events to send obserable data from child to parent


### What is Observable in Angular
1. converts stream of data in to observable stream of data.
2. Observable stream emits the value from the stream continously
3. Observable signals when the stream is completed or error is thrown
4. Observales are declarative
5. define observable as a function and then observable will emit values when someone subscrivbes to it 


### Observer
1. observer is a subscriber to the Observable
2. observer communicate with observable using callbacks
3. when the observer subsscribe to the observable it send three callbacks
4. `next` `error` `complete`

5. Observable will send the inforamtion as soon as it is subscribed
6. When some values arrived it will invoke `next ` callback
7. Error --> `error`
8. Completion --> `complete`
9. 













