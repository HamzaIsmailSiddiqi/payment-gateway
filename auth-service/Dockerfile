FROM openjdk:17

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Zap-Auth-Service.jar

ENTRYPOINT ["java", "-jar","Zap-Auth-Service.jar"]
EXPOSE 8082