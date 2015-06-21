#!/bin/sh

java java -jar all-in-one/target/all-in-one.jar &
sleep 10

gnome-www-browser http://localhost:8080/user/1
gnome-www-browser http://localhost:8080/product/1
gnome-www-browser http://localhost:8080/shopping-cart/1