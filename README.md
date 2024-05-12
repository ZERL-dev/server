# ZERL.server

A Java Spring Boot API for a real estate site. Uses AWS RDS Aurora (Postgres in Development), Spring Data JPA, and Swagger UI. 
Also uses Spring Security's BCrypt and JOSE JWT for security and authentication.
Deployed on AWS ECS with Github actions for automatic deployments.

## Listings

### GET `/listing/all`

![image](https://github.com/ZERL-dev/server/assets/106638403/0bcedce6-d9ac-49d8-9aef-5607545cb252)

### GET `/listing/id/{id}`

![image](https://github.com/ZERL-dev/server/assets/106638403/1e38aca2-5929-4ff7-b080-90073213ca27)

### POST `/listing/new`

![image](https://github.com/ZERL-dev/server/assets/106638403/e9da6ee4-bd6e-491b-9db0-6f416120a99c)

### PUT `/listing/update/{id}`

![image](https://github.com/ZERL-dev/server/assets/106638403/646b6a82-22ff-4222-82ee-eb69255375e9)

### DELETE `/listing/delete/{id}`

![image](https://github.com/ZERL-dev/server/assets/106638403/47ae00b6-d70b-4dd6-acb1-d9bb8b364ff9)


## Admin

### GET `/admin/auth`

![Screenshot 2024-05-12 134523](https://github.com/ZERL-dev/server/assets/106638403/bb27a31c-08ca-4a33-a201-d24b82935cb7)

### POST `/admin/create`

![Screenshot 2024-05-12 132544](https://github.com/ZERL-dev/server/assets/106638403/ff3ed60a-2752-400c-a51e-8a09f938f318)

### PATCH `/admin/update/{updatedPassword}`

![Screenshot 2024-05-12 134217](https://github.com/ZERL-dev/server/assets/106638403/97801757-d95c-4af6-b8cc-604250372d75)


Use the `dev.sh` script to run the project locally. The default port is `8080`.