# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container at /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Expose the port your Spring Boot app will run on
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "/app.jar"]