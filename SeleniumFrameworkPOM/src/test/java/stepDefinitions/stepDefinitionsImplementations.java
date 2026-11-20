package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import SeleniumFrameworkDesign.seleniumframework.pageobject.CheckOutPage;
import SeleniumFrameworkDesign.seleniumframework.pageobject.ConfirmationPage;
import SeleniumFrameworkDesign.seleniumframework.pageobject.LandingPage;
import SeleniumFrameworkDesign.seleniumframework.pageobject.cartpage;
import SeleniumFrameworkDesign.seleniumframework.pageobject.productCatalouge;
import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class stepDefinitionsImplementations extends BaseTest{
	
	public LandingPage landingpage;		
	public productCatalouge productcatlog;
	public ConfirmationPage confirmationpage;
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException
	{// code
		landingpage =launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+0)$")
	public void logged_in_with_username_and_password(String username, String password)
	{
		productcatlog = landingpage.loginApplication(username, password);

	}
	
	@When("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String productname) throws InterruptedException
	{
		List<WebElement> products = productcatlog.getProductList();
		productcatlog.addProductToCart(productname);
	}
	
	@When("^Checkout (.+) and sumbit order$")
	public void Checkout_and_submit_order(String productname)
	{
		cartpage cart = productcatlog.goToCartPage();
		boolean match = cart.verifyProductDisplay(productname);
		Assert.assertTrue(match);
		cart.goToCheckout();
		CheckOutPage checkoutpage = cart.goToCheckout();
		checkoutpage.selectCountry("India");
		confirmationpage = checkoutpage.submitOrder();
	}
	
}
