# SteelDoor

## 1. Summary

This repository contain all the code from challenge Steeldoor, this repository is separated in api and frontend directories. I've use docker and docker compose to manipulate dependencies. The frontend is made in Angular Framework (Javascript), and backend in Spring Boot (Java).

**OBS:** To jump to install instructions use this [Link](#3-installation)

## 2. Screens

### 2.1 Logins

![image1](./images/page_login.png)
### 2.2 SignUp

#### 2.2.1 Company
![image2](./images/page_sign_up_company.png)

#### 2.2.2 User
![image3](./images/page_sign_up_users.png)

### 2.3 Job Seeker Area
#### 2.3.1 List jobs
![image3](./images/page_jobs_availables.png)
#### 2.3.2 Jobs Applied
![image3](./images/page_jobs_applied.png)

### 2.4 Company Area
#### 2.3.1 Create Jobs
![image3](./images/page_create_job.png)
#### 2.3.2 Users by job
![image3](./images/page_list_users.png)


## 3. Installation

To start installation you need to the follow dependencies:

- [Docker](https://docs.docker.com/engine/install/)
- [Docker compose](https://docs.docker.com/compose/install/)

After download and install the dependecies above, user the follow command:

```
docker-compose up --build
```

This running take a little while, so wait until front end container start and say that is running an ready in host **http://localhost:4200**

Now just start to play with application.
