package com.fbm.fretquiz.repository;

import org.springframework.data.repository.CrudRepository;

import com.fbm.fretquiz.domain.Game;
import com.fbm.fretquiz.domain.Question;

public interface GameRepository extends CrudRepository<Game, Long>{
	Game findByQuestions(Question question);
}
