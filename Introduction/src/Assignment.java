import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/work/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.xpath("//div/input[@name='name']")).sendKeys("Ayushi");
		driver.findElement(By.xpath("//div/input[@name='email']")).sendKeys("ayushi@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("practice");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement dropdownValue = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(dropdownValue);
		dropdown.selectByVisibleText("Female");
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("12-07-1995");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		System.out.println(driver.findElement(By.xpath("//div[contains(@class, 'success')]")).getText());
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'success')]")).getText()
				.contains("Success! The Form has been submitted successfully!."));
		Thread.sleep(3000);
		driver.close();
	}

}
