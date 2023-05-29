package basicProgramsOnAppium;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;

public class CreateBoard {
	public static void main(String[] args) throws Exception{
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
		capability.setCapability("appPackage", "com.trello");
		capability.setCapability("appActivity", "com.trello.home.HomeActivity");

		//Object of Android Driver
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(appiumServerURL,capability);
		WebDriverWait explicitWait = new WebDriverWait(driver, 40);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		System.out.println("Application Launched successfully");
		AndroidElement allowButton = driver.findElementById("com.android.permissioncontroller:id/permission_allow_button");
		allowButton.click();

		AndroidElement trelloText = driver.findElementById("com.trello:id/trello_logo");
		explicitWait.until(ExpectedConditions.visibilityOf(trelloText));
		System.out.println(trelloText.getText());
		System.out.println("Navigated to Login Screen");

		AndroidElement loginButton = driver.findElementById("com.trello:id/log_in_button");
		explicitWait.until(ExpectedConditions.visibilityOf(loginButton));
		loginButton.click();

		AndroidElement googleLogin = driver.findElementById("com.trello:id/google_auth");
		explicitWait.until(ExpectedConditions.visibilityOf(googleLogin));
		googleLogin.click();
		
		AndroidElement sharoon = driver.findElementByXPath("//android.view.View[contains(@content-desc,'rozario618@gmail.com')]");
		explicitWait.until(ExpectedConditions.visibilityOf(sharoon));
		sharoon.click();

		AndroidElement continueButton = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
		explicitWait.until(ExpectedConditions.visibilityOf(continueButton));
		continueButton.click();

		AndroidElement boardsText = driver.findElementByXPath("//android.widget.TextView[@text='Boards']");
		explicitWait.until(ExpectedConditions.visibilityOf(boardsText));
		System.out.println(boardsText.getText());

		AndroidElement plusIcon = driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open create board or add card menu'] ");
		plusIcon.click();
		
		AndroidElement boardIcon = driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Create board']");
		boardIcon.click();
		
		AndroidElement boardNameTextField = driver.findElementById("com.trello:id/board_name");
		boardNameTextField.sendKeys("Car");
		
		AndroidElement tickButton = driver.findElementByAccessibilityId("Create");
		explicitWait.until(ExpectedConditions.visibilityOf(tickButton));
		tickButton.click();
		
		AndroidElement addListPop = driver.findElementById("com.trello:id/add_list_button");
		explicitWait.until(ExpectedConditions.visibilityOf(addListPop));
		if(addListPop.isDisplayed()) {
			System.out.println("Board Created");
		}
		else {
			System.out.println("Board Not created");
		}
		addListPop.click();
		
		AndroidElement listNameTextField = driver.findElementById("com.trello:id/list_name_edit_text");
		explicitWait.until(ExpectedConditions.visibilityOf(listNameTextField));
		listNameTextField.sendKeys("audi");
		
		AndroidElement tick2 = driver.findElementById("com.trello:id/confirm");
		tick2.click();
		
		AndroidElement threeDots = driver.findElementByAccessibilityId("Board settings");
		threeDots.click();
		
		AndroidElement boardSettings = driver.findElementById("com.trello:id/settings_button");
		boardSettings.click();
		
		//scroll maadi
		
		AndroidElement closeBoard = driver.findElementByXPath("//android.widget.TextView[@text='Close board'] ");
		closeBoard.click();
		
		AndroidElement thisBoardIsClosedText = driver.findElementById("com.trello:id/board_unavailable_text");
		explicitWait.until(ExpectedConditions.visibilityOf(thisBoardIsClosedText));
		System.out.println(thisBoardIsClosedText.getText());
		driver.quit();
		service.stop();
	}
}
