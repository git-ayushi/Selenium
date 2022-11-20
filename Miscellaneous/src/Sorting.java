


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/work/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		
		//comparing two lists to verify sorting functionality
//		List<String> l1 = new ArrayList<>();
//		for(int i = 0; i < veggies.size(); i++) {
//			l1.add(veggies.get(i).getText());
//		}
//		List<String> l2 = l1;
//		Collections.sort(l1);
//		Assert.assertEquals(l2, l1);
		
		//finding price of column named apple
//		for(int i = 0; i < veggies.size(); i++) {
//			if(veggies.get(i).getText().equalsIgnoreCase("apple")) {
//				price = veggies.get(i).findElement(By.xpath("following-sibling::td[1]")).getText();
//			}
//		}
//		
//		System.out.println(price);
		
		//using Java Streams instead of for loop for below concepts
		
		List<String> originalList = veggies.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertEquals(originalList, sortedList);
		
		//scan the name column with getText and if it is equal to Rice->print the price of the Beans
		List<String> price;
		do {
	    List<WebElement> veggiesList = driver.findElements(By.xpath("//tr/td[1]"));	
		price = veggiesList.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s)).collect(Collectors.toList());
		
		price.forEach(s->System.out.println(s));	
		
		if(price.size()<1) {
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		}while(price.size()<1);
		driver.close();
	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String PriceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return PriceValue;
	}

}

