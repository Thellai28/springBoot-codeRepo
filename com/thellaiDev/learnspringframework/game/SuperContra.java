package com.thellaiDev.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")
public class SuperContra implements GamingConsole {
	
	public void up(){
		System.out.println( "Super contra : Im flying" );
	}
	
	public void down(){
		System.out.println( "Super contra : Im drowning" );
	}
	
	public void left(){
		System.out.println( "Super contra : Im doing a back flip" );
	}
	
	public void right(){
		System.out.println( "Super contra : Im shooting" );
	}
}