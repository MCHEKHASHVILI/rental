package com.mchekhashvili.rental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class RentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalApplication.class, args);
	}
}
