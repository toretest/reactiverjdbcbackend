# Info

## github action pipeline
- https://medium.com/@alexander.volminger/ci-cd-for-java-maven-using-github-actions-d009a7cb4b8f
- https://docs.github.com/en/free-pro-team@latest/actions/reference/specifications-for-github-hosted-runners
- https://github.com/actions

## actuator
```
curl localhost:8080/actuator | jq .

http://localhost:8080/actuator
```

## Docker 
```
docker build -t toregard/backend:1.0

docker push toregard/backend:2.0

docker run -p 8080:8080 toregard/backend:2.0

## NB! Følger med docker!!!! 
## se https://spring.io/blog/2020/01/27/creating-docker-images-with-spring-boot-2-3-0-m1
./mvnw spring-boot:build-image

```

### maven docker 
- see https://dzone.com/articles/build-docker-image-from-maven
- See https://codefresh.io/docker-tutorial/java_docker_pipeline/

#### dockerfile
https://spring.io/blog/2020/01/27/creating-docker-images-with-spring-boot-2-3-0-m1
```
FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/my-application.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

##Jib  
See also https://medium.com/@prgnr173/containerize-your-spring-boot-app-with-jib-plugin-50127d99a22f

###

# kubernetes

##  kubectl commands
```
 kubectl get all 
 docker build -t toregard/backend:2.0 .
 docker push toregard/backend:2.0
```

Generer deployment.yaml
```
kubectl create deployment backend --image=toregard/backend:2.0 --dry-run=client -o=yaml > deployment.yaml
kubectl apply -f deployment.yaml 
kubectl delete pods --all

```

```
kubectl get all
```

## Kurs

####https://www.youtube.com/watch?v=w9vy3wHGKeo

### status
```
{
    status: {
        all_stations_closed: false,
        stations_closed: [ ]
    }
}

---

{
stations: [
    {
    id: "2280",
    availability: {
    bikes: 3,
    locks: 12
    }
    },
    {
    id: "2270",
    availability: {
    bikes: 2,
    locks: 18
    }
}
}

---

{
stations: [
{
id: "2280",
title: "Klingenberggata",
subtitle: "By Olav V street",
number_of_locks: 12,
center: {
latitude: 59.913150534075015,
longitude: 10.732281291700133
},
bounds: [
{
latitude: 59.913320335043096,
longitude: 10.732257962884887
},
{
latitude: 59.913304714142924,
longitude: 10.732448203974826
},
{
latitude: 59.91307944350453,
longitude: 10.732344883382694
},
{
latitude: 59.913102463931835,
longitude: 10.732148082254866
},
{
latitude: 59.913320335043096,
longitude: 10.732257962884887
}
]
},
{
```
