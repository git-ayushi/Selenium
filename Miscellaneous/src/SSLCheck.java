import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ChromeOptions class is used to set the behavior of the browser
		ChromeOptions options = new ChromeOptions();
		//setting it to true so that it handles the SSL check by clicking on Advanced automatically
		options.setAcceptInsecureCerts(true);
		
		System.setProperty("webdriver.chrome.driver", "C:/work/chromedriver.exe");
		
		//passing options object as parameter in ChromeDriver so that it knows the behavior set in line 12
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com");
		System.out.println(driver.getTitle());
		driver.close();
	}

}
