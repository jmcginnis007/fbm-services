package com.fbm.fretquiz.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fbm.fretquiz.domain.Answer;
import com.fbm.fretquiz.domain.request.AnswerRequest;
import com.fbm.fretquiz.service.AnswerService;

@RestController
@RequestMapping("/fbm/answers")
public class AnswerController {
	
	@Autowired
	private AnswerService answerService;
	
	@PostMapping
	@ResponseBody
    public Answer getAnswer(@RequestBody @Valid AnswerRequest answerRequest)
	{
		return answerService.getAnswer(answerRequest);
	}
}