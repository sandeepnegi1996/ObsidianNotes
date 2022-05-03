# How to separate read and write in database for relational

-  same example of the tiny  url
-  we know that our application will be read intensive so for that we want more read and less write in that case , we want that our db should scale or we can divide the read request to one db and write to one db

- mysql : is not the best here since it does not work best with master and slave
- postgres : will be best here since it supports master and slave and we can divide read and write request to maste and slave respectively.

[[What is master and slave architecture in database]]