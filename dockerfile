FROM adoptopenjdk/openjdk11:alpine-slim AS BUILD
ARG JAR_FILE=build/libs/Board-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
