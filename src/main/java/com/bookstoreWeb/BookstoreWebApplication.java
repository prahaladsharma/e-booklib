package com.bookstoreWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



@SpringBootApplication
@EnableJpaAuditing
@ComponentScan("com.bookstoreWeb")
public class BookstoreWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreWebApplication.class, args);
	}

	
}
