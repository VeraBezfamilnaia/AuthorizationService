FROM openjdk:17-oracle

EXPOSE 8080

COPY target/AuthorizationService-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]


