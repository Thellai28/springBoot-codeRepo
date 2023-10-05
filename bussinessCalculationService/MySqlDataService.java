package bussinessCalculationService;

import org.springframework.stereotype.Component;

@Component
public class MySqlDataService implements DataServices{
	public int[] retrieveData() {
		return new int[] {1,2,4,55,43, 100};
	}

}
