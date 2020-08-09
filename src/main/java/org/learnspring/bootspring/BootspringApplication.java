package org.learnspring.bootspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BootspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootspringApplication.class, args);
	}

}
