FROM openjdk:17-jdk-alpine3.12
ARG JAR_FILE=target/*.jar
# Copia todos los archivos del proyecto
COPY ./target/Daruma-0.0.1-SNAPSHOT.jar app.jar
# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]