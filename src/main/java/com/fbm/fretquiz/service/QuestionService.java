package com.fbm.fretquiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbm.fretquiz.domain.Game;
import com.fbm.fretquiz.domain.Question;
import com.fbm.fretquiz.domain.request.NewQuestionRequest;
import com.fbm.fretquiz.exception.GameOverException;
import com.fbm.fretquiz.exception.NotFoundException;
import com.fbm.fretquiz.factory.QuestionFactory;
import com.fbm.fretquiz.repository.GameRepository;
import com.fbm.fretquiz.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public Question newQuestion(NewQuestionRequest newQuestionRequest) {
		Long gameId = newQuestionRequest.getGameId();
        Game game = gameRepository.findOne(gameId);
        if (game == null) throw (new NotFoundException("game", gameId.toString()));
        
        if (game.isGameCompleted())
        {
        	throw new GameOverException(gameId.toString());
        }
        
        Question previousQuestion = (game.getQuestions().size() > 0 ? game.getQuestions().get(game.getQuestions().size() - 1) : null);
                
        Question question = QuestionFactory.getQuestion(game.getGuitarType(), 
        		game.getDifficultyLevel(), 
        		game.getNumberOfFrets(), 
        		game.getPracticeMode(), 
        		game.getQuestionType(), 
        		game.getNoteType(),
        		previousQuestion);
        
        game.addQuestion(question);
    
        questionRepository.save(question);
        gameRepository.save(game);
        //TODO: handle save errors
        //TODO: create a transaction so both saves can be rolledback if 2nd save fails?
        
        return question;
	}
	
	public Question getExistingQuestion(Long id) {
		
		Question question = questionRepository.findOne(id);
		
		if (question == null) throw (new NotFoundException("question", id.toString()));
		
		return question;
	}
}
