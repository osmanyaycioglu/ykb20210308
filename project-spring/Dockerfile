FROM openjdk:8-jdk-alpine
WORKDIR /project
COPY target/project-spring-1.0.0.jar xyz.jar
EXPOSE 9090
ENV MYENV=osman
ENV JRUN=-Xmx256m
ENTRYPOINT [ "sh","-c","java ${JRUN} -jar xyz.jar" ]
