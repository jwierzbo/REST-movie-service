# Spring Boot REST Controller Example
REST CRUD Example for Spring Boot 

### How to run
1. To Run this project locally:
    ```shell
    $ mvn spring-boot:run
    ```
1. To build and run from executable war:
    ```shell
    $ mvn package
    $ java -jar target/movies-0.3.war
    ```
1. To build and run on standalone Tomcat server:
    ```shell
    $ mvn package -Ptomcat
    $ cp target/movies-0.3.war <Tomcat Root>/webapps/
    ```
1. To access Movies app, open: <http://localhost:8081/v1/movies>
1. To access Movies app deployed on Tomcat: <http://localhost:8080/movies-0.3/v1/movies>
1. To access swagger-ui, open: <http://localhost:8081/swagger-ui.html>


### Hot Deploy in Idea IntelliJ
1. Settings -> Build-Execution-Deployment -> Compiler -> Select "Build Project Automatically"

1. Press `ctrl+shift+alt+/` and search for the `registry`. In the registry, enable : `compiler.automake.allow.when.app.running`
