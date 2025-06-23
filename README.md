# Todo List Application

## Overview
This is a robust Todo List application built with Spring Boot that allows users to manage tasks through a RESTful API interface. The application provides endpoints for creating, reading, updating, and deleting tasks, as well as filtering tasks by their status.

## Features
- Create new tasks with automatic status tracking
- Update existing tasks (name and status)
- Delete tasks
- View all tasks
- Filter tasks by status (in-progress, completed, etc.)
- Automatic timestamp tracking for task creation and updates

## Tech Stack
- **Java 17**
- **Spring Boot 3.5.0**
- **Spring Data JPA**
- **MySQL Database**
- **Maven**
- **Lombok**

## Prerequisites
- Java 17 or higher
- Maven
- MySQL Server
- Your favorite IDE (IntelliJ IDEA recommended)

## Swagger
![image](https://github.com/user-attachments/assets/7827ae7f-b651-46b8-b54d-81e6a9eca5de)

## Postman
![image](https://github.com/user-attachments/assets/a03ce270-c431-4017-8ddf-3a34a16b1512)
![image](https://github.com/user-attachments/assets/be802166-7fa3-4042-b0a6-22672362fac8)
![image](https://github.com/user-attachments/assets/c0a6faaa-8aaa-4421-84d7-edc25a0536fb)




## Database Setup
The application is configured to connect to a MySQL database named `todo`. Before running the application, make sure to:

1. Create a MySQL database named `todo`
2. Update the database configuration in `application.properties` if needed:
```
spring.datasource.url=jdbc:mysql://localhost:3306/todo 
spring.datasource.username=your_user_name
spring.datasource.password=your_pass_word
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
```
![image](https://github.com/user-attachments/assets/1a430642-93d0-44d7-8645-426f3c315c2e)

## Project Structure
```
src/main/java/com/toDoList/toDoList/
├── ToDoListApplication.java
├── controller/
│   ├── ListCrudController.java
│   └── ListDisplayController.java
├── dto/
│   └── ListDto.java
├── entity/
│   └── ListItem.java
├── repository/
│   └── ListRepository.java
└── service/
    ├── ListCrudService.java
    └── ListDisplayService.java
```


## API Endpoints

### Task Management
- **Add Task**
  - Method: `POST`
  - URL: `/task`
  - Body: Task name as plain text
  - Response: Confirmation message with task ID

- **Update Task**
  - Method: `PUT`
  - URL: `/task/update`
  - Body: JSON object containing task details
    ```json
    {
        "id": 1,
        "taskName": "Updated task name",
        "taskStatus": "completed"
    }
    ```
  - Response: Confirmation message

- **Delete Task**
  - Method: `DELETE`
  - URL: `/task/{id}`
  - Response: Confirmation message

### Task Display
- **Get All Tasks**
  - Method: `GET`
  - URL: `/task/display`
  - Response: Array of task objects

- **Get Tasks by Status**
  - Method: `GET`
  - URL: `/task/display/{taskStatus}`
  - Example: `/task/display/completed`
  - Response: Array of tasks with specified status

## Task Structure
Each task in the system has the following properties:
- `id`: Unique identifier (auto-generated)
- `taskName`: Description of the task
- `taskStatus`: Current status (default is "in-progress")
- `taskCreatedAt`: Timestamp when the task was created
- `taskUpdatedAt`: Timestamp when the task was last updated

## Building and Running the Application

### Using Maven
```bash
# Clone the repository
git clone https://github.com/your-username/toDoList.git

# Navigate to the project directory
cd toDoList

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

### Using IDE
1. Import the project into your IDE
2. Build the project
3. Run the ToDoListApplication class

#### The application will start on http://localhost:8080  


## Testing the API
You can test the API using tools like Postman, cURL, or any REST client.  

### Example Requests
1. Create a Task:
```
curl -X POST -H "Content-Type: text/plain" -d "Buy groceries" http://localhost:8080/task
```

2. Update a Task:
```
curl -X PUT -H "Content-Type: application/json" -d '{"id":1,"taskName":"Buy vegetables","taskStatus":"completed"}' http://localhost:8080/task/update
```

3. Get All Tasks:
```
curl -X GET http://localhost:8080/task/display
```

4. Get Completed Tasks:
```
curl -X GET http://localhost:8080/task/display/completed
```

5. Delete a Task:
```
curl -X DELETE http://localhost:8080/task/1
```

## Future Enhancements
1. User authentication and authorization
2. Task categories or tags
3. Due dates for tasks
4. Priority levels
5. Pagination for task listings
6. Frontend UI

## License
This project is licensed under the MIT License - see the LICENSE file for details.
