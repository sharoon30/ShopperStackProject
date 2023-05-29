package basicProgramsOnAppium;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Dem {
	public static void main(String[] args) throws Exception {
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"));
		builder.withAppiumJS(new File("C:\\Users\\Sharoon\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"));
		builder.withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER, "4728");
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(Integer.parseInt("4723"));

		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
		service.start();
		URL appiumServerURL = service.getUrl();
		System.out.println(appiumServerURL.toString());
		
		//SettingUpTheDesired Capabilities
				DesiredCapabilities capability = new DesiredCapabilities();
				capability.setCapability("platformName", "Android");
				capability.setCapability("platformVersion", "13.0");
				capability.setCapability("deviceName","iQOO Z6- Lite 5G");
				capability.setCapability("automationName", "Appium");
				capability.setCapability("appPackage", "com.androidsample.generalstore");
				capability.setCapability("appActivity", ".SplashActivity");

		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(appiumServerURL,capability);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		AndroidElement yourNAmeTf = driver.findElementById("com.androidsample.generalstore:id/nameField");
		yourNAmeTf.sendKeys("sharoon");
		
		AndroidElement radioButton = driver.findElementById("com.androidsample.generalstore:id/radioMale");
		radioButton.click();
		
		AndroidElement countryDropDown = driver.findElementById("com.androidsample.generalstore:id/spinnerCountry");
		countryDropDown.click();
		
		Thread.sleep(3000);
		
		Dimension size = driver.manage().window().getSize();
		int startX = size.getWidth()/2;
		int height = size.getHeight();
		int startY =(int) (height*0.9);
		int endY = (int)(height*0.3);
		TouchAction touch = new TouchAction(driver);
		touch.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(startX, endY)).release().perform();
		
	}
}
