import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EndToEndFlow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/work/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//selecting the From and To dropdowns
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();

		//selecting current date
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();
		
		//validating disabled return date for one way trip
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("Its Enabled");
			Assert.assertTrue(false);			
		}else {
			System.out.println("Its Disabled");
			Assert.assertTrue(true);
		}
		Thread.sleep(3000);
		
		//selecting Senior Citizen checkbox
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		
		//selecting values from dynamic dropdown
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		int i = 1;
		while(i<5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		//selecting static dropdown
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(1);
		
		//finally clicking on search button
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		System.out.println("Search successfully performed");
		driver.close();
	}

}
