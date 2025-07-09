# Cross-Platform Gym Management System



This project provides a REST API backend for a gym management system. It is built using Spring Boot and Java. The API is used by both a website and an Android app to communicate with the database.



### Built With

\- Spring Boot: https://spring.io/projects/spring-boot

\- Java: https://www.java.com/en/

\- MariaDB: https://mariadb.org/

\- Maven: https://maven.apache.org/Documentation



### Libraries Used

\- Mockito - For unit testing

\- JUnit - For unit testing

\- Spring Framework - For dependency injection and web layer



## Features

\- RESTful API endpoints for managing gym data

\- Simple and comprehensive project structure

\- URL mappings for CRUD operations

\- Individual unit tests

\- Easily extendable and maintainable



### How to Build and Run

1\) Clone the repository:

   git clone https://github.com/your-username/your-repo.git

2\) Open the project in IntelliJ IDEA or another IDE.

3\) Navigate to:

   backend/src/main/resources/application.properties

   Update the database connection settings to match your local MariaDB configuration.

4\) Build the project:

   mvn clean install

5\) Run the API:

   mvn spring-boot:run

The application should start on port 8080 by default.

