package com.instamint.services.ds;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Producer implements Runnable {
    @Override
    public void run()  {
        List<String> words = Arrays.asList("1","2","3","4","5");
        Scanner console = new Scanner(System.in);
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        Random rand = new Random();
        Properties props = new Properties();
        props.put("bootstrap.servers","kb.instamint.com:9092");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("client.id","instamint");
        KafkaProducer producer = new KafkaProducer<String,String>(props);
        String msg = "{\n" +
                "\t\"issuerID\": \"959980e5ff59427AbbC54c59FfF22809\",\n" +
                "\t\"assetID\": \"assetid321\",\n" +
                "\t\"command\": \"mint\",\n" +
                "\t\"chain\": \"ethereum\",\n" +
                "\t\"env\": \"testnet\",\n" +
                "\t\"linger\": \"86400\",\n" +
                "\t\"contract\": \"INSTA1\",\n" +
                "\t\"b2bCrossReferenceID\": \"4230402830\",\n" +
                "\t\"strategy\": \"real\",\n" +
                "\t\"assetTypeID\": \"J1234\",\n" +
                "\t\"asset\": {\n" +
                "\t\t\"maturityDate\": \"11/1/2068\",\n" +
                "\t\t\"serialNumber\": \"A12345\"\n" +
                "\t},\n" +
                "\t\"references\": {\n" +
                "\t\t\"image\": \"https://s3-prod-europe.autonews.com/s3fs-public/styles/1200x630/public/Lamborghini%20Huracan%20STO%20web.jpg\"\n" +
                "\t},\n" +
                "\t\"storage\": \"ipfs\",\n" +
                "\t\"fractionalization\": \"0\",\n" +
                "\t\"royalties\": {\n" +
                "\t\t\"scheme\": \"standard\"\n" +
                "\t},\n" +
                "\t\"chainSpecific\": {\n" +
                "\n" +
                "\t}\n" +
                "}";
        while (true) {
            //msg = words.get(rand.nextInt(words.size()));
            ProducerRecord<String,String> message = new ProducerRecord<>("service.ds","Precision",msg);
            producer.send(message);
            producer.flush();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
