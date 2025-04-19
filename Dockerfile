# Stage 1: Build the JAR
FROM maven:3.9.0-eclipse-temurin-17 AS builder

WORKDIR /app
COPY . .

# ✅ Make mvnw executable
RUN chmod +x mvnw

# 🛠️ Build the project
RUN ./mvnw clean package -DskipTests

# Stage 2: Run the app
FROM eclipse-temurin:17-jdk

WORKDIR /app
COPY --from=builder /app/target/tournex.jar tournex.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "tournex.jar"]
