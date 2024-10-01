package com.test.testhack;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@AutoConfiguration
@OpenAPIDefinition(info = @Info(title = "My API", version = "1.0", description = "My API Description"))
public class TesthackApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesthackApplication.class, args);
	}

}
