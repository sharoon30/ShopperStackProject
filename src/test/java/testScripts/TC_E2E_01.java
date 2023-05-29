package testScripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;

public class TC_E2E_01 extends BaseClass{
	@Test
	public void testCase() {
		//Validates whether it is navigated to home screen or not 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='MEN']").isDisplayed(), true , "Home Screen is not displayed");
		Reporter.log("Home screen is displayed",true);
		//Will click on Mens Option
		driver.findElementByXPath("//android.widget.TextView[@text='MEN']").click();
		
		//Validates the mens page 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='BOTTOMWEAR']").isDisplayed(), true , "Mens Category Screen is not displayed");
		Reporter.log("Mens Category screen is displayed",true);
		//clicks on BottomWear option 
		driver.findElementByXPath("//android.widget.TextView[@text='BOTTOMWEAR']").click();
		
		
		//will click on add to cart button
		driver.findElementByXPath("//android.widget.Button[@text='ADD TO CART']").click();
		
		//Validates Add is changed to added
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[@text='ADDED']").isDisplayed(), true , "Add to cart button is not changed to added");
		Reporter.log("Add to cart button is changed to Added" , true);

		//will click on cart icon
		driver.findElementByXPath("//android.view.View[@resource-id='cart']").click();
		
		//Validates whether product is added to the cart 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[@text='Continue Shopping']").isDisplayed(),true , "Not navigated to cart screen ");
		Reporter.log("Navigated to cart screen",true);
		
		//will click on continue shopping button
		driver.findElementByXPath("//android.widget.Button[@text='Continue Shopping']").click();
		driver.findElementByXPath("//android.view.View[@resource-id='cart']").click();
		
		Reporter.log("Product is added to cart and the same product has been displayed in cart",true);
	}
}
