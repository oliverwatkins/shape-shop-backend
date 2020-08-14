# shape-shop-backend


To run on Docker :

- make sure docker is installed
- go in project directory, and run :

docker build -t shapeshop:1.0

- image should appear in the list of images. Check by running :

docker images

- run in container (make sure ports are not in use)

docker run -p 8080:8080 shapeshop

- should appear in running containers by executing :

docker container ls

- run the following in a browser. It should be possible to get some json back

http://localhost:8080/higgines/products

- and thats it! :)







