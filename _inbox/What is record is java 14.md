# 📑 What is record is java

- **🏷️Tags** : #03-05-2022, #review, #reading_list

#### 🔗 Links


## Key Takeaways

## Overview

###  Traditional way of using creating Models
```java
import java.io.*; 
import java.util.*; 

public class HelloWorld {
    public static void main(String[] args) {
      
      Employee e1=new Employee(1,"sandy");
      System.out.println(e1.getempNumber()+" "+e1.getempName());
       
    }
}


class Employee {
  
  private  int empNumber;
  private  String empName;
  
  public int getempNumber() {
    
    return empNumber;
  }
  
  public String getempName() {
    return empName;
  }
  
  public void setempNumber(int empNumber) {
    this.empNumber=empNumber;
  }
  
  public void setempName(String empName) {
    this.empName=empName;
  }
  
  public Employee(int empNumber,String empName) {
    this.empNumber=empNumber;
    this.empName=empName;
  }
}

```

### How to do this with java 14
```java

public record EmployeeRecord(String name, int empNumber ) {

}

```

- This will generate getters and setters
- generate constructor
- generate toString
- generate hashCode
- generate equals method in java
- this will not generate setters
- this is immutable object , means record object is `immutable`
- we can create instance method
- we can create static method similar to normal class
- we can create static fields
- records cannot extend other classes in record in java
- records are final
- 