package testScripts;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.internal.BaseTestMethod;

import genericLibrary.BaseClass;
import genericLibrary.MobileUtil;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
//NOT ABLE TO SWIPE TOWARDS LEFT LINE NUMBER 40()  ///WORKED***in alternate way

public class TC_E2E_09 extends BaseClass{
	@Test
	public void testScripts() throws Exception {
		//Validates Home Page 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.Button[@text='Account settings']").isDisplayed(),true,"Home Screen is not displayed");
		Reporter.log("HomeScreen is displayed",true);
	
		//will click on account settings
		driver.findElementByXPath("//android.widget.Button[@text='Account settings']").click();
		
		//Validates Account setting menu
		Assert.assertEquals(driver.findElementByXPath("//android.view.MenuItem[@text='My Profile']").isDisplayed(), true , "Account setting options are not displayed");
		Reporter.log("Account Setting Options are displayed",true);
		
		//will click on my profile
		driver.findElementByXPath("//android.view.MenuItem[@text='My Profile']").click();
		
		//Validates Profile screen 
		Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='My Likes']").isDisplayed(), true,"Profile screen is not displayed");
		Reporter.log("Profile screen is displayed",true);
		
		//Will click on My likes
		driver.findElementByXPath("//android.widget.TextView[@text='My Likes']").click();

		//Enabling desktopMode in order to avoid scrolling

		//Clicks on Dotted Hamburger
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='More options']").click();
		//Clicks on desktopsite
		driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.android.chrome:id/checkbox']").click();
		
		//Validate My likes screen
		Assert.assertEquals(driver.findElementByXPath("//android.view.View[@text='Select Category']"), true , "Like screen is not displayed");
		Reporter.log("Like screen is displayed",true);

		//will click on select category
		driver.findElementByXPath("//android.view.View[@text='Select Category']").click();
		//will click on men
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='Men']").click();
		
		Reporter.log("Men selected");

		//Swipe left 
		
		swipeLeftToTheElement("//android.view.View[@resource-id='Category Type']");
		driver.findElementByXPath("//android.view.View[@resource-id='Category Type']").click();
		//will click on shirt 
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='Shirt']").click();
		
		Reporter.log("CLicked on shirt",true);
		
		//will click on Jacket 
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='Jacket']").click();
		//will click on OKay COnfirmation button
		driver.findElementByXPath("//android.widget.Button[@text='OK']").click();

		//NOT ABLE TO SWIPE LEFT************************##########################
		swipeLeftToTheElement("//android.widget.Button[@text='Submit']");
		driver.findElementByXPath("//android.widget.Button[@text='Submit']").click();

		//will click on Account settings
		Thread.sleep(8000);
		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//android.widget.Button[@text='Account settings']")));
		driver.findElementByXPath("//android.widget.Button[@text='Account settings']").click();
		
		//Validate Account setting menu 
		Assert.assertEquals(driver.findElementByXPath("//android.view.MenuItem[@text='Logout']").isDisplayed(), true ,"Account settings menu is not displayed");
		Reporter.log("Account settings Menu is displayed",true);

		//will click on logout button 
		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//android.view.MenuItem[@text='Logout']")));
		driver.findElementByXPath("//android.view.MenuItem[@text='Logout']").click();
	}
	//Swipe left
	public void swipeLeftToTheElement(String xpath) {
		Dimension size = driver.manage().window().getSize();

		int startX = (int) (size.width*0.86);
		int endX = (int)(size.width*0.3);
		int startY = size.height/2;
		System.out.println(size.getWidth()+" "+" width");
		System.out.println(size.getHeight()+" "+" Height");
		System.out.println(startX+" StartX");
		System.out.println(endX+" EndX");
		System.out.println(startY+" StartY");

		TouchAction action = new TouchAction(driver);
		AndroidElement element = null;
		for(;;) {
			try {
				element = driver.findElementByXPath(xpath);
				explicitWait.until(ExpectedConditions.visibilityOf(element));
				break;
			}
			catch(Exception e) {
				action.press(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, startY)).release().perform();
			}
		}
	}



}
