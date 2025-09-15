# GoalGrid App 📅
Created a goal-tracking platform for users to set, monitor, and complete monthly tasks. GoalGrid is a full-stack application with a **Spring Boot (Maven) backend**, a **React frontend**, and a **MySQL database**. This guide will help you set up and run the project locally.

---

## Prerequisites

- **Java 17+**
- **Node.js 16+** and **npm**
- **Maven 3.8+**
- **MySQL 8+**
- (Optional) **Git**

---

## Project Structure

```
goalgrid/
  backend/     # Spring Boot (Maven) backend
  frontend/    # React frontend
```

---

## 1. Clone the Repository

```bash
git clone https://github.com/<chetann-verma>/goalgrid.git
cd goalgrid
```

---

## 2. Set Up MySQL Database

1. **Start your MySQL server.**
2. **Create a database:**
   ```sql
   CREATE DATABASE goalgrid_db;
   ```
3. **(Optional) Create a user and grant privileges:**
   ```sql
   CREATE USER 'goalgrid_user'@'localhost' IDENTIFIED BY 'yourpassword';
   GRANT ALL PRIVILEGES ON goalgrid_db.* TO 'goalgrid_user'@'localhost';
   FLUSH PRIVILEGES;
   ```

---

## 3. Configure the Backend

1. Navigate to the backend directory:
   ```bash
   cd backend
   ```
2. Copy or create the `application.properties` file in `src/main/resources/`:

   ```properties
   # src/main/resources/application.properties

   spring.datasource.url=jdbc:mysql://localhost:3306/goalgrid_db
   spring.datasource.username=goalgrid_user
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true

   # Other configurations as needed
   ```

---

## 4. Build and Run the Backend

```bash
# From the backend directory
mvn clean install
mvn spring-boot:run
```

The backend server will start on [http://localhost:8080](http://localhost:8080).

---

## 5. Set Up and Run the Frontend

1. Open a new terminal and navigate to the frontend directory:
   ```bash
   cd frontend
   ```
2. Install dependencies:
   ```bash
   npm install
   ```
3. Start the React development server:
   ```bash
   npm start
   ```
   The app will open at [http://localhost:3000](http://localhost:3000).

---

## 6. Connect Frontend to Backend

- If your frontend makes API requests, ensure the API endpoints in your React code point to `http://localhost:8080` or use a proxy in `frontend/package.json`:
  ```json
  "proxy": "http://localhost:8080"
  ```

---

## 7. Environment Variables

- **Backend:** Store sensitive DB credentials in `application.properties` (see above).
- **Frontend:** If you have any API URLs or secrets, use a `.env` file in `frontend`.

---

## 8. Common Commands

- **Backend**
  - Build: `mvn clean install`
  - Run: `mvn spring-boot:run`
- **Frontend**
  - Install deps: `npm install`
  - Start: `npm start`
  - Build: `npm run build`

---

## 9. Troubleshooting

- **Port Conflicts:** Make sure ports 8080 (backend) and 3000 (frontend) are free.
- **Database Connection:** Check your MySQL credentials and ensure the database is running.
- **CORS Errors:** Configure CORS in your Spring Boot app if needed.

---

## 10. Contributing

1. Fork the repository.
2. Create a new branch: `git checkout -b my-feature`
3. Commit your changes: `git commit -am 'Add new feature'`
4. Push to the branch: `git push origin my-feature`
5. Open a pull request.

---

**Happy coding!**
