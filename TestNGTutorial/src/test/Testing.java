package test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Testing {

	@Test(groups= {"Smoke"})
	public void Demo1() {
		// TODO Auto-generated method stub
		System.out.println("Bye");

	}
	
	@AfterTest
	public void AfTest() {
		System.out.println("Executes after all the methods in this test folder only");
	}
	
	@BeforeSuite()
	public void BfSuite() {
		System.out.println("Executes before any method in the test suite");
	}
	

}


