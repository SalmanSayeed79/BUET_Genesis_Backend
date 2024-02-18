### BebshaAI Backend

### Team: BUET_Genesis

Welcome to the backend repository of BebshaAI, developed by Team BUET_Genesis. This backend is built using Java Spring Boot and is dedicated to handling database-related tasks for the BebshaAI project.

### Features:

- **User Data Management:** This backend is responsible for storing and managing user data, including user profiles, preferences, and authentication.

- **Product Data Management:** It handles the storage and retrieval of product-related information, such as product details, inventory, and pricing.

- **Querying Capabilities:** The backend provides querying functionalities to retrieve specific data from the database efficiently.

- **Data Manipulation Operations:** It supports various data manipulation operations like adding, updating, and deleting user and product records.

## Setup Instructions:

To set up the backend locally, follow these steps:

1. Clone the repository:
   ```
   git clone https://github.com/BUET-Genesis/BebshaAI-Backend.git
   ```

2. Navigate to the project directory:
   ```
   cd BebshaAI-Backend
   ```

3. Ensure you have Java and Maven installed on your system.

4. Configure the database connection properties in `application.properties` file.

5. Build the project:
   ```
   mvn clean install
   ```

6. Run the Spring Boot application:
   ```
   java -jar target/bebshaai-backend.jar
   ```

7. Access the backend APIs through the specified endpoints.
