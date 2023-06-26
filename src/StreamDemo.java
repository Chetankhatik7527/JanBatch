import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> e1=driver.findElements(By.xpath("//tr/td[1]"));
		//get data of original list
		List<String> orginalList=e1.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println(orginalList);
		//sort string in ascending order
		List<String> sortedList=orginalList.stream().sorted().collect(Collectors.toList());
//		compare original list with sorted list
		Assert.assertTrue(orginalList.equals(sortedList));
		
//		scan the name column with getText->Beans->print the price of same
		List<String>price=e1.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
	}
	
	private static String getPriceVeggie(WebElement s)
	{
		String priceValue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}
}
