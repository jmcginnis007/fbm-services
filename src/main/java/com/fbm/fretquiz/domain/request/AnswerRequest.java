package com.fbm.fretquiz.domain.request;

public class AnswerRequest {
	
	private Long questionId;
	private String nameTheNoteAnswer;
	private Integer findTheNoteAnswerFret;
	private Integer findTheNoteAnswerString;
	private Long duration;
	
	public AnswerRequest() {}
	
	public AnswerRequest(Long questionId, String nameTheNoteAnswer, Integer findTheNoteAnswerFret,
			Integer findTheNoteAnswerString, Long duration) {
		super();
		this.questionId = questionId;
		this.nameTheNoteAnswer = nameTheNoteAnswer;
		this.findTheNoteAnswerFret = findTheNoteAnswerFret;
		this.findTheNoteAnswerString = findTheNoteAnswerString;
		this.duration = duration;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getNameTheNoteAnswer() {
		return nameTheNoteAnswer;
	}

	public void setNameTheNoteAnswer(String nameTheNoteAnswer) {
		this.nameTheNoteAnswer = nameTheNoteAnswer;
	}

	public Integer getFindTheNoteAnswerFret() {
		return findTheNoteAnswerFret;
	}

	public void setFindTheNoteAnswerFret(Integer findTheNoteAnswerFret) {
		this.findTheNoteAnswerFret = findTheNoteAnswerFret;
	}

	public Integer getFindTheNoteAnswerString() {
		return findTheNoteAnswerString;
	}

	public void setFindTheNoteAnswerString(Integer findTheNoteAnswerString) {
		this.findTheNoteAnswerString = findTheNoteAnswerString;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "AnswerRequest [questionId=" + questionId + ", nameTheNoteAnswer=" + nameTheNoteAnswer
				+ ", findTheNoteAnswerFret=" + findTheNoteAnswerFret + ", findTheNoteAnswerString="
				+ findTheNoteAnswerString + ", duration=" + duration + "]";
	}
}
