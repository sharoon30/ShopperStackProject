package testScripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TC_E2E_22 extends BaseClass{
	@Test
	public void testScripts() throws Exception{
		//Enabling desktopMode
		//Clicks on Dotted Hamburger
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='More options']").click();
		//Clicks on desktop site
		driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.android.chrome:id/checkbox']").click();
		Reporter.log("Homescreen displayed",true);
		//clicks on women major category 
		driver.findElementByXPath("//android.widget.TextView[@text='WOMEN']").click();
		Reporter.log("women category is selected",true);
		Thread.sleep(2000);
		//clicks on open space to close the women sub-categories
		TouchAction action = new TouchAction(driver);
		action.tap(TapOptions.tapOptions().withPosition(PointOption.point(128, 1180))).perform();

		Thread.sleep(2000);
		//clicks on the first heard symbol of the First product 
		action.tap(TapOptions.tapOptions().withPosition(PointOption.point(498, 1060))).perform();
		Reporter.log("Product wishlisted",true);

		//will click on account settings
		driver.findElementByXPath("//android.widget.Button[@text='Account settings']").click();
		Reporter.log("Account settings Menu is displayed",true);
		//will click on wishlist 
		driver.findElementByXPath("//android.view.MenuItem[@text='Wish List']").click();
		Reporter.log("Wishlist page is displayed",true);
		//will tap on remove from the wishlist button 
		driver.findElementByXPath("//android.widget.TextView[@text='indianclothings women kurti']//following-sibling::android.widget.Button[@text='REMOVE FROM WISHLIST?']").click();
		Reporter.log("Product removed",true);
		int x = 903;
		int y = 1413;
		//handles alert
		handleAlert(x, y);
		
		Thread.sleep(2000);
		//clicks on Account Settings
		driver.findElementByXPath("//android.widget.Button[@text='Account settings']").click();
		Reporter.log("Account settings Menu is display",true);
		//clicks on Logout 
		driver.findElementByXPath("//android.view.MenuItem[@text='Logout']").click();
		Reporter.log("Logged Out",true);
	}
	public void handleAlert(int x , int y) throws Exception{
		int i = 1;
		TouchAction action = new TouchAction(driver);
		while(i<=5) {
			Thread.sleep(1000);
			if(i<=5) {
				action.tap(TapOptions.tapOptions().withPosition(PointOption.point(x, y))).perform();
				x = x - 8;
			}
			else {
				x = x + 19;
				y = y + 15;
				action.tap(TapOptions.tapOptions().withPosition(PointOption.point(x, y))).perform();
			}
			i++;
		}
	}
}
