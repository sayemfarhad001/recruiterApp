package com.recruiter.recruiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



// @SpringBootApplication
// @ComponentScan({"services"})
// @EntityScan("model")
// @EnableJpaRepositories("repository")
@SpringBootApplication
// @ComponentScan({"com.delivery.request"})
// @EntityScan("com.delivery.domain")
// @EnableJpaRepositories("com.delivery.repository")
public class RecruiterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruiterApplication.class, args);
	}

}
