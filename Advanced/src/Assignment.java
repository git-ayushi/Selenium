import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/work/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.cssSelector("label[class='customradio']:nth-child(2) span[class='checkmark']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.modal-content")));
		driver.findElement(By.id("okayBtn")).click();
		WebElement dropdown = driver.findElement(By.cssSelector(".form-control:nth-child(1)"));
		Select dropdownValue = new Select(dropdown);
		dropdownValue.selectByValue("consult");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.my-4")));

		//declaring an array instead of list bcoz array takes less memory as compared to list
		String[] phones = { "iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry" };
		addPhones(driver, phones);

		driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.btn-success")));
		driver.close();
	}

	public static void addPhones(WebDriver driver, String[] phones) throws InterruptedException {
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='card-title']/a"));
		int count = 0;
		//converting above created array into list
		List<String> phonesList = Arrays.asList(phones);
		for (int i = 0; i < products.size(); i++) {
			String item = products.get(i).getText();
			if (phonesList.contains(item)) {
				count++;
				driver.findElements(By.xpath("//button[text()='Add ']")).get(i).click();

				if (count == phones.length) {
					break;
				}
			}

		}
	}

}
