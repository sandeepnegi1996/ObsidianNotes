# What is the use of immutable class
#pending

Immutable classes make concurrent programming easier. Immutable classes make sure that values are not changed in the middle of an operation without using synchronized blocks.

By avoiding synchronization blocks, you avoid deadlocks. And since you are always working with an unchangeable consistent state, you avoid race conditions.


https://dzone.com/articles/java-using-immutable-classes-for-concurrent-programming#:~:text=Immutable%20classes%20make%20sure%20that,state%2C%20you%20avoid%20race%20conditions.

 So you should use immutable classes when it is feasible to copy the object for every modification and you need read-only access to the data.