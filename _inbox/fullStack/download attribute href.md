##  Problem Statement
- I am not able to download the attachments from the link and the link is added in the href , 

## Root Cause
- This is due to [[same origin policy,]] if anyone is able to download any file from any origin this is security issue so to avoid that by default we are not able to download the files from the different domain,

### Solution 
- Using anchor tag and download option , we cannot download from the differnt domain

##### Solution : 1
Create blob and then provide the download option


https://dev.to/pencillr/an-ode-to-cross-origin-image-downloads-26o2

- 
https://stackoverflow.com/questions/49474775/chrome-65-blocks-cross-origin-a-download-client-side-workaround-to-force-down?answertab=votes#tab-top


##### Solution :  2
send the below mentioned as the response header
```
Access-Control-Allow-Origin: *

Content-Disposition : attachment; filename=image.gif```
```


- Access Control Allow Origin : this is a response header and this will be set by the backend server from where we are trying to download the files

-  Content-Disposition : attachment : this header needs to be send by the backend server 


```
content-disposition: attachment
```




```
```
<a href="/samanthaming.png" download>
  Download with original filename -> samanthaming.png
</a>

<a href="/samanthaming.png" download="logo">
  Download with custom filename -> logo.png
</a>
```
```



## Enforcing file download - Content-Disposition
- if we want that client should not open the resource and it should be directly downloaded. we can add this header from the server side 
- 
```
Content-Disposition : attachment; filename=image.gif```
```



## download Attribute
- This is added in html5 in the anchor tag so that the browser is downloading the resource instead of navigating to that URL.

- This only works with same-origin policy. it cannot be used to download resource served from a different origin.


TODO:  [[blob]]









