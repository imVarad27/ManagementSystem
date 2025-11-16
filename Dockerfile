# Stage 1: Use a full JDK to build the application
FROM eclipse-temurin:25-jdk-jammy as builder

# Set the working directory
WORKDIR /workspace

# Copy the build files and source code
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src

# Build the application (and run tests)
RUN ./mvnw package -DskipTests

# Stage 2: Use a minimal JRE for the final, small image
FROM eclipse-temurin:25-jre-jammy

# Set a new working directory
WORKDIR /app

# Copy ONLY the built JAR file from the 'builder' stage
COPY --from=builder /workspace/target/*.jar app.jar

# Expose the port your Spring Boot app runs on (default 8080)
EXPOSE 8080

# The command to run your application
ENTRYPOINT ["java", "-jar", "app.jar"]