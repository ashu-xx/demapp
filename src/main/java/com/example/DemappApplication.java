package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@SpringBootApplication()
public class DemappApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemappApplication.class, args);
	}
}