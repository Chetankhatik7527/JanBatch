import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SelDemo10 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Mouse hover effecct
			System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://ldce.ac.in/");
			
			Actions a=new Actions(driver);
			//Thread.sleep(10000);
			a.moveToElement(driver.findElement(By.cssSelector("li a[href='/admissions']"))).build().perform();
	}

}
