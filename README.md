
shape-shop-backend
====================

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

``docker run -d -p 6033:3306 --name=shape-shop-db-container --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=shapeshop" mysql``

``docker exec -it shape-shop-db-container bash ``

``mysql -uroot -proot ``
(password = root)

``show databases;``
shapeshop should be there

``exit;
exit;``

play in initial SQL :

``docker exec -i shape-shop-db-container mysql -uroot -proot shapeshop < schema_gen.sql``

go into the database :
``docker exec -it shape-shop-db-container bash``
``mysql -uroot -proot ``
(password = root)
shapeshop should be there

``use shapeshop;``

``show tables;``

``exit;``
``exit;``

Now create image from container

``docker commit shape-shop-db-container``

This will create a nameless image (REPOSITORY = <<none>> ).

Find the image ID and tag it with an appropriate name :

``docker tag fd45b0f4eaa5 shape-shop-db ``

Or you can name it as ollyw123/shape-shop-db and then push it :

First login to Docker 

``docker login ``
(ollyw123,t..1)

`` docker push ollyw123/shape-shop-db ``



### DOCKER-COMPOSE :

1) delete jar files in /target/. Should be called shape-shop-backend-0.1.0.jar

2) run maven : 'package' 

3) docker-compose up

If there are connection errors, remove ALL images and container related to shape-shop and try again.

Current error :

Caused by: javax.persistence.NonUniqueResultException: query did not return a unique result: 2



















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





