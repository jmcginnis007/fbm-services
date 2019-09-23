package com.fbm.fretquiz.impl;

import com.fbm.fretquiz.contract.AbstractGameOptions;
import com.fbm.fretquiz.contract.GameSettings;
import com.fbm.fretquiz.domain.QuestionType;

public class EasyGame extends AbstractGameOptions implements GameSettings{
	
	public EasyGame(int totalFrets, Boolean practiceMode, QuestionType questionType) {
		this.totalFrets = totalFrets;
		this.practiceMode = practiceMode;
		this.questionType = questionType;
	}
	
	@Override
	public Integer getMinFret() {
		return 1;
	}

	@Override
	public Integer getMaxFret() {
		return (questionType.equals(QuestionType.NAME_THE_NOTE) ? 5 : super.getMaxFret());
	}

	@Override
	public boolean getShowOpenNotes() {
		return true;
	}

	@Override
	public boolean getOpenNotesEnabled() {
		return true;
	}

	@Override
	public boolean getShowNotesEnabled() {
		return practiceMode;
	}

	@Override
	public boolean getShowFretNumbersEnabled() {
		return true;
	}
}
