

This README consists of three parts.

- 1. Running the application within the IDE against the DB in a docker container.
- 2. Running the application and DB via two docker containers.
- 3. Running everything using docker-compose

### 1. Running the application within the IDE against the DB in a docker container

Run the database :

docker run -d -p 3306:3306 --name=shape-shop-db-container --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=shapeshop" mysql
docker exec -i shape-shop-db-container mysql -uroot -proot shapeshop < SCHEMA.sql

(Note sometimes you may get : 
ERROR 2002 (HY000): Can't connect to local MySQL server through socket '/var/run/mysqld/mysqld.sock'
Just wait 30 seconds and try again)


docker exec -i shape-shop-db-container mysql -uroot -proot shapeshop < TEST_DATA.sql

In IDE should be able to see this with this URL :
jdbc:mysql://localhost:3306/shapeshop

In spring properties add this :hibernate.dialect
spring.datasource.url=jdbc:mysql://localhost:3306/shapeshop?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false

START BACKEND APP IN IDE

it is now possible to start app (server side - spring) in IDE and debug through the code. It should be possible to 
access http://localhost:8080/alpenhof/products

it sould be possible to run the client side as well.







### 2. Running the application and DB via two docker containers. TODO

docker network create shape-shop-network
# create volume?

docker run -d -p 3306:3306 --name=shape-shop-db-container --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=shapeshop" mysql


docker run -d -p 3306:3306 --name=shape-shop-db-container --network shape-shop-network --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=shapeshop" mysql
docker exec -i shape-shop-db-container mysql -uroot -proot shapeshop < SCHEMA.sql
docker exec -i shape-shop-db-container mysql -uroot -proot shapeshop < TEST_DATA.sql

In IDE should be able to see this with this URL :
jdbc:mysql://localhost:3306/shapeshop

In spring properties add this :hibernate.dialect
spring.datasource.url=jdbc:mysql://localhost:3306/shapeshop?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false

it is now possible to start app in IDE and debug through the code.

# App (TODO)
3 things -
- Maven package
- docker build
- docker run

docker build -t shapeshop:1.0 . 
docker run -p 8080:8080 shapeshop:1.0 --network shape-shop-network 







### 3. Running everything using docker-compose 

remove all containers and volumes and images

`` docker-compose down ``
`` docker container prune ``
`` docker volume prune ``

KILL :

`` docker container stop shape-shop-back-end_db_1 `` 
`` docker container rm shape-shop-back-end_db_1 `` 
`` docker volume rm shape-shop-back-end_db-data2 `` 

There should be no volumes or processes associated with shapeshop.


1) delete jar files in /target/. Should be called shape-shop-backend-0.1.0.jar

2) run maven : 'package' 

(TODO - incorporate Maven into the DockerFile)

3) docker-compose up

This should work. Sometimes there are connection errors at first but after a while it seems
to stabilize and connect to the DB.

If there are connection errors, remove ALL images, containers, volumes, networks related 
to shape-shop and try again.

Should be able to access like so :
http://localhost:8080/higgins/products


You can look at the database by doing this

``docker exec -it shape-shop-back-end_db_1 bash ``
``mysql -uroot -proot ``
``show databases;``
``use shapeshop;``






























### DOCKER (simple setup) APP without DB

To run on Docker :

- go in project directory, and run :

`` docker build -t shapeshop:1.0 . ``

- image should appear in the list of images. Check by running :

`` docker images ``
 
- run in container (make sure ports are not in use) (make sure databse is in memory DB mode TODO)

`` docker run -p 8080:8080 shapeshop:1.0 ``

- should appear in running containers by executing :

`` docker container ls ``

- run the following in a browser. It should be possible to get some json back

`` http://localhost:8080/higgines/products ``

- and thats it! :)

Next, push image to docker hub

- tag image like this. Number is the ID of the shapeshop image from before. ollyw123 is username on docker hub. firsttry is some kind of tag name.

`` docker tag 7769f3792278 ollyw123/shapeshop:firsttry ``

- then push 

`` docker push ollyw123/shapeshop ``

- log into docker hub. It should appear in the list





### MySQL and docker (create instance of MYSQL. play in DDL, tag and then push) *

Run an instance of mySQL and populate it with new database schema

based on this example :
https://dzone.com/articles/all-about-hibernate-manytomany-association

create and run image of MySQL :

``
docker run -d -p 3306:3306 --name=shape-shop-db-container --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=shapeshop" mysql
``

``docker exec -it shape-shop-db-container bash ``

``mysql -uroot -proot ``
(password = root)

``show databases;``
shapeshop should be there

``exit;
exit;``

play in initial SQL :

``docker exec -i shape-shop-db-container mysql -uroot -proot shapeshop < SCHEMA.sql``

play in initial TEST_DATA :

``docker exec -i shape-shop-db-container mysql -uroot -proot shapeshop < TEST_DATA.sql``

go into the database :
``docker exec -it shape-shop-db-container bash``
``mysql -uroot -proot ``
(password = root)
shapeshop should be there as well as test data

``use shapeshop;``

``show tables;``

``exit;``
``exit;``




*** NOTE. THIS DOES NOT WORK!! *** 
https://stackoverflow.com/questions/66734991/cannot-save-database-changes-to-mysql-docker-image

Now create image from container 

``docker commit shape-shop-db-container``

This will create a nameless image (REPOSITORY = <<none>> ).

Find the image ID and tag it with an appropriate name :

``docker tag fd45b0f4eaa5 shape-shop-db:1.1 ``

Or you can name it as ollyw123/shape-shop-db and then push it :

``docker image tag shape-shop-db:1.1 ollyw123/shape-shop-db:1.1 ``

First login to Docker 

``docker login ``
(ollyw123,t..1)

`` docker push ollyw123/shape-shop-db ``

Run database again as another container :

`` docker run -d -p 3306:3306 --name db ollyw123/shape-shop-db:latest `` 

(3306 is a special magical number for MYSQL, so dont change it)

Should look like this :

`` CONTAINER ID        IMAGE                           COMMAND                  CREATED              STATUS              PORTS                                         NAMES`` 
`` b907f878f82b        ollyw123/shape-shop-db:latest   "docker-entrypoint.s…"   About a minute ago   Up About a minute   3306/tcp, 33060/tcp, 0.0.0.0:3406->3407/tcp   db `` 

The connection URL should look like this : 

`` jdbc:mysql://localhost:3306/shapeshop`` 









