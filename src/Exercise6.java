import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercise6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");

			driver.findElement(By.id("checkBoxOption2")).click();
			String s=driver.findElement(By.cssSelector("label[for='benz']")).getText();
			System.out.println(s);
			
			Select select=new Select(driver.findElement(By.id("dropdown-class-example")));
			select.selectByVisibleText(s);
			System.out.println(select.getFirstSelectedOption().getText());
			
			Thread.sleep(1000);
			driver.findElement(By.name("enter-name")).sendKeys(s);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@value='Alert']")).click();
			Thread.sleep(1000);
			
			String alertText=driver.switchTo().alert().getText();
			
			if(alertText.contains(s))
			{
				System.out.println("Alert Message is successful");
			}
			else
			{
				System.out.println("Alert Message is unsuccessful");
			}
			
			driver.switchTo().alert().accept();
			
			
	}

}
