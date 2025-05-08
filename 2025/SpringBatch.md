# 📑 SpringBatch

- **🏷️Tags** : #05-05-2025,  #pending #completed #permanent

#### 🔗 Links


## Key Takeaways


#### Goal
1. Build a simple spring batch project
2. Understand how it can be implemented with GeoCoding 
	1. Take a list of Adress in a csv and then call geoMaps API , get the response and write the response 




## Overview 
1. processing framework designed for execution of jobs 
2. use if spring batch -> http://docs.spring.io/spring-batch/reference/htmlsingle/#springBatchUsageScenarios

### workflow basics
1. batch architecture 
	1. job repository -> schedule and interacts with jobs 
	2. job -> reading , processing , writing. 
	3. job repository internally uses h2 
### Usecase -> Migrate financial transaction data from csv to xml 
1. input file 
```csv
username, userid, transaction_date, transaction_amount
devendra, 1234, 31/10/2015, 10000
john, 2134, 3/12/2015, 12321
robin, 2134, 2/02/2015, 23411

```


Dependecies -> [Spring Batch Core](https://mvnrepository.com/artifact/org.springframework.batch/spring-batch-core), [Spring Object/XML Marshalling (OXM)](https://mvnrepository.com/artifact/org.springframework/spring-oxm), and [_H2_](https://mvnrepository.com/artifact/com.h2database/h2) database:


### Auto Create Schema 
1. SQL initialization Script -> created schema on startup
2. When we use H2 -> automatically the sql will run and create the schema for us 


`spring.batch.jdbc.initialize-schema=always`

Disable auto creation `spring.batch.jdbc.initialize-schema=never`

#### Implementation

##### Read Data and Create Objects with ItermReader  -> READING 
- read from the csv and convert to Transaction Object 

```java
@SuppressWarnings("restriction")
@XmlRootElement(name = "transactionRecord")
public class Transaction {
    private String username;
    private int userId;
    private LocalDateTime transactionDate;
    private double amount;

    /* getters and setters for the attributes */

    @Override
    public String toString() {
        return "Transaction [username=" + username + ", userId=" + userId
          + ", transactionDate=" + transactionDate + ", amount=" + amount
          + "]";
    }
}
```

Custom Mapper 
```java 
public class RecordFieldSetMapper implements FieldSetMapper<Transaction> {
 
    public Transaction mapFieldSet(FieldSet fieldSet) throws BindException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyy");
        Transaction transaction = new Transaction();
 
        transaction.setUsername(fieldSet.readString("username"));
        transaction.setUserId(fieldSet.readInt(1));
        transaction.setAmount(fieldSet.readDouble(3));
        String dateString = fieldSet.readString(2);
        transaction.setTransactionDate(LocalDate.parse(dateString, formatter).atStartOfDay());
        return transaction;
    }
}
```


##### Processing
it does nothing 
```java
public class CustomItemProcessor implements ItemProcessor<Transaction, Transaction> {

    public Transaction process(Transaction item) {
        return item;
    }
}
```

##### Writer
```xml
<bean id="itemWriter" class="org.springframework.batch.item.xml.StaxEventItemWriter">
    <property name="resource" value="file:xml/output.xml" />
    <property name="marshaller" ref="marshaller" />
    <property name="rootTagName" value="transactionRecord" />
</bean>
```

### Learn from this 
- [ ] https://github.com/ali-bouali/spring-batch-demo

