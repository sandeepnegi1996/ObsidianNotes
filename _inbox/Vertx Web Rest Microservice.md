# 📑 Vertx Web Rest Microservice

- **🏷️Tags** : #01-06-2022,  #pending

#### 🔗 Links

## Overview
- vert.x-web can be used to create the HTTP/ REST Microservice 
- below mentioned API Allows
- List all products
- get a product
- Add a product 


## Simple REST microservice using vertx web
-  I have modified the code and added one endpoint to return the product with product name

[github link](https://github.com/vert-x3/vertx-examples/blob/4.x/web-examples/README.adoc)

```JAVA

package io.vertx.example.web.rest;  
  
import io.vertx.core.AbstractVerticle;  
import io.vertx.core.http.HttpServerResponse;  
import io.vertx.core.json.JsonArray;  
import io.vertx.core.json.JsonObject;  
import io.vertx.example.util.Runner;  
import io.vertx.ext.web.Router;  
import io.vertx.ext.web.RoutingContext;  
import io.vertx.ext.web.handler.BodyHandler;  
  
import java.util.HashMap;  
import java.util.Map;  
  

public class SimpleREST extends AbstractVerticle {  
  
  // Convenience method so you can run it in your IDE  
  public static void main(String[] args) {  
    Runner.runExample(SimpleREST.class);  
  }  
  
  private Map<String, JsonObject> products = new HashMap<>();  
  
  @Override  
  public void start() {  
  
    //method will basically add the products in the hashmap  
    setUpInitialData();  
  
    Router router = Router.router(vertx);  
  
    router.route().handler(BodyHandler.create());  
  
//    modify the route to get the product by name  
    router.get("/products/:productID").handler(this::handleGetProduct);  
    router.get("/products/:productName").handler(this::handleGetProductByName);  
    router.put("/products/:productID").handler(this::handleAddProduct);  
    router.get("/products").handler(this::handleListProducts);  
  
  
  
  
  
    vertx.createHttpServer().requestHandler(router).listen(8080);  
  }  
  
  private void handleGetProductByName(RoutingContext routingContext) {  
    String productName = routingContext.request().getParam("productName");  
  
    HttpServerResponse response = routingContext.response();  
  
    if (productName == null) {  
      sendError(400, response);  
    } else {  
  
      final String[] keyOfProduct = new String[1];  
      products.forEach((k, v) -> {  
  
        if (v.getString("name").equals(productName)) {  
          System.out.println(v.getString("name"));  
          keyOfProduct[0] = k;  
  
  
        }  
  
      });  
  
      System.out.println(keyOfProduct[0]);  
      JsonObject product = products.get(keyOfProduct[0]);  
  
      if (product == null) {  
        sendError(404, response);  
      } else {  
        response.putHeader("content-type", "application/json").end(product.encodePrettily());  
  
//      JsonObject product = //write code to find the product by name  
      }  
  
  
    }  
  }  
  
  private void handleGetProduct(RoutingContext routingContext) {  
    String productID = routingContext.request().getParam("productID");  
  
    HttpServerResponse response = routingContext.response();  
  
    if (productID == null) {  
      sendError(400, response);  
    } else {  
      JsonObject product = products.get(productID);  
      if (product == null) {  
        sendError(404, response);  
      } else {  
        response.putHeader("content-type", "application/json").end(product.encodePrettily());  
      }  
    }  
  }  
  
  private void handleAddProduct(RoutingContext routingContext) {  
    String productID = routingContext.request().getParam("productID");  
    HttpServerResponse response = routingContext.response();  
    if (productID == null) {  
      sendError(400, response);  
    } else {  
      JsonObject product = routingContext.getBodyAsJson();  
      if (product == null) {  
        sendError(400, response);  
      } else {  
        products.put(productID, product);  
        response.end();  
      }  
    }  
  }  
  
  private void handleListProducts(RoutingContext routingContext) {  
    JsonArray arr = new JsonArray();  
    products.forEach((k, v) -> arr.add(v));  
  
    routingContext.response().putHeader("content-type", "application/json").end(arr.encodePrettily());  
  
  }  
  
  private void sendError(int statusCode, HttpServerResponse response) {  
    response.setStatusCode(statusCode).end();  
  }  
  
  private void setUpInitialData() {  
    addProduct(new JsonObject().put("id", "1").put("name", "macbook").put("price", 500).put("weight", 150));  
    addProduct(new JsonObject().put("id", "2").put("name", "monitor").put("price", 200.99).put("weight", 100));  
    addProduct(new JsonObject().put("id", "3").put("name", "keyboard").put("price", 300.00).put("weight", 80));  
  }  
  
  private void addProduct(JsonObject product) {  
    products.put(product.getString("id"), product);  
  }  
}

```