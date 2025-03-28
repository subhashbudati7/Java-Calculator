# Java Calculator - Subhash Budati

## Overview
This is a Spring Boot-based Java calculator application that processes mathematical expressions and returns computed results. The project follows a structured MVC (Model-View-Controller) architecture with DTOs for data representation.

## Features
- Supports basic arithmetic operations
- REST API-based communication
- Well-structured DTOs and services
- Configurable settings through `application.properties`
- Unit and integration tests

## Project Structure
```
java-calculator-budati/
│── src/
│   ├── main/
│   │   ├── java/com/budati/calculator/
│   │   │   ├── config/ (Application Configuration)
│   │   │   ├── controller/ (API Controllers)
│   │   │   ├── dto/ (Data Transfer Objects)
│   │   │   ├── service/ (Business Logic)
│   │   │   ├── CalculatorApplication.java (Main Spring Boot Class)
│   ├── test/
│   │   ├── java/com/budati/calculator/ (Unit & Integration Tests)
│── pom.xml (Maven Dependencies)
│── application.properties (Configurable properties)
```

## Prerequisites
- Java 17+
- Maven 3.8+
- (Optional) Docker for containerized execution

## Installation & Setup
1. **Clone the Repository**
   ```sh
   git clone https://github.com/your-repo/java-calculator-budati.git
   cd java-calculator-budati
   ```
2. **Build the Project**
   ```sh
   mvn clean install
   ```
3. **Run the Application**
   ```sh
   mvn spring-boot:run
   ```
4. **Access API Endpoints**
   - Base URL: `http://localhost:8080`
   - Sample API Call:
     ```sh
     curl -X POST "http://localhost:8080/calculate" -H "Content-Type: application/json" -d '{"expression": "2+3*4"}'
     ```

## API Endpoints
| Method | Endpoint        | Description |
|--------|----------------|-------------|
| POST   | `/calculate`    | Processes a mathematical expression |

## Flowchart
Below is a high-level flowchart representing the application's request flow:

```
User Request --> ComputationalController --> Service Layer --> Expression Parsing & Calculation --> Response to User
```

## Running Tests
To execute unit tests, run:
```sh
mvn test
```

## Docker Support (Optional)
To run the application inside a Docker container:
```sh
docker build -t java-calculator .
docker run -p 8080:8080 java-calculator
```

## Contribution
Feel free to fork the repository and submit pull requests for improvements!

## License
This project is licensed under the MIT License.

