import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".//drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/windows");
		
		driver.findElement(By.xpath("//div/a[text()='Click Here']")).click();
		Set<String> window=driver.getWindowHandles();
		Iterator<String> itr=window.iterator();
		String parent=itr.next();
		String child=itr.next();
		driver.switchTo().window(child);
		String str1=driver.findElement(By.cssSelector("div[class='example'] h3")).getText();
		System.out.println(str1);
		driver.switchTo().window(parent);
		String str2=driver.findElement(By.xpath("//div/h3[text()='Opening a new window']")).getText();
		System.out.println(str2);
		
	}

}
