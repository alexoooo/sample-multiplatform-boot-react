# Work in progress
######

## Features
- Spring Boot on server using Kotlin
- React in browser using Kotlin
- Auto-reload in browser for development


# Run application
- `gradlew -t :proj-js:run` will run development application at https://localhost:8080 with live reload:
  - Run from IDE: --server.port=8081 to start https://localhost:8081
  - Webpack dev server will be started at the front https://localhost:8080            
  - Webpack dev server will call server for everything expect `*.js` files.     


# See also 
- https://github.com/Kotlin/kotlin-fullstack-sample
