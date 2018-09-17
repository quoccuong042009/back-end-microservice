FROM openjdk:8-jdk-alpine

VOLUME ["/tmp", "/tmp/config", "/tmp/logs"]

ENV TIME_ZONE Indochina

RUN apk --no-cache add \
	tzdata \
	&& echo "${TIME_ZONE}" > /etc/timezone \
	&& ln -sf /usr/share/zoneinfo/${TIME_ZONE} /etc/localtime

ADD /target/*.jar app.jar

EXPOSE 8765

COPY wait-for /wait-for

CMD sh -c './wait-for eureka-server:8761' &&  java -jar app.jar
