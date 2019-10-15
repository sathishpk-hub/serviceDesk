package com.energia.ticket.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan( basePackages = { "com.energia.ticket", "org.springframework.jms" ," org.springframework.jms.core", "org.hibernate"} )
@EnableJpaRepositories("com.energia.ticket.repository")
@EntityScan("com.energia.ticket.entity")
public class ServiceDeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDeskApplication.class, args);
	}

}
