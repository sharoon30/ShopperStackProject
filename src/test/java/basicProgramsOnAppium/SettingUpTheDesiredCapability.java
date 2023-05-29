package basicProgramsOnAppium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;

public class SettingUpTheDesiredCapability {
	/**
	 * @param args
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException {
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"));
		builder.withAppiumJS(new File("C:\\Users\\Sharoon\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"));
		builder.withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER, "4728");
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(Integer.parseInt("4723"));
		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
		service.start();
		URL appiumServerURL = service.getUrl();
		
		//Setting Desired Capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "13.0");
		capabilities.setCapability("deviceName", "iQOO Z6 Lite 5G");
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("app", "C:\\Users\\Sharoon\\Downloads\\General-Store.apk");
		
		//Objects
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(appiumServerURL,capabilities);
		System.out.println("Application installed successfully");
		//service.stop();
		
	}
}
