### Mini-Project: Smart Coffeeshop System

#### Objective:
Develop a simulation of a smart coffeeshop system that automates the processes involved in order handling, payment processing, and inventory management. This project will demonstrate your understanding of Dependency Injection, AOP, and transactional behavior in Spring Boot applications.

#### Requirements:

1. **Core Functionality:**
   - **Order Processing System**: Implement a service to handle coffee orders. This should include receiving orders, processing payments, and updating inventory.
   - **Inventory Management**: Create a service to manage inventory levels. The service should track the quantities of coffee and other ingredients available.
   - **Payment Processing**: Develop a service to simulate payment transactions. Each payment should be associated with an order.

2. **Dynamic Pricing Aspect**:
   - Implement an AOP aspect to adjust coffee prices based on certain criteria (e.g., time-of-day discounts, demand-driven pricing). The system should apply these rules automatically to orders being processed.

3. **Transactional Order Placement**:
   - Ensure the process of placing an order is transactional. If payment processing fails or if there is insufficient inventory for an order, the operation should roll back to maintain data consistency.

4. **Bean Scopes**:
   - Use the Singleton scope for your services (`OrderService`, `InventoryService`, `PaymentService`) to demonstrate their shared usage throughout the application.
   - Apply the Prototype scope to the `Order` object to illustrate how each order is a unique instance managed independently.

5. **Logging Aspect**:
   - Implement an AOP aspect to log significant actions in the system, such as when an order is placed, payment is processed, and inventory is updated. This should help in tracking the application's behavior and troubleshooting.

#### Present:
   - Prepare a short demo scenario to showcase the working of your smart coffeeshop system. This should include:
     - Placing an order and demonstrating the dynamic pricing adjustment.
     - Showing the transactional nature of the order process by simulating a failure in payment or inventory shortage.
     - Illustrating how the logging aspect captures system operations.


#### Tips for Success:
- Start by sketching out the components of your system and their interactions. This will help you identify where to apply Dependency Injection, AOP, and transactions.
- Test your application thoroughly, especially the transactional aspects, to ensure that your system behaves correctly under various scenarios.
- Use Spring's built-in capabilities (e.g., `@Transactional`, `@Aspect`, `@Scheduled` for dynamic pricing based on time) to implement the required functionality efficiently.

Enjoy your coffee!