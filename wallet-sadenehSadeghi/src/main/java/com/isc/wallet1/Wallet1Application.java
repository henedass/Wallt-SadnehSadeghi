package com.isc.wallet1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Wallet1Application {

	public static void main(String[] args) {
		SpringApplication.run(Wallet1Application.class, args);
	}

}
