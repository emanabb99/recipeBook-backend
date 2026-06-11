# RecipeBook (Backend)

A decoupled REST API engineered with Java, Spring Boot, and PostgreSQL, featuring robust CRUD functionality and relational data mapping via Spring Data JPA.

---

## 🚀 Key Features

* **Complete CRUD Capabilities:** Users can dynamically create, read, update, and delete recipes.
* **Decoupled Architecture:** Built as a separate, microservice-ready backend REST API that communicates seamlessly with a modular frontend via CORS.
---

## 🛠️ Tech Stack & Architecture

* **Language:** Java 17 
* **Framework:** Spring Boot (REST API, Spring Data JPA) 
* **Database:** PostgreSQL 
* **Build Tools:** Gradle

---

## Technical Challenges & Key Learnings

### 1. Decoupling the Monolith & Handling CORS
**Challenge:** Initially, the frontend and backend architectures faced integration friction, throwing cross-origin resource sharing (CORS) blocks during API requests.
**Solution:** Implemented a robust global CORS configuration bean in Spring Boot to explicitly whitelist incoming frontend origins, ensuring secure and seamless communication.

### 2. Architectural Analysis & Production Scoping
**Challenge:** During development, I scoped out adding a recipe image upload feature. However, doing so would require storing binary file data directly onto my local computer's file system, which creates deployment blocks and violates cloud-native architecture principles.
**Solution:** Rather than implementing a non-scalable local file storage solution, I chose to deliberately defer the feature. I am prioritizing a future iteration that properly integrates a dedicated cloud media service (such as AWS S3 or Cloudinary) to handle asset management securely and scalably via external APIs.

---

## ⚙️ Local Setup Instructions

Follow these steps to get the development environment running locally.

### Prerequisites
* Java JDK 17 or higher
* Node.js (for frontend)

### Installation
1. Clone the repository:
   ```bash
   git clone [https://github.com/your-username/recipeBook-backend.git](https://github.com/your-username/recipeBook-backend.git)
