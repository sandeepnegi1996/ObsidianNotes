# Golang
#language
#backend

Link :https://www.freecodecamp.org/news/what-is-go-programming-language/



## What is Go and Golang ?
- Go is a languages which is known as Golang, 
- opensource 
- Google
- simple
- high-performing
- readable 
- efficient

### Origin of Golang
- since code base at google is becoming much more complex 
- designed by Robert Griesemer, Rob Pike and Ken thompson
- **Go lanunched in 2009, open source is 2012**
- concurrent

### Where it is used
- Server -side programming backend,
- game development
- cloud-based programming
- command-line tools.
- Devops and site reliability
- 
- Today : google, netflix, twitch, ethereum, Dropbox, Kubernetes, Docker, Heroku uses this language
- *Developer love coding in Go since it is simple to write code in Go *
- *Cloud platforms supports Go, AWS,Azure, GCP*

## Why is it better then other backend languages ?
-	What are the usecases where it is better 
- fast compilation and execution
- good documentation and community support
- Multhithreading and concurrency
	- Go is best in concurrency, means leverage multiple cores to run a task scaling is big issue which is solved by Go
	- it uses goroutines and not threads

- just like C/C++ Golang is a compiled language so it removes the step of interpretation and can boost performance and speed of execution.
- Go also uses garbage collection from java, so it is basically the best of both worlds

-  inbuilt Framework for Testing and Profiling

## How to get started ?
- Install go
- Create go-workspace --> means normal folder
- Add the go-workspace in the environment variable 
- create go simple program
- run : go run main.go

```

package main

import "fmt"
  
func main(){

    fmt.Println("hello sandy")

    fmt.Println("first program done")

  

    // This is how we comment in Go

}
```


```
go run main.go
```


## Learn Go
#### Beginners
- video Course 
```

https://www.youtube.com/playlist?list=PLDZujg-VgQlZUy1iCqBbe5faZLMkA3g2x
```

- Books 

```

https://www.golang-book.com/books/intro


```
- [ ] [[Golang introduction by Caleb Doxsey]] 

#### Intermediate 
```

# 2. Intermediate-level programmer

You have a programming language or two under your belt, and you know some fundamentals well.

**Since you’ve already had some experience, the first thing to do is to consume these three free resources:**

1.  Go by Example: [https://gobyexample.com](https://gobyexample.com/)

This is a very concise and practical language overview with details on how to write idiomatic code and all the basics.

2. Tour of Go: [https://tour.golang.org](https://tour.golang.org/)

Dive into this tour from the language authors, with exercises and all the necessary info. And it goes deep fast. You’ve been warned ;-)

3. Effective Go: [https://golang.org/doc/effective_go.html](https://golang.org/doc/effective_go.html)

This document shows you how to write idiomatic Go code and avoid common errors.
```

## Go Programs 
1. hello world
```
package main

import "fmt"

  

func main() {

    fmt.Println("second go program")

}
```


2. 