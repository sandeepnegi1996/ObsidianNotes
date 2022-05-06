# WorkON RBCM (Gratuities Reporting Tool)


### Problem 
- export an excel report of all RBCM requests created and closed in 2019, 2020, 2021 **including data** in archive?

### Pre-requisite
```

Applicaiton Name : Gratuities Reporting Tool (GRT)
Key : RBCM
Server: EMEA P1
```



### Database

#### WORKON
[[SQL Query with date ]]
```
jiraissue : all the requests are stored here

select * from JIRAISSUE where PKEY LIKE '%RBCM%' AND CREATED >= '01-01-2019' AND CREATED <='31-12-2021' ;

this will give the issues fro RBCM which are created from 2019 to 2021 and are there in WorkON System

```

**One Request is archived it is removed from the jiraissue table **

NOTE : *ctrl + end  --> to get all the records in a table *


#### Archive 
NOTE:  

*ACTIVE = 1
means the request are archived*  

```

select * from ISSUE where PKEY LIKE '%RBCM%' AND CREATED_AT >= '01-JAN-19' AND CREATED_AT <='31-DEC-21' AND ACTIVE=1;
```