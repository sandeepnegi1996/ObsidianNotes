# 📑 how garbage collector works in java

- **🏷️Tags** : #03-05-2025,  #pending #completed #permanent

#### 🔗 Links

- [ ] [[how string constant pool works under the hood]]
 - [ ] [[Types of Memory in java]]
## Key Takeaways

## Overview

### **How Object is garbage collected in java 8   ?  ** 
1. Garbage collection is handled by jvm it is process of reclaiming the memory by removing the objects that are no longer reachable.
2. we cannot force the garbage collection since it is managed by JVM however, we can make our object eligible for garbage collection by ensuring that object is no longer reacable 

### **How to make the object eligible for garbage collection ? **
1. Set the object reference to nukk
2. Reassign the reference variable 
- in both the above cases the object is not reachable and hence it is eligible for garbage collection. 
1. Object Inside Method local scope 
2. `System.gc` only requests the JVM to perform garbage collection , it doesn't guarantee immediate execution. 
3. Tools such as `VisualVM` can be used to monitor and debug the memory issues in our application.



### **Command to Run the Spring Boot JAR with Heap Size Settings**
To set the heap size while running a Spring Boot JAR, you can use the `-Xms` and `-Xmx` JVM options to specify the initial and maximum heap size, respectively.

`java -Xms512m -Xmx1024m -jar student-services.jar`

### **Alternative: Setting Heap Size in `application.properties`**

You can also configure JVM options in the `application.properties` file by using the `JAVA_OPTS` environment variable:

`JAVA_OPTS=-Xms512m -Xmx1024m`

`java $JAVA_OPTS -jar student-services.jar`


### Related Topics 
- [ ] [[Types of Memory in java]]


