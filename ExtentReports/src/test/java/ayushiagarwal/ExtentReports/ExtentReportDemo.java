package ayushiagarwal.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReportDemo {

	ExtentReports extentReport;
	WebDriver driver;
	@BeforeTest
	public void config() {
		//ExtentReports and ExtentSparkReporter classes are used to create extent reports
		System.setProperty("webdriver.chrome.driver", "C:/work/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		//Extent Reports class is the main class that will take object of ExtentSparkReporter as argument to attach extent reporter
		extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Tester", "Ayushi Agarwal");
	}
	
	
	@Test
	public void initialDemo() {
		
		//Extent Test will store the object of the extent report test created after InitialDemo is run to manipulate the created extent report
		ExtentTest test = extentReport.createTest("Initial Demo");
		driver.get("https://www.rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("Results do not match");
		
		//flush() method is used to stop monitoring the execution now and prepare the final report
		extentReport.flush();
	}
	
}
