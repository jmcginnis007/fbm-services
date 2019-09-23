package com.fbm.fretquiz.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GameOverException extends RuntimeException {
	
	private static final long serialVersionUID = 7050452985243496969L;

	public GameOverException(String id) {
		super("Game with id " + id + " is already completed");
	}
}