FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
#ENV HOME=/usr/app
#ENV BUILD_ENV=/target/product-api-annotation-0.0.1-SNAPSHOT.jar
#RUN mkdir -p /app
#WORKDIR /app
#COPY --from=BUILD_ENV /home/usr/app/act/target/act*.jar ./act.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
#ENTRYPOINT exec java  -jar ./act.jar
ENTRYPOINT ["java","-jar","/app.jar"]
