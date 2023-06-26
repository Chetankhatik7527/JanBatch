import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelDemo3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Handling static dropdowns
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//implicit wait ; will wait for each element for 5 seconds to load them
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement dp=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		//For static drop down Select class is used
		Select dropdown=new Select(dp);
		dropdown.selectByIndex(1);//select value from drop down by index no
		System.out.println(dropdown.getFirstSelectedOption().getText());//to print the text of the selected dropdown value
		Thread.sleep(1000);
		dropdown.selectByVisibleText("AED");//select dropdown value using text name
		System.out.println(dropdown.getFirstSelectedOption().getText());//to print the text of the selected dropdown value
		Thread.sleep(1000);
		dropdown.selectByValue("USD");//select value from dropdown by attribute "Value"
		System.out.println(dropdown.getFirstSelectedOption().getText());//to print the text of the selected dropdown value
		Thread.sleep(1000);
		driver.close();
		
	}

}
