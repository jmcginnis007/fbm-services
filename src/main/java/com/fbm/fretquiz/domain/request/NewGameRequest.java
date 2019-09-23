package com.fbm.fretquiz.domain.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.fbm.fretquiz.domain.DifficultyLevel;
import com.fbm.fretquiz.domain.GuitarType;
import com.fbm.fretquiz.domain.NoteType;
import com.fbm.fretquiz.domain.QuestionType;

public class NewGameRequest {
	
	@NotNull
	private GuitarType guitarType;
	
	@NotNull
	@Range(min = 14, max = 30, message = "Must choose between 14 and 30 frets")
	private int numberOfFrets;
	
	@NotNull
	private NoteType noteType;
	
	@NotNull
	private QuestionType questionType;
	
	@NotNull
	private DifficultyLevel difficultyLevel;
	
	@NotNull
	private Boolean practiceMode;
	
	@Max(value = 30)
	private int totalQuestions;
	
	public NewGameRequest(GuitarType guitarType, int numberOfFrets, NoteType noteType, QuestionType questionType, DifficultyLevel difficultyLevel,
			Boolean practiceMode, Integer totalQuestions) {
		super();
		this.guitarType = guitarType;
		this.numberOfFrets = numberOfFrets;
		this.noteType = noteType;
		this.questionType = questionType;
		this.difficultyLevel = difficultyLevel;
		this.practiceMode = practiceMode;
		this.totalQuestions = totalQuestions;
	}
	
	public NewGameRequest() {}
	
	public GuitarType getGuitarType() {
		return guitarType;
	}
	
	public int getNumberOfFrets() {
		return numberOfFrets;
	}

	public NoteType getNoteType() {
		return noteType;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public DifficultyLevel getDifficultyLevel() {
		return difficultyLevel;
	}

	public Boolean getPracticeMode() {
		return practiceMode;
	}

	public int getTotalQuestions() {
		return totalQuestions;
	}

	@Override
	public String toString() {
		return "NewGame [guitarType=" + guitarType + ", numberOfFrets=" + numberOfFrets + ", noteType=" + noteType
				+ ", questionType=" + questionType + ", difficultyLevel=" + difficultyLevel + ", practiceMode="
				+ practiceMode + ", totalQuestions=" + totalQuestions + "]";
	}
	
}
