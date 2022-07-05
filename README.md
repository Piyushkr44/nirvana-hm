# Hotel-Management
Hotel management system using Spring boot, Jpa and MVC
"# nirvana-hm" 

#Docker command to run the app
docker run -d -p 3306:3306 --name=db --env="MYSQL_ROOT_PASSWORD=password123" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=hotel" mysql
docker run -t --link db:mysql -d -p 8081:8080 --name my-hm --env "SPRING_DATASOURCE_URL=jdbc:mysql://db:3306/hotel" my-hotel
