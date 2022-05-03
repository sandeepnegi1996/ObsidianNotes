# 📑 what is spring profile

- **🏷️Tags** : #25-04-2022, #review, #reading_list

## 🔗 Links
[baeldung](https://www.baeldung.com/spring-profiles)

## Overview
1. core feature, it allows us to map our beans to different profiles for example, dec,test and prod


## @Profile
1. `@Profile` is used to map the bean to particular profile
2. Ex: in the below mentioned code the bean is mapped to `dev` profile, so it will be only present in the spring container during developement, in production it won't be active
```java
@Component
@Profile("dev")
public class DevSourceConfi{

}

```


## Set Profile
1. activate and set the profile, so that the respective beans are registered in the conatiner.


### Programatically via WebApplicationInitializer Interface

### JVM System Parameter
```
-Dspring.profiles.active=dev

```

### Using Maven
1. In the pom.xml we can set the profile and it will be pushed to the application.propertie

```XML
<profiles>
	<profile>
		<id>dev</id> 
			<activation> 
			<activeByDefault>true</activeByDefault>
			</activation> 
		<properties> 
			<spring.profiles.active>dev</spring.profiles.active> 
		</properties>
		</profile> 
		<profile> 
			<id>prod</id>
			<properties> 
			<spring.profiles.active>prod</spring.profiles.active> 
		</properties> 
	</profile>
</profiles>

```


##  Real Example
- Separate Data Source Configuration using Profiles
- datasoruce configuration for dev and prod

```java
public interface DatasourceConfig
{ public void setup(); 
 }

```


```java
@Component
@Profile("dev")
public class DevDatasourceConfig implements DatasourceConfig
	{ 
	@Override
	public void setup()
		{
		 System.out.println("Setting up datasource for DEV environment. "); 
		}
}

```


```java

@Component @Profile("production")
public class ProductionDatasourceConfig implements DatasourceConfig 
	{
	@Override 
	public void setup()
		{ 
		System.out.println("Setting up datasource for PRODUCTION environment. "); 
		} 
	}

```