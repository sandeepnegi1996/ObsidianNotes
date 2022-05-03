# Multithreading and multiprocessing
#os
#interview

## Multithreading
- threads, are there, each thread will run some portion of the code, and it will run
- Parallel to each other and concurrently.
- *these thread uses same memory space from the parent process.*
- save memory (by utilizing under utilized memory)
- increase computing speed ( since now we have more workers *thread*)
- [[multithreading with examples in java]]

### Deep explaination
- Browser running , and IDE running, teams is running etc in our local system
- All these applications are basically called as process we can check this from the task manager also
- Inside Browser : we are having multiple tabs, those are basically threads for the same process.
- Similar thing happens in Teams: there we have channel, sharepoint integration and bots and many other integrations all those most probably will be using sepeate thread to run.



## Multiprocessing
- it depends on the CPU units (CPU Cores)
- means more Cores more multiprocessing is possible, each core can handle multiple processing .
- [ ] [[single core multiprocessing]] --> how this works


## Difference 
-   Multiprocessing uses two or more CPUs to increase computing power, whereas multithreading uses a single process with multiple code segments to increase computing power.
    
-   Multiprocessing increases computing power by adding CPUs, whereas multithreading focuses on generating computing threads from a single process.
    
-   Multiprocessing is used to create a more reliable system, whereas multithreading is used to create threads that run parallel to each other.
    
-   Multiprocessing requires a significant amount of time and specific resources to create, whereas multithreading is quick to create and requires few resources.
    
-   Multiprocessing executes many processes simultaneously, whereas multithreading executes many threads simultaneously.
    
-   Multiprocessing creates a separate address space for each process, whereas multithreading uses a common address space for all the threads.

## Benefits of Multithreading
1. less memeory required
2. accssing memory is easier since threads share teh same memory space
3. switching between threads is fast, since they are using same memory space
4. [ ] [[What is memory space in multithreading]]
5. threads creation is faster
6. lightweight than process
7. cost of communitcation between threads is low


## Drawbacks of multithreading
1. debugging and trouble shooting issues may become more challengin


## When to use Multithreading and Multiprocessing
1. use multithreading to make *user interactions* faster

Example : Text editor
- one thread can track keystrokes
- second thread can display data
- third thread can checking spelling
- one thread can do the grammar check and so on

2. Use for I/O bound or network bound application

Example:
- Lets say a webscraper is there i will be network bound application
- so there we can multiple threads to do multiple operations

3. Multiprocessing : *computational-intensive programs*

Example:
- here we can leverage multiple cores and use that for our processing to do machine learning model and so on

4. Multiprocessing to develop programs that is CPU intensive.
