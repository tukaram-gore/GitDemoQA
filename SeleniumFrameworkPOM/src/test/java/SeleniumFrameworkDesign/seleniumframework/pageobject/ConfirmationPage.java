package SeleniumFrameworkDesign.seleniumframework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import reusbaleCodes.abstractComponenet;

public class ConfirmationPage extends abstractComponenet {
	

	WebDriver driver;
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		// initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	
	public String getConfirmationMessage()
	{
	return confirmationMessage.getText();
	}

}



