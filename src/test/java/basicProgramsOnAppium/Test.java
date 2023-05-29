package basicProgramsOnAppium;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Test {
	public static void main(String[] args) throws Exception {
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		
		URL url = new URL("http://localhost:4723");
		
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platformName", "Android");
		capability.setCapability("platformVersion", "13.0");
		capability.setCapability("deviceName","iQOO Z6- Lite 5G");
		capability.setCapability("automationName", "Appium");
		capability.setCapability("appPackage", "com.androidsample.generalstore");
		capability.setCapability("appActivity", ".SplashActivity");
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url,capability);
		
	}

}
