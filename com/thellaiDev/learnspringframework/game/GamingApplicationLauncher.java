package com.thellaiDev.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.thellaiDev.learnspringframework.game")
public class GamingApplicationLauncher {

	public static void main(String[] args) {
		
		// To prevent resource leakage, we are creating the context with in try block: 
		try (var context = 
				new AnnotationConfigApplicationContext
				( GamingApplicationLauncher.class )) {
					context.getBean( GameRunner.class ).run();
			} 
	}
}
