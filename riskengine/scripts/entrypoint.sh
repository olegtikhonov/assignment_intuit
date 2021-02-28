#! /bin/bash

exec java -jar riskengine-*.jar --logging.file=/app/logs/riskengine.log --spring.config.location=/app/config/application.properties
