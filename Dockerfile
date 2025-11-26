# Etapa 1: compilar el proyecto
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copiamos pom y código fuente
COPY pom.xml .
COPY src ./src

# Compilamos el jar (sin tests para ir más rápido)
RUN mvn -B -DskipTests clean package

# Etapa 2: imagen ligera sólo con el JRE
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copiamos el jar generado
COPY --from=build /app/target/*.jar app.jar

# Nuestro Spring Boot está escuchando en el puerto 8081
EXPOSE 8081

# Arrancar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
