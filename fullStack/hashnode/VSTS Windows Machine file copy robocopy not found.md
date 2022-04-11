# # VSTS Windows Machine file copy robocopy not found

### Problem
- Suddenly copy task is failing in our build tasks azure devops 


### Background
- We are using on prem azure devops instance and our build agent is on prem private build agent

### Error 
```
  
The term 'robocopy' is not recognized as the name of a cmdlet, function, script file, or operable program. Check the spelling of the name, or if a path was included, verify that the path is correct and try again.
```

### Fix 

Added the C:\Windows\System32 folder back into PATH system environment Variables (and putting it on top) fixed it for us.