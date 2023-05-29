package genericLibrary;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;

public class BaseClass {
	public AndroidDriver<AndroidElement> driver;
	public WebDriverWait explicitWait;
	
	@BeforeClass
	public void capabilitiesSettings() {
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
		capability.setCapability("autoAcceptAlerts", true);
		capability.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, false);
		
		driver = new AndroidDriver<AndroidElement>(appiumServerURL,capability);
		explicitWait = new WebDriverWait(driver, 40);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	//	driver.get("https://www.ShoppersStack.com");
		
		AndroidElement useWithoutAnAccount = driver.findElementByXPath("//android.widget.Button[@text=\r\n"
				+ "'Use without an account']");
		useWithoutAnAccount.click();
	}
	
	@BeforeMethod
	public void loginToApplication() {
		AndroidElement gSearchTextField  = driver.findElementById("com.android.chrome:id/search_box_text");
		gSearchTextField.sendKeys("ShopperStack");
		
		AndroidElement shopperStackSuggestion = driver.findElementByXPath("//android.widget.TextView[@text='ShopperStack']");
		shopperStackSuggestion.click();
		
		Assert.assertEquals(driver.findElementByXPath("//android.view.View[@text='ShoppersStack']").isDisplayed(), true , "Welcome page is not displayed");
		Reporter.log("Welcome Page is displayed" , true);
		
		AndroidElement shopper = driver.findElementByXPath("//android.view.View[@text='ShoppersStack']");
		shopper.click();
		
		AndroidElement loginButton = driver.findElementByXPath("//android.widget.Button[@text='Login']");
		loginButton.click();	
		
		Assert.assertEquals(driver.findElementByXPath("//android.widget.EditText[@resource-id='Email']").isDisplayed(), true , "Login page is not displayed");
		Reporter.log("Login Page is Displayed" , true);
		driver.findElementByXPath("//android.widget.EditText[@resource-id='Email']").sendKeys("neerajapasala21@gmail.com");
		driver.findElementByXPath("//android.widget.EditText[@resource-id='Password']").sendKeys("nrSBTYV8g@S@Eau");
		driver.findElementByXPath("//android.widget.Button[@resource-id='Login']").click();
		
	}
	
}
