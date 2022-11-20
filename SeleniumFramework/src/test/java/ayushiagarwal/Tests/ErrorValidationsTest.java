package ayushiagarwal.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import ayushiagarwal.TestComponents.BaseTest;
import ayushiagarwal.TestComponents.RetryMechanism;
import ayushiagarwal.pageobjects.CartPage;
import ayushiagarwal.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest{

	@Test(groups= {"ErrorHandling"}, retryAnalyzer = RetryMechanism.class)
	public void loginValidation() throws IOException {
		landingPage.loginApplication("Teet!23@gmail.com", "Teet@123");
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
	}
	
	@Test
	public void productValidation() throws IOException {
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 33";
		String countryName = "India";
		String myOrderConfirmation = "Thankyou for the order.";	
		ProductCatalogue productCatalogue = landingPage.loginApplication("New!23@gmail.com", "News@123");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean value = cartPage.verifyProductDisplay(productName);
		Assert.assertFalse(value);
		
	}

}