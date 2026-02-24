
## Title: E-Commerce Microservices with API Gateway

# 🏗 Expected Architecture


                AUTHSERVICE(5001)
                      ↑
                      |
                APIGATEWAY(5000)
                      |
                      ↓
              PRODUCTSERVICE(5002)


Clients must ONLY communicate with:

👉 API Gateway (Port 5000)

Direct access to services is not allowed.

---

# 🎯 Functional Requirements

---

## 1️⃣ Auth Service (Port 5001)

### Responsibilities:

- User Registration
- User Login
- JWT Generation
- Token Validation

### APIs:

- POST /register
- POST /login
- GET /validate-token

### Database:

- users table / collection

Fields:

- id
- name
- email
- password (hashed)
- role

---

## 2️⃣ Product Service (Port 5002)

### Responsibilities:

- Create product
- Update product
- Delete product
- Get all products
- Get product by ID

### APIs:

- POST /products
- GET /products
- GET /products/:id
- PUT /products/:id
- DELETE /products/:id

### Database:

- products table / collection

Fields:

- id
- name
- description
- price
- createdBy (userId)

---

## 3️⃣ API Gateway (Port 5000)

### Responsibilities:

- Route requests to appropriate services
- Verify JWT before forwarding request
- Block unauthorized access
- Forward headers properly
- Global error handling

### Example Routing:

| Gateway Route | Forward To |
| --- | --- |
| /auth/* | localhost:5001 |
| /products/* | localhost:5002 |

---
