# user-management


# User Management System (Spring Boot + JWT + Role-Based Security)

This is a **User Management REST API** built with Spring Boot that supports:

- User Registration & Login
- JWT-based Authentication
- Role-Based Authorization (`ROLE_USER`, `ROLE_ADMIN`)
- Global Exception Handling
- Admin functionality to create users
- H2 Console & MySQL integration

---

## 📦 Technologies Used

- Java 17
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- MySQL (DB)
- H2 Console (for in-memory test)
- Lombok
- Maven

---

## 📂 Project Structure

```

src/main/java
├── config                 # JWT & Security configuration
├── controller             # REST Controllers
├── dto                   # Request & Response DTOs
├── entity                # JPA Entities
├── exception             # Custom exceptions & handler
├── initializer           # DataLoader for default roles/admin
├── repository            # JPA repositories
├── service               # Service logic

````

---

## 🛠️ Setup Instructions

### 1. Clone the project

```bash
git clone https://github.com/your-username/user-management.git
cd user-management
````

### 2. Configure application properties

In `src/main/resources/application.properties`, ensure the following:

```properties
server.port=4321
spring.datasource.url=jdbc:mysql://localhost:3306/jwt_db
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# JWT config
jwt.secret=mysupersecuresecretkeymysupersecuresecre
jwt.expiration=86400000 # 1 day in ms
```

✅ Make sure MySQL is running and database `jwt_db` exists.

---

## 🔐 API Endpoints

| Method | Endpoint          | Description                 | Access       |
| ------ | ----------------- | --------------------------- | ------------ |
| POST   | `/register`       | User Registration           | Public       |
| POST   | `/login`          | User Login & JWT generation | Public       |
| POST   | `/admin/register` | Admin creates a new user    | `ROLE_ADMIN` |
| GET    | `/users`          | Fetch all users             | `ROLE_ADMIN` |
| GET    | `/users/{id}`     | Fetch user by ID            | Admin/User   |
| DELETE | `/users/{id}`     | Delete user by ID           | `ROLE_ADMIN` |

---

## 🔑 Default Admin User (auto-created)

```json
{
  "email": "admin@example.com",
  "password": "admin123"
}
```

Admin is created at application startup using `CommandLineRunner`.

---

## 🧪 Testing the API

You can use **Postman** or **curl** to test the API.
Make sure to include the **Bearer token** in the Authorization header after login.

```
Authorization: Bearer <your_jwt_token>
```

---

## ⚠️ Important Notes

* Passwords are encrypted using `BCryptPasswordEncoder`.
* Global exception handler returns meaningful error messages.
* H2 Console is enabled for testing at `/h2-console`.

---

## 📸 Demo (Optional)

You can record a demo using [OBS Studio](https://obsproject.com/) and upload the `.mp4` file along with your GitHub repository.

---

## 📜 License

This project is open-source and free to use under the MIT License.

---

## 🙌 Author

**Vikas Paithane**
Backend Developer (Spring Boot)
