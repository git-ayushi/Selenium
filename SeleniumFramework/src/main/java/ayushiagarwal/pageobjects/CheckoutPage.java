package ayushiagarwal.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ayushiagarwal.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		//initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement placeholder;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement myCountry;
	
	@FindBy(css="a[class*='action__submit']")
	WebElement placeOrder;
	
	By selectCountry = By.cssSelector("section[class*='ta-results']");
	
	public void selectCountry(String countryName) {
		placeholder.sendKeys(countryName);
		waitForElementToAppear(selectCountry);
		myCountry.click();	
	}
	
	public ConfirmationPage submitOrder() {
		placeOrder.click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}
	

}
