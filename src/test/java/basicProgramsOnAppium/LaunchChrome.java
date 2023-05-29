package basicProgramsOnAppium;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.ShoppersLogin;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;

public class LaunchChrome {
	public static void main(String[] args) {
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"));
		builder.withAppiumJS(new File("C:\\Users\\Sharoon\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"));
		builder.withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER, "4728");
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(Integer.parseInt("4725"));
		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
		service.start();
		URL appiumServerURL = service.getUrl();
		
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platformName", "Android");
		capability.setCapability("platformVersion", "12.0");
		capability.setCapability("deviceName","moto g(60)");
		capability.setCapability("automationName", "Appium");
		capability.setCapability("appPackage", "com.android.chrome");
		capability.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(appiumServerURL,capability);
		WebDriverWait explicitWait = new WebDriverWait(driver, 40);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		System.out.println("Application Launched successfully");
		
		AndroidElement useWithoutAnAccount = driver.findElementByXPath("//android.widget.Button[@text=\r\n"
				+ "'Use without an account']");
		useWithoutAnAccount.click();
		AndroidElement gSearchTextField  = driver.findElementById("com.android.chrome:id/search_box_text");
		gSearchTextField.sendKeys("ShopperStack");
		
		AndroidElement shopperStackSuggestion = driver.findElementByXPath("//android.widget.TextView[@text='ShopperStack']");
		shopperStackSuggestion.click();
		
		AndroidElement shopper = driver.findElementByXPath("//android.view.View[@text='ShoppersStack']");
		shopper.click();
		
		AndroidElement loginButton = driver.findElementByXPath("//android.widget.Button[@text='Login']");
		loginButton.click();
		
		ShoppersLogin sl = new ShoppersLogin(driver);
		sl.getEmail().sendKeys("neerajapasala21@gmail.com");
		sl.getPass().sendKeys("nrSBTYV8g@S@Eau");
		
		AndroidElement shopperLoginButton = driver.findElementByXPath("//android.widget.Button[@text='LOGIN']");
		shopperLoginButton.click();
	}
}
