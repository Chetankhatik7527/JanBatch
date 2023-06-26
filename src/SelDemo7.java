import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelDemo7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Alert practice
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("input[placeholder='Enter Your Name']")).sendKeys("Chetan");
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(1000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(1000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();

	}

}
