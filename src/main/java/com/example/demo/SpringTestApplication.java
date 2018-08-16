package com.example.demo;

import com.example.demo.repository.RepositoriesInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class SpringTestApplication {
	@Autowired
	private RepositoriesInitializer initializer;
	@Bean
	public CommandLineRunner initialize()
	{
		return strings -> {
			initializer.iniialize();
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringTestApplication.class, args);
	}
}
