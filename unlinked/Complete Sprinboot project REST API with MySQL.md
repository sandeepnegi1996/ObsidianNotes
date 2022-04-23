# Complete Sprinboot project REST API with MySQL
[[JAVA-interviews]]

## Most Detailed Solution

link: https://www.section.io/engineering-education/how-to-create-a-rest-api-using-spring-boot-maven-and-mysql/

repo link : https://github.com/sandeepnegi1996/employee-management-system

[[open-source]]


## Goal
1. create a Spring Boot RESTful API that performs CRUD operations by making a database call to a MySQL database using Hibernate - an implementation of JPA (Java Persistence API).


## Key Points we will learn
-   How to create and set up a Spring Boot application with a tomcat server.
-   MySQL database Configuration in a Spring Boot project.
-   You will learn how to implement Object Relational Mapping using Hibernate.
-   Maven for dependency management.
-   Exception handling in Java.
-   How to consume a REST API using postman.
-   How to document API using Swagger.


## Steps 

### Create Springboot project
1. visit start.spring.io
2. create spring project
3. add dependency such as SpringWeb, MySQL , Spring Data JPA
4. spring-boot-starter-web : it will help to create web project. pulls transistive dependeny, and use tomcat as embedded server
5. spring-data JPA : allow us to persist data in SQL database using Spring Data and hibernate
6. MySQL Driver : for the database




### Configuring MySQL , JPA and Hibernate 
1. src/main/resources / application.properties

```properties 
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
spring.datasource.username=root
spring.datasource.password=mypassword
```


2. change server port 
`server.port=8081`

3. Hibernate 
```properties

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto=update

```

###  Entry point of the application
```java
@SpringBootApplication
public class EmployeeAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeAppApplication.class, args);
    }

}
```

2. `@SpringBootApplication` : it enables auto configuration, beans are automatically created based on classpath settings, propery settings. and other factors

3. Run the application 
	`mvn spring-boot:run`


### Project structure
-  we are going to structure our code into four packages
1. Data :  for repository and models and payloads
2. service :  business logic
3. web : controllers
4. Exceptions : custom exceptions

Controller --> service --> Repository --> call our database

![[Pasted image 20220421143133.png]]



 ### Creating the domain class inside data package
1. here create models
2. Department enum
3. Employee Class


```java
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastname;
    private String phoneNumber;
    private String email;
    private double salary;
    @Enumerated(EnumType.STRING)
    private Department department;

    public Employee(){}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && Objects.equals(id, employee.id) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastname, employee.lastname) && Objects.equals(phoneNumber, employee.phoneNumber) && Objects.equals(email, employee.email) && department == employee.department;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastname, phoneNumber, email, salary, department);
    }
}
```


- `@Entity` : tells spring that Employee class is a POJO `Plain Old Java Object` and we want this to be persisted in the database. 
- `@Id` which makes the field as *primary key* for the *Employee table* [[What is primary key]].
- `@GeneratedValue` : tells database to automatically generate this id 
- override, `toString`, `equals` and `hashCode` method , [[What is equals() method in java]]


### Adding additional Maven dependencies
1. `javax validation` : this will help us to validate the fields of an object before writing to a database
2. `springfox` : document our API


### Payloads
1. to handle request and response, we will have payloads 


#### Request payload 
- EmployeeRequest
1. when we are receiving request at that time we will be using this payload
2. add all the fields , getters and setters similar to the Employee Model class
3. `@NotBlank` and `@NotNull` this ensures fields are not empty and not full.
4. `@Email`  : validates that the email is valid


```java
public class EmployeeRequest {
    @NotBlank
    @NotNull
    private String firstName;
    @NotBlank
    @NotNull
    private String lastname;
    @NotBlank
    @NotNull
    private String phoneNumber;
    @Email
    private String email;
    @NotBlank
    @NotNull
    private double salary;
    @NotBlank
    @NotNull
    @Enumerated(EnumType.STRING)
    private Department department;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
}
```



