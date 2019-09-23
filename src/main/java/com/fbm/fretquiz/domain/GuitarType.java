package com.fbm.fretquiz.domain;

public enum GuitarType {
	FOUR_STRING_BASS("4 String Bass", new Note[] {
			new Note('G', NoteType.NATURAL), 
			new Note('D', NoteType.NATURAL), 
			new Note('A', NoteType.NATURAL), 
			new Note('E', NoteType.NATURAL)}), 
	FIVE_STRING_BASS("5 String Bass", new Note[] {
			new Note('G', NoteType.NATURAL), 
			new Note('D', NoteType.NATURAL), 
			new Note('A', NoteType.NATURAL), 
			new Note('E', NoteType.NATURAL),
			new Note('B', NoteType.NATURAL)}), 
	SIX_STRING_GUITAR("6 String Guitar",new Note[] {
			new Note('E', NoteType.NATURAL),
			new Note('B', NoteType.NATURAL),
			new Note('G', NoteType.NATURAL), 
			new Note('D', NoteType.NATURAL), 
			new Note('A', NoteType.NATURAL), 
			new Note('E', NoteType.NATURAL)}),
	SIX_STRING_BASS("6 String Bass", new Note[] {
			new Note('C', NoteType.NATURAL), 
			new Note('G', NoteType.NATURAL),
			new Note('D', NoteType.NATURAL), 
			new Note('A', NoteType.NATURAL), 
			new Note('E', NoteType.NATURAL),
			new Note('B', NoteType.NATURAL)})
	;
	
	private final String name;
	private Note[] openNotes;
	
	GuitarType(String name, Note[] openNotes){
		this.name = name;
		this.openNotes = openNotes;
	}

	public String getName() {
		return name;
	}
	
	public Note[] getOpenNotes() {
		return openNotes;
	}
}