package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG {
 
	@Parameters({"URL"})
	@Test
	public void Demo(String urlname) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		System.out.println(urlname);

	}
	

	@Test(groups= {"Smoke"})
	public void Word() {
		// TODO Auto-generated method stub
		System.out.println("World");

	}
	
	@BeforeTest
	public void BfTest() {
		System.out.println("Executes before any method in this test folder");
	}
	
	@AfterSuite
	public void AfSuite() {
		System.out.println("Executes after all the methods in the test suite");
	}
	
}


