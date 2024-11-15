# spring boot

## Basic Level
### 1. What is Spring Boot?

Spring boot is framework built on top of spring framework, which simplify development of java application.
Spring boot eliminates needs to set up complex configuration and provide default configuration and embedded server
like Tomcat and Jetty. make it easier and faster to develop stand-alone, production-ready applications.

### 2. What is the difference between Spring Boot and Spring Framework?

### 3.What is the purpose of the @SpringBootApplication annotation?

this annotation combined three annotation
@configuration, which mark a class as configuration class
@AutoConfiguration, which enable spring-boot auto configuration feature
@ScanComponent, which enable components scanning for spring beans

### 4. What is an embedded server in Spring Boot?
Embeded server is a server that is packaged inside the application, allowing you to run spring boot application
as stand-alone service

### 5.How do you configure properties in Spring Boot?
1. application.properties or application.yml
2. Environment variables:  Useful for production or when you want to externalize the configuration.
3. Command-line arguments
4. Profiles: Use application-{profile}.properties

### 6.What is a Spring Boot starter?
it is a pre-configured set of dependencies that you can include in your application to quickly enable specific features.
It is essentially a convenience dependency descriptor that simplifies adding configurations.

## Intermediate Level

### 7. Explain the concept of dependency injection in Spring Boot.


### 8. What are Spring Boot profiles, and how do you use them?

### 9. What is @RestController and how is it different from @Controller in Spring Boot?
@RestController: A specialized version of @Controller that is used for REST APIs. It combines @Controller and @ResponseBody, meaning methods in a @RestController automatically return the response body (typically JSON or XML).
@Controller: A general-purpose controller for rendering views (using ModelAndView or @ResponseBody).
Use @RestController for RESTful APIs and @Controller for MVC-based applications.

### 10. Explain the concept of Spring Boot Actuator and what features it provides.
Spring Boot Actuator provides built-in tools for monitoring and managing Spring Boot applications in production. It exposes various endpoints that you can use to inspect application health, metrics, and configuration.
Features include:
/actuator/health: Provides the health status of the application.
/actuator/metrics: Provides various metrics like memory usage, garbage collection, etc.
/actuator/env: Exposes environment properties.
/actuator/beans: Shows all the beans configured in the application.

### 11. How does Spring Boot handle security, and what is the role of Spring Security?
Spring Security integrates with Spring Boot to provide security features like authentication, authorization, and protection against common vulnerabilities (e.g., CSRF, session fixation).
Spring Security can be easily added by including spring-boot-starter-security in your project. By default, Spring Security adds basic HTTP authentication and a default login page.
You can customize security using configuration classes or annotations like @EnableWebSecurity and @Secured.

## Advanced Level

### 13. Explain the difference between @Component, @Service, @Repository, and @Controller in Spring Boot.
These annotations all mark classes as Spring beans, but each serves a specific purpose:
@Component: A generic annotation for any Spring-managed bean.
@Service: A specialization of @Component, typically used for service layer beans.
@Repository: A specialization of @Component for Data Access Objects (DAO), often used with Spring Data JPA or other persistence technologies.
@Controller: Used for Spring MVC controllers handling web requests.

### 14. What is the @Autowired annotation, and how does it work in Spring Boot?
@Autowired is used to inject dependencies into Spring-managed beans. Spring uses reflection to inject the appropriate bean (by type) into the field, constructor, or setter method.
If there are multiple matching beans, you can use @Qualifier to specify which bean to inject.

### 15. What is the role of @Entity in Spring Boot?
@Entity is used to mark a class as a JPA entity, which will be mapped to a database table.
The class must have a @Id annotation to denote the primary key, and it should be managed by Spring Data JPA to perform CRUD operations.

### 16. What is the @Transactional annotation, and how is it used in Spring Boot?
@Transactional is used to define a transaction boundary around a method or class.
It ensures that all database operations inside the method are executed within a single transaction, 
and if any operation fails, the transaction is rolled back.

It’s commonly used for service methods that involve multiple database interactions.

### 17. Explain the concept of asynchronous processing in Spring Boot.
Asynchronous processing in Spring Boot allows methods to be executed in the background, 
freeing up the main thread. This can be done using @Async and a TaskExecutor.

```java
@Async
public void doSomethingAsync() {
    // long-running task
}

```

### 18.How do you configure CORS in a Spring Boot application?
You can configure Cross-Origin Resource Sharing (CORS) using @CrossOrigin or globally by configuring it in the WebMvcConfigurer.
```java
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**").allowedOrigins("http://localhost:4200");
    }
}
```
### 19. What is Spring Boot's support for database migrations (e.g., Flyway or Liquibase)?
Spring Boot integrates with both Flyway and Liquibase for database schema migrations.
Flyway and Liquibase manage database schema changes by applying migration scripts in a controlled, versioned manner.
Both tools can be integrated simply by adding their dependencies, and Spring Boot will automatically run the migrations on startup.

### 20.What is Spring Boot's support for caching, and how do you implement it?
Spring Boot provides support for caching with the @Cacheable, @CachePut, and @CacheEvict annotations.
You can use caching solutions like Redis, EhCache, and Caffeine. To enable caching:
```java
@EnableCaching
@Configuration
public class CacheConfig {
    // Cache configuration
}

```
### 21 JPA example
```java
public interface UserRepository extends JpaRepository<User, Long> {
    // Additional query methods can be defined here
}
```

## Java
### 1.What is the difference between JDK, JRE, and JVM?
1.JVM (Java Virtual Machine): An abstract machine that enables your computer to run Java programs by converting Java bytecode into machine-specific code.
It provides platform independence by abstracting the underlying hardware and operating system.

