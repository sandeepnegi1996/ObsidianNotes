# 📑 Use lambda expression to implement Runnable Interface

- **🏷️Tags** : #07-05-2022,  #pending #completed #permanent
[[JAVA-interviews]]
#### 🔗 Links


## Key Takeaways

## Overview
- to do this using a Runnable Interface and Lambda expression
- we have to to create reference variable to the Runnable interfacae and then just pass the method implmnetaion of run since it only contains the run method 
- then pass the reference variable to the thread class constructor and call the method start which will call the run internally


```java

class test {

    public static void main(String args[]) {

        Runnable thread1 = () ->{

            System.out.println("hello first thread");

        };

        // call the start method of the thread

  

        Thread myfirstThread=new Thread(thread1);

        myfirstThread.start();

    }

}

```

