package com.instamint.services.ds;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.header.Header;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class Consumer implements Runnable {
    @Override
    public void run() {
        //System.out.println("Starting Consumer");
        Duration timeout = Duration.ofMillis(100);
        Properties props = new Properties();
        props.put("bootstrap.servers","kb.instamint.com:9092");
        props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("group.id","storage");
        Jsonb jsonb = JsonbBuilder.create();
        KafkaConsumer consumer = new KafkaConsumer<String,String>(props);
        consumer.subscribe(Collections.singletonList("service.ds"));
        System.out.println("Consumer starting");
        while (true) {
            ConsumerRecords<String,String> records = consumer.poll(timeout);
            for (ConsumerRecord<String,String> r : records) {
//                System.out.println(r.key() + " " + r.value());
                System.out.println(r.value());
                Request request = jsonb.fromJson(r.value(),Request.class);
                System.out.println(request.getIssuerID() + " "
                        + request.getEnv() + " "
                        + request.getLinger() + " "
                        + request.getChain() + " "
                        + request.getAssetTypeID() + " "
                        + request.getAssetTypeID() + " "
                        + request.getStorage()
                );
                System.out.println(request.getAsset().get("maturityDate"));
                System.out.println(request.getAsset().get("serialNumber"));
                System.out.println(request.getReferences());
//                for (Header h : r.headers()) {
//                    System.out.println(h.key()+","+h.value());
//                }
            }
        }
    }
}
