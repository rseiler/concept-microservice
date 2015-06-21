start cmd /k java -jar common/eureka-service/target/eureka-service.jar
SLEEP 15

start cmd /k java -jar product-domain/product-service/target/product-service.jar
start cmd /k java -jar user-domain/shopping-cart-service/target/shopping-cart-service.jar
start cmd /k java -jar user-domain/user-service/target/user-service.jar
SLEEP 30
start cmd /k java -jar frontend-service/target/frontend-service.jar
SLEEP 45

start http://localhost:8080/user/1
start http://localhost:8080/product/1
start http://localhost:8080/shopping-cart/1