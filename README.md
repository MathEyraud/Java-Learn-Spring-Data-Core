# Core Project

## Objective
The primary objective of this project is to compare various technologies used for database communications within the Spring framework. The technologies being compared are:
- Spring JDBC
- Spring Data JDBC
- Spring Data JPA

## Project Overview
This project consists of two distinct data models:

1. Simple Model : This model represents a straightforward structure with basic relationships between entities. It includes entities such as Invoice and Customer with simple references.
2. Complex Model : This model is designed to showcase more advanced relationships between entities. It includes more intricate connections, such as linking customers and products to invoices through additional entities.

## Technologies Compared

### Spring JDBC
- Description: Spring JDBC provides a straightforward approach to interact with the database using raw SQL queries.
- Pros:
  - Greater control over SQL queries.
  - Performance can be optimized by writing specific queries.
- Cons:
  - More boilerplate code.
  - Increased risk of SQL injection if queries are not handled properly.

### Spring Data JDBC
- Description: Spring Data JDBC simplifies the development process by providing a more object-oriented approach to database interactions, while still maintaining control over the SQL.
- Pros:
  - Easier to use compared to Spring JDBC.
  - Less boilerplate code.
  - Still allows direct SQL queries.
- Cons:
  - Less flexible compared to Spring JDBC.
  - Limited support for complex relationships and custom queries.

### Spring Data JPA
- Description: Spring Data JPA uses the Java Persistence API (JPA) to interact with the database, offering a higher level of abstraction and more powerful ORM capabilities.
- Pros:
  - Powerful ORM capabilities.
  - Simplifies data access layers.
  - Handles complex relationships well.
- Cons:
  - Can have a steeper learning curve.
  - Performance overhead due to the abstraction layer.

## Models

### Simple Model
- Entities:
  - Invoice: Represents an invoice with basic details.
  - Customer: Represents a customer linked to the invoice by a simple reference.

### Complex Model
- Entities:
  - Invoice: Represents an invoice.
  - Customer: Linked to invoices.
  - Product: Linked to invoices through additional entities.
  - Address: Associated with customers.
  - Category: Associated with products.
  - InvoiceLine: Represents the relationship between invoices and products.

## Project Structure
- Core Project: Contains the business logic and database interaction layers using the different Spring technologies.
- Web Layer Project: A separate project that handles the web interactions and interfaces with the core project.

## Setup and Execution

1. Clone the Repository:
- git clone <repository-url>
- cd core-project

2. Configure Database: Set up your database and update the application.properties file with your database credentials.

3. Build and Run:
- Using Maven:
  - mvn clean install
  - mvn spring-boot:run

## Usage
The project exposes various endpoints to interact with the different data models and demonstrates the capabilities of Spring JDBC, Spring Data JDBC, and Spring Data JPA (depending on the branche).

## Correlation with Web Layer Project
This core project is designed to work in conjunction with a web layer project that provides the user interface and additional functionalities. Ensure to check out the Web Layer Project for the complete setup.
https://github.com/MathEyraud/Java-Learn-Spring-Data-Web

## Conclusion
This project serves as a comprehensive comparison of the different technologies used for database communications in Spring, providing insights into their strengths and weaknesses through practical implementations.
