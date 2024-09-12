# Read Me First
The following was discovered as part of building this project:

* The original package name 'procedures.example.procedures-backend' is invalid and this project uses 'procedures.example.procedures_backend' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.3/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.3/gradle-plugin/packaging-oci-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#web)
* [Spring for RabbitMQ](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#messaging.amqp)
* [JDBC API](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#data.sql)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Messaging with RabbitMQ](https://spring.io/guides/gs/messaging-rabbitmq/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)


### docker compose up --build for running application

And to run other containers in the same Docker network:

docker network create your-network
docker run --network your-network -p 8080:8080 your-project
