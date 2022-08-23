FROM openjdk:11.0.16-slim
COPY target/todo-1.0.3.jar todo-1.0.3.jar
RUN mkdir -p /opt/arqui_software/logs
VOLUME /opt/arqui_software/logs
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh
ENV DATABASE_NAME "test"
ENV PASSWORD "my-secret-pw"
ENV USERNAME "root"
ENV IP "localhost"
ENTRYPOINT ["./wait-for-it.sh","mysql:3306","--","java","-jar","/todo-1.0.3.jar"]