FROM tomcat:9.0.71-jre8-temurin-focal
COPY /target/web-shop-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/web-shop.war
