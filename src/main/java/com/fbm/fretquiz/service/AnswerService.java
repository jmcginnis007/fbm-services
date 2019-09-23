package com.fbm.fretquiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbm.fretquiz.domain.Answer;
import com.fbm.fretquiz.domain.Game;
import com.fbm.fretquiz.domain.Guitar;
import com.fbm.fretquiz.domain.Question;
import com.fbm.fretquiz.domain.request.AnswerRequest;
import com.fbm.fretquiz.exception.NotFoundException;
import com.fbm.fretquiz.factory.AnswerFactory;
import com.fbm.fretquiz.factory.GuitarFactory;
import com.fbm.fretquiz.repository.GameRepository;
import com.fbm.fretquiz.repository.QuestionRepository;

@Service
public class AnswerService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public Answer getAnswer(AnswerRequest answerRequest)
	{
		Question question = questionRepository.findOne(answerRequest.getQuestionId());
		if (question == null) throw (new NotFoundException("question", answerRequest.getQuestionId().toString()));
		
		Game game = gameRepository.findByQuestions(question);
		if (game == null) throw (new NotFoundException("game with question", answerRequest.getQuestionId().toString()));
		
		Guitar guitar = GuitarFactory.getGuitar(game.getGuitarType(), game.getNumberOfFrets(), game.getNoteType());
		Answer answer = AnswerFactory.getAnswer(game, question, guitar, answerRequest);
		
		int score = answer.getScore();
		
		game.setCurrentScore(game.getCurrentScore() + score);
		if (game.getNumberOfQuestionsAsked() == game.getTotalQuestions() && !game.getPracticeMode())
		{
			game.setGameCompleted(true);
		}
		
		gameRepository.save(game);
		//TODO: handle error
		
		return answer;
	}

}
