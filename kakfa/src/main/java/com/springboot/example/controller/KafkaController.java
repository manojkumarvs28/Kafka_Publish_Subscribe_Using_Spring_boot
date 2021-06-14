package com.springboot.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.example.services.ProducerService;

@RestController
public class KafkaController {
	
	@Autowired
	private ProducerService producerService;

	@GetMapping("/kafka/publish")
	public String sendMessage(@RequestParam String message) {
		 producerService.send(message);
		 return "sent";
	}
	
}
