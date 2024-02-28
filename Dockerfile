#Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

#Information around who maintains the image
MAINTAINER marlonenyapwere

# Add the application's jar to the image
COPY target/erp-service.jar erp-service.jar

# execute the application
ENTRYPOINT ["java", "-jar", "erp-service.jar"]