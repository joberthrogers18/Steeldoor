#
# Build stage
#

FROM maven:3.6.3-jdk-11-slim AS build

WORKDIR usr/src/app

COPY . ./

RUN mvn clean package

#
# Package stage
#

FROM openjdk:11-jre-slim

ARG JAR_NAME="SteelDoor-1.0.0"

WORKDIR /usr/src/app

EXPOSE ${HTTP_PORT}

COPY --from=build /usr/src/app/target/${JAR_NAME}.jar ./app.jar

CMD ["java","-jar", "./app.jar"]