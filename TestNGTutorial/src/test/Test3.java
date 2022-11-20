package test;

import org.testng.annotations.Test;


public class Test3 {
 
	@Test(priority=1)
	public void Ant(){
		System.out.println("Test Ant is executed");
	}
	
	@Test(priority=2)
	public void Animal() {
		System.out.println("Test Animal is executed");
	}
	
	@Test
	public void Waste() {
		System.out.println("Test Waste is executed");
	}
	
	@Test
	public void Owl() {
		System.out.println("Test Owl is executed");
	}
}
