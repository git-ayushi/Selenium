


package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test1 {

	@Test(dataProvider = "getData")
	public void WebLogin(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println("Web Login");
		System.out.println(username);
		System.out.println(password);
	}
	
	@Test(dependsOnMethods = {"WebLogin"})
	public void APILogin() {
		// TODO Auto-generated method stub
		System.out.println("API Login");
	}
	
	@Test(enabled = false)	
	public void MobileLogin() {
		// TODO Auto-generated method stub
		System.out.println("Mobile Login");
	}
	
	@AfterMethod
	public void AfMethod() {
		System.out.println("Executes after every test method in this class");
	}
	@Test(timeOut = 4000)
	public void MobileSignIn() {
		// TODO Auto-generated method stub
		System.out.println("Mobile Sign In");
	}
	
	@Test(groups = {"Smoke"})
	public void MobileSignOut() {
		// TODO Auto-generated method stub
		System.out.println("Mobile Sign Out");
	}
	
	@DataProvider
	public Object[][] getData() {
		//1st combination of data with username, password having good credit history
		//2nd combination of data with username, password having no credit history
		//3rd combination of data with username, password having fradulent credit history
		Object[][] data = new Object[3][2];
		//columns in the row are nothing but values for that combination(row)
		//1st set
		data[0][0] = "firstusername";
		data[0][1] = "password1";
		//2nd set
		data[1][0] = "secondusername";
		data[1][1] = "secondpassword";
		//3rd set
		data[2][0] = "thirdusername";
		data[2][1] = "thirdpassword";
		
		return data;
	}

}
