FROM maven:3.9.9-amazoncorretto-17-al2023 AS builder

RUN apt-get update && apt-get install -y jq

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY --from=builder /app/target/worker-management-app.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
