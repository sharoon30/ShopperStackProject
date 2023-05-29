package testScripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

//REMOVE THE PRODUCT FROMTHE CART


public class TC_E2E_29 extends BaseClass{
	@Test
	public void testScripts() throws Exception{
		//Enabling desktopMode
		//Clicks on Dotted Hamburger
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='More options']").click();
		//Clicks on desktop site
		driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.android.chrome:id/checkbox']").click();
		Reporter.log("HHomescreen is displayed",true);
		//clicks on beauty 
		driver.findElementByXPath("//android.widget.TextView[@text='BEAUTY']").click();
		Reporter.log("Beauty section clicked",true);
		//clicks on the first beauty product 
		driver.findElementByXPath("//android.widget.Image[@text='lip gloss']").click();
		Reporter.log("Product deailed is displayed",true);

		//clicks on add to cart button 
		driver.findElementByXPath("//android.widget.Button[@text='Add To Cart']").click();
		Reporter.log("Add to button was changed to Added",true);

		//clicks on cart icon 
		driver.findElementByXPath("//android.view.View[@resource-id='cart']").click();
		Reporter.log("CartScreen is displayed",true);

		//clicks on buy now 
		driver.findElementByXPath("//android.widget.Button[@text='Buy Now']").click();
		
		//clicks on address radio button 
		driver.findElementByXPath("//android.widget.RadioButton[contains(@text,'Address')]").click();
		Reporter.log("Order Confirmation message is displayed",true);

		//clicks on proceed
		driver.findElementByXPath("//android.widget.Button[@text='Proceed']").click();
		Reporter.log("Payment screen is displayed",true);

		//clicks on cash on delivery 
		driver.findElementByXPath("//android.widget.TextView[@text='Cash On Delivery (COD)']").click();
		
		//clicks on proceed 
		driver.findElementByXPath("//android.widget.Button[@text='Proceed']").click();
		Reporter.log("Order PLaced ",true);

		Thread.sleep(8000);
		
		//clicks on Account Settings
		driver.findElementByXPath("//android.widget.Button[@text='Account settings']").click();
		Reporter.log("Account settings menu is displayed",true);
		Thread.sleep(2000);
		
		//clicks on My orders link 
		driver.findElementByXPath("//android.view.MenuItem[@text='My Orders']").click();
		Reporter.log("Order screen is displayed",true);
		Thread.sleep(2000);
		
		//clicks on Cancel order 
		TouchAction action = new TouchAction(driver);
		action.tap(TapOptions.tapOptions().withPosition(PointOption.point(915,779))).perform();

		//clicks on yes confirmation button 
		driver.findElementByXPath("//android.widget.Button[@text='YES']").click();
		Reporter.log("Order cancelled",true);
		Thread.sleep(7000);
		//clicks on Account Settings
		driver.findElementByXPath("//android.widget.Button[@text='Account settings']").click();
		Reporter.log("Account setting menu ",true);
		//clicks on Logout 
		driver.findElementByXPath("//android.view.MenuItem[@text='Logout']").click();
		Reporter.log("Logged Out",true);
	}
}
