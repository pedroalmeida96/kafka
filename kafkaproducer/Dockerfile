FROM openjdk:19
COPY kafkaproducer/target/*.jar app.jar
EXPOSE 8079
ENTRYPOINT ["java", "-jar", "app.jar"]