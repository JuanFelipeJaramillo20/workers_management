# Build Stage
FROM maven:3.9.9-amazoncorretto-17-al2023 AS builder

# Install jq for JSON parsing
RUN dnf update -y && dnf install -y jq

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Final Stage
FROM openjdk

WORKDIR /app

COPY --from=builder /app/target/worker-management-app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
