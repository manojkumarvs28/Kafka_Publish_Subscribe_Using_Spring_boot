package com.springboot.example.kakfa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springboot.example.controller", 
							   "com.springboot.example.configurations", 
							   "com.springboot.example.services"})
public class KakfaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KakfaApplication.class, args);
	}

}
