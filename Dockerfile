FROM amazoncorretto:17-alpine3.17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} SIAP-1.0.jar
ENTRYPOINT ["java", "-jar", "/SIAP-1.0.jar"]
