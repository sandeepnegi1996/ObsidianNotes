# 📑 What is JAX-RS

- **🏷️Tags** : #10-06-2022,  #pending #completed #permanent

#### 🔗 Links


## Key Takeaways

## Overview
- there are multiple ways to implement RESTFUL API in java we can use Spring or we can use JAX-RS
- JAX-RS is a specification , set of interfaces and annotations offered by JAVA EE.


### Lightweight Wars 


### Always know your Server
1. Glassfish comes with Jersey 
2. Wildfly or jboss comes with RESTEasy.
3. 

### Annotations
### `@GET` and `@POST`

### `@Path`

### `@PathParam`


### `@Consumes`
- it is like an input to a method , it tells what media type the HTTP method takes in 

### `@Produces`
- It is like an output to a method , means media type produced by the method

##### Note
- It is good practice to add both for each method 


#### Code Sample

```java

	@GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotification(@PathParam("id") int id) {
        return Response.ok()
          .entity(new Notification(id, "john", "test notification"))
          .build();
    }

    @POST
    @Path("/post/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postNotification(Notification notification) {
        return Response.status(201).entity(notification).build();
    }

```

### `@Context`
- with this we can inject 12 Object instances in the context of HTTP requests
- object instances that can be injected are 

-   **SecurityContext** – Security context instance for the current HTTP request
-   **Request** – Used for setting precondition request processing
-   **Application**, **Configuration**, and **Providers** -> Provide access to the JAX-RS application, configuration, and providers instances
-   **ResourceContext** – Resource context class instances
-   **ServletConfig** – The ServletConfig instance instance
-   **ServletContext** – The ServletContext instance
-   **HttpServletRequest** – The HttpServletRequest instance for the current request
-   **HttpServletResponse** – The HttpServletResponse instance for the current request
-   **HttpHeaders** – Maintains the HTTP header keys and values
-   **UriInfo** – Query parameters and path variables from the URI called


