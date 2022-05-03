# 📑 how to handle custom exceptions in spring project

- **🏷️Tags** : #25-04-2022, #review, #reading_list

#### 🔗 Links
[best resource](https://auth0.com/blog/get-started-with-custom-error-handling-in-spring-boot-java/)

[github repo for code](https://github.com/Tonel/spring-boot-custom-error-handling)


## Key Takeaways
1. A class annotated with `@ControllerAdvice` will be able to handle exceptions from anywhere in our spring application
2. 
## Overview
1. lets understand how to handle custom exceptions in spring boot

##  Prerequisites
-   Java >= 1.8 (Java >= 13 recommended)
-   Spring Boot >= 2.5
-   [Spring Boot Starter Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web) >= 2.5
-   [Spring Security](https://mvnrepository.com/artifact/org.springframework.security/spring-security-core) >= 5.5
-   [Project Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok) >= 1.18
-   Gradle >= 4.x or Maven 3.6.x



##  Default Error handling in springboot
1. by default spring boot will look for `/error` endpoint
2. when no mapping can be found , spring boot will automatically configures a default fallback error page.
3. `Whitelable Error Page` which is like empty HTML Page.
4. similarly in case of REST service it will return the default JSON response
```json

{
  "timestamp": "2021-15-08T14:32:17.947+0000",
  "status": 500,
  "error": "Internal Server Error",
  "path": "/test"
}
```




###  Handling Exceptions with @ControllerAdvice
1. Since Spring 3.2  we had the `@ControllerAdvice` it promotes unified exception handling throughout the whole application   [[@ControllerAdvice]]
2. with this we can handle , exceptions throughout our application.
3. It means , a class annotated with `@ControllerAdvice` will be able to handle exceptions thrown from anywhere from the application.
4. we have access to status code and response body.


#### Example
1. `error` package, Class `ErrorMessage` it will be used for the `custom error body`
2. it has variour data members that are required for the error reponse.
3. such as status code,name,timestamp,error message, stacktrace,data

```java
public class ErrorResponse {
    // customizing timestamp serialization format
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    private int code;

    private String status;

    private String message;

    private String stackTrace;

    private Object data;

    public ErrorResponse() {
        timestamp = new Date();
    }

    public ErrorResponse(
            HttpStatus httpStatus,
            String message
    ) {
        this();
    
        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
    }

    public ErrorResponse(
            HttpStatus httpStatus,
            String message,
            String stackTrace
    ) {
        this(
                httpStatus,
                message        
        );

        this.stackTrace = stackTrace;
    }

    public ErrorResponse(
            HttpStatus httpStatus,
            String message,
        String stackTrace,
            Object data
    ) {
        this(
                httpStatus,
                message,
        stackTrace
        );

        this.data = data;
    }
}
```


#### @ControllerAdvice
- to handle the custom response we will use @ControllerAdvice
- `@ControllerAdvice` internally uses `@ExceptionHandler` this annotation is used to define which method should be used in case of an error.
- whatever exception is thrown is compared to the ExceptionHandler and then based on the parameter that method will be used for the response.
- if the exception does not match to any of the exception in the class of the `CustomControllerAdvice` then we shoul definitely implement the fallback method to cover all the remaining cases.
- 


```java
@ControllerAdvice
class CustomControllerAdvice {

    @ExceptionHandler(NullPointerException.class) // exception handled
    public ResponseEntity<ErrorResponse> handleNullPointerExceptions(
        Exception e
    ) {
        // ... potential custom logic

        HttpStatus status = HttpStatus.NOT_FOUND; // 404

        return new ResponseEntity<>(
            new ErrorResponse(
              status, 
              e.getMessage()
            ),
            status
        );
    }



    // fallback method
    @ExceptionHandler(Exception.class) // exception handled
    public ResponseEntity<ErrorResponse> handleExceptions(
        Exception e
    ) {
        // ... potential custom logic

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500

    // converting the stack trace to String
    StringWriter stringWriter = new StringWriter();
    PrintWriter printWriter = new PrintWriter(stringWriter);
    e.printStackTrace();printWriter
    String stackTrace = stringWriter.toString();

        return new ResponseEntity<>(
            new ErrorResponse(
              status, 
              e.getMessage(), 
              stackTrace // specifying the stack trace in case of 500s
            ),
            status
        );
    }
}
```

### How to use it further

#### Defining many Custom Exceptions (Preferred way)

#### Defining single custom exceptions to carry all data
