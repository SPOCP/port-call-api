## ⚓ JIT (Just-In-Time)

Implementation of the **Just-In-Time (JIT)** concept based on the sub-model defined in the **IMO Compendium on Facilitation and Electronic Business**.  
This enables effective and standardized communication between ships and ports.

The **JIT (Just-In-Time)** concept in maritime operations — standardized under the **IMO (International Maritime Organization)** — aims to:

- ⏱️ Optimize vessel arrival times to minimize waiting at anchor  
- 🌱 Reduce fuel consumption and emissions  
- ⚓ Improve port efficiency and berth utilization 

## 📄 IMO-FAL (Facilitation)

Implementation of the **IMO Facilitation (FAL)** data model as defined in the **IMO Compendium on Facilitation and Electronic Business**.  
This enables standardized electronic submission and exchange of maritime, ship, crew, cargo, and port call information.

The **IMO-FAL** concept in maritime operations — governed by the **IMO Facilitation (FAL) Convention** — aims to:

- 📑 Standardize mandatory reporting requirements for ships and ports  
- 🔄 Enable seamless electronic data exchange between maritime stakeholders  
- ⚖️ Improve regulatory compliance and reduce administrative burden  

---

### ⚙️ Tech Stack

- **Java 17**
- **Spring Boot 3.3.12**
- **PostgreSQL**
- **Maven**

---

### 🚀 Run the Application
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
http://localhost:8080/imomsw
```
---

### 🔎 General Swagger Access

You can also access the combined Swagger UI and OpenAPI specification:

- **Swagger UI:**  
  http://localhost:8080/imomsw/swagger-ui/index.html

- **OpenAPI Specification:**  
  http://localhost:8080/imomsw/v3/api-docs  

#### 📘 Swagger API Definitions

The Swagger UI provides **two API definitions**:

- **IMO-JIT** – APIs aligned with the IMO Just-In-Time (JIT) model for port call optimization.
- **IMO-FAL** – APIs based on IMO Facilitation (FAL) Convention data models for standardized maritime reporting.

You can switch between these APIs in Swagger UI by selecting the appropriate **definition** from the dropdown menu.

---
### 🔐 Access to Master Data & IMO-FAL Document APIs

This application exposes dedicated endpoints for:

- **Master Data** (reference and lookup data used across the system)
- **IMO-FAL Documents** (standardized maritime reporting documents)


#### Master Data Integration

Use of the master data is **optional**.

- If you prefer, you may integrate your **own master data endpoints**
- The system supports external master data sources, allowing flexibility based on organizational or regional requirements

This approach ensures both **standardization** and **integration flexibility**.

#### Console Application Registration

To access the **Master Data** and **IMO-FAL Document** endpoints, users must first register through the **Pomfret Console Application**:

<a href="http://dev-console.ibpaas.pomfret.cloud" target="_blank" rel="noopener noreferrer">Pomfret Console Application</a>


#### Registration & Authentication

After successful registration:
- You will receive a **username and password**
- These credentials are required to authenticate and consume the protected APIs
- The credentials must be configured in the application properties file:

```yaml
auth:
  username: <your-username>
  password: <your-password>
```
---

### 🌐 SPOCP Community & Forum

SPOCP provides a community forum at  <a href="https://spocp.org" target="_blank" rel="noopener noreferrer">spocp.org</a>   where users and contributors can:

- Ask questions related to IMO-JIT and IMO-FAL implementations
- Share knowledge, best practices, and experiences
- Receive updates and announcements related to SPOCP initiatives

The forum serves as a collaborative platform for discussions and continuous learning within the SPOCP maritime technology community.

---

### 📌 Notes

- Ensure the PostgreSQL schema **`imo_jit`** exists before starting the application.
- This project follows **IMO-aligned data models** to ensure interoperability between maritime stakeholders.

---
