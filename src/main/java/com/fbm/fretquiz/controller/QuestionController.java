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

import com.fbm.fretquiz.domain.Question;
import com.fbm.fretquiz.domain.request.NewQuestionRequest;
import com.fbm.fretquiz.service.QuestionService;

@RestController
@RequestMapping("/fbm/questions")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@PostMapping
	@ResponseBody
    public Question newQuestion(@RequestBody @Valid NewQuestionRequest newQuestionRequest)
	{
    	return questionService.newQuestion(newQuestionRequest);
    }
	
	@GetMapping(value = "/{id}")
	@ResponseBody
	public Question getExistingQuestion(@PathVariable("id") Long id)
	{
		return questionService.getExistingQuestion(id);
	}
	
}
