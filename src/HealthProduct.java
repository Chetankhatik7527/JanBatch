import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HealthProduct {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://10.0.21.53/HealthBond_QA");
		for(int i=532;i<=714;i++)
		{
			Thread.sleep(2000);
			WebElement e1=driver.findElement(By.id("txtContactNo"));

			e1.sendKeys("9724168"+i);
			
		
		driver.findElement(By.id("btnsendotp")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='jconfirm-buttons']/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("1111");
		Thread.sleep(1000);
		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='jconfirm-buttons']/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Choice Selection']")).click();
		Thread.sleep(1000);
		WebElement ele1 = driver.findElement(By.id("drpDistrict"));
		Select select2 = new Select(ele1);
		select2.selectByValue("1");
		Thread.sleep(1000);
		WebElement ele2 = driver.findElement(By.id("drpTalukaId"));
		Select select3 = new Select(ele2);
		select3.selectByValue("12");
		
		Actions action=new Actions(driver);
		action.dragAndDrop(driver.findElement(By.xpath("//li[@class='ui-state-default']")), driver.findElement(By.id("sortable2"))).build().perform();
		
		Thread.sleep(1000);
		select3.selectByValue("13");
		Thread.sleep(1000);
		action.dragAndDrop(driver.findElement(By.id("r_1")), driver.findElement(By.id("sortable2"))).build().perform();
		
		Thread.sleep(1000);
		select3.selectByValue("10");
		Thread.sleep(1000);
		action.dragAndDrop(driver.findElement(By.id("r_1")), driver.findElement(By.id("sortable2"))).build().perform();
		
		
		Thread.sleep(1000);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='jconfirm-buttons']/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Log Out']")).click();
		
		}
	}

}
