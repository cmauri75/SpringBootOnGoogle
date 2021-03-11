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

### Publish to dockerhub
Create a repo and a project, than:
```bash
docker tag microserv:latest cmauri75/microserv:latest
docker push cmauri75/microserv:latest
```

# Deploy on Google cloud

1. Create a google cloud project "PRJ0"
2. Cloud Sql --> Create a MySql Instance. 
> We use a private ip (DB is used only inside privat network by our app). If you need to connect to manage data you should use public connectivity (best not allow external network) and then use "Cloud Sql Proxy" to access.
3. Create a VM to deploy our app: new VM Instance --> general purpose/Linux
4. Check db connectivity
```bash
   sudo apt-get update
   sudo apt-get install -y default-mysql-client
   mysql -h PRIVATE_MYSQL_UP -u root -p
   SHOW TABLES; 
 ```
5. install docker on VM
6. copy gcloudData dir and run script to run (just change VMNAME with your created above in application.properties). These overrides bundled application.properties
7. Create a Cloud Load Balancer instance.
> * In firewall config create rule "allow-lb_health" so LB can comunicate with VM. Choose tcp 8080 port and check this rule inside VM
> * Create an instance group containing only (for now, may be later we can add other VM) our VM and set 8080 as endpoint-port
> * Create a backend service using previous instance group. Config to use spring actuator for health checking.

Thanks to italiancoders: https://italiancoders.it/deploy-di-un-applicazione-spring-boot-su-una-vm-in-google-cloud-usando-compute-engine-cloud-sql-e-load-balancing-parte-1/