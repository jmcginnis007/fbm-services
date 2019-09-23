package com.fbm.fretquiz.domain;

public class CorrectFret {
	private int stringNumber;
	private int fretNumber;
	
	public CorrectFret(int stringNumber, int fretNumber) {
		super();
		this.stringNumber = stringNumber;
		this.fretNumber = fretNumber;
	}

	public int getStringNumber() {
		return stringNumber;
	}

	public int getFretNumber() {
		return fretNumber;
	}
	
}
