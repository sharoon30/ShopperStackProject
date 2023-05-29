package testScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

//DONT KNOW HOW TO HANDLE THE MOBILE ALERTS(AND THE MOBILE ALERT IS ALSO NOT DISPLAYING IN THE APPIUM CANNOT BE IDENTIFIED)
//KEYBOARD IS POPPING UP AND DONT KNOW HOW TO DISABLE IT 


public class TC_E2E_06 extends BaseClass{
	@Test
	public void testScripts() throws Exception{
		//validates home page
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[@text='Account settings']").isDisplayed(), true,"The Home Screen is not displayed");
		Reporter.log("The home screen is displayed",true);
		
		//will click on account settings
		driver.findElementByXPath("//android.widget.Button[@text='Account settings']").click();
		
		//Validates Account Settings Options
		Assert.assertEquals(driver.findElementByXPath("//android.view.MenuItem[@text='My Profile']").isDisplayed(), true , "The account settings Options are not displayed");
		Reporter.log("The Account settings Options are displayed ",true);
		
		//will click on my profile
		driver.findElementByXPath("//android.view.MenuItem[@text='My Profile']").click();
		
		//Validates my profile screen 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[contains(@text,'Profile')]").isDisplayed(), true,"My Profile screen is not displayed");
		Reporter.log("My profile screen is displayed",true);
		
		//will tap on edit profile 
		driver.findElementByXPath("//android.widget.Button[contains(@text,'Profile')]").click();
		
		//Edit Profile Pop Up should be displayed
		Assert.assertEquals(driver.findElementByXPath("//android.widget.EditText[@resource-id='First Name']").isDisplayed(), true , "Edit Profile Pop up is not displayed");
		Reporter.log("Edit profile pop is displayed",true);
		
		//will locate firstName text field
		driver.findElementByXPath("//android.widget.EditText[@resource-id='First Name']").clear();
		driver.findElementByXPath("//android.widget.EditText[@resource-id='First Name']").sendKeys("Dinesh");
		
		Reporter.log("First Name is entered",true);
		
		//will locate the last name text field
		driver.findElementByXPath("//android.widget.EditText[@resource-id='Last Name']").clear();
		driver.findElementByXPath("//android.widget.EditText[@resource-id='Last Name']").sendKeys("Kumar");
		
		Reporter.log("Last Name is entered",true);
		
		//Will locate date of birth text field 
		driver.findElementByXPath("//android.widget.EditText[@resource-id=':r5:']").click();

		//will click on edit date of birth icon 
		driver.findElementByXPath("(//android.widget.Button[contains(@text,'calendar view')])[1]").click();
		//will clear the date of birth 
		driver.findElementByXPath("//android.widget.EditText[@resource-id=':r9:']").clear();
		driver.findElementByXPath("//android.widget.EditText[@resource-id=':r9:']").sendKeys("02/01/1998");
		
		Reporter.log("Date of Birth is Enterd",true);
		
		//will tap on OK confirmation button
		driver.findElementByXPath("//android.widget.Button[@text='OK']").click();

		//will locate the phone number text field 
		driver.findElementByXPath("//android.widget.EditText[@resource-id='Phone Number']").clear();
		driver.findElementByXPath("//android.widget.EditText[@resource-id='Phone Number']").sendKeys("9876543210");
		
		Reporter.log("Phone Number is entered",true);
		
		//will click on country dropdown 
		driver.findElementByXPath("//android.view.View[@resource-id='Country']").click();
		//will click on canada 
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='Canada']").click();
		
		Reporter.log("Country is selected",true);
		
		//click on state dropdown 
		driver.findElementByXPath("//android.view.View[@resource-id='State']").click();

		//will click on alberta 
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='Alberta']").click();
		
		Reporter.log("State is selected" , true);
		
		//will click on city dropdown 
		driver.findElementByXPath("//android.view.View[@resource-id='City']").click();
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='Blackfalds']").click();
		
		Reporter.log("City is selected",true);
		
		//Will click on submit button 
		driver.findElementByXPath("//android.widget.Button[@text='SUBMIT']").click();

		//Handles the alert 
		int x = 903;
		int y = 1413;
		//handles alert
		handleAlert(x, y);
		
		Thread.sleep(2000);
		
		//Validates the alert pop up
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[@text='Account settings']").isDisplayed(), true,"Alert pop up is not displayed");
		Reporter.log("Alert Pop up is displayed",true);
		
		//Clicks on account settings
		driver.findElementByXPath("//android.widget.Button[@text='Account settings']").click();
		
		//Validates account setting menu 
		Assert.assertEquals(driver.findElementByXPath("//android.view.MenuItem[@text='Logout']").isDisplayed(), true , "The account setting menu is not displayed");
		Reporter.log("The account setting menu is displayed" , true);
		
		//clicks on logout button 
		driver.findElementByXPath("//android.view.MenuItem[@text='Logout']").click();
		Reporter.log("The user was logged out successfully ",true);	
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
