import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exercise3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input#password")).sendKeys("learning");
		driver.findElement(By.cssSelector("input[value='user']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("okayBtn")).click();
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.cssSelector("div select[data-style='btn-info']"));
		Select dropdown = new Select(element);
		dropdown.selectByIndex(2);
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn btn-info']")));
		List<WebElement> element1 = driver.findElements(By.cssSelector("button[class='btn btn-info']"));
		for (int i = 0; i < element1.size(); i++) {
			driver.findElements(By.cssSelector("button[class='btn btn-info']")).get(i).click();
		}

		Thread.sleep(1000);
		driver.findElement(By.cssSelector("li a[class='nav-link btn btn-primary']")).click();
	}

}
