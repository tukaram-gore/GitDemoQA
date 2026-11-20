package reusbaleCodes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumFrameworkDesign.seleniumframework.pageobject.cartpage;

public class abstractComponenet {
	
	WebDriver driver;
	public abstractComponenet(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);

		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;

	public void waitForElementToAppear(By FindBy) {
		
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	
	public void waitForWEBElementToAppear(WebElement FindBy) {
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(FindBy));
		}
	
	public cartpage goToCartPage() 
	{
		cartHeader.click();
		cartpage cart= new cartpage(driver);
		return cart;

	}
			
	
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
		
		Thread.sleep(3000);
	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	//	wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
}
