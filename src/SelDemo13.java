import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelDemo13 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//		Limiting Webdriver scope
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		1. Count of all the links on the entire page
		int i = driver.findElements(By.tagName("a")).size();
		System.out.println(i);
//		One way to locate the element
//		System.out.println(driver.findElements(By.cssSelector("#gf-BIG a")).size());
//		2. Count the links from footer only
		// 2nd way to locate the element
		WebElement element = driver.findElement(By.id("gf-BIG"));// Limiting the webdriver scope like here we are
																	// counting for links for footer only
		System.out.println(element.findElements(By.tagName("a")).size());

//		3. Count links from first column of the footer
		WebElement columnCount = element.findElement(By.xpath("//table/tbody/tr/td/ul"));
		System.out.println(columnCount.findElements(By.tagName("a")).size());

//		4. Click on each link in the column and check if the pages are opening
		for (int j = 1; j < columnCount.findElements(By.tagName("a")).size(); j++) {
			String clickOnLinks = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnCount.findElements(By.tagName("a")).get(j).sendKeys(clickOnLinks);
			Thread.sleep(5000);
		}

//		5. Getting title of each windows opened

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();

		while (itr.hasNext()) {
			String titleOfWindow = driver.switchTo().window(itr.next()).getTitle();
			System.out.println(titleOfWindow);
			Thread.sleep(2000);
		}

	}

}
