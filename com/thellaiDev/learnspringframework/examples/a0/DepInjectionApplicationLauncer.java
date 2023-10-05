package com.thellaiDev.learnspringframework.examples.a0;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan // Scans for components in current package : 
public class DepInjectionApplicationLauncer {

	public static void main(String[] args) {
		
		// To prevent resource leakage, we are creating the context with in try block: 
		try (var context = 
				new AnnotationConfigApplicationContext
				( DepInjectionApplicationLauncer.class )) {
			Arrays.stream( context.getBeanDefinitionNames() )
				  .forEach( System.out::println );
					
			} 
	}
}
