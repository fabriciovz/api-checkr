FROM openjdk:14-alpine
VOLUME /tmp
COPY target/*.jar app.jar
EXPOSE 7001
ENTRYPOINT ["java","-jar","/app.jar"]