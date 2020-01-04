# shape-shop-backend

GET 
http://localhost:8080/shapes

POST
curl -H "Content-Type: application/json" -X POST -d {\"name\":\"pentagon\",\"sides\":\"5\"} http://localhost:8080/shapes

DELETE
curl -H "Content-Type: application/json" -X DELETE -d {\"id\":\"1\",\"name\":\"pentagon\",\"sides\":\"5\"} http://localhost:8080/shapes

UPDATE
curl -H "Content-Type: application/json" -X POST -d {\"id\":\"2\",\"name\":\"ASDFASDFASDFASDF\",\"sides\":\"5\"} http://localhost:8080/shapes






