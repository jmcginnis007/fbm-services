package com.fbm.fretquiz.domain;

public class Note {
		
	private char note;
	private NoteType noteType;
	
	public Note(char note, NoteType noteType) {
		super();
		this.note = note;
		this.noteType = noteType;
	}
	
	public char getNote() {
		return note;
	}

	public NoteType getNoteType() {
		return noteType;
	}

	@Override
	public String toString() {
		String noteString = Character.toString(note);
		
		switch (noteType) {
		case FLAT:
			noteString+= "b";
			break;
		case SHARP:
			noteString+= "#";
			break;
		default:
			break;
		}
		return noteString;
	}
	
}
