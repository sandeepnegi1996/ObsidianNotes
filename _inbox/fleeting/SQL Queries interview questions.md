# SQL Queries interview questions
#sql 

#database/sql

#interview 
[[JAVA-interviews]]

### References

Begginner Level : https://artoftesting.com/sql-queries-for-interview


![[screenshot_15.png]]


7. SQL query to fetch all those employees who work on Project other than P1

```sql
select EmpId from EmployeeSalary where NOT Project ='P1';
```

6. Write an SQL query to fetch those employees who live in Toronto and work under manager with ManagerId – 321.


```SQL
select empId from EmployeeDetails where CITY='TORONTO' AND ManagerId='321';

```


5.  Write an SQL query to find the employee id whose salary lies in the range of 9000 and 15000.

```sql

select empId from EmployeeSalary where salary>=9000 AND Salary <=15000 ;
```


4.**Write an SQL query to find the maximum, minimum, and average salary of the employees.**

```sql

select MAX(salary),AVG(salary),MIN(salary) from EmployeeSalary
```

3. Write an SQL query to fetch the count of employees working in project ‘P1’.

```sql

SELECT COUNT(empId) FROM EmployeeSalary where Project='P1';
```

5. Write an SQL query to fetch the different projects available from the EmployeeSalary table

```sql

select DISTINCT(Project) from EmployeeSalary;
```

1. Ques.1. Write an SQL query to fetch the EmpId and FullName of all the employees working under Manager with id – ‘986’.

```sql
select EmpId,FullName from EmployeeDetails where ManagerId='986'
```