2.JRE (Java Runtime Environment): Provides the libraries, Java Virtual Machine (JVM), and other components necessary to run applications written in Java.
It does not include development tools like the compiler.

3.JDK (Java Development Kit): A software development kit used to develop Java applications.
It includes the JRE and development tools like the compiler (javac), debugger, and other utilities.

### 2. What is the difference between == and equals() in Java?
== is a reference comparison operator that checks if two references point to the same object in memory.
equals() is a method that checks for value equality, meaning it determines if two objects are logically equivalent. 
By default, the equals() method in the Object class behaves like ==,
but many classes override this method to provide meaningful equality logic. 

### 3. What is inheritance in Java?
Inheritance is an OOP principle where a new class (subclass or derived class) inherits attributes and methods from an existing class (superclass or base class). This mechanism promotes code reusability and establishes a natural hierarchy between classes. 
In Java, inheritance is achieved using the extends keyword.

### 4.What is polymorphism in Java?
olymorphism allows objects to be treated as instances of their parent class rather than their actual class.
It enables a single interface to represent different underlying forms (data types). 

### 5.What is encapsulation in Java?
Encapsulation is the OOP principle of bundling data (attributes) and methods that operate on that data into a single unit, typically a class. 
It restricts direct access to some of an object's components, which can prevent unintended interference and misuse of the data. 
Access to the data is typically provided through public methods (getters and setters).

### 6. The following table summarizes the accessibility of these modifiers:

## SQL questions, https://www.sql-practice.com/
1. Write an SQL query to retrieve each customer’s name and the total amount they’ve spent, including customers who haven’t placed any orders.
```sql

SELECT customers.contact_name, COALESCE(AVG(orders.freight), 0) AS totalFreight
FROM customers
left join orders on customers.customer_id = orders.customer_id
group by customers.contact_name;
```
2.Write a query to retrieve the CustomerID and CustomerName for customers with more than five orders.
```sql
select customers.contact_name, customers.customer_id
from customers
where customers.customer_id in 
(
	select orders.customer_id
  	from orders
  	group by customer_id
  	having count(orders.order_id) > 10
);
```
3.Write a query using a window function to display OrderID, CustomerID, Amount, and the ranking of each order within each customer based on the Amount.
```sql
select orders.order_id, orders.customer_id, orders.freight,
rank() over(partition by orders.customer_id order by orders.freight DESC) as FreightRank
from orders;
```
4. Find the total sales amount for each customer who made purchases in 2023, sorted by the total amount in descending order.
```sql
select customers.contact_name, SUM(orders.freight) as totalAmount
from customers
inner join orders on customers.customer_id = orders.customer_id
where 1 = 1
and year(orders.order_date) = 2016
group by customers.contact_name
order by totalAmount DESC;
```
5.
```sql
select customers.contact_name, orders.order_date,
SUM(orders.freight) over (order by orders.order_date) as CumulativeTotal 
from customers
inner join orders on customers.customer_id = orders.customer_id;

select orders.customer_id, orders.order_id, orders.freight,
rank() over (partition by orders.customer_id order by orders.freight desc) as AmountRankas  
from orders;

select c.city, avg(o.freight) as AverageFreight
from customers c
join orders o on c.customer_id = o.customer_id
group by c.city
having AVG(o.freight) > 10; 

select o.customer_id, count(*) as Duplicate
from orders o
group by o.customer_id
having count(*) >1;

```

## practicl question java
1. Key differences between String, StringBuilder, and StringBuffer?
String is immutable
Stringbuilder is mutable, not thread safe
StringBuffer is mutable, thread safe
2. Explain OOP principles.
Encapsulation: we wrap data and method into a sing unit class
Inheritance: Reusing code from a parent class
Polymorphism: using a sing interface for different type, like method overriding
Abstraction: like interface/abstract class, hiding implementation details and only provide functionality
3. how to implement  multiple threads?
```java
class Test extends Thread{
    @Override
    public void run(){
        System.out.println("Thread " + Thread.currentThread().getName() + " is running.");
    }
}
public class ThreadExmaple{
    public static void main(String[] args) {
        Test thread1 = new Test();
        Test thread2 = new Test();
        thread1.start();
        thread2.start();
    }
}
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable " + Thread.currentThread().getName() + " is running.");
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());
        thread1.start();
        thread2.start();
    }
}
public class LamdbaExmaple{
    public static void main(String[] args) {
        Thread thread1 = new Thread(
                () -> {
                    System.out.println("Runnable " + Thread.currentThread().getName() + " is running.");
                }
        );
        thread1.start();
    }
}
```
4. what's thread safety and how to ensuyre thread safety
Thread-unsafe usually result in issues lik:
 - Race condition: multiple threads access shared resources simultaneously and the outcome varies based on the thread execution sequence.
 - Data Inconsistency:happens when shared data is modified by multiple threads in an unpredictable manner, leading to corrupted or incorrect results
 - DeadLock: two or more threads are waiting for each other to release locks, and none of them can proceed, causing the program to hang indefinitely

4. sychronized can prevent thread safty, How does synchronized work?
```java
class BankAccount {
    private int balance = 100;

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
        }
    }

    public int getBalance() {
        return balance;
    }
}
}
```
5. How transactions work in Spring?
Spring uses @Transactional to manage transactions declaratively. if the transaction failed, freamwork will roll back
the transaction to its original state, and make sure no partial of inconsistent change are persisted in database
6. Handling exceptions in a Spring Boot REST API?
Use @ControllerAdvice with custom exception handlers:
```java
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}

```
7. stack and heap
   - Primitive types and method references are stored in the stack.
   - Objects and instance variables are allocated in the heap.