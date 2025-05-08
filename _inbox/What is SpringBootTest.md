[[spring boot interview questions]]
[[springboot integration tests example]]
**🏷️Tags** : #interview/springboot 



- articles 
- [x] [Spring boot integration testing with @SpringBootTest - HowToDoInJava](https://howtodoinjava.com/spring-boot2/testing/springboottest-annotation/)
- [ ] [Testing with Spring Boot and @SpringBootTest (reflectoring.io)](https://reflectoring.io/spring-boot-test/)  -> pending read and document everything in this 

### Integration Tests Vs Unit Tests 
1. a unit test focus on testing single unit and the single unit will be mostly a class
2. whereas an integration test can be 
	1.  a tests that covers multiple units or classes or group of classes
	2. a test that might cover an interaction between the business service and persistence layer.
	3. A test that convers whole path -> we send the request and then we check whether it has changed the database state or not -> but why we need to check the database state we can just check the api response 


#### Do we really need SpringBootTest
1. with **test slice annotaion** we can only loads the beans which are required for a particular layer unlike springboot test that will fire up the whole application context.
2. . `@WebFulxTest` 
3. `@jdbcTest`
4. `@RestClientTest`
5. `JooqTest`





### Spring  Boot Test
-  as we were reading and learning about the integration tests with spring boot [[springboot integration tests example]]
- we have came across the annotation such as `@SpringBootTest` so we will deep dive and understand how it works and how we can use it further.


1. It can be used with integration or unit tests.
2. Spring TestContext -> `@ContextConfiguration(classes)` in spring -test , but `SpringBootTest` provides additional facilities over the normal spring test context.
3. we can define custom environment properties with @SpringBootTest
4. provides support for web Environment Mode
5. it automatically registers the `TestRestTemplate ` [[What is TestRestTemplate]]
6. internally it starts the whole application with class attribute we can mention what all classes we want in the application context 


#### @SpringBootTest Interface 
- these are all the meta annotations used in this case.

```java
@Target({ElementType.TYPE})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
@Inherited  
@BootstrapWith(SpringBootTestContextBootstrapper.class)  
@ExtendWith({SpringExtension.class})  
public @interface SpringBootTest {
```

##### Simple Example Mentioned below
```java
package com.hashcodehub.springboot.studentservices.Controller;  
  
  
import com.hashcodehub.springboot.studentservices.Model.Course;  
import com.hashcodehub.springboot.studentservices.StudentServicesApplication;  
import org.json.JSONException;  
import org.junit.jupiter.api.Test;  
import org.junit.jupiter.api.extension.ExtendWith;  
import org.skyscreamer.jsonassert.JSONAssert;  
import org.springframework.boot.test.context.SpringBootTest;  
import org.springframework.boot.test.web.client.TestRestTemplate;  
import org.springframework.boot.web.server.LocalServerPort;  
import org.springframework.http.HttpEntity;  
import org.springframework.http.HttpHeaders;  
import org.springframework.http.HttpMethod;  
import org.springframework.http.ResponseEntity;  
import org.springframework.test.context.junit.jupiter.SpringExtension;  
  
import java.util.ArrayList;  
import java.util.Arrays;  
import java.util.List;  
  
import static org.junit.jupiter.api.Assertions.assertTrue;  
  
@ExtendWith(SpringExtension.class)  
@SpringBootTest(classes = StudentServicesApplication.class,webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT)  
public class StudentControllerIT {  
  
    @LocalServerPort  
    private int port;  
  
  
    TestRestTemplate restTemplate=new TestRestTemplate();  
  
    HttpHeaders headers = new HttpHeaders();  
  
    @Test  
    public void testRetrieveStudent1Course1() throws JSONException {  
  
        HttpEntity<String> entity=new HttpEntity<>(null,headers);  
  
       ResponseEntity<String> response =  restTemplate.exchange(  
                createURLWithPort("/students/Student1/courses/Course1"),  
                HttpMethod.GET,entity,String.class);  
  
       String expected="{\"name\":\"spring\",\"id\":\"Course1\",\"description\":\"10 Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";  
        JSONAssert.assertEquals(expected,response.getBody(),false);  
  
    }  
  
    @Test  
    public void testRetrieveStudent2Course2() throws JSONException {  
        HttpEntity<String> entity = new HttpEntity<>(null,headers);  
  
        ResponseEntity<String> response= restTemplate.exchange(  
                createURLWithPort("/students/Student2/courses/Course2"),  
                HttpMethod.GET,entity,String.class  
        );  
  
        String expected="{\"name\":\"spring MVC\",\"id\":\"Course2\",\"description\":\"10 Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";  
  
        JSONAssert.assertEquals(expected,response.getBody(),false);  
  
    }  
      
  
  
    @Test  
    public void addCourse() {  
  
        List<String> stepsList= Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example");  
  
        Course course = new Course("Course5","Science","10Steps",  
               stepsList );  
  
  
        // with this httpEntity we can pass the required headers and body whatever we wanted to pass  
        HttpEntity<Course> entity = new HttpEntity<>(course,headers);  
  
        ResponseEntity<String> response=restTemplate.exchange(  
                createURLWithPort("/students/Student1/courses"),  
                HttpMethod.POST,entity,String.class);  
  
        String actual= response.getHeaders().get(HttpHeaders.LOCATION).get(0);  
  
        assertTrue(actual.contains("/students/Student1/courses/"));  
  
    }  
  
  
  
  
  
  
    private String createURLWithPort(String uri) {  
        return "http://localhost:"+port+uri;  
    }  
  
  
  
  
}
```


7. if we wanted our application context to only have fewer classes this is the case when we are using `@SpringBootTest` with unit testcases -> that time we want to limit the number of classes in our context that can be achived with classes attribte 



###### TODO
- [ ] Need to read more about above mentioned annotation  