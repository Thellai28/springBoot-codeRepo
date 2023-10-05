package com.thellaiDev.learnspringframework.examples.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
class NormalScope{

}

@Component
//@Scope( value = "prototype")
@Scope( value = ConfigurableBeanFactory.SCOPE_PROTOTYPE )
class PrototypeScope{
	
}

@Configuration
@ComponentScan // Scans for components in current package : 
public class BeanScopeApplicationLauncher {

	public static void main(String[] args) {
		
		// To prevent resource leakage, we are creating the context with in try block: 
		try (var context = 
				new AnnotationConfigApplicationContext
				( BeanScopeApplicationLauncher.class )) {
			
					System.out.println( context.getBean(NormalScope.class) );
					System.out.println( context.getBean(NormalScope.class) );
					System.out.println( context.getBean(NormalScope.class) );
					System.out.println("<-------------------End of singleton ----------------->");
		
		
					System.out.println( context.getBean(PrototypeScope.class) );
					System.out.println( context.getBean(PrototypeScope.class) );
					System.out.println( context.getBean(PrototypeScope.class) );
					
					System.out.println("<-------------------End of Prototype ----------------->");	
			} 
	}
}
