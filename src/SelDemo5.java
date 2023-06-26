import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SelDemo5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Handling dynamic drop down 
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//implicit wait ; will wait for each element for 5 seconds to load them
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//Handling dynamic drop down using indexes-1st way
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		System.out.println(driver.findElement(By.xpath("//a[@value='BLR']")).getText());
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		System.out.println(driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).getText());
		
		/*
		//Handling dynamic drop down using parent child relationships-2nd way
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		*/
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));//To print the HTML tag attribute value
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))//to read the value from attribute
		{
			System.out.println("element is enabled");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("element is disabled");
			Assert.assertTrue(false);
		}
				

	}

}
