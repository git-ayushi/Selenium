package ayushiagarwal.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ayushiagarwal.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{

	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		//initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);    	
	}
	
	//Page Factory
	@FindBy(xpath="//div[@class='cartSection']/h3")  //@FindBy is equivalent to driver.FindElementBy.
	List<WebElement> cartItems;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutButton;
	
	By myCartHeader = By.cssSelector("div h1");
	
	public Boolean verifyProductDisplay(String productName) {
		waitForElementToAppear(myCartHeader);
		for(int i = 0; i < cartItems.size(); i++) {
			if(cartItems.get(i).getText().equalsIgnoreCase(productName)) {
				return true;
			}			
		}
		return false;
		
	}
	
	public CheckoutPage goToCheckout() {
		checkoutButton.click();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
	
	
	
		
	
	
}