package com.fbm.fretquiz.factory;

import com.fbm.fretquiz.domain.Guitar;
import com.fbm.fretquiz.domain.GuitarString;
import com.fbm.fretquiz.domain.GuitarType;
import com.fbm.fretquiz.domain.Note;
import com.fbm.fretquiz.domain.NoteType;

public class GuitarFactory {
	
	public static Guitar getGuitar(GuitarType guitarType, int numberOfFrets, NoteType flatsOrSharps)
	{ 
		if (flatsOrSharps  == null) flatsOrSharps = NoteType.FLAT;
		
		Note[] openNotes = guitarType.getOpenNotes();
		int numberOfStrings = openNotes.length;
		
		GuitarString[] guitarStrings = new GuitarString[numberOfStrings];
		for (int stringNum = 0; stringNum < numberOfStrings; stringNum++)
		{
			guitarStrings[stringNum] = StringFactory.getString(openNotes[stringNum], stringNum + 1, numberOfFrets, flatsOrSharps);
		}
		
		return new Guitar(guitarType.getName(), guitarStrings);
	}
}
