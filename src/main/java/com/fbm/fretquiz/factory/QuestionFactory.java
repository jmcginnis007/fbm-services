package com.fbm.fretquiz.factory;

import java.util.Random;

import com.fbm.fretquiz.contract.GameSettings;
import com.fbm.fretquiz.domain.DifficultyLevel;
import com.fbm.fretquiz.domain.GuitarType;
import com.fbm.fretquiz.domain.NoteType;
import com.fbm.fretquiz.domain.Question;
import com.fbm.fretquiz.domain.QuestionType;

public class QuestionFactory {
	
	public static Question getQuestion(GuitarType guitarType, DifficultyLevel difficultyLevel, int numberOfFrets, boolean practiceMode, QuestionType questionType, NoteType flatsOrSharps, Question previousQuestion) {
		
		GameSettings gameOptions = GameSettingsFactory.getGameOptions(difficultyLevel, numberOfFrets, practiceMode, questionType);
		Random random = new Random();
		
		Question nextQuestion = null;
		
		do {
			switch (questionType) {
			case NAME_THE_NOTE : 
				int numberOfStrings = guitarType.getOpenNotes().length;
				int randomFret =  random.nextInt((gameOptions.getMaxFret() - gameOptions.getMinFret()) + 1) + gameOptions.getMinFret();
				int randomString = random.nextInt((numberOfStrings - 1) + 1) + 1;
				nextQuestion = new Question(questionType, null, randomFret, randomString);
				break;
			default : //FIND_THE_NOTE
				int randomNotePos = random.nextInt(11);
				String[] notesArray;
				switch (flatsOrSharps)
				{
				case SHARP:
					notesArray = StringFactory.SCALE_NOTES_SHARP;
					break;
				default:
					notesArray = StringFactory.SCALE_NOTES_FLAT;
					break;
				}
				String randomNote = notesArray[randomNotePos];
				nextQuestion = new Question(questionType, randomNote, null, null);
				break;
			}
		} while (previousQuestion != null && previousQuestion.equals(nextQuestion)); // make sure we don't ask same question twice in a row
	
		return nextQuestion;
	}

}
