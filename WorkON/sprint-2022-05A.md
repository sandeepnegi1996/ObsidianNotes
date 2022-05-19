# 📑 sprint-2022-05A

- **🏷️Tags** : #06-05-2022,  #pending

#### 🔗 Links

## Daily Work : 17/May
- [ ]  Access to MD in workflow04 in Q : pham
- [ ] layout issue in RBMANUSHIP --> change history tab
- [ ] 


#### RBMANUSHIP layout issue 
1. when change history tab is accesed layout is getting wide 

how to handle click event 
-   Hit F12 to open Dev Tools
-   Click the Sources tab
-   On right-hand side, scroll down to "Event Listener Breakpoints", and expand tree
-   Click on the events you want to listen for.
-   Interact with the target element, if they fire you will get a break point in the debugger

Similarly, you can right click on the target element -> select "inspect element" Scroll down on the right side of the dev frame, at the bottom is 'event listeners'. Expand the tree to see what events are attached to the element. Not sure if this works for events that are handled through bubbling (I'm guessing not)

[[how to wrap content in the td for a table]]



#### pham MD Access
[https://rb-wam-q.bosch.com/WorkOnDashBoard/search/search.seam?keyFilter=RBKVR&pbbs=0&bu=0&pno=1#](https://rb-wam-q.bosch.com/WorkOnDashBoard/search/search.seam?keyFilter=RBKVR&pbbs=0&bu=0&pno=1)





## Daily Work : 16/May
- [ ] INC000022154037   --> check the incident 
- [x] INC000022189153 : remove user `thj1bgk` from the group ; `bgk_ea_pir-th`  --> alhad
- [x] INC000022174907   :    --> completed by alhad
- [x] INC000022161841    :  --> completed by alhad
- [ ] check the code review items and prepare the build
- [x] RE: personal substition list for  Mehrarbeitsantrag / Extra Work  Plant Leinfelden : Important and urgent  --> name issue [[Problem ticket]] 
- [ ] KT Session  --> incident management
- [x] Disciplinary manager details are not correct



#### Disciplinary manager details
Nguyen Huu Tri (SX/BSV43-EA): 
the employee that needs to check is: ISA5BU

1. emp id : `isa5bu` or `ISA5BU`
2. main user : `ISA5BU`   --> change the target manager or disciplinary manager to user 
current : `UCD1YO`
New : `BIC3BU`


#### INC000022189153
- remove user `thj1bgk` from the group ; `bgk_ea_pir-th`
- 

#### code review and build prep --> pending
1. - [ ] [Bug 27417](https://fe0vmc1007.de.bosch.com/tfs/Workflow/WorkON_Core/_workitems/edit/27417): Concession workflows missing records while sending to SAP in workflows and Retrigger attachment groovy script --> review the pull request with manju and lokesh
- [ ] review two item with manju which are assigned to me 

#### RE: personal substition list for  Mehrarbeitsantrag / Extra Work  Plant Leinfelden
- Problem : user not able to search : `RBMEHRARBEIT` in the workojn profile list 

```
Mehrarbeitsantrag / Extra Work / Túlóra elrendelo (RBMEHRARBEIT)

```


## Daily work : 13/May
Bug 27359: PBI000000265726 --> manju informed discuss this wilth lokesh
- follow up for code review  --> follow up this with lokesh
- [x] INC000022154037 : important 
- [x] INC000022180211 : user did not received emails
- [ ] check the code review items and prepare the build
- [ ] RE: personal substition list for  Mehrarbeitsantrag / Extra Work  Plant Leinfelden : Important and urgent  --> 
-




#### INC000022154037  --> convert this to Problem ticket and Create PBI and other things on this 

final --> reroute to some other team since there is no issue from workon side 

1. user able to see the request in uib but did not received an email for the same
2. user details : ial1szh [Tao.Li2@bcn.bosch.com]
3. Request :  [CNOTLEAVE-7697028](https://rb-wam-ap.bosch.com/workon02ap/browse/CNOTLEAVE-7697028)
	1. workItemDescription":"OT Batch Request
2. from the splunk logs of the Mail API Request, we can see that the emails are triggered 
3. so from workon --> we are sending request to the mail api and then in the mail api we are not tracking whether the email is send or not , so that is an issue right since how we will get to know the email are triggered or not 

4. As of now we can login to the server and check the logs wether the request is succeed or not based on the timestamp
5. splunk logs from workon :

```
CNOTLEAVE-7697028 "Tao.Li2@bcn.bosch.com" "Mail"

```

- time stamp : 2022-05-12 09:42:45,261

- from the workon side : 200 Success
- event : source

```

2022-05-12 09:42:45,329 INFO [com.bosch.mail.service.impl.GenericMailerServiceImpl] GenericMailerServiceImpl :: sendMail() -> Message has been sent..

```
6. splunk logs for email service :

```

index=workon-microservice sourcetype="microservice-debug-log"


```


- as of now reuest is send from email service 
- 361a9174-2688-4e45-9be3-c84cfb36be80
for more logs

![[Pasted image 20220513112223.png]]

```
2022-05-12 09:42:45,261 JiraQuartzScheduler_Worker-1 INFO [logger.workon.interface.MAIL_MANAGER] Mail API Request :{"request":[{"requestId":"361a9174-2688-4e45-9be3-c84cfb36be80","preName":"LI","lastName":"Tao","workItemStatus":"Pending Manager Approval 等待经理批准","workItemDescription":"OT Batch Request 批量加班申请","processName":"Leave&Overtime Forms","workItemID":"CNOTLEAVE-7697028","systemName":"WorkON","language":"en","startedBy":"MST_Operation_0001 BOT_Manufacturing (AE/MST-CN)","to":["Tao.Li2@bcn.bosch.com"],"cc":null,"templateName":null,"optionals":null,"directActions":null,"systemActions":[{"systemName":"WorkON<br><small><small>(Desktop only)</small></small>","systemLink":"https://rb-wam-ap.bosch.com/workon02ap/plugins/servlet/redir/browse/CNOTLEAVE?id=7697028"},{"systemName":"WorkON<br><small><small>(Bosch Managed Device)</small></small>","systemLink":"https://workon.bosch.tech/workon02ap/plugins/servlet/redir/browse/CNOTLEAVE?id=7697028"},{"systemName":"UIB","systemLink":"http://unifiedinbox.bosch.tech/GoUIB.htm?sid=P&launchMode=accessspecificWorkItem&systemId=WORKON_UIB_L&workInstanceId=CNOTLEAVE-7697028"}],"usefulLinks":null,"lastAction":null,"daysOverdue":null,"templateType":"Action","isProxy":false,"replyEmailAddress":null,"proxyOf":null,"isWorkflowCC":false,"introText":null,"contentFooter":null,"attachments":null,"senderAddress":null,"emailSubject":"OT Batch Request 批量加班申请","templateSubject":null,"infoMail":false}]}



2022-05-12 09:42:45,262 JiraQuartzScheduler_Worker-1 INFO [logger.workon.interface.MAIL_MANAGER] Mail API Response :{"200":[{"success":true,"errors":[],"requestId":"361a9174-2688-4e45-9be3-c84cfb36be80"}]}
```


###### Future Improvements
1. [x] Add logs in email service for each request, it can be subject or just workitemId
2. [x] We need integrate email service logs to splunk , for investigation , since it takes too much time to log in to the server and check the success logs from email service   --> done for production
3. Some message broker should be there from workon to email service so that we never miss a request from any of the system, and we can gurantee that the emails will be received.





#### INC000022154037 --> check with Pham

1. user confirmed : who added two cost center numbers(*257695,257169)* to the application *APCNMAE* ? User confirmed that *RBCC* doesn't have Cost Center in this workflow in 2021.Q4, but it was added two cost center in 2022.Q1.

2. 

## Daily work : 12/May
- INC000022172645 --> [https://rb-wam.bosch.com/workon01/workflow02/browse/RBGA-5631185]  --completed

- Bug 27359: PBI000000265726 --> manju informed discuss this wilth lokesh
- follow up for code review  --> follow up this with lokesh
- [ ] INC000022174907   :   
- [ ] INC000022161841    : 
- [ ] INC000022154037 : important 
- [ ] INC000022180211


## Daily work : 11/May
1. [x] add the tag for the layout fix to the current release
2. [x] follow up with manju for code review and the problem ticket
3. revise whats learn yesterday



### PBI000000265726 - SUBSTITUTE - Substitute rule not removing from user's I act for tab
#### Final Solution for the client is 

#### Investigation
1. there is no much information in the problem ticket 
2. So we will start checking incident ticket

Incident Ticket : INC000021843663

#### Find all the bugs in the WorkON Profile 

###### Sync Issue of Substitute tab
1. Once user is added in the substitute tab, it should immediately come to to the iact for tab of the substitute user --> *working*
2. Once user is enabled from the substitute tab it should be immediately enabled in iact for tab of substitute user --> *working*
3. Once user is disabled from the substitute tab it should be immediately enabled in iact for tab of substitute user --> *working*
5. permission change should be reflected --> *working*
6. deletion should be reflected --*>working*
7. once the user validity is expired from the substitute tab , it should be removed from the substittute tab and the iact for tab of the other user. --> **pending**
 
###### sync issue of Iact for tab
1. enabled in the iact for tab should , enable the user in the substitute tab --> *working*
2. iact for tab, substitute validity is finished it should be removed from the iact for tab and the substitute tab --> **pending**
3. disabling from the iact for tab: disable from the substityute tab --> *working*


###### Deactivated user : --> main issue 
Problem : One Case : main user is deactivated and the substitutes, are able to still enable and disable the substitute.

Solution : so once the user is deactivated its substitutes should be removed and its substitutes iact for entries should also be removed for the same user 

###### New functionality
1. user wants to delete someone from the iact for tab, 
	1. once deleted , user details should also be removed the other user substitute tab.


######  user reported issue
1. Main user  removed from the substitute from the substitute tab , but it still shows in other user , I act for tab
2. and when it shows in the other users I act for tab, they are able to enable and disable the substitute from their.





 

### build and merge
#### release plan for the may release 

#### PR Creation done
1. check the items in the release and the branch name of the same
2. uib item check with lokesh
3. priya one item is not completed

#### merge pending



```code

@Manjunath Rajamanickam (CI PWW4)](mailto:APAC\MRJ6COB) 

please review the pull request and approve there it self 😊

```

### workon operations
#### check tickets 
1. ticket for the substitutes : INC000022145747 -->closed
2. check the incident : INC000022109916  --> closed
3. INC000022146638 --> closed 
4. check the problem ticket 
5. closed one more opened ticket
6. check the issue with the email  : 
	1. Reprocessemailqueueitem





	#####  INC000022146638
1.   added substitutes


##### Email delay issue in workon
1. class in workon responsible for the emails are `Reprocessmailqueueitem`
2.  this call doesn't contain much information it is basically using AbstractQueueItem class 
3. what is active MQ [[what is active MQ]]
4. 
5. 



##### INC000022109916 --> closed
1. earlier user did not received the email but now the user has received the email
2. so we can now close the ticket 
3. no fuirther investigation is required
4. 
5. 


