package com.mybracket;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories(basePackages="com.mybracket.repository")
@EntityScan(basePackages="com.mybracket.entity")
@ComponentScan(basePackages="com.mybracket")
@SpringBootApplication
public class MybracketBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybracketBackendApplication.class, args);
	}

}
