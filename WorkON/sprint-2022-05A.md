# 📑 sprint-2022-05A

- **🏷️Tags** : #06-05-2022,  #pending

#### 🔗 Links


### PBI000000265726 - SUBSTITUTE - Substitute rule not removing from user's I act for tab
#### Final Solution for the client is 
1. 
#### Investigation
1. there is no much information in the problem ticket 
2. So we will start checking incident ticket

Incident Ticket : INC000021843663

#### Find all the bugs in the WorkON Profile 

###### Sync Issue of Substitute tab
1. Once user is added in the substitute tab, it should immediately come to to the iact for tab of the substitute user --> *working*
2. Once user is enabled from the substitute tab it should be immediately enabled in iact for tab of substitute user --> *working*
3. Once user is disabled from the substitute tab it should be immediately enabled in iact for tab of substitute user --> *working*
4. duration changed in the main user substitute tab it should reflect in iact for tab --> *working*
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


