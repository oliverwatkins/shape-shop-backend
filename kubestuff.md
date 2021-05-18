


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





