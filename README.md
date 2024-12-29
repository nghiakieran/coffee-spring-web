# Coffee Spring Web Application  

**Introduction**  
Coffee Spring Web is a web application built with Spring Boot, designed to manage coffee shop business operations efficiently.  

---


### **Features**  

- **Guest**:  
  - Register a new account with email verification  
  - Log in to the system  
  - View product list and details  

- **User**:  
  - Manage personal account  
  - Online shopping (cart, order history, checkout)  

- **Admin**:  
  - Manage products (add, update, delete)  
  - Manage orders (view, add, update, delete)  
  - Manage users (assign roles, add, update, delete)  

---

### **Built With**  
- Java 17  
- Maven  
- Spring Boot  
- Spring MVC  
- Spring Data JPA  
- Spring Security  
- Java Email  
- Cloudinary Service  

---

### **Setup and Deployment**  

#### **Prerequisites**  
- JDK 17 or higher  
- Maven 3.6.x or higher  

#### **Steps to Setup**  
1. Clone the repository:  
```bash  
git clone https://github.com/nghiakieran/coffee-spring-web.git  
```
2. Navigate to the project directory:

```bash
cd coffee-spring-web  
```

3. Configure database:
```bash 
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/coffeeshop
spring.datasource.username=username
spring.datasource.password=password
```

4. Run the application using Maven:

```bash
mvn clean install
mvn spring-boot:run
```

The application will run at: `http://localhost:8080`

## Authors

- Chi Nghia
- Email: lechinghia202@gmail.com

- Quoc Nam
- Email: namle022004@gmail.com 
