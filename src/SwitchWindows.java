import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindows {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
//		Switch to new tab or window
		driver.switchTo().newWindow(WindowType.TAB);//for new tab use WindowType.Window
		
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> it=s1.iterator();
		String parentWindow=it.next();
		String childWindow=it.next();
		Thread.sleep(5000);

		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");
		Thread.sleep(5000);
		String courseName=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(3).getText();
		System.out.println(courseName);
		driver.switchTo().window(parentWindow);
		Thread.sleep(3000);
		WebElement e2=driver.findElement(By.cssSelector("[name='name']"));
		e2.sendKeys(courseName);
		Thread.sleep(1000);
		//Scereenshot of webelement
		File file=e2.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		
		
//		get height & width
		System.out.println(e2.getRect().getDimension().getHeight());
		System.out.println(e2.getRect().getDimension().getWidth());
//		driver.quit();
	}

}
