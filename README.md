# Data storage API

Data storage API providing saving and retrieving data using cache.

## Technologies

Java 11

Spring Boot 2.5.3

H2 in-memory database

Embedded Redis cache

Maven

## Setup

This is Spring Boot Maven project. You can run a Spring Boot application from your IDE as a simple Java application, 
however, first you will need to import it as a Maven project. Using Maven wrapper you can start application running 
the following command in a terminal window (in the project directory): ./mvnw spring-boot:run. Project runs on port 8080, 
Redis instance on port 6379.

## Usage

When application starts it automatically loads 1 record into H2 in-memory database for more convenient testing.

## Author

Andrius Jauniskis - feel free to contact me!