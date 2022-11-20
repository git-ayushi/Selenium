import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/work/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		int rows = driver.findElements(By.cssSelector("table[name='courses']  tr")).size();
		int columns = driver.findElements(By.cssSelector("table[name='courses']  tr th")).size();
		System.out.println(rows);
		System.out.println(columns);
		for(int i = 0; i < rows; i++) {
			if(i==3) {
				System.out.println(driver.findElements(By.cssSelector("table[name='courses']  tr")).get(i).getText());
				
			}
		}
		driver.close();
	}

}
