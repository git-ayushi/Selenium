import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class Scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/work/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		//count the total no of links on the page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//limiting webDriver scope to only footer
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		//count the no of links only in the footer
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		//limiting footerDriver scope to only first column in footer
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		//count the no of links in first column footer
		int countOfColumnLinks = columnDriver.findElements(By.tagName("a")).size();
		System.out.println(countOfColumnLinks);
		
		//clicking on each link in columnDriver scope and checking if link is opening
		for(int i = 1; i < countOfColumnLinks; i++) {
			
			String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
			
		}
		
		//printing title from each child window opened
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
//		String parentId = it.next();
//		String childId = it.next();
//		driver.switchTo().window(childId);
//		System.out.println(driver.getTitle());
//		driver.close();	
//		driver.switchTo().window(parentId);	
//                     OR
//      checking if window has next window present and then printing the next window's title after switching to it
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());		
		}
			
		
		driver.quit();
		
	}

}
