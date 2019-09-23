package com.fbm.fretquiz.contract;

public interface GameSettings {
	
	Integer getMinFret();
	Integer getMaxFret();
	
	boolean getShowOpenNotes();
	boolean getOpenNotesEnabled();
	
	boolean getShowNotesEnabled();
	boolean getShowFretNumbersEnabled();

}
