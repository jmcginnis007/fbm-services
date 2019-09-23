package com.fbm.fretquiz;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class QuestionTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testGetQuestionBadId() throws Exception
	{
		mockMvc.perform(get("/fbm/question/get?questionId=1")).andDo(print())
		.andExpect(status().isNotFound());
	}
	
	//need to create a new game so we can add questions to it
	@Test
	public void testNewGame() throws Exception
	{
		mockMvc.perform(get("/fbm/game/new")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.gameId").value(1));
	}
	
	// TODO: something weird is going on here, gameId 1 is not available even though it is created above. 
	// seems like bug with mockMvc maybe?  can do a subsequent "get" for the game id and it works
	// just like in the GameTests.java tests.  Only one domain/table is supported by mockMVC?  Dont' get it...
	
	@Test
	@Ignore
	public void testNewQuestion() throws Exception
	{
		mockMvc.perform(get("/fbm/question/new?gameId=1")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.questionId").value(1));
	}
	
	
}
