import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/work/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("checkBoxOption2")).click();
		
		String labelName= "";
		if(driver.findElement(By.id("checkBoxOption2")).isSelected()) {
			labelName = driver.findElement(By.xpath("//label[@for='benz']")).getText();
			System.out.println(labelName);
		}
			
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select s = new Select(dropdown);
		s.selectByVisibleText(labelName);
		
		driver.findElement(By.id("name")).sendKeys(labelName);
		driver.findElement(By.id("alertbtn")).click();
		String alertText = driver.switchTo().alert().getText().split(",")[0].split(" ")[1].trim();
		if(alertText.equals(labelName)) {
			System.out.println("Text in alert is matching");
		}else {
			System.out.println("Text in alert is NOT matching");
		}
		driver.switchTo().alert().accept();	
		driver.close();
	}

}
