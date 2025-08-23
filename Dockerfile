# syntax=docker/dockerfile:1.7

############################
# 1) Build stage
############################
FROM maven:3.9.9-eclipse-temurin-21 AS build
LABEL authors="Devian"
WORKDIR /app

# Cache deps first
COPY pom.xml .
RUN --mount=type=cache,target=/root/.m2 mvn -q -DskipTests dependency:go-offline

# Build
COPY src ./src
RUN --mount=type=cache,target=/root/.m2 mvn -q -DskipTests package

############################
# 2) Run stage
############################
FROM eclipse-temurin:21-jre
ENV APP_HOME=/opt/app \
    JAVA_TOOL_OPTIONS="-XX:MaxRAMPercentage=75"
WORKDIR ${APP_HOME}

# Copy the fat jar and rename to app.jar
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Use the 'docker' Spring profile
ENV SPRING_PROFILES_ACTIVE=docker

ENTRYPOINT ["java","-jar","app.jar"]
