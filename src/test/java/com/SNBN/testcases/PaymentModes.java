package com.SNBN.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.SNBN.base.TestBase;

import io.appium.java_client.windows.WindowsElement;

public class PaymentModes extends TestBase {

	@Test
	public void AllPaymentModes() throws InterruptedException {
		log.debug("Inside LoginTest");
		Actions actions = new Actions(driver);

		String[] custSearchInputs = { TestData.getProperty("C1"), TestData.getProperty("C2"),
				TestData.getProperty("C3") }; // Example inputs for SearchCust

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

		OpeningCash.click();
		Thread.sleep(2000);
		WindowsElement Navigation = (WindowsElement) driver.findElementByName(OR.getProperty("OpenMenu"));

		Navigation.click();

		WindowsElement menuItem = (WindowsElement) driver.findElementByName(OR.getProperty("BillingCart"));
		menuItem.click();
		log.debug("Got into Billing Cart");
		String Num = (TestData.getProperty("PMnumberOfBills"));
		int numberOfBills = Integer.parseInt(Num);
		int k = 0;
		for (int i = 0; i < numberOfBills; i++) {

			String PNN = String.valueOf(i);
			WindowsElement ProductSearch = (WindowsElement) driver
					.findElementByAccessibilityId(OR.getProperty("ProductSearch"));
			ProductSearch.click();
			ProductSearch.sendKeys(TestData.getProperty("PMProductName") + PNN);

			WindowsElement ProductSelect = (WindowsElement) driver.findElementByName(OR.getProperty("ProductSelect"));
			ProductSelect.click();

			WebDriverWait Popwait = new WebDriverWait(driver, 10);
			WindowsElement popupWindow = (WindowsElement) Popwait
					.until(ExpectedConditions.presenceOfElementLocated(By.className("Popup")));
			popupWindow.click();

			WindowsElement Quantity = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("Quantity"));
			Quantity.clear();
			Quantity.sendKeys(TestData.getProperty("PMProductQTY"));

			WindowsElement QTYOK = (WindowsElement) driver.findElementByName(OR.getProperty("QTYOK"));
			QTYOK.click();
			log.debug("Product added in the cart");
			Thread.sleep(2000);

			WindowsElement TagCust = (WindowsElement) driver.findElementByName(OR.getProperty("TagCust"));
			TagCust.click();

			WindowsElement SearchCust = (WindowsElement) driver.findElementByName(OR.getProperty("SearchCust"));
			SearchCust.click();
			SearchCust.sendKeys(custSearchInputs[k]);

			WindowsElement CustList = (WindowsElement) driver.findElementByName(OR.getProperty("CustList"));
			CustList.click();
			log.debug("Customer Tagged");
			Thread.sleep(2000);
			
			WindowsElement Amount = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("Amount"));

			String Amt = Amount.getText();

