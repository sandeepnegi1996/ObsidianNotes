# 📑 workon -layout issue - pending

- **🏷️Tags** : #25-04-2022, #review, #reading_list

## 🔗 Links
[Bug 27360](https://fe0vmc1007.de.bosch.com/tfs/Workflow/WorkON_Core/_workitems/edit/27360): PBI000000265617 - Dynamic grid layout issue)

###  Background
1. PBI000000265617 : no information available in the problem ticket
2. https://rb-wam-q.bosch.com/workon01/workflow01q/browse/DCRPMPPUC-2811 --> request does not exist
3. Check with this request : https://rb-wam-q.bosch.com/workon01/workflow01q/browse/DCRPMPPUC-232




###  Solution
1. Solution made in Quality : https://rb-wam-q.bosch.com/workon01/workflow01q/browse/DCRPMPPUC-232
2. check with customer if the changes are fine with them
3. Customer Reply : it is not working 
4. Cause : it is not working for big screens size
```
Tobias.Mueller13@boschrexroth.de   

Orsolya.Remenyfi-Roesser@boschrexroth.de 

```


### Big Screensize issue 
```CSS

/* Large devices (laptops/desktops, 992px and up) */
@media only screen and (min-width: 1072) {
  .example {background: orange;}
} 

/* Extra large devices (large laptops and desktops, 1200px and up) */
@media only screen and (min-width: 1200px) {
  .example {background: pink;}
}

```

- in our case we wants to change the layout when the minimum width is `1073`

```CSS
@media only screen and (min-width: 1073px) {
.x-panel {

width: calc(100vw) !important;
}
```

1. changed the width of x-panel to this 
```
width: calc(

100vw

) !important;

```


2 