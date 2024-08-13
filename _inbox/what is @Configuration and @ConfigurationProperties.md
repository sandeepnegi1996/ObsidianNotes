[[spring boot interview questions]]



## @Configuration
- @Configuration can be used to create beans which will be used by the application context or we can say spring container.
- class level annotaition
- if we are not using this we need to create xml for the bean definition

Example

```java
@Configuration
public class EsgConfig{

@Bean
@ConfigurationProperties("spring.rsg.datasource")
public DataSourceProperties esgXdiDataSourceProperties() {
		return new DataSourceProperties();
	}
}
```


- @Configuration -> means this class will have bean definition
- @Bean will be used on a method to define a bean , if we are not giving any name then method name will be bean id 
- @ConfigurationProperties -> this will be used to inject hierarchies properties -> from .properties file
- Ex : spring.esg.data.source.schema=esg+db
- spring.esg.datasource.usernmae=username
- spring.esg.datasouce.password = passowrd
- thats how we will inject the nested properties 


