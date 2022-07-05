FROM openjdk:8
MAINTAINER Piyush<senditto.piyush@gmail.com>
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/hm-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} hm-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","hm-0.0.1-SNAPSHOT.jar"]