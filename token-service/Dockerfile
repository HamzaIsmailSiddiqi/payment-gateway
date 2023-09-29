FROM openjdk:17

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Zap-Token-Service.jar

ENTRYPOINT ["java", "-jar","Zap-Token-Service.jar"]
EXPOSE 8081