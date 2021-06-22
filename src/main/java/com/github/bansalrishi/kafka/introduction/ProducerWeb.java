package com.github.bansalrishi.kafka.introduction;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerWeb {
    public static void main(String[] args) {
        String bootStrapServers = "127.0.0.1:9092";
        System.out.println("Hello World");

        // create Properties for Producer
        Properties properties = new Properties();
        //properties.setProperty("bootstrap.servers", bootStrapServers);
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG , bootStrapServers);
        //properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //properties.setProperty("value.serializer", StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());


        //create the Producer
        KafkaProducer<String, String> producer =  new KafkaProducer<String, String>(properties);

        // create a producer record
        ProducerRecord<String, String> record = new ProducerRecord<>("hello_world", "Hello New World");
        // sending the data
        producer.send(record);
    }
}
