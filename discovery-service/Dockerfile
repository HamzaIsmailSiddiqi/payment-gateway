FROM openjdk:17

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Zap-Discovery-Service.jar

ENTRYPOINT ["java", "-jar","Zap-Discovery-Service.jar"]
EXPOSE 8761