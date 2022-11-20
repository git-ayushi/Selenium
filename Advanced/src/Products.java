import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Products {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/work/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise");

		// creating array of all veggies needed to add into cart
		String[] veggies = {"Cucumber","Brocolli","Beetroot","Carrot"};	
		addItems(driver, veggies);
		driver.close();

	}
	
	public static void addItems(WebDriver driver, String[] veggies) {
		int count = 0;
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		for (int i = 0; i < products.size(); i++) {
			String[] items = products.get(i).getText().split("-");
			// formatting the returned item Cucumber-1Kg to Cucumber to match it with arraylist elements
			String item = items[0].trim();

			// check whether name you extracted in present in arrayList or not
			// convert veggies array to arrayList for easy search

			List<String> veggiesList = Arrays.asList(veggies);

			if (veggiesList.contains(item)) {

				count++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (count == veggies.length) {
					break;
				}
			}
		}
		//explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		//explicit wait condition
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		//explicit wait condition
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		driver.findElement(By.xpath("//div[@class='products']//button[text()='Place Order']")).click();
		
	}

}
