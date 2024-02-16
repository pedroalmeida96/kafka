FROM openjdk:19
COPY kafkaconsumer/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]