FROM openjdk:8u181-jdk

ENV JAR_FILE=riskengine-1.0-SNAPSHOT.jar

ADD target/riskengine-1.0-SNAPSHOT.jar riskengine-1.0-SNAPSHOT.jar


ADD scripts/entrypoint.sh entrypoint.sh
RUN chmod 755 entrypoint.sh

RUN mkdir -p /app/config
RUN chmod 755 /app/config
ADD src/main/resources/application.properties /app/config/application.properties

RUN mkdir -p /app/logs
RUN chmod 755 /app/config

CMD ["./entrypoint.sh"]
