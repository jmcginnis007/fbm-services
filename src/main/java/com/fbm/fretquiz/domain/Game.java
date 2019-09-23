package com.fbm.fretquiz.domain;	

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fbm.fretquiz.domain.request.NewGameRequest;

@Entity
public class Game {
	
	@JsonIgnore
	@OneToMany
	private List<Question> questions = new ArrayList<>();

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long gameId;

	private GuitarType guitarType;
	private int numberOfFrets;
	private NoteType noteType;
	private QuestionType questionType;
	private DifficultyLevel difficultyLevel;
	private Boolean practiceMode;
	private int totalQuestions;
	private int currentScore;
	private boolean gameCompleted;

	protected Game() {}
	
	public Game(GuitarType guitarType, int numberOfFrets, NoteType noteType, QuestionType questionType, DifficultyLevel difficultyLevel,
			Boolean practiceMode, Integer totalQuestions) {
		super();
		this.guitarType = guitarType;
		this.numberOfFrets = numberOfFrets;
		this.noteType = noteType;
		this.questionType = questionType;
		this.difficultyLevel = difficultyLevel;
		this.practiceMode = practiceMode;
		this.totalQuestions = (practiceMode ? 0 : totalQuestions);
	}
	
	public Game(NewGameRequest newGame) {
		super();
		this.guitarType = newGame.getGuitarType();
		this.numberOfFrets = newGame.getNumberOfFrets();
		this.noteType = newGame.getNoteType();
		this.questionType = newGame.getQuestionType();
		this.difficultyLevel = newGame.getDifficultyLevel();
		this.practiceMode = newGame.getPracticeMode();
		this.totalQuestions = (practiceMode ? 0 : totalQuestions);
	}
	
	public List<Question> getQuestions() {
		return questions;
	}
	
	public void addQuestion(Question question) {
		questions.add(question);
	}
	
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

	public Long getGameId() {
		return gameId;
	}

	public int getTotalQuestions() {
		return totalQuestions;
	}
	
	public int getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}
	
	public boolean isGameCompleted() {
		return gameCompleted;
	}

	public void setGameCompleted(boolean gameCompleted) {
		this.gameCompleted = gameCompleted;
	}
	
	@JsonIgnore
	public int getNumberOfQuestionsAsked()
	{
		return questions.size();
	}

	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", noteType=" + noteType + ", questionType=" + questionType
				+ ", difficultyLevel=" + difficultyLevel + ", practiceMode=" + practiceMode + ", totalQuestions="
				+ totalQuestions + ", currentScore=" + currentScore + ", gameCompleted=" + gameCompleted + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gameId == null) ? 0 : gameId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (gameId == null) {
			if (other.gameId != null)
				return false;
		} else if (!gameId.equals(other.gameId))
			return false;
		return true;
	}
	
	
}
