import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SelDemo6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Handling dynamic drop down 
				System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//implicit wait ; will wait for each element for 5 seconds to load them
				driver.manage().window().maximize();
				Thread.sleep(1000);
				driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//				Thread.sleep(4000);
				driver.findElement(By.id("autosuggest")).sendKeys("in");
				List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
				for(WebElement opt:options)
				{
					if(opt.getText().equalsIgnoreCase("Benin"))
					{
						Thread.sleep(1000);
						opt.click();
					}
				}
				//Handling checkboxes with assertions
				Assert.assertFalse(driver.findElement(By.xpath("//input[contains(@id,'StudentDiscount')]")).isSelected());
				driver.findElement(By.xpath("//input[contains(@id,'StudentDiscount')]")).click();
				Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@id,'StudentDiscount')]")).isSelected());
				System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());//Use of findElements method to get size of checkboxes
				
				
	}
}
