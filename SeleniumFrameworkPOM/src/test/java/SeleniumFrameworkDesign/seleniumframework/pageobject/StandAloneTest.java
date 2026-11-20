package SeleniumFrameworkDesign.seleniumframework.pageobject;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		
		// to handle pop up
		
		String productname="ZARA COAT 3";		
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize(); 

		driver.get("https://rahulshettyacademy.com/client");
		LandingPage obj= new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("Abcdxyz@gmail.com");
			
		driver.findElement(By.id("userPassword")).sendKeys("Abcd@123");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		Thread.sleep(4000);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//ng-animating
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
	List<WebElement> CartProducts= driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
	
	boolean match=	 CartProducts.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(productname));
	Assert.assertTrue(match);
	
// checkout
	Thread.sleep(12000);
	driver.findElement(By.xpath("//button[contains(.,'Checkout')]")).click();
	
	Actions a = new Actions(driver);
	 a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"india").build().perform();
	 
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ta-results")));
	 
	 Thread.sleep(2000);	
	 driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	 driver.findElement(By.xpath("//div//a[@class='btnn action__submit ng-star-inserted']")).click();
	 
String confirmMSg=	 driver.findElement(By.cssSelector(".hero-primary")).getText();
	 
Assert.assertTrue(confirmMSg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
driver.close();
	
	
	

	}

}
