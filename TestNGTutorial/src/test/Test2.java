package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test2 {

		// TODO Auto-generated method stub
	@Test(groups= {"Smoke"})	
	public void WebLoginHome() {
			// TODO Auto-generated method stub
			System.out.println("Web Login Home");
		}
	
	@BeforeClass
	public void BfClass() {
		System.out.println("Executes before any method in that class");
	}

	@Test(groups= {"Smoke"})
	public void APILoginHome() {
		// TODO Auto-generated method stub
		System.out.println("API Login Home ");
	}
	
	@BeforeMethod(groups= {"Smoke"})
		public void BfMethod() {
		System.out.println("Executes before every test method in this class");
	}
	
	@AfterClass
	public void AfClass() {
		System.out.println("Executes after all the methods in that class");
	}
	
	@Parameters({"URL", "APIKey/Username"})
	@Test
	public void MobileLoginHome(String url, String key) {
		// TODO Auto-generated method stub
		System.out.println("Mobile Login Home");
		System.out.println(url);
		System.out.println(key);
	}
	}


