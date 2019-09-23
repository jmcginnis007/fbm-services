package com.fbm.fretquiz.factory;

import com.fbm.fretquiz.domain.Answer;
import com.fbm.fretquiz.domain.Game;
import com.fbm.fretquiz.domain.Guitar;
import com.fbm.fretquiz.domain.Note;
import com.fbm.fretquiz.domain.Question;
import com.fbm.fretquiz.domain.request.AnswerRequest;

public class AnswerFactory {
	private static final int CORRECT_WORTH = 25;
	private static final int INCORRECT_WORTH = -15;
	public static Answer getAnswer(Game game, Question question, Guitar guitar, AnswerRequest answerRequest)
	{
		String nameTheNote = answerRequest.getNameTheNoteAnswer();
		Integer findTheNoteFret = answerRequest.getFindTheNoteAnswerFret();
		Integer findTheNoteString = answerRequest.getFindTheNoteAnswerString();
		long duration = answerRequest.getDuration();
		
		boolean isCorrect = false;
		Answer answer = null;
		switch (question.getQuestionType()) {
		case NAME_THE_NOTE : 
			// see if the questions fret/string is the same note as the passed in answer
			int fret = question.getNameTheNoteFret();
			int string = question.getNameTheNoteString();
			Note correctNote = guitar.getNote(fret, string);	
			if (correctNote.toString().equals(nameTheNote))
				isCorrect = true;	
			answer = new Answer(isCorrect);
			if (game.getPracticeMode())
			{
				answer.setCorrectNote(correctNote.toString());
			}
			else
			{
				answer.setScore(calculateScore(isCorrect, duration));
			}
			break;
		default : //FIND_THE_NOTE
			// see if the questions note to name is the same as the note at the passed in answer location fret/string
			String correctNoteString = question.getFindTheNote();
			Note selectedNote = guitar.getNote(findTheNoteFret, findTheNoteString);
			if (correctNoteString.equals(selectedNote.toString()))
				isCorrect = true;
			answer = new Answer(isCorrect);
			if (game.getPracticeMode())
			{
				answer.setCorrectFrets(guitar.getMatchingFrets(correctNoteString));
			}
			else
			{
				answer.setScore(calculateScore(isCorrect, duration));
			}
			break;
		} 
		
		return answer;
	}
	
	private static int calculateScore(boolean isCorrect, long duration) {
		int score = 0;
		
		if (isCorrect) {
			score = CORRECT_WORTH;
			//calcuate time bonus
			if (duration > 3000) return score;
			if (duration <= 500) return score + 50;
			if (duration <= 1000) return score + 25;
			if (duration <= 1500) return score + 20;
			if (duration <= 2000) return score + 15;
			if (duration <= 2500) return score + 10;
			if (duration <= 3000) return score + 5;
		}	
		return INCORRECT_WORTH;
	}
}
