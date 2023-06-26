import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class SelDemo9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			
			//Below block is used to check whether element is visible or not
		     public WebElement apply(WebDriver driver) {
		       if(driver.findElement(By.cssSelector("#finish h4")).isDisplayed())//As text is disabled when one click on the Start button, so we are using this condition
		       {
		    	   return driver.findElement(By.cssSelector("#finish h4"));   
		       }
		       else
		    	   return null;
		    	
		     }
		   });
		 
		System.out.println(driver.findElement(By.cssSelector("#finish h4")).isDisplayed());
		System.out.println(driver.findElement(By.cssSelector("#finish h4")).getText());
	}

}
