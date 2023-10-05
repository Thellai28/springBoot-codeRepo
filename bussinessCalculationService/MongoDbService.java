package bussinessCalculationService;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MongoDbService implements DataServices{
	public int[] retrieveData() {
		return new int[] {10, 20, 30, 40, 50, 78, 87373};
	}

}
