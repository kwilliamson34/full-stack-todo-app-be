# Swagger generated server

Spring Boot Server 


## Overview  
This server was generated by the [swagger-codegen](https://github.com/swagger-api/swagger-codegen) project.  
By using the [OpenAPI-Spec](https://github.com/swagger-api/swagger-core), you can easily generate a server stub.  
This is an example of building a swagger-enabled server in Java using the SpringBoot framework.  

The underlying library integrating swagger to SpringBoot is [springfox](https://github.com/springfox/springfox)  

Start your server as an simple java application
```
mvn clean install
mvn package
java -jar target/swagger-srping-1.0.0.jar
```

You can view the api documentation in swagger-ui by pointing to  
http://localhost:8080/  

Change default port value in application.properties