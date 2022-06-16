# 📑 Vert.x core Examples

- **🏷️Tags** : #31-05-2022,  #pending #completed #permanent

#### 🔗 Links


## Key Takeaways

## Overview
- Vert.x Core : 


### Vert.x Simple HTTP Server
- below mentioned is the simplest http server that will basically return the same html on each hit 
- it is running on port number 9090
- and it can be hit from the browser

```java
@Override  
public void start() throws Exception {  
  
    vertx.createHttpServer().requestHandler(  
            req -> {  
                req.response().putHeader("content-type", "text/html")  
                        .end(" <html>  <body> <h1 style=\"color:red;\" > From the server </h1>  </body>  </html>  ");  
            }  
    ).listen(9090);  
  
}

```


### Vert.x simple Http Client Code 

```java
@Override  
public void start() throws Exception {  
    HttpClient client= vertx.createHttpClient();  
    client.request(HttpMethod.GET ,9090 ,"localhost", "/" )  
            .compose(req  ->req.send()  
            .compose(resp -> {  
                System.out.println("Received response from server " + resp.statusCode());  
                System.out.println("Received response from Server message " + resp.statusMessage());  
                return resp.body();  
            }))  
            .onSuccess( body -> {  
                System.out.println("Got data "+body.toString("ISO-8859-1"));  
                    }  
            )  
            .onFailure(Throwable::printStackTrace);  
  }

```



