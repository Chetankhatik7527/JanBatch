import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercise2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.xpath("//form/div/input[@minlength='2']")).sendKeys("Jack Sparrow");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("jks@yahoo.in");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("JKS@12345");
		driver.findElement(By.id("exampleCheck1")).click();
		Thread.sleep(1000);

		WebElement element=driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown=new Select(element);
		dropdown.selectByIndex(0);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		Thread.sleep(1000);
		
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.cssSelector("input[type='date']")).sendKeys("12/05/2023");
		driver.findElement(By.xpath("//input[contains(@value,'Submit')]")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
		
		

	}

}
