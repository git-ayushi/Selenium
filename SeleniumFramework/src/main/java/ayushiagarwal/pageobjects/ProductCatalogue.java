package ayushiagarwal.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ayushiagarwal.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{

	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		//initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);    //initElements will initialize/construct all the elements of PageFactory using driver object 
		                                           //so that all the elements such as @FindBy etc will have the knowledge of driver object		
	}
	
	//Page Factory
	@FindBy(xpath="//div[@class='card-body']")  //@FindBy is equivalent to driver.FindElementBy.
	List<WebElement> products;
	
	By product = By.xpath("//div[@class='card-body']");
	By productText = By.xpath("h5/b");
	By addToCart = By.xpath("button[@class='btn w-10 rounded']");
	By toastMessage  = By.id("toast-container");
	By spinner = By.cssSelector(".ng-animating");
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(product);
		return products;
	}
	
	public void addProductToCart(String productName) {
		
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).findElement(productText).getText().equalsIgnoreCase(productName)) {
				products.get(i).findElement(addToCart).click();
			}
		}
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
	}
	
	
	
		
	
	
}