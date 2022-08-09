FROM openjdk:11.0.16-slim
COPY target/todo-1.0.1.jar todo-1.0.1.jar
RUN mkdir -p /opt/arqui_software/logs
VOLUME /opt/arqui_software/logs
ENTRYPOINT ["java","-jar","/todo-1.0.1.jar"]