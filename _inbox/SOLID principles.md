# 📑 SOLID principles

- **🏷️Tags** : #04-05-2025,  #pending #completed #permanent

#### 🔗 Links


## Key Takeaways

## Overview


### SOLID

#### **Single Responsibility Principle (SRP)** 
- a class should handle one functionality. if a class has multiple functionalities or responsibilities changes in one area can affect others , leading to bugs.
	1. keep class focused and easier to maintain.

BAD design -> a single class is doing business logic and db logic, we can separate the concern and move the database logic to a repository class like 
```java
public class EmployeeService {
    public void saveEmployee(Employee employee) {
        // Business logic
        if (employee.getName() == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        // Database logic
        System.out.println("Saving employee to database...");
    }
}
```


Right Design 

```java 
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void validateAndSaveEmployee(Employee employee) {
        if (employee.getName() == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        employeeRepository.save(employee);
    }
}

@Repository
public class EmployeeRepository {
    public void save(Employee employee) {
        System.out.println("Saving employee to database...");
    }
}
```

#### **Open /Closed Principle (OCP ) :**
1. software should be open for extension and closed for modification
2. should be able to add new functionality to a class without modifying existing code.





### **4. Interface Segregation Principle (ISP)**

- **Definition**: A class should not be forced to implement interfaces it does not use.
- **Why It Matters**: Prevents bloated interfaces and keeps them focused.


```java
public interface EmployeeService {
    void createEmployee();
    void deleteEmployee();
    void generatePayroll();
}
```


```java
public interface EmployeeManagementService {
    void createEmployee();
    void deleteEmployee();
}

public interface PayrollService {
    void generatePayroll();
}
```


### **5. Dependency Inversion Principle (DIP)**

- **Definition**: High-level modules should not depend on low-level modules. Both should depend on abstractions.
- **Why It Matters**: Promotes loose coupling and makes the code easier to test and maintain.

```java
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
    }
}
```

4. ![[Pasted image 20250430100912.png]]




