package com.thellaiDev.learnspringframework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//<---------------------------- EAGER INTIALIZATION ---------------------------------------->
@Component
class EagerHelper{
	//By default all the component class will be in Eager initialization mode, meaning every component class object will be
	// created by string frame work, when configuration file is processed by Application configuration application method
	// just to create spring context. In real world, the beans and the outer shell will grow together. Like wise when 
	// String context( outer shell of real world bean ) is created all the beans( all component class ) will be created along :
	
	public EagerHelper() {
		System.out.println("PRINT STATEMENT : 01 -> EagerHelper "
				+ "object initialed automatically, since is in 'Eager' initialization mode");
	}
	
}

//<----------------------------- LAZY INITIALIZATION ---------------------------------------->
 @Component 
 @Lazy
 class ClassLazy{
	 //Since this component is annotated with @Lazy annotation, the object of this bean will be created, only if this bean is
	 // requested through the spring context. This Lazy initialization is not used frequently and not recommended as well.
	 // This initialization is used only on specific conditions or occasions.
	 private EagerHelper helper;
	 
	 public ClassLazy( EagerHelper help ) {
		 this.helper = help;
		 System.out.println("PRINT STATEMENT : 02 -> Hey, I'm lazy Bean. Some one invoked me");
	 }
	 public void sayHello() {
		 System.out.println("PRINT STATEMENT : 03 -> Hello everyOne!! i'm happy to meet ya all :)");
	 }
 }
 
 //<---------------------------- CONFIGURATION & MAIN CLASS --------------------------------->

@Configuration
@ComponentScan // Scans for components in current package : 
public class LazyInitializationApplicationLauncer {

	public static void main(String[] args) {
		
		System.out.println("PRINT STATEMENT :04-> Configurationc class initialized as bean");
		System.out.println();
		
		// To prevent resource leakage, we are creating the context with in try block: 
		try (var context = 	new AnnotationConfigApplicationContext
								( LazyInitializationApplicationLauncer.class )) {
			
				System.out.println("PRINT STATEMENT : 05 -> when spring context is initialized, all the Eager components will be"
						+ "initialized automatically, since all the component classes are bean");
				System.out.println();
				
				System.out.println("PRINT STATEMENT : 06 -> initializing Lazy component");
				context.getBean(ClassLazy.class).sayHello();	
			} 
	}
}
