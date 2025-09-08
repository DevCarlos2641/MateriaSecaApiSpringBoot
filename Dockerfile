# Etapa de build
FROM gradle:8.10.2-jdk21-alpine AS build

WORKDIR /app

# Copiamos solo lo necesario primero (para cache de dependencias)
COPY build.gradle.kts settings.gradle.kts gradlew ./
COPY gradle ./gradle

RUN chmod +x gradlew

# Descargamos dependencias (cacheadas en capas)
RUN ./gradlew dependencies --no-daemon || return 0

# Copiamos el resto del código fuente
COPY . .

# Construimos el jar ejecutable con nombre fijo
RUN ./gradlew clean bootJar -x test --no-daemon \
    && mv build/libs/app.jar app.jar

# Etapa de runtime
FROM eclipse-temurin:21-jre-alpine AS runtime

WORKDIR /app

# Copiamos el jar generado en build
COPY --from=build /app/app.jar app.jar

# Usuario no root
RUN addgroup -S spring && adduser -S spring -G spring
USER spring

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]