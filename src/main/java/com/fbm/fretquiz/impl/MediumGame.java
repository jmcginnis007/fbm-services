package com.fbm.fretquiz.impl;

import com.fbm.fretquiz.contract.AbstractGameOptions;
import com.fbm.fretquiz.contract.GameSettings;
import com.fbm.fretquiz.domain.QuestionType;

public class MediumGame extends AbstractGameOptions implements GameSettings{
	
	public MediumGame(int totalFrets, Boolean practiceMode, QuestionType questionType) {
		this.totalFrets = totalFrets;
		this.practiceMode = practiceMode;
		this.questionType = questionType;
	}

	@Override
	public Integer getMinFret() {
		return (questionType.equals(QuestionType.NAME_THE_NOTE) ? 1 : 6);
	}

	@Override
	public Integer getMaxFret() {
		return (questionType.equals(QuestionType.NAME_THE_NOTE) ? 9 : super.getMaxFret());
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
		return practiceMode;
	}
}
