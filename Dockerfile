FROM openjdk:17-alpine
ARG JAR_FILE=target/spring-boot-65-final-1.0.0.jar
RUN mkdir /c65
WORKDIR /c65
COPY ${JAR_FILE} /c65
ENTRYPOINT java -jar /c65/spring-boot-65-final-1.0.0.jar