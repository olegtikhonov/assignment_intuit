## How to run and use this module
### What to do
Design and implement REST API using Maven, JAX-RS, Spring and Tomcat [or Spring Boot]. 
Consider REST API design practices, response codes and bodies, error codes and bodies, naming conventions, testability etc.


Some consideration:
* JSR 354 – “Currency and Money” addresses the standardization of currencies and monetary amounts in Java.

## Make payment
Payment
```
{"amount":70.6,"currency":"CAD","userId":"9c6d348c-f343-46a1-9515-76ea01a8a3a2","payeeId":"67be12dd-6abe-4da2-8114-d115ec2a038b","paymentMethodId":"1a044dd5-096d-404c-a479-2477984ae4ae"}
```

Send payment request
```
curl 127.0.0.1:6767/payment -X POST -H "Content-Type: application/json" -d '{"amount":45.78,"currency":"USD","userId":"b16a6440-9b2a-11e9-a885-0242ac110003","payeeId":"b16d9139-9b2a-11e9-a885-0242ac110003","paymentMethodId":"b1721f63-9b2a-11e9-a885-0242ac110003"}'
```

Get all payments by userID
```
curl 127.0.0.1:6767/payment/method/dddd
```

Get payees
```
curl -s 127.0.0.1:6767/payee | python -m json.tool
```

## How to install Kafka with Zookeeper
```
git clone from my repo
```
Next,
```
docker build -t arm/kafka:221 .
```

Next,
```
docker run -p 2181:2181 -p 9092:9092 --env KAFKA_LISTENERS=LISTENER_BOB://localhost:9092,LISTENER_ALICE://172.17.0.1:9092 --name kafka -d -it arm/kafka:221 sleep 50000
```
where ```2181``` is a Zookeeper port, ```9092``` - kafka bootstrap server port 

Start Zookeeper
```
./bin/zookeeper-server-start.sh config/zookeeper.properties &
```

Start Kafka
```
./bin/kafka-server-start.sh config/server.properties &
```


Test Kafka
### Create a topic
```
echo $KAFKA_HOME
```
```
$KAFKA_HOME/bin/zookeeper-server-start.sh config/zookeeper.properties
```
```
$KAFKA_HOME/bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test
/opt/kafka_2.12-2.2.1/bin/kafka-topics.sh --list --bootstrap-server localhost:9092
```
This module serves as a Publisher, i.e. puts payment request into queue
Fraud analytics - is a consumer

https://www.wibmo.co/fraud-and-risk-management/

## Create new topic
```
mvn archetype:generate -DgroupId=com.intuit.home -DartifactId=riskengine -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Create a docker
```
docker build -t baybal:100 .
```

## Deploy baybal
```
docker run -p 6767:6767 --name baybal -d baybal:100
```

## How to get to the swagger UI
```
http://localhost:6767/swagger-ui.html
```

### About topics
We have to create two topics: one for payments, and the second - for responses

Things to do:
1. Create here a kafka messages consumer
2. Add kafka messages producer into risk-management
3. remove user-id url_callback
