package com.thellaiDev.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MarioGame implements GamingConsole{
	
	public void up(){
		System.out.println( "mario : Jump" );
	}
	
	public void down(){
		System.out.println( "mario : Go into the hole" );
	}
	
	public void left(){
		System.out.println( "mario : Go back" );
	}
	
	public void right(){
		System.out.println( "mario : Accelarate" );
	}
}
