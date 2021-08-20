package com.payconique.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = {"com.payconique.demo.controller", "com.payconique.demo.controller.service"})
public class StackListApplication {

	public static void main(String[] args) {
		SpringApplication.run(StackListApplication.class, args);
	}

}
