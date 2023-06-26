import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SelDemo12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//frames locating
		System.setProperty("webdriver.chrome.driver",".//drivers//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));//switch to the frame 
		//driver.switchTo().frame(0);//switching to frame using index
		Actions a=new Actions(driver);
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement destination=driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, destination).build().perform();//drag from source and drop at destination
		driver.switchTo().defaultContent();//to get out from the frames
	}

}
