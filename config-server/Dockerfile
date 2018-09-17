FROM openjdk:8-jdk-alpine

VOLUME ["/tmp", "/tmp/config", "/tmp/logs"]

ENV TIME_ZONE Indochina

RUN apk --no-cache add \
	tzdata \
	&& echo "${TIME_ZONE}" > /etc/timezone \
	&& ln -sf /usr/share/zoneinfo/${TIME_ZONE} /etc/localtime

ADD /target/*.jar app.jar

EXPOSE 8888

ENTRYPOINT ["java","-jar","app.jar"]
