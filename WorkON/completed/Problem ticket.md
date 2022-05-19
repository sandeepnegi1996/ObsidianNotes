# Application Name issue 

 
 Main User : DAG4FE
 
 Substitute user : LAT2RNG
 
 application name : DSGA 
 
PS General Approval Form
 
 EMEA P1

Description: User wants to set Lang Thomas (PS-DI/EFC-EM2) [LAT2RNG] as his substitute on project specific:        


#### Actual Name in the Project List
General Approval Form for PS (DSGA)

#### Problem Ticket
- Find the name of application in WorkON Dashboard and match the name with the user profile page



## Examples of Applications

1. List of application whose name is different 
	1. DSGA, GP ,RBMEHRARBEIT -->
		1.    RBAU PRS Gatepass Form  --> *GP*
		2. * PS General Approval  *DSGA*
		3. RBMEHRARBEIT --> *Mehrarbeitsantrag / Extra Work / Túlóra elrendelo (RBMEHRARBEIT)*
2. Invite Prabah and Harini about the issue
3. Analayse 
	1. Pros and Cons of Solutions
4. Discuss with Tech lead 
	1. Discussion about Problem and Solution
5. Discuss with Ashok 
	1. Discussion about Problem and Solution


- ProjectList --> workon 
- sync from dashboard to workon for the project list is working or not,


Not changing in the Dashboard is the correct approac


Please ask the user to search for the above mentioned request.

This is the application name for the China Property Gate Pass Application


## Action Points
- Test in Q with changing the project name in Shared Db  (R: Harini)
- Prabah opinion is required, how the sync works (R: Prabah)


## MoM
- Project list in user profile must be coming from shared db or individual db , we can change the value of the project there an test whether it is reflecting in the user profile or not. ( Harini)
- Future Modification : to project name should be either synced automatically from the dashboard to workon or manually we need to update , ( Prabah point of view required)



### Try harini approach
1.  modify in db and check it is reflecting in user profile or not 
2. original PNAME='PRS Gatepass Form'


modified SHARED_PROJECT in Shared Db no change in project list 
modified pPROJECT folder in AP Q1 no change in prpject list 
```
select * from SHARED_PROJECT where PKEY='GP';


update  SHARED_PROJECT
Set PNAME='RBAU PRS Gatepass Form'
where PKEY='GP';



update PROJECT
set PNAME='RBAU PRS Gatepass Form'
where PKEY='GP';

```
3. 