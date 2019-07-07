package com.bets.scrape.common;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bets.scrape.betscrapper.server.BetscrapperApplication;
import com.bets.scrape.mock.BaseballMockServer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=BetscrapperApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MockTestCommon {

	
	

	private BaseballMockServer baseallMockServer;
	private String baseballMockServerUrl = "http://localhost:30001/team";
	

	@Before
	public void baseSetup() throws Exception {
		baseallMockServer = BaseballMockServer.start(baseballMockServerUrl);
	}
	
	@After
	public void tearDown() throws Exception{
		baseallMockServer.shutDown();
	}
}
