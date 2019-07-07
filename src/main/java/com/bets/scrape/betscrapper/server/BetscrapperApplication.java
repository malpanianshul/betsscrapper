package com.bets.scrape.betscrapper.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.bets.scrape.betscrapper.server.config.Swagger2Config;

@SpringBootApplication(scanBasePackages="com.bets.*")
@Import(Swagger2Config.class)
public class BetscrapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetscrapperApplication.class, args);
	}

}
