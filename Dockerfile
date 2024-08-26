# Step 1: Builder
FROM eclipse-temurin:17-jdk as builder
COPY . /app
WORKDIR /app
RUN chmod 777 ./gradlew
RUN ./gradlew build -x check

# Step 2: Final
FROM eclipse-temurin:17-jre
COPY --from=builder /app/build/libs/exercise-storage-task.jar /app/
CMD ["java","-jar","/app/exercise-storage-task.jar"]
