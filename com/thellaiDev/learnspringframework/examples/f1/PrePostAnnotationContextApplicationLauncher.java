package com.thellaiDev.learnspringframework.examples.f1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass{
	private DataBase DB;
	
	public SomeClass( DataBase someDependency) {
		this.DB = someDependency;
		System.out.println("Line 01 -> Some class object initialized by using autowiring");
	}
	
	@PostConstruct
	private void initializeDependencies() {
		// Establish the required connections with the data base : 
		// This connections should be made once this bean is created : 
		DB.dependencyInitializer();
	}
	
	@PreDestroy
	private void removeDependencyies() {
		// Once this beans purpose is over, we have to remove all the resources
		// that is being held by the current bean.This has to happen automatically
		// Before this bean is destroyed : 
		DB.dependencyRemover();
	}
}

@Component
class DataBase{
	public void dependencyInitializer() {
		System.out.println("Line 02<-----Dependencies are initialized -------->");
		
	}
	public void dependencyRemover() {
		System.out.println("Line 03<-----Dependencies are Removed -------->");
	}
	
}

@Configuration
@ComponentScan // Scans for components in current package : 
public class PrePostAnnotationContextApplicationLauncher {

	public static void main(String[] args) {
		
		// To prevent resource leakage, we are creating the context with in try block: 
		try (var context = 
				new AnnotationConfigApplicationContext
				( PrePostAnnotationContextApplicationLauncher.class )) {
				// We are doing nothing in the main method : 
				// Based on the autoWiring & postConstruct & preDestroy
				// methods are invoked automatically : 
					
			} 
	}
}
