# 📑 What are the annotations used in Spring Data JPA

- **🏷️Tags** : #10-05-2022,  #pending #completed #permanent

#### 🔗 Links


## Key Takeaways

## Overview 
- @Repository
- @NoRepositoryBean
- @Transactional
- @Id
- @Transient
- @CreatedBy
- @LastModifiedBy
- @CreatedDate
- @Query
- @Procedure
- @Lock
- @Entity
- @Table
- @EnableJPARepositories
@Modifying
@Param



### Code Sample
```
@Entity
@Table (name="merchant_service_type", catalog="verifi", schema = "" , uniqueConstraints =    

{
	@UniqueConstraint( columnName = {"label"}),
	@UniqueConstraint( columnName = {"label"}) } ) 


@NamedQuery ( {

		@NamedQuery ( name="MerchantServiceType.findAll" , query = "SELECT m FROM MerchantServiceType m" ),
	
				@NamedQuery ( name="MerchantServiceType.findByMerchantServicetypeKey" , query = "SELECT m FROM MerchantServiceType m where m.merchantServiceTypeKry = :merchantServiceTypeKey" )

	}

	)


```

@Serializable 

```


@Id
@Basic ( optional = false )
@Column ( name = "merchant_service_type_key", nullable = false )

```





