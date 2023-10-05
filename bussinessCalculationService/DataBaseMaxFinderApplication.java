package bussinessCalculationService;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class DataBaseMaxFinderApplication {

	public static void main(String[] args) {
		
		try(var context = 
				new AnnotationConfigApplicationContext( DataBaseMaxFinderApplication.class )){
			
			var dataServices = context.getBean(DataServices.class);
			int max = Arrays.stream( dataServices.retrieveData() ).max().orElse(0);
			System.out.println( "The maximum value from DB is " + max );
		}

	}

}
