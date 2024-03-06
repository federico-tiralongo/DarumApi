# Usa una imagen base compatible con Fly.io
FROM maven:3.8.4-openjdk-17

# Crea el directorio de la aplicación
RUN mkdir /app
WORKDIR /app

# Copia solo el archivo pom.xml para descargar las dependencias
COPY pom.xml .

# Descarga las dependencias de Maven (esto aprovecha el caché si el pom.xml no ha cambiado)
RUN mvn -B dependency:resolve dependency:resolve-plugins

# Copia todos los archivos del proyecto
COPY . .

# Empaqueta la aplicación
RUN mvn -B package -DskipTests

# Expone el puerto en el que la aplicación se ejecutará
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "target/Daruma-0.0.1-SNAPSHOT.jar"]