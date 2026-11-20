package SeleniumFrameworkDesign.seleniumframework.pageobject;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TestComponents.BaseTest;

public class Errovalidation extends BaseTest{

	@Test
	public void LoginErrorValidation() throws IOException, InterruptedException
	{
		String productName="ZARA COAT 3";		
	 	productCatalouge productcatlog=	landingpage.loginApplication("Abcdxyz@gmail.com", "Abcd@123");
	 	
	 	Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMgs());
		
 }
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{
		String productName="ZARA COAT 3";		
	 	productCatalouge productcatlog=	landingpage.loginApplication("Abcdxyz@gmail.com", "Abcd@123");
		List<WebElement> products= 	productcatlog.getProductList();
		productcatlog.addProductToCart(productName);
		cartpage cart= 	productcatlog.goToCartPage();
		
		boolean match=	cart.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		//Assert.assertFalse(match);
}

}
