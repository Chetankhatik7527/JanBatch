import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SelDemo2 {

	public static void main(String[] args) throws InterruptedException {

		String name = "rahul";
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// implicit wait ; will wait for each element
																			// for 5 seconds to load them
		driver.manage().window().maximize();
		Thread.sleep(1000);
		String s1 = getPasswordText(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys(s1);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
				"Hello " + name + ",");
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		Thread.sleep(1000);
		driver.close();
	}

	public static String getPasswordText(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		Thread.sleep(1000);// Used for waiting for time period to stable the web page
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("chetan@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234567890");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		Thread.sleep(1000);

		System.out.println(driver.findElement(By.className("infoMsg")).getText());
		String passwordText = driver.findElement(By.className("infoMsg")).getText();
		String[] pwdArray = passwordText.split("'");
		// one way
		/*
		 * String[] pwdArray1=pwdArray[1].split("'"); Split method splits the string
		 * into array of strings 0th index will display string before ' 1th index will
		 * display string after '
		 * 
		 * String finalText=pwdArray1[0]; System.err.println(finalText); return
		 * finalText;
		 */
		// second way
		String finalText = pwdArray[1].split("'")[0];
		return finalText;

	}

}
