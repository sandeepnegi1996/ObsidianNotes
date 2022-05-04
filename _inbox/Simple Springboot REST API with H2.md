# 📑 Simple Springboot REST API with H2

- **🏷️Tags** : #27-04-2022, #review, #reading_list
[[spring boot interview questions]]

#### 🔗 Links
[baeldung](https://www.baeldung.com/spring-boot-h2-database)

## Key Takeaways

## Overview
1. simple rest api with spring boot-jpa and h2

## Project Overview
1. get the dependecy for `spring-boot-starter-data-jpa`
2. `h2`
3. `spring-boot-starter-web`

```xml

	<dependencies>
	
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>


	</dependencies>

```


4. By default spring will connect to in memory database, with username : sa and password : empty but we can override these settings.
- by making changes in the application.properties

```properties

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect


```


5. By default `h2` is in memory and what happens it will not store anything once restarted, so the persist the data we need to make changes in the datasource url

```properties


spring.datasource.url=jdbc:h2:file:./data/demo1
#spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

```


### Data source initiazliaton
1. once the h2 is up and running/
2. we want some dummpy informatin in that so for that what we can do , we will basically create sql file in resources with some insert queries.

`data.sql`
```SQL

INSERT INTO countries (id, name) VALUES (1, 'USA');
INSERT INTO countries (id, name) VALUES (2, 'France');
INSERT INTO countries (id, name) VALUES (3, 'Brazil');
INSERT INTO countries (id, name) VALUES (4, 'Italy');
INSERT INTO countries (id, name) VALUES (5, 'Canada');
```

3. since we are recreating schema everytime so we need to make sure , we need one more property

```properties

spring.jpa.defer-datasource-initialization=true


```

### Accessing h2 console.
- by default h2 is not enabled so we need to enable h2
- 
```properties

spring.h2.console.enabled=true

```

- `localhost:8080/h2-console`
- use the name datasource as `jdbc:h2:file:./data/demo1`
- since now the relative path is not allowed


### First endpoint 
```java

@RestController
@RequestMapping("/movie")
public class MovieController {

	@GetMapping("/getMovie")
	public String getMovieInfo() {
		return "this is random string";
	}
	
}


```

1. once this is working we will start by writing some more code , for the post mapping


### Post Controller
1.  if this is is not working ,
2. `spring.jpa.hibernate.ddl-auto=create-drop`

Model
```java
@Entity
public class Movie {

	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

```

1. 
```java

@PostMapping("/createmovie")
	public ResponseEntity<String> createMovie(@RequestBody Movie m) {
				
		Movie m1=new Movie();
		m1.setId(m.getId());
		
		m1.setMovieName(m.getMovieName());
		
		movierepository.save(m1);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

```