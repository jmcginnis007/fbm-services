package com.fbm.fretquiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FretquizApplication {

	public static void main(String[] args) {
		SpringApplication.run(FretquizApplication.class, args);
	}
	
//	@Bean
//    public CommandLineRunner commandLineRunner() {
//        return blah -> {
//
//            System.out.println("Let's create a guitar");
//
//            Guitar test = GuitarFactory.getGuitar(GuitarType.FIVE_STRING_BASS, 0, NoteType.SHARP, true);
//
//            System.out.println(test);
//        };
//    }
}
