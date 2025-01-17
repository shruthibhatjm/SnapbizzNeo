package com.SNBN.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.lang.Process;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.appium.java_client.windows.WindowsDriver;

public class TestBase {



	public WindowsDriver<WebElement> driver;
	static Process p;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static Properties TestData = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");

	@BeforeSuite
	public WindowsDriver<WebElement> setUp() throws IOException, InterruptedException {
		PropertyConfigurator.configure(
				"C:\\Users\\snapbizz\\git\\repository\\SnapbizzNeoAutomation\\src\\test\\java\\log4j.properties");
		if (driver == null) {
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded !!!");
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded !!!");
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\TestData.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				TestData.load(fis);
				log.debug("TestData file loaded !!!");
			} catch (IOException e) {
				e.printStackTrace();
			}

			String command = config.getProperty("command");
			ProcessBuilder builder = new ProcessBuilder(command).inheritIO();

			p = builder.start();

			try {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("app", config.getProperty("appaddress"));
				capabilities.setCapability("appArguments", "-internal -NoSplash");
				capabilities.setCapability("platformName", "Windows");
				capabilities.setCapability("deviceName", "WindowsPC");

				driver = new WindowsDriver<WebElement>(new URL(config.getProperty("url")), capabilities);
				log.debug("Navigated to : " + config.getProperty("url"));
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

				driver.findElementByName("Snapbizz Neo");

			} catch (Exception e) {

				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("app", "Root");

				WindowsDriver<WebElement> desktopsession = new WindowsDriver<WebElement>(
						new URL(config.getProperty("url")), capabilities);
				String topWindow = "";
				int maxIterations = 10;
				int iteration = 0;
				while (topWindow.isEmpty() && iteration < maxIterations) {
					try {
						WebElement appName = desktopsession.findElementByClassName("Windows.UI.Core.CoreWindow");
						topWindow = appName.getAttribute("NativeWindowHandle");
					} catch (Exception ex) {
						try {
							Thread.sleep(500);
						} catch (InterruptedException ex1) {
							// ignore the exception
						}
						iteration++;
					}
				}

				if (!topWindow.isEmpty()) {
					int MAWinHandleInt = Integer.parseInt(topWindow);
					String MAWinHandleHex = Integer.toHexString(MAWinHandleInt);
					DesiredCapabilities caps = new DesiredCapabilities();
					caps.setCapability("appTopLevelWindow", MAWinHandleHex);
					driver = new WindowsDriver<WebElement>(new URL(config.getProperty("url")), capabilities);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				} else {
					driver.quit();
				}
			} finally {

			}
		}
		return driver;
	}

	@AfterSuite
	public void tearDown() {
		System.out.println("entered teardown");

		if (driver != null) {
			// Close the root session
			if (driver.getSessionId() != null) {
				driver.close();
			}

			// Close the application
			driver.closeApp();

			// Quit the driver
			driver.quit();

			// Destroy the process
			if (p != null) {
				p.destroy();
			}

			// Set the driver instance to null
			driver = null;
		}

		System.out.println("left teardown");
		log.debug("completed execution!!!");
	}

}
