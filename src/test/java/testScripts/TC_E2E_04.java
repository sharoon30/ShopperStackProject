package testScripts;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TC_E2E_04 extends BaseClass{
	@Test
	public void testScripts() throws Exception{
		//Validates the home the home screen 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[@text='Account settings']").isDisplayed(), true , "Home screen is not displayed");
		Reporter.log("Home screen is displayed");
		
		//will click on account settings
		driver.findElementByXPath("//android.widget.Button[@text='Account settings']").click();
		
		//Validates Account settings menu screen 
		Assert.assertEquals(driver.findElementByXPath("//android.view.MenuItem[@text='My Profile']").isDisplayed(), true , "Account Setting menu is not displayed ");
		Reporter.log("Account Settings Menu is displayed" , true);
		
		//will click on my profile
		driver.findElementByXPath("//android.view.MenuItem[@text='My Profile']").click();
		
		//Validates My Profile Page 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='My Addresses']").isDisplayed(), true , "My Profile screen is not displayed");
		Reporter.log("My Profile Screen is displayed" , true);
		
		//will click on My Address Option 
		driver.findElementByXPath("//android.widget.TextView[@text='My Addresses']").click();
		
		//Validates My Address Screen
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[@text='ADD ADDRESS']").isDisplayed(), true , "My Address screen is Not displayed");
		Reporter.log("My address screen is displayed" , true);
		
		//will click on Add Address
		driver.findElementByXPath("//android.widget.Button[@text='ADD ADDRESS']").click();
		
		//Validates The Address Form Page
		Assert.assertEquals(driver.findElementByXPath("//android.widget.EditText[@resource-id=\r\n"
				+ "'Name']").isDisplayed(),true,"The Address Form page is not displayed");
		Reporter.log("The address form page is displayed" , true);
		
		//Will locate Name textField 
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
		scrollAndClick("Karnataka");
		//taps on city dropdown
		driver.findElementByXPath("//android.view.View[@resource-id='City']").click();
		//taps on bangalore 
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='Bengaluru']").click();
		//sends the pincode
		driver.findElementByXPath("//android.widget.EditText[@resource-id='Pincode']").sendKeys("432101");
		//Sends the phone number
		driver.findElementByXPath("//android.widget.EditText[@resource-id='Phone Number']").sendKeys("9876543210");
		//taps on add address
		driver.findElementByXPath("//android.widget.Button[@text='Add Address']").click();
		
		Reporter.log("Sucessfully added toast message is displayed",true);
		
		//Validates the new address has been displayed in the My Address Page
		Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='My Address']").isDisplayed(), true,"The new Address has not displayed in My address page");
		Reporter.log("The new address has been displayed in My address page",true);
		
		Thread.sleep(3000);
		
	}
	public void scrollAndClick(String value) {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+value+"\").instance(0))").click();
	}
}
