package basicProgramsOnAppium;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.annotations.VisibleForTesting;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;

public class LaunchInstagram {
	public static void main(String[] args) {
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
		File path = new File("C:\\Users\\Sharoon\\Downloads\\Instagram_281.0.0.19.105_Apkpure.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "13.0");
		cap.setCapability("deviceName" ,"iQOO Z6 Lite 5G");
		cap.setCapability("automationName", "Appium");
		cap.setCapability(MobileCapabilityType.APP,path.getAbsolutePath() );
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(appiumServerURL,cap);
		
	}
}
