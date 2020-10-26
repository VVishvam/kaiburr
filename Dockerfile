FROM openjdk:11-jdk-alpine
RUN apk add maven
COPY . .
RUN mvn install
EXPOSE 8080
ENTRYPOINT ["java","-jar","./target/KaiburrRest-0.0.1-SNAPSHOT.jar"]
