#!/bin/sh

java -jar common/eureka-service/target/eureka-service.jar &
sleep 10

java -jar product-domain/product-service/target/product-service.jar &
java -jar user-domain/shopping-cart-service/target/shopping-cart-service.jar &
java -jar user-domain/user-service/target/user-service.jar &
sleep 30

java -jar frontend-service/target/frontend-service.jar &
sleep 30

gnome-www-browser http://localhost:8080/user/1
gnome-www-browser http://localhost:8080/product/1
gnome-www-browser http://localhost:8080/shopping-cart/1