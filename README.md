# Spring Boot REST Controller Example
REST CRUD Example for Spring Boot 

### How to run
1. To Run this project locally:
    ```shell
    $ mvn spring-boot:run
    ```
1. To build and run from executable jar:
    ```shell
    $ mvn package
    $ java -jar target/REST-movie-service-0.1.jar
    ```
1. To access Movies app, open: <http://localhost:8081/v1/movies>
1. To access swagger-ui, open: <http://localhost:8081/swagger-ui.html>


### Hot Deploy in Idea IntelliJ
1. Settings -> Build-Execution-Deployment -> Compiler -> Select "Build Project Automatically"

1. Press `ctrl+shift+alt+/` and search for the `registry`. In the registry, enable : `compiler.automake.allow.when.app.running`
