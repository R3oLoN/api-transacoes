FROM openjdk:11-jre-slim

LABEL maintainer="Leandro Reolon"

ADD target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=${ACTIVE_PROFILE}","/app.jar"]
