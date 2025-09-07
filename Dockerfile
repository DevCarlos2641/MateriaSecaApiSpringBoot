FROM gradle:8.10.2-jdk21-alpine AS build

WORKDIR /app

# Copiamos los archivos necesarios para Gradle
COPY build.gradle.kts settings.gradle.kts gradlew ./
COPY gradle ./gradle

# Aseguramos que gradlew tenga permisos de ejecución
RUN chmod +x gradlew

# Descargamos dependencias (se cachea en capas)
RUN ./gradlew dependencies --no-daemon || return 0

# Copiamos el resto del código fuente
COPY . .

RUN chmod +x gradlew
# Construimos el JAR
RUN ./gradlew clean build -x test --no-daemon

# Run Time
FROM eclipse-temurin:21-jre-alpine AS runtime

WORKDIR /app

# Copiamos el JAR desde el build
COPY --from=build /app/build/libs/*.jar app.jar

# Usuario no root
RUN addgroup -S spring && adduser -S spring -G spring
USER spring

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
