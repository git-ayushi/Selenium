package ayushiagarwal.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ayushiagarwal.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{

	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page Factory
		@FindBy(xpath="//tr/td[2]")  //@FindBy is equivalent to driver.FindElementBy.
		List<WebElement> orderItems;
	
	public Boolean verifyOrderDisplay(String productName) {
		for(int i = 0; i < orderItems.size(); i++) {
			if(orderItems.get(i).getText().equalsIgnoreCase(productName)) {
				return true;
			}			
		}
		return false;

   }
}
