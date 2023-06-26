import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		/*To retrieve response code for Single Link
		String url=driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");//To get the url attached with the link
		
		HttpURLConnection hp=(HttpURLConnection)new URL(url).openConnection();
		hp.setRequestMethod("HEAD");
		hp.connect();
		int resCode=hp.getResponseCode();
		System.out.println(resCode);
*/
/*	For getting broken link from multiple links
		List<WebElement> links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for(WebElement link:links)
		{
			String url=link.getAttribute("href");//To get the url attached with the link
			
			HttpURLConnection hp=(HttpURLConnection)new URL(url).openConnection();
			hp.setRequestMethod("HEAD");
			hp.connect();
			int resCode=hp.getResponseCode();
			System.out.println(resCode);
			if(resCode>400)
			{
				System.out.println("The link with text is :"+ link.getText() + "is broken with code "+ resCode);
				Assert.assertTrue(false);

			}
		}
		*/
		//Use of SoftAssertions
		List<WebElement> links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a=new SoftAssert();
		for(WebElement link:links)
		{
			String url=link.getAttribute("href");//To get the url attached with the link
			
			HttpURLConnection hp=(HttpURLConnection)new URL(url).openConnection();
			hp.setRequestMethod("HEAD");
			hp.connect();
			int resCode=hp.getResponseCode();
			System.out.println(resCode);
			a.assertTrue(resCode<400,"The link with text is :"+ link.getText() + "is broken with code "+ resCode);
		}
		a.assertAll();//to report the failure with msg
	}

}
