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


## Hot Deploy

### Local Update in Idea IntelliJ
1. Settings -> Build-Execution-Deployment -> Compiler -> Select "Build Project Automatically"

1. Press `ctrl+shift+alt+/` and search for the `registry`. In the registry, enable : `compiler.automake.allow.when.app.running`

1. Run app from IntelliJ: in [Application.java](src/main/java/net/jwierzbo/rest/Application.java) click right mouse button on the `main()` method and select `Debug 'Application.java'`

### Remote Update on Maven running app
1. Set `<excludeDevtools>false</excludeDevtools>` in [pom.xml](pom.xml)

1. Set `PASSWORD` and `$DEBUG_PORT` for remote update in [application.properties](src/main/resources/application.properties)

1. Run app in debug mode without choosing the port: `mvn spring-boot:run -Drun.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n"`

1. In Intellij add new Configuration and Run it
    * Run –> Edit Configurations… -> Add (+) -> Application
    * Use `org.springframework.boot.devtools.RemoteSpringApplication` as the main class.
    * Add `http://$HOST:$DEBUG_PORT` to the Program arguments

1. Edit some Java file end reload it: `Build -> Build Projekt (Ctrl+F9)` - server should reload and restart automatically