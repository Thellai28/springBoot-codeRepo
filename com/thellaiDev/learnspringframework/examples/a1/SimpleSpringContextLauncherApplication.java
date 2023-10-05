package com.thellaiDev.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
class Dependency1{ 
	// These classes should created separately in this package, for the sake of simplicity
	// We are creating dummy classes here
}

@Component
class Dependency2{
	
}

@Component
class YourBussinessClass{
	
	// <---------------------------- FIELD INJECTIONS --------------------------------------->
	
		@Autowired
		Dependency1 fieldInjection_Dep1;
		
		@Autowired
		Dependency2 fieldInjectionDep2;
	
	
	// <----------------------------- SETTER INJECTION -------------------------------------->
	
		Dependency1 setterInjection_Dep4;
		Dependency2 setterInjection_Dep5;
	
		@Autowired
		public void setDep1(Dependency1 dep1) {
			this.setterInjection_Dep4 = dep1;
			System.out.println("setterInjection_Dep4 -->Objects are injected using Setter dependency injection");
			System.out.println();
		}
		
		@Autowired
		public void setDpe2(Dependency2 dpe2) {
			this.setterInjection_Dep5 = dpe2;
			System.out.println("setterInjection_Dep5 -->Objects are injected using Setter dependency injection");
			System.out.println();
		}
	
	// <--------------------------- CONSTRUCTOR INJECTIION -------------------------------------->
		
		Dependency1 constructorInjection_Dep6;
		Dependency2 constructorInjection_Dep7;
		
		//@Autowired // optional, constructor injection would work without Autowired annotation : 
		public YourBussinessClass( Dependency1 dep1, Dependency2 dep2 ) {
			this.constructorInjection_Dep6 = dep1;
			this.constructorInjection_Dep7 = dep2;
			System.out.println("constructorInjection_Dep7 && constructorInjection_Dep6"
					+ " --> Objects are injected using Constructor dependency injection");
			System.out.println();
		}
}

@Configuration
@ComponentScan // If we don't provide package link, The spring will search in current package :  
public class SimpleSpringContextLauncherApplication {

	public static void main(String[] args) {
		
		// To prevent resource leakage, we are creating the context with in try block: 
		try (var context = 
				new AnnotationConfigApplicationContext
				( SimpleSpringContextLauncherApplication.class )) {
			
			// Printing the @Beans present inside the Spring context or Spring container : 
					Arrays.stream( context.getBeanDefinitionNames() )
					  .forEach( System.out::println );
					
			} 
	}
}
