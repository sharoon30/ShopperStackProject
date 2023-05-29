package testScripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

//ALWAYS REMOVE THE ALREADY PRESENT PRODUCT THAT IS PRESENT IN WISHLIST BEFORE RUNNING THE SCRIPTS , THIS SCRIPTS IS BIT HARDCODED

public class TC_E2E_21 extends BaseClass{
	@Test
	public void testScripts() throws Exception{
		//Enabling desktopMode
		//Clicks on Dotted Hamburger
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='More options']").click();
		//Clicks on desktop site
		driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.android.chrome:id/checkbox']").click();
		
		//Validate Home screen 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='WOMEN']").isDisplayed() , true , "Home Screen is not displayed ");
		Reporter.log("Homescreen is displayed",true);
		
		//clicks on women major category 
		driver.findElementByXPath("//android.widget.TextView[@text='WOMEN']").click();
		
		Reporter.log("Detail Page is displayed",true);
		
		Thread.sleep(2000);
		//clicks on open space to close the women sub-categories
		TouchAction action = new TouchAction(driver);
		action.tap(TapOptions.tapOptions().withPosition(PointOption.point(128, 1180))).perform();

		
		
		Thread.sleep(2000);
		//clicks on the first heart symbol of the First product 
		action.tap(TapOptions.tapOptions().withPosition(PointOption.point(498, 1060))).perform();
		Reporter.log("wished listed fro the first product",true);
		
		//will click on account settings
		driver.findElementByXPath("//android.widget.Button[@text='Account settings']").click();
		
		Reporter.log("Account setting menu displayed",true);
		
		//will click on wishlist 
		driver.findElementByXPath("//android.view.MenuItem[@text='Wish List']").click();
		
		Reporter.log("Wishlist screen is displayed",true);
		
		//VAlidates whether clicked product is present here 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='indianclothings women kurti']").isDisplayed(), true, "The wishlisted product is not displayed");
		Reporter.log("WishListed product is displayed",true);
		
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.Button[@text='Account settings']").click();
		Reporter.log("Account setting menu dispayed",true);
		//clicks on Logout 
		driver.findElementByXPath("//android.view.MenuItem[@text='Logout']").click();
		Reporter.log("Logged Out",true);
	}
}