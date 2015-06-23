#!/bin/sh

cd common/common-configuration
mvn clean install

cd ../../
mvn clean install