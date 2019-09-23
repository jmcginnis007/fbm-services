package com.fbm.fretquiz.domain;

import java.util.Arrays;

public class GuitarString {
	
	private final int stringNumber;
	private final Note openStringNote;
	private final Fret[] frets;
	
	public GuitarString(int stringNumber, Note openStringNote, Fret[] frets) {
		super();
		this.stringNumber = stringNumber;
		this.openStringNote = openStringNote;
		this.frets = frets;
	}

	public int getStringNumber() {
		return stringNumber;
	}

	public Note getOpenStringNote() {
		return openStringNote;
	}

	//TODO: should I return a cloned list here for immutability?
	public Fret[] getFrets() {
		return frets;
	}

	@Override
	public String toString() {
		return "GuitarString [stringNumber=" + stringNumber + ", openStringNote=" + openStringNote + ", frets="
				+ Arrays.toString(frets) + "]";
	}
}
