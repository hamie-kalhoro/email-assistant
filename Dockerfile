## -------- BUILD STAGE --------
#FROM eclipse-temurin:21-jdk AS build
#
## Set working directory
#WORKDIR /app
#
## Copy Maven wrapper & pom first (for dependency caching)
#COPY mvnw .
#COPY .mvn .mvn
#COPY pom.xml .
#
## Download dependencies
#RUN ./mvnw dependency:go-offline
#
## Copy source code
#COPY src src
#
## Build the application
#RUN ./mvnw clean package -DskipTests
#
#
## -------- RUNTIME STAGE --------
#FROM eclipse-temurin:21-jre
#
## Set working directory
#WORKDIR /app
#
## Copy jar from build stage
#COPY --from=build /app/target/*.jar app.jar
#
## Expose Spring Boot port
#EXPOSE 8080
#
## Run application
#ENTRYPOINT ["java", "-jar", "app.jar"]


#888888888888888888888888888888800000000000000000000000000000000000888

# -------- BUILD STAGE --------
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies (cache layer)
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src src

# Build the Spring Boot application
RUN ./mvnw clean package -DskipTests


# -------- RUNTIME STAGE --------
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy ONLY the executable Spring Boot JAR
COPY --from=build /app/target/email-writer-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
