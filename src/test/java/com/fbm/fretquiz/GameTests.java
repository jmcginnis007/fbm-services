package com.fbm.fretquiz;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fbm.fretquiz.domain.DifficultyLevel;
import com.fbm.fretquiz.domain.Game;
import com.fbm.fretquiz.domain.GuitarType;
import com.fbm.fretquiz.domain.NoteType;
import com.fbm.fretquiz.domain.QuestionType;
import com.fbm.fretquiz.domain.request.NewGameRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GameTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testGetGameBadId() throws Exception
	{
		mockMvc.perform(get("/fbm/games/0")).andDo(print())
		.andExpect(status().isNotFound());
	}
	
	@Test
	public void testNewGame() throws Exception
	{
		NewGameRequest newGameRequest = new NewGameRequest(
				GuitarType.FOUR_STRING_BASS, 
				20, 
				NoteType.FLAT, 
				QuestionType.FIND_THE_NOTE, 
				DifficultyLevel.EASY, 
				false, 
				20);
		
		Game newGameResponse = getNewGame(newGameRequest);
		
		assertTrue("unexepected id value", newGameResponse.getGameId() >= 1L );
	}
	
	@Test
	public void testGetGameGoodId() throws Exception
	{
		mockMvc.perform(get("/fbm/games/1")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.gameId").value(1));
	}
	
	@Test
	public void testGetGameSettings() throws Exception
	{
		mockMvc.perform(get("/fbm/games/1/settings")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.minFret").exists())
		.andExpect(jsonPath("$.maxFret").exists())
		.andExpect(jsonPath("$.minFret").value(1));
	}
	
	@Test
	public void testGetGameSettingsMaster() throws Exception
	{
		NewGameRequest newGameRequest = new NewGameRequest(
				GuitarType.FOUR_STRING_BASS, 
				20, 
				NoteType.FLAT, 
				QuestionType.FIND_THE_NOTE, 
				DifficultyLevel.MASTER, 
				false, 
				20);
		
		Game newGameResponse = getNewGame(newGameRequest);
		
		mockMvc.perform(get("/fbm/games/" + newGameResponse.getGameId() + "/settings")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.minFret").exists())
		.andExpect(jsonPath("$.maxFret").exists())
		.andExpect(jsonPath("$.minFret").value(9))
		.andExpect(jsonPath("$.showOpenNotes").value(false))
		.andExpect(jsonPath("$.openNotesEnabled").value(false))
		.andExpect(jsonPath("$.showNotesEnabled").value(false))
		.andExpect(jsonPath("$.showFretNumbersEnabled").value(false));
	}
	
	
	@Test
	public void testGetGameOptionsPractice() throws Exception
	{
		NewGameRequest newGameRequest = new NewGameRequest(
				GuitarType.FOUR_STRING_BASS, 
				20, 
				NoteType.FLAT, 
				QuestionType.FIND_THE_NOTE, 
				DifficultyLevel.EASY, 
				true, //practiceMode = true
				20);
		
		Game newGameResponse = getNewGame(newGameRequest);
		
		mockMvc.perform(get("/fbm/games/" + newGameResponse.getGameId() + "/settings")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.minFret").exists())
		.andExpect(jsonPath("$.maxFret").exists())
		.andExpect(jsonPath("$.minFret").value(1))
		.andExpect(jsonPath("$.showOpenNotes").value(true))
		.andExpect(jsonPath("$.openNotesEnabled").value(true))
		.andExpect(jsonPath("$.showNotesEnabled").value(true))
		.andExpect(jsonPath("$.showFretNumbersEnabled").value(true));
	}
	
	@Test
	public void testGetGameOptionsPracticeNoId() throws Exception
	{
		mockMvc.perform(get("/fbm/games/options?practicemode=true")).andDo(print())
		.andExpect(status().is4xxClientError());
	}
	
	private Game getNewGame(NewGameRequest newGameRequest) throws Exception {
		ResultActions resultActions = 
				mockMvc.perform(post("/fbm/games/")
				.content(asJsonString(newGameRequest))
				.contentType(MediaType.APPLICATION_JSON)
			    .accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
		
		MvcResult result = resultActions.andReturn();
		String content = result.getResponse().getContentAsString();
		Game newGameResponse = new ObjectMapper().readValue(content, Game.class);
		
		return newGameResponse;
		
	}
	
	private static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}