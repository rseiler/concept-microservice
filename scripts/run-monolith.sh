#!/bin/sh

java0 -jar all-in-one/target/all-in-one.jar &
sleep 20

gnome-www-browser http://localhost:8080/user/1 &
sleep 5
gnome-www-browser http://localhost:8080/product/1 &
sleep 5
gnome-www-browser http://localhost:8080/shopping-cart/1 &