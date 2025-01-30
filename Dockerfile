FROM openjdk:21-jdk-slim

WORKDIR /app

# Copy the built Spring Boot JAR file
COPY target/library-app.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]