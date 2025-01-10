package com.SNBN.testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.SNBN.base.TestBase;

import io.appium.java_client.windows.WindowsElement;

public class AddProductWithUserdefinedBarcode extends TestBase {
	@Test
	public void AddProductsAutoGenBarcode() throws InterruptedException {
	
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

	WindowsElement OpenMenu = (WindowsElement) driver.findElementByName(OR.getProperty("OpenMenu"));
	OpenMenu.click();
	
	
	WindowsElement Inventory = (WindowsElement) driver.findElementByName(OR.getProperty("Inventory"));
	Inventory.click();
	
	WindowsElement AddProd = (WindowsElement) driver.findElementByName(OR.getProperty("AddProd"));
	AddProd.click();
	String Num = (TestData.getProperty("APAnumberOfProducts"));
	int numberOfProducts = Integer.parseInt(Num);
	for(int i=11;i<=numberOfProducts;i++)
	{
	String PNN = String.valueOf(i);
	WindowsElement PN = (WindowsElement) driver.findElementByName(OR.getProperty("PN"));
	PN.clear();
	PN.sendKeys(TestData.getProperty("APAProductName")+PNN);
	WindowsElement Category = (WindowsElement) driver.findElementByName(OR.getProperty("Category"));
	Category.click();
	
	WindowsElement GirlsWear = (WindowsElement) driver.findElementByName(OR.getProperty("GirlsWear"));
	GirlsWear.click();
	WindowsElement SubCategory = (WindowsElement) driver.findElementByName(OR.getProperty("SubCategory"));
	SubCategory.click();
	WindowsElement GirlsWearPartywear = (WindowsElement) driver.findElementByName(OR.getProperty("GirlsWearPartywear"));
	GirlsWearPartywear.click();

	WindowsElement PP = (WindowsElement) driver.findElementByName(OR.getProperty("PP"));
	PP.clear();
	PP.sendKeys(TestData.getProperty("APAPurchasePrice"));

	WindowsElement MRP = (WindowsElement) driver.findElementByName(OR.getProperty("MRP"));
	MRP.clear();
	MRP.sendKeys(TestData.getProperty("APAmrp"));
	
	WindowsElement UOM = (WindowsElement) driver.findElementByName(OR.getProperty("UOM"));
	UOM.click();
	WindowsElement PC = (WindowsElement) driver.findElementByName(OR.getProperty("PC"));
	PC.click();
	WindowsElement SQ = (WindowsElement) driver.findElementByName(OR.getProperty("SQ"));
	SQ.clear();
	SQ.sendKeys(TestData.getProperty("APAStock"));
	WindowsElement SP1 = (WindowsElement) driver.findElementByName(OR.getProperty("SP1"));
	SP1.clear();
	SP1.sendKeys(TestData.getProperty("APASp1"));
	WindowsElement QA = (WindowsElement) driver.findElementByName(OR.getProperty("QA"));
	QA.click();
	
	WindowsElement SaveProduct = (WindowsElement) driver.findElementByName(OR.getProperty("SaveProduct"));
	SaveProduct.click();
	}
	WindowsElement Cancel = (WindowsElement) driver.findElementByName(OR.getProperty("CancelProduct"));
	Cancel.click();
	Thread.sleep(2000);
	WindowsElement Admin = (WindowsElement) driver.findElementByName(OR.getProperty("Admin"));
	Admin.click();
	WindowsElement Logout = (WindowsElement) driver.findElementByName(OR.getProperty("Logout"));
	Logout.click();
	WindowsElement ClosingCash = (WindowsElement) driver.findElementByName(OR.getProperty("ClosingCash"));
	ClosingCash.click();

	}

}
