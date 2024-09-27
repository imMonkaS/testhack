FROM openjdk:22

ARG JAR_FILE=/target/*.jar

EXPOSE 6701

WORKDIR /project

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]
