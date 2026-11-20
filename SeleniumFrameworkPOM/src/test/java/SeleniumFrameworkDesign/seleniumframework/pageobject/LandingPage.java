package SeleniumFrameworkDesign.seleniumframework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusbaleCodes.abstractComponenet;

public class LandingPage extends abstractComponenet {
	
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		// initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	WebElement userEmail= driver.findElement(By.id("userEmail"));
	//page factory
	@FindBy(id="userEmail")
	WebElement userEmail;
	
//driver.findElement(By.id("userPassword"))
	@FindBy(id="userPassword")
	WebElement userPassword;
	
//driver.findElement(By.id("login"))
	@FindBy(id="login")
	WebElement  submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement error;
	
	public  productCatalouge loginApplication(String email,String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		productCatalouge productcatlog = new productCatalouge(driver);
		return productcatlog;
	}
	
	public String getErrorMgs()
	{
		waitForWEBElementToAppear(error);
		return error.getText();
		
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

}
