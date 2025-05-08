

Backlinks 
[[spring boot interview questions]] -->  [[001_interviews MOC]]

[Factory Design Pattern using Spring Boot | by Vipul Kumar | Medium](https://vipulkumarsviit.medium.com/factory-design-pattern-using-spring-boot-a8c812f22baa)
simplest tutorial ever on factory design pattern : [Factory Design Pattern | Java Development Journal (javadevjournal.com)](https://www.javadevjournal.com/java-design-patterns/factory-design-pattern/)



repository : [sandeepnegi1996/design-patterns: Demonstarting how to implement Factoty Design Pattern in Spring Boot (github.com)](https://github.com/sandeepnegi1996/design-patterns)



- design patterns is basically a solution for common software design problems
- Factory design pattern comes under Creational Design Patterns

- FDP : provides interface for creating objects but allows subclasses to alter the type of objects 


#### usecase
1. Example let say we have paypal and payU as two payment provider
2. so we want to use a payment provider based on client needs 
3. how we will do this without design pattern ?

1. Create `PaymentProviderFactory` to create payment different type of payment providers based on client need.
2. Accept Payment(a dummy implementation) using the payment provider created in the 1st step.
3. Decouple `PaymentProvider` creation logic from normal business logic.


### Implementation
1. initial springboot setup
2. Create Payment Provider -> interface for all the different payment provider lets say in future we are going to use some other payment provider
3. acceptPayment -> is the only method in this 

```java
package com.vksviit.patterns.factorydesignpattern;  
  
  
public interface PaymentProvider {  
public void acceptPayment();  
}
```

4. creating class to implement payment Provider StripePaymentProvider

```java
package com.vksviit.patterns.factorydesignpattern;  
  
import lombok.extern.slf4j.Slf4j;  
import org.springframework.stereotype.Service;  
  
@Service(StripePaymentProvider.BEAN_ID)  
@Slf4j  
public class StripePaymentProvider implements PaymentProvider {  
public static final String BEAN_ID = "stripePaymentProvider";  
  
@Override  
public void acceptPayment() {  
log.info("Accepting payment using Stripe");  
}  
}
```


5. paypal payment provider 

```java
package com.vksviit.patterns.factorydesignpattern;  
  
import lombok.extern.slf4j.Slf4j;  
import org.springframework.stereotype.Service;  
  
@Service(PayPalPaymentProvider.BEAN_ID)  
@Slf4j  
public class PayPalPaymentProvider implements PaymentProvider {  
public static final String BEAN_ID = "payPalPaymentProvider";  
  
@Override  
public void acceptPayment() {  
log.info("Accepting payment using PayPal");  
}  
}
```

6. Implementing a factory in springboot
```java
@Service  
@RequiredArgsConstructor  
public class PaymentProviderFactory {  
private final Map<String, PaymentProvider> paymentProviderMap;  
  
public PaymentProvider getPaymentProvider(String paymentProviderType) {  
return paymentProviderMap.get(paymentProviderType);  
}  
}
```


7. main class 
```java
package com.vksviit.patterns.factorydesignpattern;  
  
import lombok.extern.slf4j.Slf4j;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.boot.CommandLineRunner;  
import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;  
  
@Slf4j  
@SpringBootApplication  
public class FactoryDesignPatternApplication implements CommandLineRunner {  
  
@Autowired  
PaymentProviderFactory paymentProviderFactory;  
  
public static void main(String[] args) {  
SpringApplication.run(FactoryDesignPatternApplication.class, args);  
}  
  
@Override  
public void run(String... args) throws Exception {  
log.info("Hello spring boot");  
  
// Provides StripePaymentProvider instance usage the same to accept payment  
paymentProviderFactory.getPaymentProvider(StripePaymentProvider.BEAN_ID).acceptPayment();  
  
// Provides PayPalPaymentProvider instance usage the same to accept payment  
paymentProviderFactory.getPaymentProvider(PayPalPaymentProvider.BEAN_ID).acceptPayment();  
  
// Provides PayUPaymentProvider instance usage the same to accept payment  
paymentProviderFactory.getPaymentProvider(PayUPaymentProvider.BEAN_ID).acceptPayment();  
  
}  
}
```



### ActiveMqService Examples 

[Factory design pattern with spring boot (github.com)](https://gist.github.com/malathit/a480c2002388e64d5d51720f457ccee7)

1. how to create class diagram in intellj ?
2. when to use factory design pattern ? 
3. 



