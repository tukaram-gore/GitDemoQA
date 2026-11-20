package SeleniumFrameworkDesign.seleniumframework.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusbaleCodes.abstractComponenet;

public class cartpage extends abstractComponenet {

	WebDriver driver;
	public cartpage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css =".toatlRow button")
	WebElement checkoutEle;
	
	//	List<WebElement> CartProducts= driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
	@FindBy(xpath = "//div[@class='cartSection']/h3")
	private List<WebElement> CartProducts;
	
	public boolean verifyProductDisplay(String productName)
	{
		boolean match=	 CartProducts.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckOutPage goToCheckout()
	{
		checkoutEle.click();
		return new CheckOutPage(driver);
	}

}
