package com.fbm.fretquiz.domain;

import java.util.Arrays;

public class Guitar {
	
	private final String name;
	private final GuitarString[] strings;
	
	public Guitar(String name, GuitarString[] strings) {
		super();
		this.name = name;
		this.strings = strings;
	}

	public String getName() {
		return name;
	}

	//TODO: should I return a cloned list here for immutability?
	public GuitarString[] getStrings() {
		return strings;
	}
	
	public Note getNote(int fret, int string)
	{
		if (string > strings.length || fret > strings[0].getFrets().length)
			return null;
		return strings[string - 1].getFrets()[fret - 1].getNote();
	}
	
	public CorrectFret[] getMatchingFrets(String noteToMatch)
	{
		CorrectFret matchingFrets[] = new CorrectFret[2 * strings.length];
		int index = 0;
		for (int stringNumber = 0; stringNumber < strings.length; stringNumber++)
		{
			for (int fretNumber = 0; fretNumber < strings[stringNumber].getFrets().length; fretNumber++)
			{
				if (strings[stringNumber]
						.getFrets()[fretNumber]
						.getNote()
						.toString()
						.equals(noteToMatch)) {
					CorrectFret matchingFret = new CorrectFret(stringNumber + 1, fretNumber + 1);
					matchingFrets[index++] = matchingFret;
				}
			}
		}
		return matchingFrets;
	}
	
	@Override
	public String toString() {
		return "Guitar [name=" + name + ", strings=" + Arrays.toString(strings) + "]";
	}
}
