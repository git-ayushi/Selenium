package ayushiagarwal.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ayushiagarwal.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
	
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		//initialization
				super(driver);
				this.driver = driver;
				PageFactory.initElements(driver, this);
	}

	@FindBy(css="h1[class='hero-primary']")
	WebElement confirmationMessage ;
	
	By orderDetail = By.cssSelector("h1[class='hero-primary']");
	
	public String getConfirmationMessage(){
		waitForElementToAppear(orderDetail);
		return confirmationMessage.getText();	
	}
	
	
	
}
