# ⚓ JIT (Just-In-Time)

Implementation of the **Just-In-Time (JIT)** concept based on the sub-model defined in the **IMO Compendium on Facilitation and Electronic Business**.  
This enables effective and standardized communication between ships and ports.

The **JIT (Just-In-Time)** concept in maritime operations — standardized under the **IMO (International Maritime Organization)** — aims to:

- ⏱️ Optimize vessel arrival times to minimize waiting at anchor  
- 🌱 Reduce fuel consumption and emissions  
- ⚓ Improve port efficiency and berth utilization  

---

## ⚙️ Tech Stack

- **Java 17**
- **Spring Boot 3.3.12**
- **PostgreSQL**
- **Maven**

---

## 🚀 Run the Application
- Before Running the application ,Add the database properties in **``application.yml``** file.
- Schema name give as **imo_jit**

Clone the repository

```bash
git clone https://github.com/SPOCP/port-call-api.git
```
- Go to the project directory

```bash
cd IMO-JIT
```
- Build the project

```bash
mvn clean install
```
- Run the application

```bash
mvn spring-boot:run
```

- The application will start at:
```bash
http://localhost:8080/jit
```
---

## 📘 Swagger

You can explore and test APIs using Swagger UI or access the OpenAPI specification directly.

- **OpenAPI Specification:** 
  `http://localhost:8080/jit/v3/api-docs`  
- **Swagger UI Endpoint:** 
  `http://localhost:8080/jit/swagger-ui/index.html`

