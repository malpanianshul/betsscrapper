package com.bets.scrape.betscrapper.service.impl;

import java.time.Duration;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.bets.scrape.betscrapper.service.BaseBallScrapService;
@Service
public class BaseBallScrapServiceImpl implements BaseBallScrapService {
	
	public final WebClient webclient;
	
	private String baseballMockServerUrl = "http://localhost:30001/team";
	
	public BaseBallScrapServiceImpl() {
		webclient = WebClient.builder().baseUrl(baseballMockServerUrl).build();
	}
	
	
	public Optional<String> scrapBaseBall(){
		Optional<String> blockOptional = webclient.get().uri("/more").retrieve().bodyToMono(String.class).retry(1).doOnError(WebClientResponseException.class, e-> logError(e,"URL")).blockOptional(Duration.ofMillis(1000000));
		return blockOptional;
	}


	private Object logError(WebClientResponseException e, String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
