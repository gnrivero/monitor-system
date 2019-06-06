package com.atix.monitorsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MonitorSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitorSystemApplication.class, args);
	}

}
