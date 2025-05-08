# 📑 introduction to docker

- **🏷️Tags** : #06-05-2025,  #pending #completed #permanent

#### 🔗 Links


## Key Takeaways

## Overview

### Create a nginx docker container and mount a index.html 


```code
docker run -d -p 8080:80 --name nginx-container -v /D:/code/workspace-practice/webapp/app:/usr/share/nginx/html nginx
```

### Ubuntu container in interactive mode 
```
docker run -it --name ubuntu-container ubuntu bash
```


### Database container -> mysql 
```
docker run -d -p 3306:3306 --name mysql-container -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=testdb mysql
```

- **What it does**: Runs a MySQL database with:
    - Root password: `root`
    - Database: `testdb`
    - User : `root`
- **Access**: Use a MySQL client to connect to `localhost:3306`.

able to run the database on container and run a query against it 

![[Pasted image 20250506114832.png]]


#### Hibernate with sprinboot 
```yml
spring:
  datasource:
    url: jdbc:h2:mem:testdb
    driver-class-name: org.h2.Driver
    username: sa
    password: 
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
    database-platform: org.hibernate.dialect.H2Dialect
  batch:
    jdbc:
      initialize-schema: ALWAYS
    job:
      enabled: false

  h2:
    console:
      enabled: true
      path: /h2-console
server:
  port: 9090

```


1. Start your Spring Boot application.
2. Open your browser and navigate to: `http://localhost:9090/h2-console`.
3. Use the following credentials:
   - **JDBC URL**: `jdbc:h2:mem:testdb`
   - **Username**: `sa`
   - **Password**: (leave blank).



#### Post endpoint 
1. `http://localhost:9090/students`
2. 