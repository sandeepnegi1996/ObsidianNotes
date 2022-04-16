# How to patch fix inside WAR

### Problem
- urgent patch fix we need to make the UI changes in the application so for that we have made changes in the CSS and we cannot deploy those so for that we will do patch fix.

### Backgroung
- java enterprise application monolithic and it deployed as WAR in the tomcat server , on prem linux server 

### Solution
- Login to server
- Copy the modified files
- open the WAR
- check the styles files : taking backup of original style files
	- mv currentfile currentfile.currentdate

- Paste your style files in the same location !!voila
- no need to restart the application server


### How to test ?
- Clear browser cache and then see the magic :) 

