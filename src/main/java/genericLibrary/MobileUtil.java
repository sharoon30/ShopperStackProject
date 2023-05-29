package genericLibrary;

import org.openqa.selenium.Dimension;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class MobileUtil extends BaseClass{
	public void swipleLeft() {
		Dimension sizeOfWindow = driver.manage().window().getSize();
		int width = sizeOfWindow.getWidth();
		int height = sizeOfWindow.getHeight();
		new TouchAction((AppiumDriver)driver).press(PointOption.point((int) (width * 0.1), height / 2))
		.moveTo(PointOption.point((int) (width * 0.9), height / 2)).release().perform();
	}
	public void scrollAndClick(String value) {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+value+"\").instance(0))").click();
	}
	public void scrolltoLast() {
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(200000)"));
	}
}
