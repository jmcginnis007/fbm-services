package com.fbm.fretquiz.repository;

import org.springframework.data.repository.CrudRepository;

import com.fbm.fretquiz.domain.Question;

public interface QuestionRepository extends CrudRepository<Question, Long>{

}
