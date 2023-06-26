import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SelDemo1to6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Handling static dropdowns
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// implicit wait ; will wait for each element
																			// for 5 seconds to load them
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		System.out.println(driver.findElement(By.xpath("//a[@value='BLR']")).getText());
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		System.out.println(driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).getText());

		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		// driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))// to read the value from attribute
		{
			System.out.println("element is disabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		driver.findElement(By.id("divpaxinfo")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Thread.sleep(1000);

		int i = 1;
		while (i < 5) {
			Thread.sleep(500);
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		WebElement dp = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		// For static drop down Select class is used
		Select dropdown = new Select(dp);
		dropdown.selectByIndex(1);// select value from drop down by index no
		System.out.println(dropdown.getFirstSelectedOption().getText());// to print the text of the selected dropdown
																		// value
		Thread.sleep(1000);

		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();

		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}

}
