
shape-shop-backend
====================



### DO THIS:

docker run -d -p 3406:3306 --name=shape-shop-db-container --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=shapeshop" mysql
docker exec -i shape-shop-db-container mysql -uroot -proot shapeshop < SCHEMA.sql
docker exec -i shape-shop-db-container mysql -uroot -proot shapeshop < TEST_DATA.sql

In IDE should be able to see this with this URL :
jdbc:mysql://localhost:3406/shapeshop

In spring properties add this :
spring.datasource.url=jdbc:mysql://localhost:3406/shapeshop?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false

it is now possible to start app in IDE and debug through the code.




### DOCKER (simple setup) APP without DB

To run on Docker :

- make sure docker is installed
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
docker run -d -p 3406:3306 --name=shape-shop-db-container --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=shapeshop" mysql
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

`` docker run -d -p 3406:3306 --name db ollyw123/shape-shop-db:latest `` 

(3306 is a special magical number for MYSQL, so dont change it)

Should look like this :

`` CONTAINER ID        IMAGE                           COMMAND                  CREATED              STATUS              PORTS                                         NAMES`` 
`` b907f878f82b        ollyw123/shape-shop-db:latest   "docker-entrypoint.s…"   About a minute ago   Up About a minute   3306/tcp, 33060/tcp, 0.0.0.0:3406->3407/tcp   db `` 

The connection URL should look like this : 

`` jdbc:mysql://localhost:3406/shapeshop`` 









### DOCKER-COMPOSE :

1) delete jar files in /target/. Should be called shape-shop-backend-0.1.0.jar

2) run maven : 'package' 

3) docker-compose up

If there are connection errors, remove ALL images and container related to shape-shop and try again.

Current error :

Caused by: javax.persistence.NonUniqueResultException: query did not return a unique result: 2
UPDATE : connection problems again. tried to remove all shapeshop associated conatienrs and images but stiill same problem
UPDATE : changed ports for DB to 3406 and 3407, and application server to 9090:90





















Kubenertes GCP etc..
--------

#### GCLOUD


GCLOUD RUN (work in progress - still not working):

https://cloud.google.com/run/docs/quickstarts/build-and-deploy#java


Go into base directory (where docker file is)

Apparantyle just run :

C:\dev\shape-shop>gcloud builds submit --tag gcr.io/whataboutanewproject/shapeshop








#### KUBERNETES 

KUBERNETES (work in progress - still not working) :

To run on Kubernetes :

- create gcloud account



- Perform these three commands from within the project directory (dry run just means it first puts in a yaml file. Nothing yet is created):

kubectl create deployment shape-shop --image=shapeshop --dry-run -o=yaml > deployment.yaml

kubectl apply -f deployment.yaml

kubectl create service clusterip shape-shop --tcp=8080:8080 --dry-run -o=yaml >> deployment.yaml

kubectl apply -f deployment.yaml


- but I think this is more correct (using the expose) because clusterip is internal

kubectl expose deployment shape-shop --type=LoadBalancer --port=8080



- Make sure that shape-shop appears in the services list :

kubectl get svc

- or..

kubectl get all



- create a cluster on gcloud. Then LOCALLY connect to it :

gcloud container clusters get-credentials helloworld --zone us-central1-c --project strange-vortex-286312

- execute deployment yaml

kubectl create -f deployment.yaml

- have a look at the ingress

kubectl get ingress hello-ingress -oyaml


- and find the IP in the status field. That is the URL to access the backend!!





