package com.fbm.fretquiz;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
public class GuitarTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testDefaultGuitar() throws Exception
	{
		mockMvc.perform(get("/fbm/guitars")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name").value("6 String Guitar"))
		.andExpect(jsonPath("$.strings").isArray())
		.andExpect(jsonPath("$.strings[1].frets[1].note.noteType").value("FLAT"))
		.andExpect(jsonPath("$.strings[5]").exists())
		.andExpect(jsonPath("$.strings[6]").doesNotExist());;
	}
	
	@Test
	public void testSharps() throws Exception
	{
		mockMvc.perform(get("/fbm/guitars")
		.param("noteType", "SHARP"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.strings").isArray())
		.andExpect(jsonPath("$.strings[1].frets[1].note.noteType").value("SHARP"));
	}
	
	@Test
	public void testNumberOfFrets() throws Exception
	{
		mockMvc.perform(get("/fbm/guitars")
		.param("frets", "21"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.strings").isArray())
		.andExpect(jsonPath("$.strings[0].frets").isArray())
		.andExpect(jsonPath("$.strings[0].frets[20]").exists())
		.andExpect(jsonPath("$.strings[0].frets[21]").doesNotExist());		
	}
	
	@Test
	public void testNumberOfStrings() throws Exception
	{
		mockMvc.perform(get("/fbm/guitars?type=FOUR_STRING_BASS")
		.param("type", "FOUR_STRING_BASS"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.strings").isArray())
		.andExpect(jsonPath("$.strings[3]").exists())
		.andExpect(jsonPath("$.strings[4]").doesNotExist());
	}
	
	@Test
	public void testGetGuitarTypes() throws Exception
	{
		mockMvc.perform(get("/fbm/guitars/types")).andDo(print())
		.andExpect(status().isOk());
	}
}