			if(i<=5) {
				
			if (i == 0) {

				WindowsElement PaymentType = (WindowsElement) driver.findElementByName(OR.getProperty("PaymentType"));
				PaymentType.click();
				
				WindowsElement PaymentOpt = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PaymentOpt"));
				PaymentOpt.click();
				WindowsElement Digital = (WindowsElement) driver.findElementByName(OR.getProperty("Digital"));
				Digital.click();
				
				WindowsElement DigPayOpt = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PayOpt"));
				DigPayOpt.click();
				
				WindowsElement PayTm = (WindowsElement) driver.findElementByName(OR.getProperty("PayTm"));
				PayTm.click();
			} else if (i == 1) {
				WindowsElement PaymentType = (WindowsElement) driver.findElementByName(OR.getProperty("PaymentType"));
				PaymentType.click();
				
				WindowsElement PaymentOpt = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PaymentOpt"));
				PaymentOpt.click();
				WindowsElement Digital = (WindowsElement) driver.findElementByName(OR.getProperty("Digital"));
				Digital.click();
				
				WindowsElement DigPayOpt = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PayOpt"));
				DigPayOpt.click();
				WindowsElement PhonePe = (WindowsElement) driver.findElementByName(OR.getProperty("PhonePe"));
				PhonePe.click();
			} else if (i == 2) {
				WindowsElement PaymentType = (WindowsElement) driver.findElementByName(OR.getProperty("PaymentType"));
				PaymentType.click();
				
				WindowsElement PaymentOpt = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PaymentOpt"));
				PaymentOpt.click();
				WindowsElement Digital = (WindowsElement) driver.findElementByName(OR.getProperty("Digital"));
				Digital.click();
				
				WindowsElement DigPayOpt = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PayOpt"));
				DigPayOpt.click();
				WindowsElement MobiKwik = (WindowsElement) driver.findElementByName(OR.getProperty("MobiKwik"));
				MobiKwik.click();
			} else if (i == 3) {
				WindowsElement PaymentType = (WindowsElement) driver.findElementByName(OR.getProperty("PaymentType"));
				PaymentType.click();
				
				WindowsElement PaymentOpt = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PaymentOpt"));
				PaymentOpt.click();
				WindowsElement Digital = (WindowsElement) driver.findElementByName(OR.getProperty("Digital"));
				Digital.click();
				
				WindowsElement DigPayOpt = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PayOpt"));
				DigPayOpt.click();
				WindowsElement GooglePay = (WindowsElement) driver.findElementByName(OR.getProperty("GooglePay"));
				GooglePay.click();
			}
			else if (i == 4) {
				WindowsElement PaymentType = (WindowsElement) driver.findElementByName(OR.getProperty("PaymentType"));
				PaymentType.click();
				
				WindowsElement PaymentOpt = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PaymentOpt"));
				PaymentOpt.click();
				WindowsElement Card = (WindowsElement) driver.findElementByName(OR.getProperty("Card"));
				Card.click();
				
				WindowsElement CardPayOpt = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("CardType"));
				CardPayOpt.click();
				WindowsElement CreditCard = (WindowsElement) driver.findElementByName(OR.getProperty("CreditCard"));
				CreditCard.click();
			}
			else if (i == 5) {
				WindowsElement PaymentType = (WindowsElement) driver.findElementByName(OR.getProperty("PaymentType"));
				PaymentType.click();
				
				WindowsElement PaymentOpt = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PaymentOpt"));
				PaymentOpt.click();
				WindowsElement Card = (WindowsElement) driver.findElementByName(OR.getProperty("Card"));
				Card.click();
				
				WindowsElement CardPayOpt = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("CardType"));
				CardPayOpt.click();
				WindowsElement DebitCard = (WindowsElement) driver.findElementByName(OR.getProperty("DebitCard"));
				DebitCard.click();
			}
			


			WindowsElement PayAmount = (WindowsElement) driver.findElementByName(OR.getProperty("AMT"));
			PayAmount.sendKeys(Amt);

			WindowsElement TransactionId = (WindowsElement) driver.findElementByName(OR.getProperty("TransactionId"));
			TransactionId.sendKeys("Test");
			
			WindowsElement Description = (WindowsElement) driver.findElementByName(OR.getProperty("Description"));
			Description.sendKeys("Test");
			WindowsElement PaymentSave = (WindowsElement) driver.findElementByName(OR.getProperty("PaymentSave"));
			PaymentSave.click();
			
			WindowsElement Save = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("SaveBill"));
			Save.click();

			log.debug("Bill Saved successfully!!!");

			k++;
			if (k == 3 && i <= numberOfBills) {
				k = 0;
			}
			}
			if (i == 6) {
				WindowsElement PaymentType = (WindowsElement) driver.findElementByName(OR.getProperty("PaymentType"));
				PaymentType.click();
				
				WindowsElement PaymentOpt = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PaymentOpt"));
				PaymentOpt.click();
				WindowsElement Cheque = (WindowsElement) driver.findElementByName(OR.getProperty("Cheque"));
				Cheque.click();
				
				WindowsElement BankName = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("BankName"));
				BankName.click();
				WindowsElement SBI = (WindowsElement) driver.findElementByName(OR.getProperty("SBI"));
				SBI.click();
				WindowsElement PayAmount = (WindowsElement) driver.findElementByName(OR.getProperty("AMT"));
				PayAmount.sendKeys(Amt);
				WindowsElement ChequeNum = (WindowsElement) driver.findElementByName(OR.getProperty("ChequeNum"));
				ChequeNum.sendKeys("test");
				WindowsElement ChequeDate = (WindowsElement) driver.findElementByName(OR.getProperty("ChequeDate"));
				ChequeDate.click();
				WindowsElement Calendar = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("Calendar"));
				Calendar.click();
				
				WindowsElement Description = (WindowsElement) driver.findElementByName(OR.getProperty("Description"));
				Description.sendKeys("Test");
				WindowsElement PaymentSave = (WindowsElement) driver.findElementByName(OR.getProperty("PaymentSave"));
				PaymentSave.click();
				
				WindowsElement Save = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("SaveBill"));
				Save.click();

				log.debug("Bill Saved successfully!!!");

				k++;
				if (k == 3 && i <= numberOfBills) {
					k = 0;
				}
				
			}
			if(i==7)
			{
				WindowsElement PaymentType = (WindowsElement) driver.findElementByName(OR.getProperty("PaymentType"));
				PaymentType.click();
				
				WindowsElement PaymentOpt = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PaymentOpt"));
				PaymentOpt.click();
				WindowsElement Ezetap = (WindowsElement) driver.findElementByName(OR.getProperty("Ezetap"));
				Ezetap.click();
				
				WindowsElement EzePayMode = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("EzePayMode"));
				EzePayMode.click();
				WindowsElement EzeCash = (WindowsElement) driver.findElementByName(OR.getProperty("EzeCash"));
				EzeCash.click();
				
				WindowsElement Initiate = (WindowsElement) driver.findElementByName(OR.getProperty("Initiate"));
				Initiate.click();
				
			}
			
			if(i>7)
			{
				WindowsElement SavecashPay = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("SaveBill"));
				SavecashPay.click();
				log.debug("Bill Saved successfully!!!");

				k++;
				if (k == 3 && i <= numberOfBills) {
					k = 0;
				}
			}
			
		}
	
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