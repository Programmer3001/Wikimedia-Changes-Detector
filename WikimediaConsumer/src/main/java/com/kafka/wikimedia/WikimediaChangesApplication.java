package com.kafka.wikimedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories( basePackages = {"com.kafka.*"} )
@EntityScan( basePackages = {"com.kafka.*"} )
@ComponentScan(basePackages = { "com.kafka.*" })
public class WikimediaChangesApplication {

	public static void main(String[] args) {
		SpringApplication.run(WikimediaChangesApplication.class, args);
	}

}
