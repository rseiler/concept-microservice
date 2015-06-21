start cmd /k java -jar all-in-one/target/all-in-one.jar
SLEEP 10

start http://localhost:8080/user/1
start http://localhost:8080/product/1
start http://localhost:8080/shopping-cart/1
