package SeleniumFrameworkDesign.seleniumframework.pageobject;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void sumbitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		productCatalouge productcatlog = landingpage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productcatlog.getProductList();
		productcatlog.addProductToCart(input.get("product"));
		cartpage cart = productcatlog.goToCartPage();

		boolean match = cart.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		// Assert.assertFalse(match);

		cart.goToCheckout();
		CheckOutPage checkoutpage = cart.goToCheckout();
		checkoutpage.selectCountry("India");

		ConfirmationPage confirmationpage = checkoutpage.submitOrder();
		String confirmMessage = confirmationpage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	

	@DataProvider
	public Object[][] getData() throws IOException {
		/*
		 * HashMap<String, String> map = new HashMap<>(); map.put("email",
		 * "Abcdxyz@gmail.com"); map.put("password", "Abcd@123"); map.put("product",
		 * "ZARA COAT 3");
		 * 
		 * HashMap<String, String> map1 = new HashMap<>(); map1.put("email",
		 * "Shetty@gmail.com"); map1.put("password", "Iamking@000"); map1.put("product",
		 * "ADIDAS ORIGINAL");
		 */
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//data//PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}
}
