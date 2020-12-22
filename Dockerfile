#FROM maven:3.6.3-jdk-11 AS build-env
#COPY ./pom.xml ./pom.xml
#RUN mvn dependency:go-offline -B
#COPY ./src ./src
#RUN mvn package

FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
#ENV HOME=/usr/app
#ENV BUILD_ENV=/target/product-api-annotation-0.0.1-SNAPSHOT.jar
#RUN mkdir -p /app
#WORKDIR /app
#COPY --from=BUILD_ENV /home/usr/app/act/target/act*.jar ./act.jar
COPY ${JAR_FILE} app.jar
#COPY --from=build-env /target /app
EXPOSE 8080
#ENTRYPOINT exec java  -jar ./act.jar
ENTRYPOINT ["java","-jar","/app.jar"]

#FROM openjdk:11-jdk
#VOLUME /tmp
#COPY target/*.jar app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
