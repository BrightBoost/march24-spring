### Personal Budget Tracker Application

**Objective:** Develop a RESTful API for a Personal Budget Tracker that supports creating, retrieving, updating, and deleting financial transactions (incomes and expenses). The application should be reactive, utilizing Spring WebFlux and R2DBC for database interactions with MySQL.

### Components to Implement:

1. **Transaction Model**

   - **Fields:** `id` (Long), `type` (String - either "INCOME" or "EXPENSE"), `amount` (BigDecimal), `category` (String), `date` (LocalDate), `description` (String - optional).

2. **Transaction Repository**

   - Interface for reactive CRUD operations on transactions.

3. **Transaction Controller**

   - RESTful endpoints to manage transactions.
   - Endpoints for create, get by ID, list all, update, delete.

### Steps:

#### 1. Setup Project Dependencies

Set up a new Spring Boot project with dependencies for Spring WebFlux, R2DBC, and MySQL.

#### 2. Configure Application Properties

Configure `application.properties` for connecting to an in-memory or local/remote MySQL database using R2DBC.

#### 3. Implement the Transaction Model

Create a `Transaction` model + MySQL table (see SQL below).

#### 4. Create the Transaction Repository

Create a repository interface extending `ReactiveCrudRepository` for the `Transaction` model.

#### 5. Develop the Transaction Controller

Implement a controller with WebFlux annotations to handle HTTP requests for transaction CRUD operations.

#### 6. Test the API

Test the API using tools like Postman, PostCode or cURL.

### Need more? Challenges:

- **Challenge 1:** Implement endpoint for filtering transactions by type (INCOME/EXPENSE) and date range.
- **Challenge 2:** Add validation for the `Transaction` model (e.g., `amount` should be positive, `type` should match predefined values).
- **Challenge 3:** Integrate basic authentication using Spring Security's reactive support to secure the API.

### SQL schema creation

This is not a SQL course, here's the SQL command to create the `transactions` table:

```sql
CREATE TABLE transactions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(10) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    category VARCHAR(255) NOT NULL,
    date DATE NOT NULL,
    description TEXT,
    INDEX (type),
    INDEX (date)
);
```
