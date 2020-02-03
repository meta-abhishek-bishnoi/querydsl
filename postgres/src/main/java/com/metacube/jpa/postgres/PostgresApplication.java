package com.metacube.jpa.postgres;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostgresApplication {
	public static void main(String[] args) {
		SpringApplication.run(PostgresApplication.class, args);
	}
}
