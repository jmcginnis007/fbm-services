package com.fbm.fretquiz.domain.request;

import javax.validation.constraints.NotNull;

public class NewQuestionRequest {
	
	@NotNull
	private Long gameId;

	public NewQuestionRequest() {}
	
	public NewQuestionRequest(Long gameId) {
		super();
		this.gameId = gameId;
	}

	public Long getGameId() {
		return gameId;
	}

	@Override
	public String toString() {
		return "NewQuestion [gameId=" + gameId + "]";
	}

}
