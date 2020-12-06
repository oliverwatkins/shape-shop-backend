
shape-shop-backend
====================

DOCKER :
----------

To run on Docker :

- make sure docker is installed
- go in project directory, and run :

docker build -t shapeshop:1.0 .

- image should appear in the list of images. Check by running :

docker images
 
- run in container (make sure ports are not in use)

docker run -p 8080:8080 shapeshop:1.0

- should appear in running containers by executing :

docker container ls

- run the following in a browser. It should be possible to get some json back

http://localhost:8080/higgines/products

- and thats it! :)

Next, push image to docker hub

- tag image like this. Number is the ID of the shapeshop image from before. ollyw123 is username on docker hub. firsttry is some kind of tag name.

docker tag 7769f3792278 ollyw123/shapeshop:firsttry

- then push 

docker push ollyw123/shapeshop

- log into docker hub. It should appear in the list




mySQL and docker
----------


based on this example :
https://dzone.com/articles/all-about-hibernate-manytomany-association

create and run image of MySQL :


``docker run -d -p 6033:3306 --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=shape_shop" mysql``

``
docker exec -it docker-mysql bash
mysql -uroot -p ``
(password = root)

``show databases;``
shape_shop should be there

``exit;
exit;``

play in initial SQL :

``docker exec -i docker-mysql mysql -uroot -proot book_manager < initial_DB.sql``

go into the database :
``docker exec -it docker-mysql bash``
``mysql -uroot -p ``
(password = root)

``show databases;``
shape_shop should be there

``use shape_shop``
``select * from shape;``
table should have data!!

``exit;``
``exit;``





DOCKER-COMPOSE :
----------

docker-compose up

Current Problem :

 Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'dataSource' defined in class path resource [org/springframework/boot/autoconfigure/jdbc/DataSourceConfiguration$H
ikari.class]: Initialization of bean failed; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.boot.autoconfigure.jdbc.DataSourceInitializerInvoker': Inv
ocation of init method failed; nested exception is org.springframework.jdbc.datasource.init.UncategorizedScriptException: Failed to execute database script; nested exception is org.springframework.jdbc.CannotGetJdbcConnectionExcept
ion: Failed to obtain JDBC Connection; nested exception is com.mysql.jdbc.exceptions.jdbc4.CommunicationsException: Communications link failure















GCLOUD RUN (work in progress - still not working):

https://cloud.google.com/run/docs/quickstarts/build-and-deploy#java


Go into base directory (where docker file is)

Apparantyle just run :

C:\dev\shape-shop>gcloud builds submit --tag gcr.io/whataboutanewproject/shapeshop










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





