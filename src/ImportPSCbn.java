import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ImportPSCbn {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://103.20.104.189:8080/CBNPortal/");
		driver.findElement(By.id("navbarDarkDropdownMenuLink")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ul/li/h5[contains(text(),'Applicant')]/parent::li/div/a[1]")).click();
		Thread.sleep(9000);
		driver.findElement(By.id("txt_reference_id")).sendKeys("CHANECOP97");
		driver.findElement(By.id("txt_password")).sendKeys("Gnfc@123");
		Thread.sleep(6000);

		driver.findElement(By.id("btngetOtp")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("confirm")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("txt_otp")).sendKeys("111111");
		driver.findElement(By.id("btnveryifyotp")).click();
		Thread.sleep(3000);

		driver.findElement(By.className("confirm")).click();
		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Psychotrophic Substance ']")).click();
		driver.findElement(By.xpath(
				"//span[text()='Psychotrophic Substance ']/parent::span/following::div[2]/a/span[text()='Import Form']"))
				.click();

		// Importer Details
		WebElement element = driver.findElement(By.id("ddl_import_purpose_id"));
		Select select = new Select(element);
		select.selectByValue("1");

		WebElement element1 = driver.findElement(By.id("ddl_is_sole_selling_agent"));
		Select select1 = new Select(element1);
		select1.selectByValue("Y");
		driver.findElement(By.id("savedraft")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("confirm")).click();
		Thread.sleep(2000);

		// Exporter details
		driver.findElement(By.name("txt_exportername")).sendKeys("Roman Rock");
		driver.findElement(By.name("txt_exporteraddress")).sendKeys("Sample address");
		WebElement eleCountry = driver.findElement(By.id("ddl_export_country"));
		Select select2 = new Select(eleCountry);
		select2.selectByValue("1967");
		driver.findElement(By.id("txt_exportercity")).sendKeys("YehCity");
		driver.findElement(By.id("txt_exporterpincode")).sendKeys("123445");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='SAVE & NEXT']")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("confirm")).click();

		// Port details
		driver.findElement(By.cssSelector("a[data_id='6']")).click();
		Thread.sleep(1000);
		WebElement element3 = driver.findElement(By.id("ddl_entry_port_id"));
		Select select3 = new Select(element3);
		select3.selectByValue("139700");
		WebElement element4 = driver.findElement(By.id("ddl_exit_port_id"));
		Select select4 = new Select(element4);
		select4.selectByValue("139699");
		WebElement element5 = driver.findElement(By.id("ddl_transport_mode"));
		Select select5 = new Select(element5);
		select5.selectByValue("BY ROAD");
		driver.findElement(By.name("txt_route")).sendKeys("Route Follow");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='SAVE & NEXT']")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("confirm")).click();

		// Payment details
		WebElement element6 = driver.findElement(By.id("ddl_paymentmode"));
		Select select6 = new Select(element6);
		select6.selectByValue("Online");
		Thread.sleep(1000);
		WebElement payMethod = driver.findElement(By.id("ddl_payment_method"));
		Select select7 = new Select(payMethod);
		select7.selectByValue("CCavenue");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='SAVE & NEXT']")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("confirm")).click();

		// Documents
		driver.findElement(By.cssSelector("a[data_id='10']")).click();
		Thread.sleep(1000);
		WebElement docType = driver.findElement(By.id("ddl_PSImportdoctype"));
		Select select8 = new Select(docType);
		select8.selectByValue("1");
		
	}

}
