# Docker 镜像构建

FROM openjdk:8-jdk-alpine

ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY api-backend-0.0.1-SNAPSHOT.jar /api-backend.jar

# Run the web service on container startup.
ENTRYPOINT ["java","-jar","/api-backend.jar"]