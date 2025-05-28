# Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

# Add Maintainer Info
LABEL maintainer="savindu29"

# Set the working directory
WORKDIR /app

# Install curl and other useful utilities
RUN apt-get update && \
    apt-get install -y curl && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Copy the jar file from the target directory
COPY target/configserver-0.0.1-SNAPSHOT.jar /app/configserver-0.0.1-SNAPSHOT.jar

# Expose the port the application runs on
EXPOSE 8071

# Execute the jar file
ENTRYPOINT ["java", "-jar", "/app/configserver-0.0.1-SNAPSHOT.jar"]


