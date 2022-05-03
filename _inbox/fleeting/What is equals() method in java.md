# 📑 What is equals() method in java

- **🏷️Tags** : #03-05-2022, #review, #java 

#### 🔗 Links


## Key Takeaways

## Overview
- every class is a child class of the object class and it has the `equals` method 
- this method is used to compare the two objects.
- 

```java
 @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Simpson simpson = (Simpson) o;
            return age == simpson.age &&
                    weight == simpson.weight &&
                    name.equals(simpson.name);
        }
    }
```

1.  first we are comparing current object , with the object that is being passed, if both of them are equal then it returns true
2. second we check object is null or object is of different class if that is the case we return fasle
3. then we write out logic to comapre the objects, if we wanted to comapre with which fields of that particular class.
4. 
