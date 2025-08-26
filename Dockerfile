# =========================
# 1. Build stage
# =========================
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

# Copy Maven wrapper and pom.xml first (to cache dependencies)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies (layer caching)
RUN ./mvnw dependency:go-offline

# Copy application source code
COPY src ./src

# Build the Spring Boot JAR
RUN ./mvnw clean package -DskipTests

# =========================
# 2. Runtime stage
# =========================
FROM eclipse-temurin:17-jre

# Create non-root user
RUN addgroup --system spring && adduser --system --ingroup spring spring

WORKDIR /app

# Copy the JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Change file ownership
RUN chown spring:spring app.jar
USER spring

# Run the Spring Boot app
ENTRYPOINT ["java","-jar","app.jar"]

