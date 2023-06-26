import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			System.out.println("Number of Rows:"+driver.findElements(By.cssSelector(".left-align tr")).size());
			System.out.println("Number of Cols:"+driver.findElements(By.cssSelector(".left-align tr th")).size());
//			System.out.println(driver.findElement(By.cssSelector(".left-align tr:nth-child(3)")).getText());
			
			
			List<WebElement> ele1=driver.findElements(By.cssSelector(".left-align tr:nth-child(3)"));
			for(int i=0;i<ele1.size();i++)
			{
				System.out.println(ele1.get(i).getText());
			}
			
			
	}

}
