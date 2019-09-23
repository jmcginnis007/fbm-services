package com.fbm.fretquiz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fbm.fretquiz.domain.Guitar;
import com.fbm.fretquiz.domain.GuitarType;
import com.fbm.fretquiz.domain.NoteType;
import com.fbm.fretquiz.factory.GuitarFactory;

@RestController
@RequestMapping("/fbm/guitars")
public class GuitarController {
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
    public Guitar getGuitar(@RequestParam(value="type", defaultValue="SIX_STRING_GUITAR", required = true) GuitarType guitarType, 
    						@RequestParam(value="frets", defaultValue="20", required = true) Integer numberOfFrets,
    						@RequestParam(value="noteType", defaultValue="FLAT", required = true) NoteType noteType)
	{
        return GuitarFactory.getGuitar(guitarType, numberOfFrets, noteType);
    }
	
	@RequestMapping(value = "/types", method = RequestMethod.GET)
	@ResponseBody
    public GuitarType[] getGuitarTypes()
    {
		return GuitarType.values();
    }
}
