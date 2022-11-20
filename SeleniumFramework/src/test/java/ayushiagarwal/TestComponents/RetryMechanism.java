package ayushiagarwal.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryMechanism implements IRetryAnalyzer{

	int count = 0;
	int maxTry = 1;
	@Override
	//IRetryAnalyzer is used to rerun failed test cases that we think are failed due to flakiness in the application and they are not actually fail
	public boolean retry(ITestResult result) {
		
		if(count < maxTry) {
			count++;
			return true;
		}
		return false;
	}

}
