import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelDemo14 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.path2usa.com/travel-companion/");
		System.out.println(driver.findElement(By.id("form-field-travel_comp_date")).isDisplayed());
		Thread.sleep(5000);

		driver.findElement(By.cssSelector("div input[name='form_fields[travel_comp_date]']")).click();
		Thread.sleep(3000);
		List<WebElement> dates=driver.findElements(By.className("flatpickr-day "));
		int count=driver.findElements(By.className("flatpickr-day ")).size();
		
		for(int i=0;i<count;i++)
		{
			String text=driver.findElements(By.className("flatpickr-day ")).get(i).getText();
			if(text.equalsIgnoreCase("23"))
			{
				driver.findElements(By.className("flatpickr-day ")).get(i).click();
			}
		}
	}

}
