package com.springboot.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class ProducerService {
	private static final String Topic = "CustomTopic";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void send(String message) {
		ListenableFuture<SendResult<String, String>> future = this.kafkaTemplate.send(Topic, message);
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
			@Override
			public void onFailure(Throwable ex) {
				System.out.println("Sending message failed with exception "+ ex.getMessage());
			}

			@Override
			public void onSuccess(SendResult<String, String> result) {
				System.out.println("Message Sent "+ message+ " to topic "+ result.getRecordMetadata().topic() + 
						" And offset is "+ result.getRecordMetadata().offset());
			}
		});
		
	}
	
}
