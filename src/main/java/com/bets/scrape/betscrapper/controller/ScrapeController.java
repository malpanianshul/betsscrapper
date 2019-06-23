package com.bets.scrape.betscrapper.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/api")
@Api(value="Baseball bets info")
public class ScrapeController {

	@GetMapping(path = "/", produces = "application/json")
	@ApiOperation(value="Get the baseball bets")
	@ApiResponses(value= {@ApiResponse(code=200,message="Get")})
	public String getEmployees() {
		return "Test";
	}
}
