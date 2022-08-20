package com.api.apicrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApiCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCrudApplication.class, args);
	}

}
