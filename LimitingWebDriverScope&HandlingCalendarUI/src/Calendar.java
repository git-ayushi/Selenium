import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/work/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.cssSelector("span[class='langCardClose']")).click();
		driver.findElement(By.cssSelector("label[for='departure']")).click();
		Thread.sleep(4000);
		
		while(!driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]/div")).getText().contains("April")) {
			driver.findElement(By.cssSelector("span[aria-label='Next Month']")).click();
		}
		
		List<WebElement> dates = driver.findElements(By.xpath("//div[@class='dateInnerCell']/p[1]"));
		int count = dates.size();
		for(int i = 0; i < count; i++) {
			String text = driver.findElements(By.xpath("//div[@class='dateInnerCell']/p[1]")).get(i).getText();
			if(text.equalsIgnoreCase("29")){
				driver.findElements(By.xpath("//div[@class='dateInnerCell']/p[1]")).get(i).click();
				break;
				
			}
		}
		driver.close();
	}

}
