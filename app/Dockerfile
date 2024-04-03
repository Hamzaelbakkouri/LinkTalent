
# Use the official OpenJDK 21 image as the base image
FROM openjdk:21-jdk-slim

# Copy the entire project into the container
COPY target/app-0.0.1-SNAPSHOT.jar app-0.0.1-SNAPSHOT.jar

# Expose the port your application will run on
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "target/app-0.0.1-SNAPSHOT.jar"]