import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelDemo4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Handling static drop down without of select tag
				System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//implicit wait ; will wait for each element for 5 seconds to load them
				driver.manage().window().maximize();
				Thread.sleep(1000);
				driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
				driver.findElement(By.id("divpaxinfo")).click();
				System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
				Thread.sleep(1000);
				
				int i=1;
				while(i<5)
				{
					Thread.sleep(500);
					driver.findElement(By.id("hrefIncAdt")).click();	
					i++;
				}
				driver.findElement(By.id("btnclosepaxoption")).click();
				System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}

}
