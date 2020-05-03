package com.batch.rewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RewardsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RewardsAppApplication.class, args);
	}

}
