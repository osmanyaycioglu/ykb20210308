FROM openjdk:8-jdk-alpine
WORKDIR /project
COPY target/node-apigateway-1.0.0.jar xyz.jar
EXPOSE 80
ENTRYPOINT [ "sh","-c","java -DPORT=80 -DDISCOVERY=${DISCOVERY} -jar xyz.jar" ]
