package com.ericknunes.ericknunes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ericknunes.ericknunes.backend.persistence.repositories")
public class EricknunesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EricknunesApplication.class, args);
	}
}
