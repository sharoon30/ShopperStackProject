package testScripts;


import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TC_E2E_13 extends BaseClass{
	@Test
	public void testScripts() throws Exception{
		//Enabling desktopMode
		//Clicks on Dotted Hamburger
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='More options']").click();
		//Clicks on desktop site
		driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.android.chrome:id/checkbox']").click();
		
		//Validate home screen 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[@text='Account settings']").isDisplayed(), true,"Home screen is not displayed");
		Reporter.log("Home screen is displayed",true);
		
		//will click on account settings
		driver.findElementByXPath("//android.widget.Button[@text='Account settings']").click();
		
		//Validate account settings screen
		Assert.assertEquals(driver.findElementByXPath("//android.view.MenuItem[@text='My Profile']").isDisplayed(),true,"Account settings screen is not displayed");
		Reporter.log("Account settings is displayed",true);
		
		//will click on my profile
		driver.findElementByXPath("//android.view.MenuItem[@text='My Profile']").click();
		
		//Validate Profile screen 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='My Addresses']").isDisplayed(),true,"Profile screen is not displayed");
		Reporter.log("Profile screen is displayed",true);
		
		//will click on My Address Option 
		driver.findElementByXPath("//android.widget.TextView[@text='My Addresses']").click();
		
		//Validate My Address page 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[@text='ADD ADDRESS']").isDisplayed(), true , "My address page is not displayed");
		Reporter.log("My address screen is displayed",true);
		
		//will click on Add Address
		driver.findElementByXPath("//android.widget.Button[@text='ADD ADDRESS']").click();
		
		//Validate Add address screen 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.EditText[@resource-id=\r\n"
				+ "'Name']").isDisplayed(), true , "Add adress screen is not displayed");
		Reporter.log("Add adress screen is displayed",true);
		
		
		//Will locatte Name textField 
		driver.findElementByXPath("//android.widget.EditText[@resource-id=\r\n"
				+ "'Name']").sendKeys("Neeraja");
		//will locate HouseTextField 
		driver.findElementByXPath("//android.widget.EditText[@resource-id=\r\n"
				+ "'House/Office Info']").sendKeys("961");
		//will locate Street INfo
		driver.findElementByXPath("//android.widget.EditText[@resource-id=\r\n"
				+ "'Street Info']").sendKeys("MG Road");
		//will locate LandMark textfield 
		driver.findElementByXPath("//android.widget.EditText[@resource-id=\r\n"
				+ "'Landmark']").sendKeys("Near Metrostation");
		//taps on ContryDropdown 
		driver.findElementByXPath("//android.view.View[@text='Country']").click();
		//taps on India 
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='India']").click();
		//taps on State dropdown 
		driver.findElementByXPath("//android.view.View[@text='State']").click();
		Thread.sleep(2000);
		scrollAndClick("Karnataka");
		//taps on city dropdown
		driver.findElementByXPath("//android.view.View[@resource-id='City']").click();
		//taps on bangalore 
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='Bengaluru']").click();
		//clicks on deliverable pincodes
		driver.findElementByXPath("//android.widget.Image[@text='Deliverable pincodes']").click();
		String pincode = driver.findElementByXPath("//android.view.View[@text='Thane']/following-sibling::android.view.View").getText();
		TouchAction action = new TouchAction(driver);
		action.tap(TapOptions.tapOptions().withPosition(PointOption.point(815, 1084))).perform();
		//send the value to the pincode text field 
		driver.findElementByXPath("//android.widget.EditText[@resource-id='Pincode']").sendKeys(pincode);
		//sends the value to the phone number text field 
		driver.findElementByXPath("//android.widget.EditText[@resource-id='Phone Number']").sendKeys("9876543210");
		//taps on add address
		driver.findElementByXPath("//android.widget.Button[@text='Add Address']").click();
		//taps on delete icon 
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.widget.Button").click();
		//taps on yes confirmation button 
		driver.findElementByXPath("//android.widget.Button[@text='YES']").click();
		int x = 903;
		int y = 1413;
		//handles alert
		handleAlert(x, y);
		Thread.sleep(3000);
		
		//Validate Remove address 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[@text='Account settings']").isDisplayed(),true , "Address is not removed");
		Reporter.log("Address is removed successfully",true);
		
		driver.findElementByXPath("//android.widget.Button[@text='Account settings']").click();
		//clicks on Logout 
		
		Reporter.log("Account setting Menu is displayed",true);
		
		driver.findElementByXPath("//android.view.MenuItem[@text='Logout']").click();
		
		Reporter.log("Logged Out",true);
	}
	public void scrollAndClick(String value) {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+value+"\").instance(0))").click();
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
