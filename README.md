# kafka-mysql_spring-boot
## What is under the hood
* **baypal** - a spring boot microservice which is responsible for REST API to make payments and get payees and mpayment methods.
* **docker-kafka-standalone** - a docker Kafka stand alone container. Make it possible to run locally kafka with zookeeper wihtout having docker compose installed.
* **risk-engine** - a microservice which checks a risk of the payment.
