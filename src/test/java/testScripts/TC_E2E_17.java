package testScripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TC_E2E_17 extends BaseClass{
	@Test
	public void  testScripts() throws Exception{
		//Enabling desktopMode
		//Clicks on Dotted Hamburger
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='More options']").click();
		//Clicks on desktop site
		driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.android.chrome:id/checkbox']").click();
		
		//Validate Home screen 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[@text='Account settings']").isDisplayed(), true , "Home screen is not displayed");
		Reporter.log("Home screen is displayed",true);
		
		//will click on account settings
		driver.findElementByXPath("//android.widget.Button[@text='Account settings']").click();
		
		//Validate Account setting Menu 
		Assert.assertEquals(driver.findElementByXPath("//android.view.MenuItem[@text='My Profile']").isDisplayed(), true , "Account Setting Menu is not displayed");
		Reporter.log("Account setting Menu is displayed",true);
		
		//will click on my profile
		driver.findElementByXPath("//android.view.MenuItem[@text='My Profile']").click();
		
		//Validates Profile Screen 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='My Likes']").isDisplayed(), true , "My profile screen is not displayed");
		Reporter.log("My Profile screen is displayed",true);
		
		//will click on my likes option 
		driver.findElementByXPath("//android.widget.TextView[@text='My Likes']").click();
		
		//Validates Likes Page 
		Assert.assertEquals(driver.findElementByXPath("//android.view.View[@text='Select Category']").isDisplayed(), true , "Likes Screen is not displayed");
		Reporter.log("LIkes screen is displayed" , true);
		
		//will click on select category
		driver.findElementByXPath("//android.view.View[@text='Select Category']").click();
		//will click on Mens 
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='Men']").click();
		//will click on sub category 
		driver.findElementByXPath("//android.view.View[@resource-id='Category Type']").click();
		//will click on Tshirt
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='Tshirt']").click();
		//will click on OK confirmation button 
		driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
		//will click on submit
		driver.findElementByXPath("//android.widget.Button[@text='Submit']").click();
		Reporter.log("Success Message is displayed",true);
		
		//will clicks on Cancel icon on My Previous liked product
		Thread.sleep(6000);
		TouchAction action = new TouchAction(driver);
		action.tap(TapOptions.tapOptions().withPosition(PointOption.point(542, 976))).perform();
		Thread.sleep(9000);
		driver.findElementByXPath("//android.widget.Button[@text='Account settings']").click();
		
		//Validates Account setting menu 
		Assert.assertEquals(driver.findElementByXPath("//android.view.MenuItem[@text='Logout']").isDisplayed(), true , "Account Setting is not displayed");
		Reporter.log("Account setting menu is displayed",true);
		
		//clicks on Logout 
		driver.findElementByXPath("//android.view.MenuItem[@text='Logout']").click();
		Reporter.log("Logged Out",true);
	}
}
