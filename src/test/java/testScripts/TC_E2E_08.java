package testScripts;

import org.testng.annotations.Test;

import genericLibrary.BaseClass;

public class TC_E2E_08 extends BaseClass{
	//DONT KNOW HOW TO COPY AND PASTE

	@Test
	public void testScripts() {
		//Enabling desktopMode
		//Clicks on Dotted Hamburger
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='More options']").click();
		//Clicks on desktop site
		driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.android.chrome:id/checkbox']").click();
		//will click on account settings
		driver.findElementByXPath("//android.widget.Button[@text='Account settings']").click();
		//will click on wishlist 
		driver.findElementByXPath("//android.view.MenuItem[@text='Wish List']").click();
		//will click on add to cart button 
		driver.findElementByXPath("//android.widget.Button[@text='ADD TO CART']").click();
		//will click on cart button 
		driver.findElementByXPath("//android.view.View[@resource-id='cart']").click();
		//Will click on the first product
		driver.findElementByXPath("(//android.view.View/child::android.widget.Image)[2]").click();
		
		//will click on buy now button 
		driver.findElementByXPath("//android.widget.Button[@text='BUY NOW']").click();
		//will click on add new address 
		driver.findElementByXPath("//android.view.View[@content-desc='Add New Address']").click();
		
		
		//Will locatte Name textField 
		driver.findElementByXPath("//android.widget.EditText[@resource-id=\r\n"
				+ "'Name']").sendKeys("DineshKumar");
		//will locate HouseTextField 
		driver.findElementByXPath("//android.widget.EditText[@resource-id=\r\n"
				+ "'House/Office Info']").sendKeys("833");
		//will locate Street INfo
		driver.findElementByXPath("//android.widget.EditText[@resource-id=\r\n"
				+ "'Street Info']").sendKeys("12th Main");
		//will locate LandMark textfield 
		driver.findElementByXPath("//android.widget.EditText[@resource-id=\r\n"
				+ "'Landmark']").sendKeys("Central Mall");
		//taps on ContryDropdown 
		driver.findElementByXPath("//android.view.View[@text='Country']").click();
		//taps on India 
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='USA']").click();
		//taps on State dropdown 
		driver.findElementByXPath("//android.view.View[@text='State']").click();
		//taps on alaska
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='Alaska']").click();
		//Taps on city dropdown
		driver.findElementByXPath("//android.view.View[@text='City']").click();
		//Taps on Juneau
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='Juneau']").click();
		//Help center 

	}
}
