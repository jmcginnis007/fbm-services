package com.fbm.fretquiz.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fbm.fretquiz.contract.GameSettings;
import com.fbm.fretquiz.domain.Game;
import com.fbm.fretquiz.domain.request.NewGameRequest;
import com.fbm.fretquiz.service.GameService;

@RestController
@RequestMapping("/fbm/games")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping(value = "/{id}")
	@ResponseBody
	public Game getGame(@PathVariable("id") Long id)
	{
		
		return gameService.getGame(id);
	}
	
	@GetMapping(value = "/{id}/settings")
	@ResponseBody
    public GameSettings getGameSettings(@PathVariable("id") Long id)			
	{
		return gameService.getGameSettings(id);
	}
	
	@PostMapping
	@ResponseBody
    public Game newGame(@RequestBody @Valid NewGameRequest newGame)		
    {		
		return gameService.newGame(newGame);
    }
}
