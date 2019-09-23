package com.fbm.fretquiz.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {
	
	@JsonIgnore
    @ManyToOne
    private Game game;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long questionId;
	
	private QuestionType questionType;
	
	private String findTheNote;
	
	private Integer nameTheNoteFret;
	private Integer nameTheNoteString;
	
	protected Question() {}
	
	public Question(QuestionType questionType, String findTheNote, Integer nameTheNoteFret, Integer nameTheNoteString) {
		super();
		this.questionType = questionType;
		this.findTheNote = findTheNote;
		this.nameTheNoteFret = nameTheNoteFret;
		this.nameTheNoteString = nameTheNoteString;
	}
	
	public Long getQuestionId() {
		return questionId;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public String getFindTheNote() {
		return findTheNote;
	}

	public Integer getNameTheNoteFret() {
		return nameTheNoteFret;
	}

	public Integer getNameTheNoteString() {
		return nameTheNoteString;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionType=" + questionType + ", findTheNote=" + findTheNote
				+ ", nameTheNoteFret=" + nameTheNoteFret + ", nameTheNoteString=" + nameTheNoteString
			    + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((findTheNote == null) ? 0 : findTheNote.hashCode());
		result = prime * result + ((game == null) ? 0 : game.hashCode());
		result = prime * result + ((nameTheNoteFret == null) ? 0 : nameTheNoteFret.hashCode());
		result = prime * result + ((nameTheNoteString == null) ? 0 : nameTheNoteString.hashCode());
		result = prime * result + ((questionType == null) ? 0 : questionType.hashCode());
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
		Question other = (Question) obj;
		if (findTheNote == null) {
			if (other.findTheNote != null)
				return false;
		} else if (!findTheNote.equals(other.findTheNote))
			return false;
		if (game == null) {
			if (other.game != null)
				return false;
		} else if (!game.equals(other.game))
			return false;
		if (nameTheNoteFret == null) {
			if (other.nameTheNoteFret != null)
				return false;
		} else if (!nameTheNoteFret.equals(other.nameTheNoteFret))
			return false;
		if (nameTheNoteString == null) {
			if (other.nameTheNoteString != null)
				return false;
		} else if (!nameTheNoteString.equals(other.nameTheNoteString))
			return false;
		if (questionType != other.questionType)
			return false;
		return true;
	}
	
	
}
