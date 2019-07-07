package com.bets.scrape.betscrapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.bets.scrape.common.MockTestBase;



public class BetscrapperApplicationTests extends MockTestBase{
	
	@Autowired
	MockMvc mockMvc;

	@Test
	public void contextLoads() throws Exception {
		
		MvcResult result = mockMvc.perform(get("/api/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		
		String resultText  =result.getResponse().getContentAsString();
		
		System.out.println(resultText);
	}


}
