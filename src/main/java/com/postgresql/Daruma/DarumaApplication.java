package com.postgresql.Daruma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaRepositories
// This anotation allos running without a datasource running. Uncomment it if
// you with to deploy locally without deploying postgresql
public class DarumaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DarumaApplication.class, args);
	}

}