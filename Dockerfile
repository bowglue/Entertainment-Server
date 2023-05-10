FROM openjdk:18-jdk-alpine AS build
ARG JAR_FILE=target/*.jar
COPY ./target/entertainment-ressource-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]

