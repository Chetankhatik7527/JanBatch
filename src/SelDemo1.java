import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelDemo1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// implicit wait ; will wait for each element
																			// for 5 seconds to load them
		driver.manage().window().maximize();
//		Thread.sleep(3000);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//System.out.println(driver.getTitle());
		//System.out.println(driver.getCurrentUrl());
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
//		Thread.sleep(3000);
		System.out.println((driver.findElement(By.cssSelector("p.error")).getText()));
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);//Used for waiting for time period to stable the web page 
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Chetan");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("chetan@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("chetan123@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234567890");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
//		System.out.println(driver.findElement(By.cssSelector("form h2")).getText());
		System.out.println(driver.findElement(By.className("infoMsg")).getText());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@class,'pwd')][1]/button[1]")).click();
		Thread.sleep(2000);
		//Login page with correct user name and password
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*='Pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div/h1")).getText());
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".logout-btn")).click();



	}

}
  	
/*Course code
mport org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;



public class SelIntroduction {



public static void main(String[] args) {

//Invoking Browser

//Chrome - ChromeDriver exten->Methods close get

//Firefox- FirefoxDriver ->methods close get

// WebDriver  close  get

//WebDriver methods + class methods

// Chrome

         ChromeOptions options = new ChromeOptions();

         options.addArguments("--remote-allow-origins=*");

System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");

WebDriver driver = new ChromeDriver(options);



//Firefox

System.setProperty("webdriver.gecko.driver", "/Users/rahulshetty/Documents/geckodriver");

WebDriver driver1 = new FirefoxDriver();

//Microsoft Edge

System.setProperty("webdriver.edge.driver", "/Users/rahulshetty/Documents/msedgedriver");

WebDriver driver2 = new EdgeDriver();

driver.get("https://rahulshettyacademy.com");

System.out.println(driver.getTitle());

System.out.println(driver.getCurrentUrl());

driver.close();

//driver.quit();



}



}*/