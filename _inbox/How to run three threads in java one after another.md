# 📑 How to run two threads in java one after another

- **🏷️Tags** : #10-05-2022, #completed #permanent

#### 🔗 Links


## Key Takeaways

## Overview
- to run two threads one after the another one it needs to be synchronized , wait, notify and notifyAll is useful 
- synchronization means to allocate a turn to a Thread
- wait method is called on some objects
- resourcelock will be used to lock all the threee threads and wait methos will be called on object of ResourceLock.
- 


### How to achieve this
1. Thread A should first acquire lock on the object of ResourceLock
2. instantiate synchronised lock
3. Thread A should check whether flag==1
4. if no , then wait
5. if yes, then print A , and set flag=2  so that next turn is for thread 2 and then Notify all the waiting threads by using notifyAll method.
6. once notified all the waiting threads will wake up that is in our case thread B and thread C but as the value of flag is 2 then only thread B is going to run and other threads will go to waiting state

\
#### Code to run three threads one after the another one 

```java
  
  

/**

 * threadTest

 */

public class threadTest {

  

    public static void main(String[] args) {

        ResourceLock lock=new ResourceLock();

  

        Thread A = new ThreadA(lock);

        Thread B=new ThreadB(lock);

        Thread C=new ThreadC(lock);

  

        A.start();

        B.start();

        C.start();

  
  

    }

}

  

class ThreadA extends Thread {

  

    ResourceLock lock;

  

    ThreadA(ResourceLock lock) {

        this.lock=lock;

    }

  

    @Override

    public void run() {

  

        synchronized(lock) {

            if (lock.flag==1) {

            System.out.println("A");

            lock.flag=2;

            lock.notifyAll();  

            }

            else{

                try {

                    lock.wait();

                } catch (InterruptedException e) {

                    // TODO Auto-generated catch block

                    e.printStackTrace();

                }

  

            }

        }

        }

  

}

  

class ThreadB extends Thread {

  

    ResourceLock lock;

  

    ThreadB(ResourceLock lock2) {

        this.lock=lock2;

    }

  

    @Override

    public void run() {

  

        synchronized(lock) {

        if (lock.flag==2) {

        System.out.println("B");

        lock.flag=3;

        lock.notifyAll();  

        }

        else{

            try {

                lock.wait();

            } catch (InterruptedException e) {

                // TODO Auto-generated catch block

                e.printStackTrace();

            }

        }

    }

  

}

  

}

  

class ThreadC extends Thread {

  

    ResourceLock lock;

  

    ThreadC(ResourceLock lock) {

        this.lock=lock;

    }

  

    @Override

    public void run() {

        synchronized(lock) {

        if (lock.flag==3) {

        System.out.println("C");

        lock.flag=1;

        lock.notifyAll();  

        }

        else{

            try {

                lock.wait();

            } catch (InterruptedException e) {

                // TODO Auto-generated catch block

                e.printStackTrace();

            }

        }

    }

}

  

}

  
  
  

class ResourceLock {

    public volatile int flag=1;  //since we wants to start from flag 1

}

```