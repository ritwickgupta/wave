package com.example.wave.payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PayrollApplication {

	static Logger log = LoggerFactory.getLogger(PayrollApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PayrollApplication.class, args);
		log.info("Server Started");
	}
}
