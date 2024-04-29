# Training Center api

## Overview
This project is a Training Center Management System implemented in Java using Spring Boot. It allows users to manage training centers, including their details such as name, code, address, capacity, courses offered, and contact information.

## Prerequisites
Before you begin, ensure you have met the following requirements:
- JDK 11 or later installed.
- Maven installed.
- Your favorite IDE (IntelliJ IDEA, Eclipse, etc.) configured for Java development.

## Installation and Setup
Follow these steps to set up the project locally:

1. **Clone the repository:**
   git clone https://github.com/your-username/training-center-management.git



2. **Navigate to the project directory:**
   cd training-center-management



3. **Build the project using Maven:**
   mvn clean install

4. **Now go to mysql workbench and create a database of your choice**
5. **Change the application properties according to your database**

![image is dead](https://i.ibb.co/HHqJwhZ/Screenshot-2024-04-28-233603.jpg)


5. **Run the application:**
   mvn spring-boot:run



The application will start running on `http://localhost:8080`.

## Usage
- Access the Swagger UI to interact with the API endpoints:
  http://localhost:8080/swagger-ui.html

- Use the provided endpoints to manage training centers, such as adding new centers, updating existing ones, and retrieving center details.
- After running on swagger input the json data 
- ![image is dead](https://i.ibb.co/YBfRpmn/Screenshot-2024-04-29-123225.png)


## Configuration
- Database configuration:
- By default, the application uses an sql database. You can configure a different database by modifying `application.properties` file.



## License
This project is created by kevin roland thank you.