docker-compose down

docker container stop shape-shop-back-end_db_1

docker container rm shape-shop-back-end_db_1

docker volume rm shape-shop-back-end_db-data2

docker image rm shape-shop-back-end_app-server

docker container stop shape-shop-db-container
docker container rm shape-shop-db-container

docker container stop petsitter-db-container
docker container rm petsitter-db-container

echo "The program has completed"

PAUSE