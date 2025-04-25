
# 📇 Contact Manager

Contact Manager is a personal project built in Java using Spring Boot. It provides a RESTful API to create, read, and delete contact information efficiently and securely.

---

## 🚀 Features

- Full CRUD operations for contacts
- RESTful API using Spring Boot
- Input validation
- Modular and clean MVC architecture

---

## 🛠️ Technologies

- Java
- Spring Boot
- REST APIs
- Maven
- JPA

---

## 📁 Project Structure

```
ContactManager/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/contactmanager/
│       │       ├── controller/
│       │       ├── model/
│       │       ├── repository/
│       │       └── ContactManagerApplication.java
│       └── resources/
│           └── application.properties
└── README.md
```

---

## ▶️ Getting Started

1. Clone the repository  
   `git clone https://github.com/yourusername/contact-manager.git`

2. Open the project in your favorite IDE (IntelliJ, Eclipse, etc.)

3. Make sure Java and Maven are installed

4. Run the application from `ContactManagerApplication.java`

---

## 📡 API Endpoints

### Add a new contact
**POST** `/api/contacts`  
**Body:**
```json
{
  "name": "John Doe",
  "email": "johndoe@example.com",
  "phone": "123456789"
}
```

### Get all contacts
**GET** `/api/contacts`

### Get a contact by ID
**GET** `/api/contacts/{id}`



### Delete a contact
**DELETE** `/api/contacts/{id}`

---

## 🔧 Future Improvements

- Relational database support
- User authentication system
- Cloud deployment (Heroku, Render, etc.)

---

## 👤 Author

**Keyron Fernández Freckleton**  
Computer Systems Engineering Student  


---
