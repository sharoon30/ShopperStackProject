package testScripts;

import java.awt.Desktop.Action;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
//PRODUCTS SHOULD BE REMOVED FROM THE CART 

public class TC_E2E_07 extends BaseClass{
	@Test
	public void testScripts() throws Exception{
		//Enabling desktopMode
		//Clicks on Dotted Hamburger
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='More options']").click();
		//Clicks on desktop site
		driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.android.chrome:id/checkbox']").click();

		//Validates Home screen 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[@text='Account settings']").isDisplayed(), true , "HomeScreen is not displayed");
		Reporter.log("Home screen is displayed");

		//will click on account settings
		driver.findElementByXPath("//android.widget.Button[@text='Account settings']").click();

		//Validates Account settings menu
		Assert.assertEquals(driver.findElementByXPath("//android.view.MenuItem[@text='Wish List']").isDisplayed(), true , "Account setting menu screen is not displayed");
		Reporter.log("Account settings menu is displayed",true);

		//will click on wishlist
		driver.findElementByXPath("//android.view.MenuItem[@text='Wish List']").click();

		//Validates wishlist screen 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[@text='ADD TO CART']").isDisplayed(), true ,"Wishlist screen is not displayed");
		Reporter.log("Wishlist screen is displayed",true);

		//will click on add to cart button 
		driver.findElementByXPath("//android.widget.Button[@text='ADD TO CART']").click();

		//Validates the add to cart
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[@text='ADDED']").isDisplayed(), true , "The product was not added to cart");
		Reporter.log("The product was added to cart ",true);

		//will click on cart icon 
		driver.findElementByXPath("//android.view.View[@resource-id='cart']").click();

		//Validates Cart Screen
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[@text='Buy Now']").isDisplayed(),true,"Cart screen is not displayed");
		Reporter.log("Cart Creen is displayed",true);

		//will click on buy now button 
		driver.findElementByXPath("//android.widget.Button[@text='Buy Now']").click();

		//Validate address page 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[@text='Add New Address']").isDisplayed(), true,"Address screen is not displayed");
		Reporter.log("The address screen is displayed",true);
		//will click on Add New Address
		driver.findElementByXPath("//android.widget.Button[@text='Add New Address']").click();

		//Validates add address page 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.EditText[@resource-id='Name']").isDisplayed(), true , "Add address screen is displayed");
		Reporter.log("Add address screen is displayed",true);

		//will send value to the name textfield 
		driver.findElementByXPath("//android.widget.EditText[@resource-id='Name']").sendKeys("DineshKumar");
		Reporter.log("Name is entered in anme text field",true);

		//sends value to the House/Office info text field 
		driver.findElementByXPath("//android.widget.EditText[@resource-id='House/Office Info']").sendKeys("833");
		Reporter.log("House is entered" ,true);

		//sends value to street info 
		driver.findElementByXPath("//android.widget.EditText[@resource-id='Street Info']").sendKeys("12th main");
		Reporter.log("Street is entered",true);

		//sends value to LandMark
		driver.findElementByXPath("//android.widget.EditText[@resource-id='Landmark']").sendKeys("Central mall");
		Reporter.log("Landmark entered",true);

		//clicks on country dropdown 
		driver.findElementByXPath("//android.view.View[@text='Country']").click();
		//clicks on canada 
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='Canada']").click();
		Reporter.log("Country selected",true);

		//clicks on state dropdown 
		driver.findElementByXPath("//android.view.View[@text='State']").click();
		//clicks on alberta //Alberta
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='Alberta']").click();
		Reporter.log("state selected",true);

		//clicks on city dropdown 
		driver.findElementByXPath("//android.view.View[@text='City']").click();
		//clicks on BlackFalds
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='Blackfalds']").click();
		Reporter.log("City selecetd",true);

		//clicks on deliverable pincodes
		driver.findElementByXPath("//android.widget.Image[@text='Deliverable pincodes']").click();

		//Validates the Deliverable Pincode
		Assert.assertEquals(driver.findElementByXPath("//android.view.View[@text='Thane']/following-sibling::android.view.View").isDisplayed(), true , "The deliverable pincodes are not displayed");
		Reporter.log("The deliverable pins are displayed",true);

		String pincode = driver.findElementByXPath("//android.view.View[@text='Thane']/following-sibling::android.view.View").getText();
		TouchAction action = new TouchAction(driver);
		action.tap(TapOptions.tapOptions().withPosition(PointOption.point(815, 1084))).perform();
		//send the value to the pincode text field 
		driver.findElementByXPath("//android.widget.EditText[@resource-id='Pincode']").sendKeys(pincode);
		Reporter.log("Pincode entered",true);

		//sends the value to the phone number text field 
		driver.findElementByXPath("//android.widget.EditText[@resource-id='Phone Number']").sendKeys("9876543210");
		Reporter.log("Phone Number Entered",true);

		//clicks on add address
		driver.findElementByXPath("//android.widget.Button[@text='Add Address']").click();

		//Validates Successfully added message should be displayed
		Assert.assertEquals(driver.findElementByXPath("//android.widget.RadioButton[contains(@text,'Address')]").isDisplayed(), true ,"The address is not added");
		Reporter.log("The address is added successfully and the message is displayed",true);

		//selects the address
		driver.findElementByXPath("//android.widget.RadioButton[contains(@text,'Address')]").click();

		Thread.sleep(2000);
		
		//Validates address selection
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[@text='Proceed']").isEnabled(), true , "THe address is not selected");
		Reporter.log("The address is selected",true);

		//clicks on proceed button 
		driver.findElementByXPath("//android.widget.Button[@text='Proceed']").click();
		
		//Validates Payment page 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Cash On Delivery (COD)']").isDisplayed(), true,"Payement page is not displayed");
		Reporter.log("Payement page is displayed",true);
		
		//clicks on COD
		driver.findElementByXPath("//android.widget.TextView[@text='Cash On Delivery (COD)']").click();
		
		Thread.sleep(2000);
		
		//Validates COD is selected
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[@text='Proceed']").isEnabled(), true , "The COD is not selected");
		Reporter.log("COD is selected",true);
		
		//clicks on proceed button
		driver.findElementByXPath("//android.widget.Button[@text='Proceed']").click();
		
		//Validates Order confirmation Message 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[@text='Account settings']").isDisplayed(), true , "Order confirmed is not displayed");
		Reporter.log("Order Confirmation is confirmed",true);
		
		//will click on Account settings
		Thread.sleep(7000);
		driver.findElementByXPath("//android.widget.Button[@text='Account settings']").click();
		
		//Validates Account setting menu 
		Assert.assertEquals(driver.findElementByXPath("//android.view.MenuItem[@text='Logout']").isDisplayed(), true,"Account settings menu is not displayed");
		Reporter.log("Account Setting Menu is displayed",true);
		
		//clicks on Logout 
		driver.findElementByXPath("//android.view.MenuItem[@text='Logout']").click();
		
		Reporter.log("Logged out",true);
	}
}
