package com.fbm.fretquiz.contract;

import com.fbm.fretquiz.domain.QuestionType;

public abstract class AbstractGameOptions {
	
	protected int totalFrets;
	protected Boolean practiceMode;
	protected QuestionType questionType;
	
	protected Integer getMaxFret() {
		return totalFrets;
	}

}
