package com.fbm.fretquiz.domain;

public class Fret {
	
	private final int fretNumber;
	private final Note note;
	
	public Fret(int fretNumber, Note note) {
		super();
		this.fretNumber = fretNumber;
		this.note = note;
	}

	public int getFretNumber() {
		return fretNumber;
	}

	public Note getNote() {
		return note;
	}
	
	@Override
	public String toString() {
		return "Fret [fretNumber=" + fretNumber + ", note=" + note + "]";
	}

}
