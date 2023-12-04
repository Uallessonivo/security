# Spring Security with JWT

## Description

This project is a simple example of how to use Spring Security with JWT.

## Dependencies

- Java
- Maven
- Lombok
- Spring Web
- Spring Security
- JPA
- PostgreSQL Driver

## Features

- Login
- Register
- Get all users
- Get user by username
- Get user by email
- Update user
- Delete user
- Role based authorization

# PostgreSQL and Spring Boot Setup

## Usage

1. **Clone the Repository**

    ```bash
    git clone https://github.com/Uallessonivo/security.git
    cd security
    ```

2. **Run PostgreSQL on Docker**

   Ensure you have Docker installed. If not, download and install it from [Docker's official website](https://www.docker.com/get-started).

    ```bash
    docker run --name postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres
    ```

3. **Connect IntelliJ IDE to the PostgreSQL Database**

    - Open IntelliJ IDEA.
    - Navigate to the `View` menu, select `Tool Windows`, and choose `Database`.
    - Click the `+` icon in the `Database` tool window to add a new data source.
    - Choose `Data Source` -> `PostgreSQL`.
    - Configure the data source:
        - **Host:** `localhost`
        - **Port:** `5432`
        - **Database:** `security`
        - **User:** `postgres`
        - **Password:** `postgres`
    - Click `Test Connection` to ensure the connection is successful.
    - Click `OK` to save the data source configuration.

4. **Create the Database (if not done during IDE setup)**

   Open a terminal and execute the following command to create the database:

    ```bash
    docker exec -it postgres psql -U postgres -c "CREATE DATABASE security"
    ```

5. **Run the Application**

   In IntelliJ IDEA:
    - Open the `src/main/java/com/example/Application.java` file.
    - Right-click on the file and select `Run 'Application'`.

   Alternatively, you can run the application using the command line:

    ```bash
    mvn spring-boot:run
    ```

Now, your application should be running, and IntelliJ IDEA should be connected to the PostgreSQL database. You can start developing and interacting with the database through the IDE.


## Endpoints

- Login

```bash
POST http://localhost:8080/api/auth/login
```

- Register

```bash
POST http://localhost:8080/api/auth/register
```

- Get all users

```bash
GET http://localhost:8080/api/users
```

- Get user by username

```bash
GET http://localhost:8080/api/users/{username}
```

- Get user by email

```bash
GET http://localhost:8080/api/users/{email}
```