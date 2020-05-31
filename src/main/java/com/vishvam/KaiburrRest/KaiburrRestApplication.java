package com.vishvam.KaiburrRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class KaiburrRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaiburrRestApplication.class, args);
	}

}
