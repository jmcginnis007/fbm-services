package com.fbm.fretquiz.domain;

import java.util.Arrays;

public class Answer {
	private boolean isCorrect;
	private int score;
	private String correctNote;
	private CorrectFret correctFrets[];


	public Answer(boolean isCorrect) {
		super();
		this.isCorrect = isCorrect;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getCorrectNote() {
		return correctNote;
	}

	public void setCorrectNote(String correctNote) {
		this.correctNote = correctNote;
	}

	public CorrectFret[] getCorrectFrets() {
		return correctFrets;
	}

	public void setCorrectFrets(CorrectFret[] correctFrets) {
		this.correctFrets = correctFrets;
	}

	@Override
	public String toString() {
		return "Answer [isCorrect=" + isCorrect + ", score=" + score + ", correctNote=" + correctNote
				+ ", correctFrets=" + Arrays.toString(correctFrets) + "]";
	}
}
