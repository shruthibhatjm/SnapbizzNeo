package com.SNBN.testcases;

//import java.time.LocalDate;
//import java.util.List;
import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.SNBN.base.TestBase;

//import io.appium.java_client.MobileBy;
import io.appium.java_client.windows.WindowsElement;

public class AddProductsUDB extends TestBase {
	@Test
	public void RegressionTesting() throws InterruptedException {

		log.debug("Inside LoginTest");
		

		//WindowsElement Login = (WindowsElement) driver.findElementByClassName(OR.getProperty("LoginPage"));
		//Login.click();

		WindowsElement UN = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("UN"));
		UN.clear();
		UN.sendKeys(TestData.getProperty("REGCred"));
		WindowsElement PWD = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PWD"));
		PWD.clear();
		PWD.sendKeys(TestData.getProperty("REGCred"));
		
		WindowsElement OK = (WindowsElement) driver.findElementByClassName(OR.getProperty("OK"));
		OK.click();
		log.debug("Login successfully executed");
		
		WindowsElement OpeningCash = (WindowsElement) driver.findElementByName(OR.getProperty("OpeningCash"));
		OpeningCash.click();

		log.debug("opening cash entered");

		WindowsElement Navigation = (WindowsElement) driver.findElementByName(OR.getProperty("OpenMenu"));

		Navigation.click();
		//adding products to myStore
		WindowsElement Inventory = (WindowsElement) driver.findElementByName(OR.getProperty("Inventory"));
		Inventory.click();
		WindowsElement AddProd = (WindowsElement) driver.findElementByName(OR.getProperty("AddProd"));
		AddProd.click();
		String Num = (TestData.getProperty("REGNumberOfProducts"));
		int numberOfProducts = Integer.parseInt(Num);
		for (int i = 62; i <= numberOfProducts; i++) {
			String PNN = String.valueOf(i);

				WindowsElement Barcode = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("Barcode"));
				Barcode.clear();
				Barcode.sendKeys("SNAPLP"+PNN);
				
				
				WindowsElement PN = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PN"));
				PN.clear();
				PN.sendKeys("SNAPLP"+PNN);
			
				WindowsElement PP = (WindowsElement) driver.findElementByName(OR.getProperty("PP"));
				PP.clear();
				PP.sendKeys("1");
				Actions action= new Actions(driver);
				action.sendKeys(Keys.TAB).perform();

				WindowsElement mrp = (WindowsElement) driver.findElementByName(OR.getProperty("MRP1"));
	            mrp.sendKeys("1");
            
			WindowsElement UOM = (WindowsElement) driver.findElementByName(OR.getProperty("UOM"));
			UOM.click();
			WindowsElement PC = (WindowsElement) driver.findElementByName(OR.getProperty("PC"));
			PC.click();
			 
			
			WindowsElement SaveProduct = (WindowsElement) driver.findElementByName(OR.getProperty("SaveProduct"));
			SaveProduct.click();
		}
		WindowsElement Cancel = (WindowsElement) driver.findElementByName(OR.getProperty("CancelProduct"));
		Cancel.click();

	WindowsElement Admin = (WindowsElement) driver.findElementByName(OR.getProperty("Admin"));
	Admin.click();
	WindowsElement Logout = (WindowsElement) driver.findElementByName(OR.getProperty("Logout"));
	Logout.click();
	WindowsElement SubmitAndLogout = (WindowsElement) driver.findElementByName(OR.getProperty("SubmitAndLogout"));
	SubmitAndLogout.click();

	}

}
