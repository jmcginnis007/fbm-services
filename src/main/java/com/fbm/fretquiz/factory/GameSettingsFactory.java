package com.fbm.fretquiz.factory;

import com.fbm.fretquiz.contract.GameSettings;
import com.fbm.fretquiz.domain.DifficultyLevel;
import com.fbm.fretquiz.domain.QuestionType;
import com.fbm.fretquiz.impl.EasyGame;
import com.fbm.fretquiz.impl.HardGame;
import com.fbm.fretquiz.impl.MasterGame;
import com.fbm.fretquiz.impl.MediumGame;

public class GameSettingsFactory {
	
	public static GameSettings getGameOptions(DifficultyLevel difficultyLevel, int numberOfFrets, boolean practiceMode, QuestionType questionType) {
		GameSettings gameOptions;
		
		switch (difficultyLevel)
		{
			case MASTER:
				gameOptions = new MasterGame(numberOfFrets, practiceMode, questionType);
				break;
			case HARD:
				gameOptions = new HardGame(numberOfFrets, practiceMode, questionType);
				break;
			case MEDIUM:
				gameOptions = new MediumGame(numberOfFrets, practiceMode, questionType);
				break;
			case EASY:
			default:
				gameOptions = new EasyGame(numberOfFrets, practiceMode, questionType);
				break;
		}
		
		return gameOptions;
	}

}
