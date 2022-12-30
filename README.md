[![Maven Test Build](https://github.com/repplix/WebJexxa/actions/workflows/mavenBuild.yml/badge.svg)](https://github.com/repplix/WebJexxa/actions/workflows/mavenBuild.yml)
[![New Release](https://github.com/repplix/WebJexxa/actions/workflows/newRelease.yml/badge.svg)](https://github.com/jexxa-projects/WebJexxa/actions/workflows/newRelease.yml)

# WebJexxa
This template can be used to start your own Jexxa application 

## Requirements

*   Java 17+ installed
*   IDE with maven support 
*   [Optional] Docker or Kubernetes if you want to run your application in a container. See [here](README-CICD.md) for more information.   
*   [Optional] A locally running [developer stack](deploy/developerStack.yml) providing a Postgres database, ActiveMQ broker, and Swagger-UI 

## Features

*   Build your first Jexxa-project as self-contained jar and/or docker image
    
*   Template for [Unit-](src/test/java/io/jexxa/webjexxa/domain/book/BookTest.java), [Stub-](src/test/java/io/jexxa/webjexxa/applicationservice/BookStoreServiceTest.java) and [Integration tests](src/test/java/io/jexxa/webjexxa/integration/WebJexxaIT.java)

*   Predefined architectural tests for: 
    *   [Pattern Language](src/test/java/io/jexxa/webjexxa/architecture/ArchitectureTest.java) to validate the correct annotation of your application using project [Addend](http://addend.jexxa.io/) 
    *   [Ports&Adapters Architecture](src/test/java/io/jexxa/webjexxa/architecture/ArchitectureTest.java) to validates dependencies between packages of your application
    *   [Usage of Aggregates](src/test/java/io/jexxa/webjexxa/architecture/ArchitectureTest.java) to validate that your business logic is not exposed

*   Predefined CI/CD pipeline for GitHub including automatic dependency updates 
 
## Create new Project from Template

*   In GitHub press `Use this template` (requires GitHub account) or fork the project. If you do not have a GitHub account you can just clone the repository. 

*   Enter a `project name` for the repository. This template uses following convention:
    *   Project name should be written in camel case notation, such as `WebJexxa`
    *   Project name of the repository is equal to the name of the java application

## Build the Project

*   Checkout the new project in your favorite IDE

*   Without running [developer stack](deploy/developerStack.yml):
    ```shell
    mvn clean install -P '!integrationTests'

    java -jar "-Dio.jexxa.config.import=src/test/resources/jexxa-local.properties" target/webjexxa-jar-with-dependencies.jar
    ```

*   [Optional] **With** running [developer stack](deploy/developerStack.yml):
    ```shell
    mvn clean install
    
    java -jar "-Dio.jexxa.config.import=src/test/resources/jexxa-test.properties" target/webjexxa-jar-with-dependencies.jar
    ```

*   Now you can use `curl` to access your application:
    ```Console
    curl -X GET  http://localhost:7503/BookStoreService/getBooks
    ```
    Response should look as follows 
    ```Console
    [
      {"isbn13":"978-1-60309-322-4"},{"isbn13":"978-1-891830-85-3"},
      {"isbn13":"978-1-60309-047-6"},{"isbn13":"978-1-60309-025-4"},
      {"isbn13":"978-1-60309-016-2"},{"isbn13":"978-1-60309-265-4"}
    ]
    ```
*   [Optional] See [here](https://github.com/jexxa-projects/JexxaTutorials/blob/main/BookStore/README-OPENAPI.md#explore-openapi) how to use the application with Swagger-UI

## Start Developing your Project

### Adjust Project Name

Rename `WebJexxa` to your own applications name, as described [here](README-ProjectName.md). 

### Set up the CI/CD Pipeline  

In order to continuously build and deply your application, configure your CI/CD pipeline as described [here](README-CICD.md).
