package com.fbm.fretquiz.factory;

import java.util.Arrays;

import com.fbm.fretquiz.domain.Fret;
import com.fbm.fretquiz.domain.GuitarString;
import com.fbm.fretquiz.domain.Note;
import com.fbm.fretquiz.domain.NoteType;

public class StringFactory {
	
	// *This Class is assuming that all open notes are natural, not sharps or flats.*
	public static final String[] SCALE_NOTES_FLAT =  { "C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B" };
	public static final String[] SCALE_NOTES_SHARP = { "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B" };
	
	public static GuitarString getString(Note openNote, int stringNumber, int numberOfFrets, NoteType flatsOrSharps )
	{
		Fret frets[] = new Fret[numberOfFrets];
		
		String[] notesArray;
		
		switch (flatsOrSharps)
		{
		case SHARP:
			notesArray = SCALE_NOTES_SHARP;
			break;
		default:
			notesArray = SCALE_NOTES_FLAT;
			break;
		}
		
		//find open note in scale and start at next position
		int scalePos = Arrays.asList(notesArray).indexOf(Character.toString(openNote.getNote())) + 1;
		
		for (int pos = 0; pos < numberOfFrets; pos++)
		{
			if (scalePos > (notesArray.length - 1)) scalePos = 0; //wrap around if we reach the end of the notesArray
			frets[pos] = new Fret(pos + 1, convertStringToNote(notesArray[scalePos]));
			scalePos++;
		}
		
		GuitarString newString = new GuitarString(stringNumber, openNote, frets);
		return newString;
	}
	
	public static Note convertStringToNote(String stringNote)
	{
		char note = stringNote.charAt(0);
		if (stringNote.length() == 1) return new Note(note, NoteType.NATURAL);
		if (stringNote.charAt(1) == '#') return new Note(note, NoteType.SHARP);
		else
			return new Note(note, NoteType.FLAT);
	}

}
