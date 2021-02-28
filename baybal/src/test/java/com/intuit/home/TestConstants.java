package com.intuit.home;


public final class TestConstants {
    public static final String KAFKA_BOOTSTRAP = "localhost:9092";
    public static final String KAFKA_TOPIC = "kafka-test-topic";
    public static final Integer PARTITION_NUMBER = 1;
    public static final Short REPLICATION_FACTOR = 3;

    public static final String GET_PAYMENT_METHODS = "/payment/method/%s";
    public static final String MAKE_PAYMENT = "/payment";
    public static final String GET_PAYEES = "/payee";
}
