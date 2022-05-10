# 📑 how to use weblogic server for  springboot application

- **🏷️Tags** : #08-05-2022,  #pending #completed #permanent

#### 🔗 Links
[web-logic](https://o7planning.org/11901/deploy-spring-boot-application-on-oracle-weblogic-server)


## Key Takeaways

## Overview
- here we will learn to deploy sprinboot application on a weblogic server. 
- weblogic : server provided by oracle and this can be used for developing , testing ad prototying your application
- It is under OTN License it is free of cost.


### TIP
1. spring boot application can be packaged as a JAR and can be run independency without the need of any of the web server, this jar is not compatible with other webserver so for this, we need to create a WAR to deploy it on a web server/


## How to deploy war on a webserver weblogic
1. when we *package using war two java files* will be created, `ServletInitializer.java` and `SpringBootMainClass.java`
2. when *we package using JAR onle one java file* is created which is main java file
3. if in case you have existing project, 
	1. change the packaging in the pom.xml and then create a `ServletInitializer.java` class file.
```java
package org.o7planning.example;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootWebLogicApplication.class);
    }

}

```
4. create two more files ., under src/main/webapp/WEB-INF
	1. `weblogic.xml `
	2. `dispatcherServlet-servlet.xml`

5. We can create the WAR using mvn install
6. from the target folder take the war and then deploy it to our weblogic server