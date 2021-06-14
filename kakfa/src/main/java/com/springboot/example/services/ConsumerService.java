package com.springboot.example.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
	
	@KafkaListener(topics= "CustomTopic", groupId= "group_id")
	public void receivedMessage(String message) {
		System.out.println("Recieved message in our class "+message);
	}
	
}
