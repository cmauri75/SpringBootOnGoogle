# Problem
Create a rest service with spring boot, deployed on google cloud that uses mysql via google cloud sql service

USER --> (Google) Load Balancer --> SPRING JAR --> CLOUD SQL (/Google)

# Project creation

## Start from start.spring.io choosing:
* Lombok DEVELOPER TOOLS: 
Java annotation library which helps to reduce boilerplate code.
* Spring Data JPA SQL: 
Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.
* MySQL Driver SQL: 
MySQL JDBC and R2DBC driver.
* Spring Web WEB: 
Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.


## Develop
- Populate application.properties
- Develop simple restService+jpa data access

## Activate test env and run tests
```bash
docker-compose -f docker-compose-test.yml up
mvn test
```

## Create dockerfile
Two ways:
```bash
mvn spring-boot:build-image 
```
or
```bash
mvn package
docker build . -t microserv
```
start server
```bash
docker-compose -f docker-compose-run.yml up
```


### Development
In case of development just add 
```
127.0.0.1 mysql-db
```
to your host file, so non-docker 
