package com.fbm.fretquiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbm.fretquiz.contract.GameSettings;
import com.fbm.fretquiz.domain.Game;
import com.fbm.fretquiz.domain.request.NewGameRequest;
import com.fbm.fretquiz.exception.NotFoundException;
import com.fbm.fretquiz.factory.GameSettingsFactory;
import com.fbm.fretquiz.repository.GameRepository;
import com.fbm.fretquiz.repository.QuestionRepository;

@Service
public class GameService {
	
	@Autowired
	GameRepository gameRepository;
	
	@Autowired
	QuestionRepository questionRepository;
	
	public Game getGame(Long id) throws NotFoundException {
		
		Game game = gameRepository.findOne(id);
		
		if (game == null) throw new NotFoundException("game", id.toString());
		
		return game;
	}
	
	public GameSettings getGameSettings(Long id) throws NotFoundException{

		Game game = gameRepository.findOne(id);
		
		if (game == null) throw (new NotFoundException("game", id.toString()));
		
		GameSettings gameOptions = GameSettingsFactory.getGameOptions(
				game.getDifficultyLevel(), 
				game.getNumberOfFrets(), 
				game.getPracticeMode(), 
				game.getQuestionType());
		
		return gameOptions;
	}
	
	public Game newGame(NewGameRequest newGame) {
		
		Game game = new Game(newGame);
		
		gameRepository.save(game);
		//TODO: handle error
        return game;
	}
}
