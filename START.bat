docker run -d -p 3306:3306 --name=shape-shop-db-container --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=shapeshop" mysql

timeout /t 10

docker exec -i shape-shop-db-container mysql -uroot -proot shapeshop < SCHEMA.sql

timeout /t 10

docker exec -i shape-shop-db-container mysql -uroot -proot shapeshop < TEST_DATA.sql