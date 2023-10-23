# Work in progress
######

## Features
- Spring Boot on server using Kotlin
- React in browser using Kotlin
- Auto-reload in browser for development


# Package and run application
- `gradlew build`
- `java -jar proj-jvm/build/libs/proj-jvm-*-boot.jar` 

# Develop application

NOTE: auto-reload is currently not working.
For working example with ktor see: https://github.com/alexoooo/sample-ktor-react

1) Run from IDE: --server.port=8081
    to start https://localhost:8081
 
2) Run from terminal: `./gradlew -t :proj-js:run`
    to run client proxy at https://localhost:8080 with live reload
    - Web UI JavaScript will be provided by Webpack          
    - Everything expect `*.js` files is served by port 8081


# See also
- https://github.com/Kotlin/kotlin-full-stack-application-demo
