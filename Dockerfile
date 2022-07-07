FROM openjdk:8
MAINTAINER Piyush<piyush@gmail.com>
EXPOSE 8080
ARG JAR_FILE=target/hm-0.0.1-SNAPSHOT.war
ADD ${JAR_FILE} hm-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java","-jar","hm-0.0.1-SNAPSHOT.war"]