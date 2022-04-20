# Find Duplicate characters in a string

``` 

Count of each character in the string 


**Algorithm:** Let input string be “geeksforgeeks”   
**1:** Construct character count array from the input string.  
count[‘e’] = 4   
count[‘g’] = 2   
count[‘k’] = 2

```


## Solution 1
- use hashmap where key will be the characters and value will be the count of the characters int he hashmap and then print the hashmap
```java
  

        String str="geeksforgeeks";

        Map<Character,Integer> map=new HashMap<>();

  

        for (int i = 0; i < str.length(); i++) {

  

            char c=str.charAt(i);

  

            if (map.containsKey(c)) {

                int counter=map.get(c);

                map.put(c, ++counter);

                counter=0;

            }

            else{

                map.put(c, 1);

            }

        }

  
  
  

            map.forEach((k,v) -> {

                if (v>=2) {

                    System.out.println(k+" "+v);

                }

            });
```