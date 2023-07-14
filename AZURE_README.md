

# AZURE SPRING APPS and AZURE MYSQL

### create DB first (this step has already been done)

- create MySQL flexible database as PULIC
- create a DB "shapeshop"
- add firewall rule to include all 0..255

connection string from IDE :

- host: shape-shop-db.mysql.database.azure.com
- port: 3306
- user: oliverwatkins
- pswd: T...1
- db: shapeshop
- jdbc: jdbc:mysql://shape-shop-db.mysql.database.azure.com:3306/shapeshop

then modify, run schema, run test data etc into IntelliJ console

(DONE!!)

### deploy spring app

- create a spring app in azure than deploy like this. Remember to **mvn clean package** first, and make sure you are using use the FOR_AZURE 
application.properties to connect to jdbc:mysql://shape-shop-db.mysql.database.azure.com:3306/shapeshop

[mvn clean package -DskipTests=true]

- Spring app must have a deployment associated with it.
Create a deployment with the default settings. Do not change memory/instance etc when creating.

> az spring app deploy --resource-group shapeShopResourceGroup --service shapeshop2 --name shape-shop-app --artifact-path target/shape-shop-backend-0.1.0.jar

[shapeshop2 = Azure Spring Apps service (blue cross with green white circle in it)
shape-shop-app = Spring App (three green cubes) ]


should be visible here :

> https://shape-shop-app.happywave-c1a7da5f.westeurope.azurecontainerapps.io/actuator
> https://shape-shop-app.happywave-c1a7da5f.westeurope.azurecontainerapps.io/test
> https://shape-shop-app.happywave-c1a7da5f.westeurope.azurecontainerapps.io/alpenhof/products





LOGS

az spring app logs --resource-group shapeShopResourceGroup --service shapeshop2 --name shape-shop-app --follow

az spring app log tail -n shape-shop-app -s shapeshop2 -g shapeShopResourceGroup --subscription 8cdb50cb-ede8-4eac-80df-55afadf861cd --lines 200



use this query :

AppEnvSpringAppConsoleLogs_CL
| where ContainerAppName_s == "shape-shop-app"

AppEnvSpringAppConsoleLogs_CL
| where ContainerAppName_s == "shape-shop-app" and RevisionName_s has "YourDeploymentName" and ContainerGroupName_s == "YourInstanceName"
| limit 50


see
https://stackoverflow.com/questions/76663560/spring-boot-apps-in-azure-cannot-view-logs-of-running-app?noredirect=1#comment135170932_76663560

????????????????

> az spring app deployment create --resource-group shapeShopResourceGroup --service shapeshop2 --app demo --name green --runtime-version Java_17 --artifact-path target/shape-shop-backend-0.1.0.jar

> az spring app create --resource-group shapeShopResourceGroup --service shapeshop2 --name demo --runtime-version Java_17 --assign-endpoint

> az spring app deploy -s shapeshop2 -g shapeShopResourceGroup -n shapeshop2instance --artifact-path target/shape-shop-backend-0.1.0.jar

notes:

-- SCALE OUT can be used to improve performance at certain times to 

-- Requested Resource is in Failed(Stopped) Status