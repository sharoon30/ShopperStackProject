package testScripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import io.appium.java_client.android.AndroidElement;

public class TC_E2E_05 extends BaseClass{
	@Test
	public void testScripts() {
		//validate the home screen
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[@text='Account settings']").isDisplayed(), true,"Home Screen is not displayed");
		Reporter.log("Home page is displayed" , true);
		
		//will click on account settings
		driver.findElementByXPath("//android.widget.Button[@text='Account settings']").click();
		
		//Valildate's Account setting Menu 
		Assert.assertEquals(driver.findElementByXPath("//android.view.MenuItem[@text='My Profile']").isDisplayed(), true , "The Account setting menu is not displayed");
		Reporter.log("The account setting menu is Displayed" , true);
		
		//will click on my profile
		driver.findElementByXPath("//android.view.MenuItem[@text='My Profile']").click();
		
		//Validates My profile page 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='My Addresses']").isDisplayed(), true , "My Profile Screen is not displayed");
		Reporter.log("My Profile screen is displayed",true);

		//will click on My Address Option 
		driver.findElementByXPath("//android.widget.TextView[@text='My Addresses']").click();
		
		//Validates My Address page 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[contains(@text,'Home')]/following-sibling::android.view.View").isDisplayed(), true , "My Address Page is not displayd");
		Reporter.log("My Address page is displayed",true);
		
		//will click on edit icon 
		driver.findElementByXPath("//android.widget.TextView[contains(@text,'Home')]/following-sibling::android.view.View").click();
		
		//Validates Edit address screen
		Assert.assertEquals(driver.findElementByXPath("//android.widget.EditText[@resource-id='Phone Number']").isDisplayed(), true , "Edit address screen is not displayed");
		Reporter.log("Edit Address Screen is displayed",true);	
		
		//will locate the phonenumber textfield 
		driver.findElementByXPath("//android.widget.EditText[@resource-id='Phone Number']").clear();
		driver.findElementByXPath("//android.widget.EditText[@resource-id='Phone Number']").sendKeys("7234567891");
		//taps on update address
		driver.findElementByXPath("//android.widget.Button[@text='Update Address']").click();
		
		AndroidElement toastMessage = driver.findElementByXPath("//android.widget.TextView[@text='successfully updated']");
		Assert.assertEquals(toastMessage.isDisplayed(), true , "NotUpdated");
		Reporter.log("Updated Successfully",true);	
	}
}
