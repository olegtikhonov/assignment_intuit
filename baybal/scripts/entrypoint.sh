#! /bin/bash

exec java -jar baybal-*.jar --logging.file=/app/logs/baybal.log --spring.config.location=/app/config/application.properties
