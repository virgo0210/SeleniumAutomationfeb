package retryLogic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogicExample implements IRetryAnalyzer{

	int counter = 0;
	int retryCount = 2;
	
	
	public boolean retry(ITestResult result) {
		
		
		
		//logic for returing ----- true
		
		if(counter < retryCount) {
			
			counter++;
			return true;
			
		}
		
		
		
		
		
		return false;
	
	
	}
	
	
	
	

}
