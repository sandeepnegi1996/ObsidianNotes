# 📑 how to wrap content in the td for a table

- **🏷️Tags** : #17-05-2022,  #pending #completed #permanent

#### 🔗 Links
[stackoverflow](https://stackoverflow.com/questions/6666532/how-to-force-table-cell-td-content-to-wrap)

## Problem
1. content in the table , is much so because of that the table is becoming wide and there is a scrollbar at the bottom

## Solution
1. we have to wrap the content of the td


```CSS


 td {

    /* css-3 */
    white-space: -o-pre-wrap; 
    word-wrap: break-word;       /* only this one change works for me  */
    white-space: pre-wrap; 
    white-space: -moz-pre-wrap; 
    white-space: -pre-wrap; 

}


```


2. modify the table layout 

```CSS
table { 
  table-layout: fixed;
  width: 100%;
}

```




In my case 

table.blank td, in the workon.css file 


add the css for the td


2. table.blank td, in workon .css add teh css mentioned above 

