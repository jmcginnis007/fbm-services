package com.fbm.fretquiz.impl;

import com.fbm.fretquiz.contract.AbstractGameOptions;
import com.fbm.fretquiz.contract.GameSettings;
import com.fbm.fretquiz.domain.QuestionType;

public class HardGame extends AbstractGameOptions implements GameSettings{
	
	public HardGame(int totalFrets, Boolean practiceMode, QuestionType questionType) {
		this.totalFrets = totalFrets;
		this.practiceMode = practiceMode;
		this.questionType = questionType;
	}
	
	@Override
	public Integer getMinFret() {
		return (questionType.equals(QuestionType.NAME_THE_NOTE) ? 1 : 12);
	}

	@Override
	public Integer getMaxFret() {
		return (questionType.equals(QuestionType.NAME_THE_NOTE) ? 14 : super.getMaxFret());
	}

	@Override
	public boolean getShowOpenNotes() {
		return practiceMode;
	}

	@Override
	public boolean getOpenNotesEnabled() {
		return practiceMode;
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
