package testScripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

//HAVE USED CO-ORDINATES TO LOCATE THE SEARCH ICON (COULDNT LOCATE THE ELEMENT)[ACCORDING TO TEST CASE PRODUCT HAS TO DISPLAY 
//BUT THE PRODUCTS ARE NOT DISPLAYING

public class TC_E2E_10 extends BaseClass{
	@Test
	public void testScripts() {
		//Enabling desktopMode

		//Clicks on Dotted Hamburger
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='More options']").click();
		//Clicks on desktopsite
		driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.android.chrome:id/checkbox']").click();

		//sends the value to the search text field 
		driver.findElementByXPath("//android.widget.EditText[@resource-id='search']").sendKeys("Mobiles");

		//taps on search icon
		TouchAction action = new TouchAction(driver);
		action.tap(TapOptions.tapOptions().withPosition(PointOption.point(719, 357))).perform();

		//will click on Account settings
		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//android.widget.Button[@text='Account settings']")));
		driver.findElementByXPath("//android.widget.Button[@text='Account settings']").click();

		//will click on logout button 
		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//android.view.MenuItem[@text='Logout']")));
		driver.findElementByXPath("//android.view.MenuItem[@text='Logout']").click();
	}
}
