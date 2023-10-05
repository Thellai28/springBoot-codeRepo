package com.thellaiDev.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	private GamingConsole game;
	
	
	public GameRunner( @Qualifier("SuperContraGameQualifier")GamingConsole game ){
		this.game = game;
		// Even though the MarioGame has the primary Annotation, the Qualifier annotation will
		// give the first preference to the class with qualifier annotation
		// Any Class with qualifier tag will get the first :
		// Constructor injection is happening behind the scenes : 
	}

	public void run(){
		System.out.println("Running game " + game );
		game.up();
		game.down();
		game.left();
		game.right();
		System.out.println("-------------------------------------");
	}
}
