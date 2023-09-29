FROM openjdk:17

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Zap-Api-Gateway.jar

ENTRYPOINT ["java", "-jar","Zap-Api-Gateway.jar"]
EXPOSE 8080