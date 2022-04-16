# Golang introduction by Caleb Doxsey

#book
#coding
#go


## Getting Started
### Files and folders
- files such as txt,exe,.zip all contains differnt type of information
- folder : used to club files into one place, managment

### Terminal
- normal
### Text editors
- normal

### Go Tools
- compiled programming languages, means what ever we code is converted to something which is understandable by the hardware.



## Your First Program
### How to read a Go Program
- top to bottom and left to right  like a book

```go
package main
import "fmt"
func main() {
	fmt.Println("hello moto")
}

```

- first line of code is package, which is a way of organizing code
- executable and libraries : executable can be run, and libraries are group of lines of code that can be shared with others 
- import : ``` import "fmt" ``` 
	- fmt is a package and we are importing it , so we know that package is just a group of files

- comment : 
	- single line : //
	- multiple line :  ```  /*   */```

- function : go language is full of function function name an then arguments and then inside that we can do anything
	- *main is a special function which is being called when we run our code this is similar to main method in java*
	- fmt.Println("hello")  --> fmt package, println is the function inside that package and we are passing argument inside println tha is string. here Println will do the major job.
	
- go doc fmt Println : this will print the documentation



### Os package 
1. Example 1 of os package
```go
package main

import (

    "fmt";
 
    "os"

)

  

func main() {

    fmt.Println("hello world")

    os.Exit(0)

    fmt.Println("second hello world")

}
```

-  here we can see that we have imported the os package and we are using the method os.Exit which is having status code 0 means all fine non zero means some error , 
-  it is used to exit from the current program.

2. Example 2 of os package

```go
package main
import (
    "fmt" ;
    "os"
)

func main() {
    for  i := 0; i <10 ;i++ {

        fmt.Printf("[%d] hello \n",i)

        if(i==5) {

           fmt.Printf("Bye")
            os.Exit(0)
        }

}

}

```









## Types
- Go is statically typed compiled language , which means that variables always have a specific type and that type cannot be changed.

### Number
	1. Integer
	2. Float

- Example

```go
package main

import "fmt"

  

func main() {

    fmt.Println("1+1 = ",1+1)

  

    fmt.Println("1.0+1.0 = ",1.0+1.0)

}

Output: is same in both the cases
```
3. Other Operands 
	1. +, - , * , / , %

4. Strings
	1. 1 byte = 1 char
- Example
- space is also counted so the length will be 5
```go
fmt.Println(len("test "))
```

#### Complete Example 

```go
package main
import "fmt"
func main() {

    fmt.Println("1+1 = ",1+1)
    fmt.Println("1.0+1.0 = ",1.0+1.0)

    //length of string

    fmt.Println(len("test "))  
    //string concetenation
    fmt.Println("hello 1 "+ "world 1")
    fmt.Println("hello"[2])     //108
    // l --> asci value is 108

    //each character is a byte

    // 1 byte = 8 bit

    //Booleans  --> named after George Boole

    // it is special 1 bit integer type

    //logical operators are used with bool

    //&& ,|| , !

    fmt.Println((true && false) || (false && true) || !(false && false))
}
```


## Variables and Control Flow Statements

- 