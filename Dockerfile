FROM openjdk:8
MAINTAINER Piyush<senditto.piyush@gmail.com>
VOLUME /tmp
ADD target/hm-0.0.1-SNAPSHOT.jar hm-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["-java","-jar","hm-0.0.1-SNAPSHOT.jar"]