package testScripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;

//THE PRODUCT SHOULD BE THERE IN THE CART(PRE CONDITION)

public class TC_E2E_03 extends BaseClass {
	@Test
	public void testScripts() {
		//Validates the home screen 
		Assert.assertEquals(driver.findElementByXPath("//android.view.View[@resource-id='cart']").isDisplayed(), true , "The Home screen is not displayed");
		Reporter.log("Homescreen is displayed",true);
		
		//will click on cart icon
		driver.findElementByXPath("//android.view.View[@resource-id='cart']").click();
		
		//Validates the cart Screen 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[@text='Continue Shopping']").isDisplayed(), true , "CartScreen is not displayed");
		Reporter.log("Cart Screen is displayed" , true);
		
		//will click on continue shopping button
		driver.findElementByXPath("//android.widget.Button[@text='Continue Shopping']").click();
		driver.findElementByXPath("//android.view.View[@resource-id='cart']").click();
		//will click on remove product button
		driver.findElementByXPath("//android.widget.Button[@text='REMOVE FROM CART']").click();
		//will click on yes confirmation button
		driver.findElementByXPath("//android.widget.Button[@text='YES']").click();
		
		Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Your cart is empty!']").isDisplayed(), true , "Not Removed");
		Reporter.log("The Product is removed successfully and Your cart is empty message is displayed",true);		
	}
}
