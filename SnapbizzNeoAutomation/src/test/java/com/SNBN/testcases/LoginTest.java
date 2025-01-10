package com.SNBN.testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.SNBN.base.TestBase;
import io.appium.java_client.windows.WindowsElement;

public class LoginTest extends TestBase {
	
	

	@Test
	public void loginAsAdmin() throws InterruptedException {

		log.debug("Inside LoginTest");
		Actions actions = new Actions(driver);

		WindowsElement Login = (WindowsElement) driver.findElementByClassName(OR.getProperty("LoginPage"));
		Login.click();

		WindowsElement UN = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("UN"));
		UN.clear();
		UN.sendKeys(TestData.getProperty("Cred"));
		WindowsElement PWD = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PWD"));
		PWD.clear();
		PWD.sendKeys(TestData.getProperty("Cred"));
		WindowsElement EYE = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("Eye"));
		actions.clickAndHold(EYE).perform();
		Thread.sleep(2000);
		actions.release().perform();
		WindowsElement OK = (WindowsElement) driver.findElementByClassName(OR.getProperty("OK"));
		OK.click();
		log.debug("Login successfully executed");

		WindowsElement OpeningCash = (WindowsElement) driver.findElementByName(OR.getProperty("OpeningCash"));
		Thread.sleep(2000);
		OpeningCash.click();

		
		WindowsElement Admin = (WindowsElement) driver.findElementByName(OR.getProperty("Admin"));
		Admin.click();
		WindowsElement Logout = (WindowsElement) driver.findElementByName(OR.getProperty("Logout"));
		Logout.click();
		WindowsElement ClosingCash = (WindowsElement) driver.findElementByName(OR.getProperty("SubmitAndLogout"));
		ClosingCash.click();
	}
}
