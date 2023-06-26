import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ImportCSCbn {

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
		driver.findElement(By.xpath("//span[text()='Controlled Substance']")).click();
		driver.findElement(By.xpath(
				"//span[text()='Controlled Substance']/parent::span/following::div[2]/a/span[text()='Import Form']"))
				.click();

		// Importer Details
		
		driver.findElement(By.id("savedraft")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("confirm")).click();
		Thread.sleep(2000);

		// Exporter details
		driver.findElement(By.name("txt_imp_exname")).sendKeys("Roman Rock");
		driver.findElement(By.name("txt_imp_exaddress")).sendKeys("Sample address");
		WebElement eleCountry = driver.findElement(By.id("ddl_exporter_country"));
		Select select2 = new Select(eleCountry);
		select2.selectByValue("1967");
		driver.findElement(By.id("txt_exporter_city")).sendKeys("YehCity");
		driver.findElement(By.id("txt_exporter_pincode")).sendKeys("123445");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='SAVE & NEXT']")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("confirm")).click();

		// Port details
		driver.findElement(By.cssSelector("a[data_id='4']")).click();
		Thread.sleep(1000);
		WebElement element3 = driver.findElement(By.id("ddl_imp_entryport"));
		Select select3 = new Select(element3);
		select3.selectByValue("139700");
		WebElement element4 = driver.findElement(By.id("ddl_imp_exitport"));
		Select select4 = new Select(element4);
		select4.selectByValue("139699");
		WebElement element5 = driver.findElement(By.id("ddl_imp_transport"));
		Select select5 = new Select(element5);
		select5.selectByValue("BY ROAD");
		driver.findElement(By.name("txt_imp_route")).sendKeys("Route Follow");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='SAVE & NEXT']")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("confirm")).click();

		// Documents
		driver.findElement(By.cssSelector("a[data_id='7']")).click();
		Thread.sleep(1000);
		WebElement docType = driver.findElement(By.id("ddl_imcs_doctype"));
		Select select8 = new Select(docType);
		select8.selectByValue("1");


		//Background Information
		driver.findElement(By.cssSelector("a[data_id='8']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name='impurpose'][value='No']")).click();
		driver.findElement(By.cssSelector("input[name='chemical'][value='No']")).click();
		WebElement entityType = driver.findElement(By.id("ddl_plantEntity"));
		Select select9 = new Select(entityType);
		select9.selectByValue("3");
		Thread.sleep(1000);
		driver.findElement(By.id("chemical_purpose_1")).sendKeys("purpose of Trader");
		driver.findElement(By.id("chemical_purpose_2")).sendKeys("purpose of Manufacturing");
		driver.findElement(By.id("chemical_purpose_3")).sendKeys("purpose of both");

		driver.findElement(By.cssSelector("input[name='broker'][value='No']")).click();
		driver.findElement(By.name("txt_trans_payment")).sendKeys("Entering");
		driver.findElement(By.name("txt_qty_detail")).sendKeys("Entering");
		driver.findElement(By.cssSelector("input[name='license'][value='No']")).click();
		driver.findElement(By.name("declaration")).click();


	}

}
