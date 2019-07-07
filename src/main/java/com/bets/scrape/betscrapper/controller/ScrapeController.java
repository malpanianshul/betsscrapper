package com.bets.scrape.betscrapper.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bets.scrape.betscrapper.service.BaseBallScrapService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping(path = "/api")
@Api(value="Baseball bets info")
public class ScrapeController {

	
	private final BaseBallScrapService baseBallScrapService;
	
	@Autowired
	public ScrapeController(BaseBallScrapService baseBallScrapService) {
		this.baseBallScrapService = baseBallScrapService;
	}
	
	//private static final Logger LOGGER = LogManager.getLogger(ScrapeController.class);
	 
	@GetMapping(path = "/", produces = "application/json")
	@ApiOperation(value="Get the baseball bets")
	@ApiResponses(value= { @ApiResponse(code=200, message="Get Successful")})
	public @ResponseBody String getBets() {
		Optional<String> scrapBaseBall = baseBallScrapService.scrapBaseBall();
		
		if(scrapBaseBall.isPresent())
			System.out.println(scrapBaseBall.get());
		else
			System.out.println("something wrong");
		return "Test Response";
	}
}
