# Discount Calculation Application

This Java Spring Boot application provides an API endpoint to calculate net payable amounts based on various discounts applicable to bills. It leverages object-oriented programming principles and ensures comprehensive test coverage using JUnit and Mockito.

## Features

- Calculates net payable amount considering:
  - Percentage discounts for employees, affiliates, and long-term customers.
  - Fixed discounts based on bill amount thresholds.
- Supports exclusion of percentage discounts on grocery items.
- Ensures only one percentage-based discount is applied per bill.

## Technologies Used

- Java 17
- Spring Boot 2.6.x
- Maven (or Gradle)
- Hibernate/JPA for database interaction
- H2 Database (for local testing)
- JUnit 5 and Mockito for unit testing


The application will start at http://localhost:8080.

4. **API Endpoint:**

- **POST `/api/discount/calculate`**
  - Calculates the net payable amount based on discounts applied to a bill.
  - Request Body (JSON):
    ```json
    {
      "user": {
        "name": "John Doe",
        "userType": "EMPLOYEE",
        "registrationDate": "2024-07-16"
      },
      "bill": {
        "amount": 100.0,
        "grocery": false
      }
    }
    ```
  - Response:
    ```json
    90.0
    ```

## Testing

- **Unit Tests:**
- Includes comprehensive unit tests using JUnit and Mockito to validate discount calculations and edge cases.
- Run tests using:
 ```
 mvn test
 ```

- **Coverage Reports:**
- Generates test coverage reports using Jacoco.
- Access reports at `/target/site/jacoco/index.html` after running tests.

## Future Enhancements

- Integration with a persistent database (e.g., MySQL) for storing user and bill data.
- Addition of more sophisticated discount calculation algorithms.
- Implementation of a front-end interface for user interaction.

