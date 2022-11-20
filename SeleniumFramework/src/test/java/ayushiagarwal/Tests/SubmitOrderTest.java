package ayushiagarwal.Tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ayushiagarwal.TestComponents.BaseTest;
import ayushiagarwal.pageobjects.CartPage;
import ayushiagarwal.pageobjects.CheckoutPage;
import ayushiagarwal.pageobjects.ConfirmationPage;
import ayushiagarwal.pageobjects.OrderPage;
import ayushiagarwal.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{

	//String productName = "ZARA COAT 3";
	@Test(dataProvider= "getData", groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException {
		String countryName = "India";
		String myOrderConfirmation = "Thankyou for the order.";	
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean value = cartPage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(value);
		CheckoutPage checkoutPage  = cartPage.goToCheckout();
		checkoutPage.selectCountry(countryName);
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(myOrderConfirmation));
	}
	
	@Test(dataProvider="getData",dependsOnMethods= {"submitOrder"})
	public void orderHistoryTest(HashMap<String,String> input) {
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		OrderPage orderPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(input.get("product")));				
	}
	
	//dataProvider using hashmap
//	@DataProvider
	@DataProvider
	public Object[][] getData() throws IOException {
//		HashMap<String,String> map = new HashMap<>();
//		map.put("email", "Test!23@gmail.com");
//		map.put("password", "Test@123");
//		map.put("product", "ZARA COAT 3");
//		
//		HashMap<Object,Object> map1 = new HashMap<>();
//		map1.put("email", "New!23@gmail.com");
//		map1.put("password", "News@123");
//		map1.put("product", "ADIDAS ORIGINAL");
		
		//data provider using json file 
		List<HashMap<String, String>> data = getJsonDataToHashmap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
	
	//dataProvider using multi-dimensional array
//	@DataProvider
//	public Object[][] getData(){
//		return new Object[][] {{"Test!23@gmail.com","Test@123","ZARA COAT 3"},{"New!23@gmail.com","News@123","ADIDAS ORIGINAL"}};
//	}

}