#### Response Payload
- normal Message Response class with message as getters and setters
- this will be used by all the response.
```java
public class MessageResponse {

    private String message;

    public MessageResponse(String message){
        this.message = message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
```



### Repository
- EmployeeRepository interface
- extends JpaRepository

```java
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
```

- `@Repository` : will make the interface as bean
- `JpaRepository` : by extending this: we have `save` . `findAll` , `findById`



### Employee service
1. service will have business logic to improve on separation of concern we will have 
	interface `EmployeeService ` and then one class `EmployeeServiceImpl`


```java
@Component
public interface EmployeeService {

    MessageResponse createEmployee(EmployeeRequest employeeRequest);
    
    Optional<Employee> updateEmployee(Integer employeeId, EmployeeRequest employeeRequest);
    
    void deleteEmployee(Integer employeeId);
    
    Employee getASingleEmployee(Integer employeeId);
    
    List<Employee> getAllEmployee();
}
```


2. `@Component` : register employeeService interface as a bean in the application context and makes it accessible durng the classpath scanning .


```java

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public MessageResponse createEmployee(EmployeeRequest employeeRequest) {
        Employee newEmployee = new Employee();
        newEmployee.setFirstName(employeeRequest.getFirstName());
        newEmployee.setLastname(employeeRequest.getLastname());
        newEmployee.setPhoneNumber(employeeRequest.getPhoneNumber());
        newEmployee.setEmail(employeeRequest.getEmail());
        newEmployee.setSalary(employeeRequest.getSalary());
        newEmployee.setDepartment(employeeRequest.getDepartment());
        employeeRepository.save(newEmployee);
        return new MessageResponse("New Employee created successfully");

    }

    @Override
    public Optional<Employee> updateEmployee(Integer employeeId, EmployeeRequest employeeRequest)  throws ResourceNotFoundException{
    
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isEmpty()){
        throw new ResourceNotFoundException("Employee", "id", employeeId);
        }
        
        else
        employee.get().setFirstName(employeeRequest.getFirstName());
        employee.get().setLastname(employeeRequest.getLastname());
        employee.get().setPhoneNumber(employeeRequest.getPhoneNumber());
        employee.get().setEmail(employeeRequest.getEmail());
        employee.get().setSalary(employeeRequest.getSalary());
        employee.get().setDepartment(employeeRequest.getDepartment());
        employeeRepository.save(employee.get());
        return employee;
    }

    @Override
    public Employee getASingleEmployee(Integer employeeId) throws ResourceNotFoundException{
        return employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
    @Override
    public void deleteEmployee(Integer employeeId) throws ResourceNotFoundException {
        if (employeeRepository.getById(employeeId).getId().equals(employeeId)){
            employeeRepository.deleteById(employeeId);
        }
        else throw new ResourceNotFoundException("Employee", "id", employeeId);
    }
}
```

-   The class throws an exception (`ResourceNotFoundException`- This is the custom exception class we created that extends `RunTimeException`) where the Id supplied to get a single employee does not exist on the database.'


### Controller

```java
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

	@PostMapping("/add")
    public ResponseEntity<MessageResponse> addEmployee( @RequestBody EmployeeRequest 
        employee) {
        
        MessageResponse newEmployee = employeeService.createEmployee(employee);
        
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees () {
        List<Employee> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Integer id) {
        Employee employee = employeeService.getASingleEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    

    @PutMapping("/update/{id}")
    public ResponseEntity<MessageResponse> updateEmployee( @PathVariable Integer id, @RequestBody EmployeeRequest employee) {
        MessageResponse updateEmployee = employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
```


#### Simplest Post Controller 
```java
@PostMapping("/add")
    public ResponseEntity<MessageResponse> addEmployee( @RequestBody EmployeeRequest 
        employee) {
        
        MessageResponse newEmployee = employeeService.createEmployee(employee);
        
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }
```


- Notes
`@ResquestBody` : PostMapping
`@PathVariable` : GetMapping(/find/{1})




