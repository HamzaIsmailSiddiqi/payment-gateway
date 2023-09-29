FROM openjdk:17

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Zap-User-Service.jar

ENTRYPOINT ["java", "-jar","Zap-User-Service.jar"]
EXPOSE 8083