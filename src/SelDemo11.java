import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class SelDemo11 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Switching from one window to another
		System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.className("blinkingText")).click();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> itr1=windows.iterator();
		String parent=itr1.next();
		String child=itr1.next();
		driver.switchTo().window(child);
		Thread.sleep(2000);
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong/a[text()='mentor@rahulshettyacademy.com']")));
		String text=driver.findElement(By.xpath("//strong/a[text()='mentor@rahulshettyacademy.com']")).getText();
		System.out.println(text);
		Thread.sleep(2000);

		driver.switchTo().window(parent);
		driver.findElement(By.id("username")).sendKeys(text);
		

	}

}
