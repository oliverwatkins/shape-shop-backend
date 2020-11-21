
# shape-shop-backend

DOCKER :

To run on Docker :

- make sure docker is installed
- go in project directory, and run :

docker build -t shapeshop:1.0 .

- image should appear in the list of images. Check by running :

docker images
 
- run in container (make sure ports are not in use)

docker run -p 8080:8080 shapeshop

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





QUICK LINKS

docker images
docker container ls
kubectl get services
kubectl get nodes
kubectl get all
kubectl cluster-info
kubectl config get-contexts

kubectl delete services --all
kubectl delete deplyoments --all





GCLOUD RUN :

https://cloud.google.com/run/docs/quickstarts/build-and-deploy#java


Go into base directory (where docker file is)

Apparantyle just run :

C:\dev\shape-shop>gcloud builds submit --tag gcr.io/whataboutanewproject/shapeshop










KUBERNETES (work in progress) :

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





