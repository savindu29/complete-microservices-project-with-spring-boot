FROM openjdk:17-jdk-slim

LABEL maintainer="savindu29"

WORKDIR /app

RUN apt-get update && \
    apt-get install -y curl && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

COPY target/eurekaserver-0.0.1-SNAPSHOT.jar /app/eurekaserver-0.0.1-SNAPSHOT.jar

EXPOSE 8761

# Complete override - this will force Spring Boot to ignore the built-in application.properties
ENTRYPOINT ["java", "-jar", "/app/eurekaserver-0.0.1-SNAPSHOT.jar", \
    "--spring.config.import=optional:configserver:http://configserver:8071/", \
    "--spring.config.location=classpath:/application.properties", \
    "--spring.cloud.config.uri=http://configserver:8071/", \
    "--eureka.client.register-with-eureka=false", \
    "--eureka.client.fetch-registry=false"]