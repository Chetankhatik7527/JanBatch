import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelDemo8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w= new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		String[] Veggies = { "Cucumber", "Brocolli", "Beetroot", "Beans" };
		Thread.sleep(2000);
		SelDemo8 s1 = new SelDemo8();
		addItems(driver, Veggies);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promocode")));

		driver.findElement(By.className("promocode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		
		
		System.out.println(driver.findElement(By.className("promoInfo")).getText());

	}

	public static void addItems(WebDriver driver, String[] Veggies) {
		List<WebElement> element = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < element.size(); i++) {
			String[] name = element.get(i).getText().split("-");
			String s1 = name[0].trim();
			List l1 = Arrays.asList(Veggies);
			int j = 0;
			if (l1.contains(s1)) {
				j++;

//				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
//				As text of button is changing from "Add to cart" to "Added" so it will not check right item located by above line , so use below line
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == Veggies.length) {
					break;
				}
			}

		}

	}
}
