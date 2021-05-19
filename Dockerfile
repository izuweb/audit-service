FROM openjdk:11-jdk-slim
EXPOSE 8080
RUN mkdir /app
ARG JAR_FILE=/target/audit-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /app/audit.jar
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar  /app/audit.jar"]