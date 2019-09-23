package com.fbm.fretquiz.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7384891441277451873L;

	public NotFoundException(String type, String id) {
		super("Could not find " + type + " with id " + id);
	}
}