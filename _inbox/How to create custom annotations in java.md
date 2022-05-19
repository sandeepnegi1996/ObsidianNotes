# 📑 How to create custom annotations in java

- **🏷️Tags** : #18-05-2022,  #pending #completed #permanent

#### 🔗 Links
[baeldung](https://www.baeldung.com/java-custom-annotation)

## Key Takeaways

## Overview
- used to add the metadata information to our source code
- annotations offers an alternative to the use of XML descriptions and marker interfaces
- [[what is XML descriptors and marker interfaces]]
- we can add them to packages, classes, interfaces, methods and fields 
- [[overview of java build in annotations ]]


### Class Level custom annotations
1. we will create three annotations, and we will serialize the object to json here

- below is the annotation created and can be basically used on classes to mark something 
- 
```java

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.Type)
public @interface JsonSerializable {

}

```



### Field Level Custom Annotation
- this annotaion can be applied on teh field that will be serialized into json

```java

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface JsonElement {

	public String key() default "";
}

```


### Method level annotation
- before serialization i want to run a particular method
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Init {

}

```


### Applying Annotations

```java

@JsonSerializable
public class Person {

    @JsonElement
    private String firstName;

    @JsonElement
    private String lastName;

    @JsonElement(key = "personAge")
    private String age;

    private String address;

    @Init
    private void initNames() {
        this.firstName = this.firstName.substring(0, 1).toUpperCase() 
          + this.firstName.substring(1);
        this.lastName = this.lastName.substring(0, 1).toUpperCase() 
          + this.lastName.substring(1);
    }

    // Standard getters and setters
}

```



