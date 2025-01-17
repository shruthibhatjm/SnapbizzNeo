package com.SNBN.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.SNBN.base.TestBase;

import io.appium.java_client.windows.WindowsElement;

public class LoginAndBill extends TestBase {

	@Test
	public void BillWithoutCustTag() throws InterruptedException {
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
		Thread.sleep(2000);

		WindowsElement OpeningCash = (WindowsElement) driver.findElementByName(OR.getProperty("OpeningCash"));

		OpeningCash.click();

		WindowsElement Navigation = (WindowsElement) driver.findElementByName(OR.getProperty("OpenMenu"));

		Navigation.click();

		WindowsElement menuItem = (WindowsElement) driver.findElementByName(OR.getProperty("BillingCart"));
		menuItem.click();
		log.debug("Got into Billing Cart");

		String Num = (TestData.getProperty("LABnumberOfBills"));
		int numberOfBills = Integer.parseInt(Num);
		for (int i = 0; i < numberOfBills; i++) {
			String PNN = String.valueOf(i);
			WindowsElement ProductSearch = (WindowsElement) driver
					.findElementByAccessibilityId(OR.getProperty("ProductSearch"));
			ProductSearch.click();
			ProductSearch.sendKeys(TestData.getProperty("LABProductName")+PNN);

			WindowsElement ProductSelect = (WindowsElement) driver.findElementByName(OR.getProperty("ProductSelect"));
			ProductSelect.click();

			WebDriverWait Popwait = new WebDriverWait(driver, 10);
			WindowsElement popupWindow = (WindowsElement) Popwait
					.until(ExpectedConditions.presenceOfElementLocated(By.className("Popup")));
			popupWindow.click();

			WindowsElement Quantity = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("Quantity"));
			Quantity.clear();
			Quantity.sendKeys(TestData.getProperty("LABProductQTY"));

			WindowsElement QTYOK = (WindowsElement) driver.findElementByName(OR.getProperty("QTYOK"));
			QTYOK.click();
			log.debug("Product added in the cart");
			Thread.sleep(2000);
			WindowsElement Save = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("SaveBill"));
			Save.click();

		}
		log.debug("Bill Saved successfully!!!");
		WindowsElement Admin = (WindowsElement) driver.findElementByName(OR.getProperty("Admin"));
		Admin.click();

		WindowsElement Logout = (WindowsElement) driver.findElementByName(OR.getProperty("Logout"));
		Logout.click();

		WindowsElement SubmitAndLogout = (WindowsElement) driver.findElementByName(OR.getProperty("SubmitAndLogout"));
		SubmitAndLogout.click();

		WindowsElement ClosingCash = (WindowsElement) driver.findElementByName(OR.getProperty("ClosingCash"));
		ClosingCash.click();
		log.debug("Logout successful!");

	}
}
