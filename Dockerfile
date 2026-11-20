FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /app

# 1. Copiar solo el pom.xml para aprovechar la caché de capas de Docker
COPY pom.xml .
RUN mvn dependency:go-offline

# 2. Copiar el código fuente y compilar
COPY src ./src
RUN mvn clean package -DskipTests

# Usamos la JRE de Alpine (mucho más ligera que la JDK completa)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app


# Copiar el JAR compilado desde la etapa "builder"
COPY --from=builder /app/target/*.jar app.jar

# Exponer el puerto por defecto de Spring Boot
EXPOSE 8080

# Ejecución con optimizaciones de JVM para contenedores
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]