package testScripts;



import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
//NOT ABLE TO SWIPE

public class TC_E2E_02 extends BaseClass{
	
	@Test
	public void testScript() throws Exception{
		//Enabling desktopMode
		//Clicks on Dotted Hamburger
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='More options']").click();
		//Clicks on desktopsite
		driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.android.chrome:id/checkbox']").click();
		
		//Validates the home screen
		Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='WOMEN']").isDisplayed(), true , "Home screen is not displaed");
		Reporter.log("Home screen is displayed" , true);
		
		//clicks on women major tab
		driver.findElementByXPath("//android.widget.TextView[@text='WOMEN']").click();
		//clicks on add to cart button
		driver.findElementByXPath("(//android.widget.Button[@text='ADD TO CART'])[3]").click(); 
		
		//validates add to cart has changed to added
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[@text='ADDED']").isDisplayed(), true , "Add To Cart is not chnaged to added");
		Reporter.log("Add to cart has been changed to Added" , true);
		
		//clicks on cart icon
		driver.findElementByXPath("//android.view.View[@resource-id='cart']").click();
		
		//Validates Cart Screen 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[@text='Buy Now']").isDisplayed(), true , "Cart screen is not displayed");
		Reporter.log("Cart Screen is displayed" , true);
		
		//clicks on buy now button 
		driver.findElementByXPath("//android.widget.Button[@text='Buy Now']").click();
		
		//VAlidates the address page 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.RadioButton[contains(@text,'Address')]").isDisplayed(), true , "Address screen is not displayed");
		Reporter.log("Address screen is displayed",true);
		
		Thread.sleep(2000);
		
		//clicks on the first radio button of the addresses present 
		driver.findElementByXPath("//android.widget.RadioButton[contains(@text,'Address')]").click();
		
		//clicks on proceed button 
		driver.findElementByXPath("//android.widget.Button[@text='Proceed']").click();
		
		Thread.sleep(2000);
		
		//Validates  the Payment screen 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.RadioButton[@text='Cash On Delivery (COD)']").isDisplayed(), true , "Payment method screen is not displayed");
		Reporter.log("Payment method screen is displayed" , true);
		
		//clicks on cash on delivery
		driver.findElementByXPath("//android.widget.RadioButton[@text='Cash On Delivery (COD)']").click();
		
		//clicks on proceed button
		driver.findElementByXPath("//android.widget.Button[@text='Proceed']").click();
		Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Order Confirmed']").isDisplayed(), true, "Order confirmation screen is not displayed");
		Reporter.log("Order confirmation screen is displayed ",true);
	}
}
