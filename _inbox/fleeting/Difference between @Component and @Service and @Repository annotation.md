# 📑 Difference between @Component and @Service annotation

- **🏷️Tags** : #25-04-2022, #review, #reading_list

## 🔗 Links


## Overview
1. In typical spring application we have , data access layer, service layer and web layer (Controller) all of these layers will have some classes
2. Spring uses `classpath scanning annotations` to scan all the beans
3. Then it registers each bean in the `ApplicationContext`



## Difference 
1. `@Component` is used to mark the beans as the `spring managed component`
2. `@Service` and `@Repository` works similar to `@Component` but they are applied to different beans.
3. `@Service` is applied on beans that store business logic
4. `@Repository` job is to catch persistence -specific exceptions and re-throw them as one of the Spring's unified unchecked exceptions.

