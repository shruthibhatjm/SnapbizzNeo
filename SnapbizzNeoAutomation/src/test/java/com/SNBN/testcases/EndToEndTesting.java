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

public class EndToEndTesting extends TestBase {


	@Test(priority = 0)
	public void Login() throws InterruptedException {

		log.debug("Inside LoginTest");
		Actions actions = new Actions(driver);

		

		WindowsElement UN = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("UN"));
		UN.clear();
		UN.sendKeys(TestData.getProperty("REGCred"));
		WindowsElement PWD = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PWD"));
		PWD.clear();
		PWD.sendKeys(TestData.getProperty("REGCred"));
		WindowsElement EYE = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("Eye"));
		actions.clickAndHold(EYE).perform();
		Thread.sleep(2000);
		actions.release().perform();
		WindowsElement OK = (WindowsElement) driver.findElementByClassName(OR.getProperty("OK"));
		OK.click();
		log.debug("Login successfully executed");
	}
	
	
		//Biller opening cash
	@Test(priority = 1)
	public void BillerOpeningCash() throws InterruptedException{
		
		WindowsElement cash2000 = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("Cash2000"));
		cash2000.clear();
		cash2000.sendKeys(TestData.getProperty("REGCash2000"));
	    WindowsElement cash500 = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("Cash500"));
		cash500.clear();
		cash500.sendKeys(TestData.getProperty("REGCash500"));
		WindowsElement cash200 = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("Cash200"));
		cash200.clear();
		cash200.sendKeys(TestData.getProperty("REGCash200"));
		WindowsElement cash100 = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("Cash100"));
		cash100.clear();
		cash100.sendKeys(TestData.getProperty("REGCash100"));
		WindowsElement cash50 = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("Cash50"));
		cash50.clear();
		cash50.sendKeys(TestData.getProperty("REGCash50"));
		WindowsElement cash20 = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("Cash20"));
		cash20.clear();
		cash20.sendKeys(TestData.getProperty("REGCash20"));
		WindowsElement cash10 = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("Cash10"));
		cash10.clear();
		cash10.sendKeys(TestData.getProperty("REGCash10"));
		
		WindowsElement cashothers = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("CashOthers"));
		cashothers.clear();
		cashothers.sendKeys(TestData.getProperty("REGCashOthers"));

		WindowsElement OpeningCash = (WindowsElement) driver.findElementByName(OR.getProperty("OpeningCash"));
		OpeningCash.click();

		log.debug("opening cash entered");
	}
	
	//adding products to myStore
	@Test(priority = 2)
	public void AddMasters() throws InterruptedException{
	
		WindowsElement Navigation = (WindowsElement) driver.findElementByName(OR.getProperty("OpenMenu"));

		Navigation.click();
		
		WindowsElement Inventory = (WindowsElement) driver.findElementByName(OR.getProperty("Inventory"));
		Inventory.click();
		WindowsElement AddProd = (WindowsElement) driver.findElementByName(OR.getProperty("AddProd"));
		AddProd.click();
		String Num = (TestData.getProperty("REGNumberOfProducts"));
		int numberOfProducts = Integer.parseInt(Num);
		for (int i = 1; i <= numberOfProducts; i++) {
			if (i > 5) {

				WindowsElement Barcode = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("Barcode"));
				Barcode.clear();
				int length = 8; // Desired length of the random alphanumeric value

				// Characters that can be used in the random value
				String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

				// Create a StringBuilder to store the random value
				StringBuilder sb = new StringBuilder();

				// Create an instance of Random
				Random random = new Random();

				// Generate random alphanumeric value
				for (int j = 0; j < length; j++) {
					int index = random.nextInt(characters.length());
					char randomChar = characters.charAt(index);
					sb.append(randomChar);
				}

				String randomValue = sb.toString();
				Barcode.sendKeys(randomValue);
			}
			String PNN = String.valueOf(i);
				
			WindowsElement PN = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PN"));
			PN.clear();
			PN.sendKeys(TestData.getProperty("REGProductName") + PNN);
			WindowsElement SN = (WindowsElement) driver.findElementByName(OR.getProperty("SN"));
			SN.clear();
			SN.sendKeys(TestData.getProperty("REGShortName") + PNN);
			Actions action= new Actions(driver);
			Thread.sleep(2000);

			if(i==1) {
			
			WindowsElement Category = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("Category"));
			Category.click();
			                   
			WindowsElement PetShop = (WindowsElement) driver.findElementByName(OR.getProperty("PetShop"));
			PetShop.click();
			Thread.sleep(2000);

			WindowsElement SubCategory = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("SubCategory"));
			SubCategory.click();

			WindowsElement PetFood = (WindowsElement) driver.findElementByName(OR.getProperty("PetFood"));
			PetFood.click();
			}

			WindowsElement PP = (WindowsElement) driver.findElementByName(OR.getProperty("PP"));
			PP.clear();
			PP.sendKeys(TestData.getProperty("REGPurchasePrice"));
			
			action.sendKeys(Keys.TAB).perform();

			WindowsElement mrp = (WindowsElement) driver.findElementByName(OR.getProperty("MRP1"));
            mrp.sendKeys(TestData.getProperty("REGmrp"));
            
			WindowsElement UOM = (WindowsElement) driver.findElementByName(OR.getProperty("UOM"));
			UOM.click();
			 
			if(i==1)
			{
				WindowsElement FT = (WindowsElement) driver.findElementByName(OR.getProperty("FT"));
				FT.click();
			}
			if (i==2) 
			{
				WindowsElement PAIR = (WindowsElement) driver.findElementByName(OR.getProperty("PAIR"));
				PAIR.click();
			}
			if (i==3) 
			{
				WindowsElement CARTON = (WindowsElement) driver.findElementByName(OR.getProperty("CARTON"));
				CARTON.click();
			}
			if (i==4) 
			{
				WindowsElement PACK10 = (WindowsElement) driver.findElementByName(OR.getProperty("PACK10"));
				PACK10.click();
			}
			if (i==5) 
			{
				WindowsElement PACK50 = (WindowsElement) driver.findElementByName(OR.getProperty("PACK50"));
				PACK50.click();
			}
			if (i==6) 
			{
				WindowsElement DOZEN = (WindowsElement) driver.findElementByName(OR.getProperty("DOZEN"));
				DOZEN.click();
			}
			if (i==7) 
			{
				WindowsElement KG = (WindowsElement) driver.findElementByName(OR.getProperty("KG"));
				KG.click();
			}
			if (i==8) 
			{
				WindowsElement L = (WindowsElement) driver.findElementByName(OR.getProperty("L"));
				L.click();
			}
			if (i==9) 
			{
				WindowsElement M = (WindowsElement) driver.findElementByName(OR.getProperty("M"));
				M.click();
			}
			if (i>=10) 
			{
				WindowsElement PC = (WindowsElement) driver.findElementByName(OR.getProperty("PC"));
				PC.click();
				
			}
			
			
			WindowsElement SQ = (WindowsElement) driver.findElementByName(OR.getProperty("SQ"));
			SQ.clear();
			SQ.sendKeys(TestData.getProperty("REGStock"));
			//WindowsElement ExpDate = (WindowsElement) driver.findElementByName(OR.getProperty("ED"));
			//ExpDate.click();
			//Thread.sleep(2000);
			//WindowsElement Calendar = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("Calendar"));
			//Calendar.click();
			//WindowsElement MafDate = (WindowsElement) driver.findElementByName(OR.getProperty("MD"));
			//MafDate.click();
			//Thread.sleep(2000);
			//WindowsElement Calendar1 = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("Calendar"));
			//Calendar1.click();
			WindowsElement SP1 = (WindowsElement) driver.findElementByName(OR.getProperty("SP1"));
			SP1.clear();
			SP1.sendKeys(TestData.getProperty("REGSp1"));
			WindowsElement SP2 = (WindowsElement) driver.findElementByName(OR.getProperty("SP2"));
			SP2.clear();
			SP2.sendKeys(TestData.getProperty("REGSp2"));
			WindowsElement SP3 = (WindowsElement) driver.findElementByName(OR.getProperty("SP3"));
			SP3.clear();
			SP3.sendKeys(TestData.getProperty("REGSp3"));
			//WindowsElement MBQ = (WindowsElement) driver.findElementByName(OR.getProperty("MBQ"));
			//MBQ.sendKeys(TestData.getProperty("REGMBQ"));
			//WindowsElement RP = (WindowsElement) driver.findElementByName(OR.getProperty("RP"));
			//RP.sendKeys(TestData.getProperty("REGRP"));
			WindowsElement QA = (WindowsElement) driver.findElementByName(OR.getProperty("QA"));
			QA.click();
			WindowsElement SaveProduct = (WindowsElement) driver.findElementByName(OR.getProperty("SaveProduct"));
			SaveProduct.click();
		}
		WindowsElement Cancel = (WindowsElement) driver.findElementByName(OR.getProperty("CancelProduct"));
		Cancel.click();
	}
		// Adding customers
	@Test(priority = 3)
	public void Customers() throws InterruptedException{
		
		WindowsElement Navigation = (WindowsElement) driver.findElementByName(OR.getProperty("OpenMenu"));

		Navigation.click();

		WindowsElement Customers = (WindowsElement) driver.findElementByName(OR.getProperty("Customers"));
		Customers.click();

		String CusNum = (TestData.getProperty("REGNumberOfCustomers"));
		int REGNumberOfCustomers = Integer.parseInt(CusNum);
		for (int i = 1; i <= REGNumberOfCustomers; i++) {
			String PNN = String.valueOf(i);

			WindowsElement AddCus = (WindowsElement) driver.findElementByName(OR.getProperty("AddCus"));
			AddCus.click();

			WindowsElement CustomerNumber = (WindowsElement) driver.findElementByName(OR.getProperty("CustomerNumber"));
			CustomerNumber.clear();
			CustomerNumber.sendKeys(TestData.getProperty("REGCustomerNumber") + PNN);
			WindowsElement CustomerAltNumber = (WindowsElement) driver
					.findElementByName(OR.getProperty("CustomerAltNumber"));
			CustomerAltNumber.clear();
			CustomerAltNumber.sendKeys(TestData.getProperty("REGCustomerAltNumber") + PNN);
			WindowsElement CustomerName = (WindowsElement) driver.findElementByName(OR.getProperty("CustomerName"));
			CustomerName.clear();
			CustomerName.sendKeys(TestData.getProperty("REGCustomerName") + PNN);
			WindowsElement CustomerEmail = (WindowsElement) driver.findElementByName(OR.getProperty("CustomerEmail"));
			CustomerEmail.clear();
			CustomerEmail.sendKeys(TestData.getProperty("REGCustomerEmail") + PNN + "@test.com");
			WindowsElement CustomerGstin = (WindowsElement) driver.findElementByName(OR.getProperty("CustomerGstin"));
			CustomerGstin.clear();
			CustomerGstin.sendKeys(TestData.getProperty("REGCustomerGstin"));
			WindowsElement CustomerAddress = (WindowsElement) driver
					.findElementByName(OR.getProperty("CustomerAddress"));
			CustomerAddress.clear();
			CustomerAddress.sendKeys(TestData.getProperty("REGCustomerAddress") + PNN);
			WindowsElement MemberShipID = (WindowsElement) driver.findElementByName(OR.getProperty("MemberShipID"));
			MemberShipID.clear();
			MemberShipID.sendKeys(TestData.getProperty("REGMemberShipID") + PNN);

			WindowsElement SaveCustomer = (WindowsElement) driver.findElementByName(OR.getProperty("SaveCustomer"));
			SaveCustomer.click();
		}
	}
	
		 //Making bills
	@Test(priority = 4)
	public void Bills() throws InterruptedException{
		
		WindowsElement Navigation = (WindowsElement) driver.findElementByName(OR.getProperty("OpenMenu"));
		Navigation.click();

		WindowsElement menuItem = (WindowsElement) driver.findElementByName(OR.getProperty("BillingCart"));
		menuItem.click();
		log.debug("Got into Billing Cart");
		String Num1 = (TestData.getProperty("REGnumberOfBills"));
		int numberOfBills = Integer.parseInt(Num1);

		for (int i = 1; i <= numberOfBills; i++) {

			String PNN = String.valueOf(i);
		

		   
			WindowsElement ProductSearch = (WindowsElement) driver.findElementByName(OR.getProperty("ProductSearch"));
		    ProductSearch.clear();
		    
			ProductSearch.sendKeys(TestData.getProperty("REGProductName"));

			WindowsElement ProductSelect = (WindowsElement) driver.findElementByName(OR.getProperty("ProductSelect"));
			ProductSelect.click();

			//WebDriverWait Popwait = new WebDriverWait(driver, 20);
			//WindowsElement popupWindow = (WindowsElement) Popwait.until(ExpectedConditions.presenceOfElementLocated(By.className("PopupRoot")));
			//popupWindow.click();

			WindowsElement Quantity = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("Quantity"));
			Quantity.clear();
			Quantity.sendKeys(TestData.getProperty("REGProductQTY"));

			WindowsElement QTYOK = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("QTYOK"));
			QTYOK.click();
			log.debug("Product added in the cart");
			Thread.sleep(2000);

			WindowsElement TagCust = (WindowsElement) driver.findElementByName(OR.getProperty("TagCust"));
			TagCust.click();

			WindowsElement SearchCust = (WindowsElement) driver.findElementByName(OR.getProperty("SearchCust"));
			SearchCust.click();
			SearchCust.clear();
			SearchCust.sendKeys(TestData.getProperty("REGCustomerName"));

			WindowsElement CustList = (WindowsElement) driver.findElementByName(OR.getProperty("CustList"));
			CustList.click();
			log.debug("Customer Tagged");
			Thread.sleep(2000);

			WindowsElement Amount = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("Amount"));

			String Amt = Amount.getText();

			if (i <= 6) {

				if (i == 1) {

					WindowsElement PaymentType = (WindowsElement) driver
							.findElementByName(OR.getProperty("PaymentType"));
					PaymentType.click();

					WindowsElement PaymentOpt = (WindowsElement) driver
							.findElementByAccessibilityId(OR.getProperty("PaymentOpt"));
					PaymentOpt.click();
					WindowsElement Digital = (WindowsElement) driver.findElementByName(OR.getProperty("Digital"));
					Digital.click();

					WindowsElement DigPayOpt = (WindowsElement) driver
							.findElementByAccessibilityId(OR.getProperty("PayOpt"));
					DigPayOpt.click();

					WindowsElement PayTm = (WindowsElement) driver.findElementByName(OR.getProperty("PayTm"));
					PayTm.click();
				} else if (i == 2) {
					WindowsElement PaymentType = (WindowsElement) driver
							.findElementByName(OR.getProperty("PaymentType"));
					PaymentType.click();

					WindowsElement PaymentOpt = (WindowsElement) driver
							.findElementByAccessibilityId(OR.getProperty("PaymentOpt"));
					PaymentOpt.click();
					WindowsElement Digital = (WindowsElement) driver.findElementByName(OR.getProperty("Digital"));
					Digital.click();

					WindowsElement DigPayOpt = (WindowsElement) driver
							.findElementByAccessibilityId(OR.getProperty("PayOpt"));
					DigPayOpt.click();
					WindowsElement PhonePe = (WindowsElement) driver.findElementByName(OR.getProperty("PhonePe"));
					PhonePe.click();
				} else if (i == 3) {
					WindowsElement PaymentType = (WindowsElement) driver
							.findElementByName(OR.getProperty("PaymentType"));
					PaymentType.click();

					WindowsElement PaymentOpt = (WindowsElement) driver
							.findElementByAccessibilityId(OR.getProperty("PaymentOpt"));
					PaymentOpt.click();
					WindowsElement Digital = (WindowsElement) driver.findElementByName(OR.getProperty("Digital"));
					Digital.click();

					WindowsElement DigPayOpt = (WindowsElement) driver
							.findElementByAccessibilityId(OR.getProperty("PayOpt"));
					DigPayOpt.click();
					WindowsElement MobiKwik = (WindowsElement) driver.findElementByName(OR.getProperty("MobiKwik"));
					MobiKwik.click();
				} else if (i == 4) {
					WindowsElement PaymentType = (WindowsElement) driver
							.findElementByName(OR.getProperty("PaymentType"));
					PaymentType.click();

					WindowsElement PaymentOpt = (WindowsElement) driver
							.findElementByAccessibilityId(OR.getProperty("PaymentOpt"));
					PaymentOpt.click();
					WindowsElement Digital = (WindowsElement) driver.findElementByName(OR.getProperty("Digital"));
					Digital.click();

					WindowsElement DigPayOpt = (WindowsElement) driver
							.findElementByAccessibilityId(OR.getProperty("PayOpt"));
					DigPayOpt.click();
					WindowsElement GooglePay = (WindowsElement) driver.findElementByName(OR.getProperty("GooglePay"));
					GooglePay.click();
				} else if (i == 5) {
					WindowsElement PaymentType = (WindowsElement) driver
							.findElementByName(OR.getProperty("PaymentType"));
					PaymentType.click();

					WindowsElement PaymentOpt = (WindowsElement) driver
							.findElementByAccessibilityId(OR.getProperty("PaymentOpt"));
					PaymentOpt.click();
					WindowsElement Card = (WindowsElement) driver.findElementByName(OR.getProperty("Card"));
					Card.click();

					WindowsElement CardPayOpt = (WindowsElement) driver
							.findElementByAccessibilityId(OR.getProperty("CardType"));
					CardPayOpt.click();
					WindowsElement CreditCard = (WindowsElement) driver.findElementByName(OR.getProperty("CreditCard"));
					CreditCard.click();
				} else if (i == 6) {
					WindowsElement PaymentType = (WindowsElement) driver
							.findElementByName(OR.getProperty("PaymentType"));
					PaymentType.click();

					WindowsElement PaymentOpt = (WindowsElement) driver
							.findElementByAccessibilityId(OR.getProperty("PaymentOpt"));
					PaymentOpt.click();
					WindowsElement Card = (WindowsElement) driver.findElementByName(OR.getProperty("Card"));
					Card.click();

					WindowsElement CardPayOpt = (WindowsElement) driver
							.findElementByAccessibilityId(OR.getProperty("CardType"));
					CardPayOpt.click();
					WindowsElement DebitCard = (WindowsElement) driver.findElementByName(OR.getProperty("DebitCard"));
					DebitCard.click();
				}

				WindowsElement PayAmount = (WindowsElement) driver.findElementByName(OR.getProperty("AMT"));
				PayAmount.clear();
				PayAmount.sendKeys(Amt);

				WindowsElement TransactionId = (WindowsElement) driver
						.findElementByName(OR.getProperty("TransactionId"));
				TransactionId.clear();
				TransactionId.sendKeys("Test");

				WindowsElement Description = (WindowsElement) driver.findElementByName(OR.getProperty("Description"));
				Description.clear();
				Description.sendKeys("Test");
				WindowsElement PaymentSave = (WindowsElement) driver.findElementByName(OR.getProperty("PaymentSave"));
				PaymentSave.click();

				WindowsElement Save = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("SaveBill"));
				Save.click();

				log.debug("Bill Saved successfully!!!");

			}
			if (i == 7) {
				WindowsElement PaymentType = (WindowsElement) driver.findElementByName(OR.getProperty("PaymentType"));
				PaymentType.click();

				WindowsElement PaymentOpt = (WindowsElement) driver
						.findElementByAccessibilityId(OR.getProperty("PaymentOpt"));
				PaymentOpt.click();
				WindowsElement Cheque = (WindowsElement) driver.findElementByName(OR.getProperty("Cheque"));
				Cheque.click();

				WindowsElement BankName = (WindowsElement) driver
						.findElementByAccessibilityId(OR.getProperty("BankName"));
				BankName.click();
				WindowsElement SBI = (WindowsElement) driver.findElementByName(OR.getProperty("SBI"));
				SBI.click();
				WindowsElement PayAmount = (WindowsElement) driver.findElementByName(OR.getProperty("AMT"));
				PayAmount.clear();
				PayAmount.sendKeys(Amt);
				WindowsElement ChequeNum = (WindowsElement) driver.findElementByName(OR.getProperty("ChequeNum"));
				ChequeNum.clear();
				ChequeNum.sendKeys("test123");
				WindowsElement ChequeDate = (WindowsElement) driver.findElementByName(OR.getProperty("ChequeDate"));
				ChequeDate.click();
				WindowsElement Calendar = (WindowsElement) driver
						.findElementByAccessibilityId(OR.getProperty("Calendar"));
				Calendar.click();

				WindowsElement Description = (WindowsElement) driver.findElementByName(OR.getProperty("Description"));
				Description.clear();
				Description.sendKeys("Test");
				WindowsElement PaymentSave = (WindowsElement) driver.findElementByName(OR.getProperty("PaymentSave"));
				PaymentSave.click();

				WindowsElement Save = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("SaveBill"));
				Save.click();

				log.debug("Bill Saved successfully!!!");

			}
			if (i == 8) {
				
				Amount.clear();
				Amount.sendKeys("0");
				WindowsElement Save = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("SaveBill"));
				Save.click();

				log.debug("Bill Saved successfully!!!");

			}

			if (i >8) {
				WindowsElement SavecashPay = (WindowsElement) driver
						.findElementByAccessibilityId(OR.getProperty("SaveBill"));
				SavecashPay.click();
				log.debug("Bill Saved successfully!!!");

			}
		}
	}

		// Add Distributors
	@Test(priority = 5)
	public void Distributors() throws InterruptedException{

		WindowsElement Navigation = (WindowsElement) driver.findElementByName(OR.getProperty("OpenMenu"));
		Navigation.click();
			
		WindowsElement DISTRIBUTORS = (WindowsElement) driver.findElementByName(OR.getProperty("DISTRIBUTORS"));
		DISTRIBUTORS.click();

		String DisNum = (TestData.getProperty("REGNumberOfDistributors"));
		int REGNumberOfDistributors = Integer.parseInt(DisNum);
		for (int i = 1; i <= REGNumberOfDistributors; i++) {
			String PNN = String.valueOf(i);

			WindowsElement AddDistributor = (WindowsElement) driver.findElementByName(OR.getProperty("AddDistributor"));
			AddDistributor.click();

			WindowsElement DMobileNumber = (WindowsElement) driver.findElementByName(OR.getProperty("DMobileNumber"));
			DMobileNumber.clear();
			DMobileNumber.sendKeys(TestData.getProperty("REGDistributorNumber") + PNN);
			WindowsElement AMobileNumber = (WindowsElement) driver
					.findElementByName(OR.getProperty("AMobileNumber"));
			AMobileNumber.clear();
			AMobileNumber.sendKeys(TestData.getProperty("REGDistributorAltNumber") + PNN);
			WindowsElement DName = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("DName"));
			DName.clear();
			DName.sendKeys(TestData.getProperty("REGDistributorName") + PNN);
			WindowsElement DEMail = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("DEMail"));
			DEMail.clear();
			DEMail.sendKeys(TestData.getProperty("REGDistributorEmail") + PNN + "@test.com");
			
			WindowsElement DAddress = (WindowsElement) driver
					.findElementByAccessibilityId(OR.getProperty("DAddress"));
			DAddress.clear();
			DAddress.sendKeys(TestData.getProperty("REGDistributorAddress") + PNN);
			WindowsElement SalespersonName = (WindowsElement) driver.findElementByName(OR.getProperty("SalespersonName"));
			SalespersonName.clear();
			SalespersonName.sendKeys(TestData.getProperty("REGSalespersonName") + PNN);

			WindowsElement Dsave = (WindowsElement) driver.findElementByName(OR.getProperty("Dsave"));
			Dsave.click();
		}
	}
	


		//Purchase order
	@Test(priority = 6)
	public void Purchase() throws InterruptedException{
		
			WindowsElement Navigation = (WindowsElement) driver.findElementByName(OR.getProperty("OpenMenu"));
			
			Navigation.click();
			
			WindowsElement Inventory = (WindowsElement) driver.findElementByName(OR.getProperty("Inventory"));
			Inventory.click();
			
			String Numb1 = (TestData.getProperty("REGNumberOfPBill"));
			int numberOfPBills = Integer.parseInt(Numb1);
			
			String Numb2 = (TestData.getProperty("REGNumberOfProductInBill"));
			int numberOfPProdcts = Integer.parseInt(Numb2);
			
			WindowsElement Purchase = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("Purchase"));
			Purchase.click();
			for (int i = 1; i <= numberOfPBills; i++) {
			
			String PNN = String.valueOf(i);
			
			WindowsElement DistributorsSearchBox = (WindowsElement) driver.findElementByName(OR.getProperty("DistributorsSearchBox"));
			DistributorsSearchBox.click();
			DistributorsSearchBox.sendKeys(TestData.getProperty("REGDistributorNumber"));
			
			WindowsElement DistributorsSearchList = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("DistributorsSearchList"));
			DistributorsSearchList.click();
			log.debug("Distributor Tagged");
			
			
				
			WindowsElement PurchaseMemo = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PurchaseMemo"));
			PurchaseMemo.click();
			
				for (int j = 1; j <= numberOfPProdcts; j++)
				{
					String PNN1 = String.valueOf(j);
					WindowsElement PProductSearch = (WindowsElement) driver.findElementByName(OR.getProperty("PProductSearch"));
					PProductSearch.click();
					PProductSearch.sendKeys(TestData.getProperty("REGProductName") + PNN1);

					WindowsElement PProductSelect = (WindowsElement) driver.findElementByName(OR.getProperty("PProductSelect"));
					PProductSelect.click();

					WebDriverWait Popwait = new WebDriverWait(driver, 10);
					WindowsElement popupWindow = (WindowsElement) Popwait
							.until(ExpectedConditions.presenceOfElementLocated(By.className("Popup")));
					popupWindow.click();

					WindowsElement Quantity = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PQty"));
					Quantity.clear();
					Quantity.sendKeys(TestData.getProperty("REGPProductQty"));

					WindowsElement QTYOK = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PQtyOk"));
					QTYOK.click();
					log.debug("Product added in the cart");
					Thread.sleep(2000);
	
				}
				WindowsElement PurchaseDiscount = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PurchaseDiscount"));
				PurchaseDiscount.clear();
				PurchaseDiscount.sendKeys(TestData.getProperty("REGPProductDiscount"));
				log.debug("Discount applied");
				
				WindowsElement PurchaseCashBox = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PurchaseCashBox"));
				PurchaseCashBox.click();
				String PurchaseTotal=PurchaseCashBox.getText();
				
				if(i<=6) {
				
				if(i==1)
				{
				
				WindowsElement PurchaseAddPayment = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PurchaseAddPayment"));
				PurchaseAddPayment.click();
				
				WindowsElement PaymentOpt = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PaymentOpt"));
				PaymentOpt.click();
				WindowsElement Digital = (WindowsElement) driver.findElementByName(OR.getProperty("Digital"));
				Digital.click();

				WindowsElement DigPayOpt = (WindowsElement) driver
						.findElementByAccessibilityId(OR.getProperty("PayOpt"));
				DigPayOpt.click();

				WindowsElement PayTm = (WindowsElement) driver.findElementByName(OR.getProperty("PayTm"));
				PayTm.click();
				}
				 else if (i == 2) {
					 
						WindowsElement PurchaseAddPayment = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PurchaseAddPayment"));
						PurchaseAddPayment.click();

						WindowsElement PaymentOpt = (WindowsElement) driver
								.findElementByAccessibilityId(OR.getProperty("PaymentOpt"));
						PaymentOpt.click();
						WindowsElement Digital = (WindowsElement) driver.findElementByName(OR.getProperty("Digital"));
						Digital.click();

						WindowsElement DigPayOpt = (WindowsElement) driver
								.findElementByAccessibilityId(OR.getProperty("PayOpt"));
						DigPayOpt.click();
						WindowsElement PhonePe = (WindowsElement) driver.findElementByName(OR.getProperty("PhonePe"));
						PhonePe.click();
					} else if (i == 3) {
						
						WindowsElement PurchaseAddPayment = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PurchaseAddPayment"));
						PurchaseAddPayment.click();

						WindowsElement PaymentOpt = (WindowsElement) driver
								.findElementByAccessibilityId(OR.getProperty("PaymentOpt"));
						PaymentOpt.click();
						WindowsElement Digital = (WindowsElement) driver.findElementByName(OR.getProperty("Digital"));
						Digital.click();

						WindowsElement DigPayOpt = (WindowsElement) driver
								.findElementByAccessibilityId(OR.getProperty("PayOpt"));
						DigPayOpt.click();
						WindowsElement MobiKwik = (WindowsElement) driver.findElementByName(OR.getProperty("MobiKwik"));
						MobiKwik.click();
					} else if (i == 4) {
						
						WindowsElement PurchaseAddPayment = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PurchaseAddPayment"));
						PurchaseAddPayment.click();

						WindowsElement PaymentOpt = (WindowsElement) driver
								.findElementByAccessibilityId(OR.getProperty("PaymentOpt"));
						PaymentOpt.click();
						WindowsElement Digital = (WindowsElement) driver.findElementByName(OR.getProperty("Digital"));
						Digital.click();

						WindowsElement DigPayOpt = (WindowsElement) driver
								.findElementByAccessibilityId(OR.getProperty("PayOpt"));
						DigPayOpt.click();
						WindowsElement GooglePay = (WindowsElement) driver.findElementByName(OR.getProperty("GooglePay"));
						GooglePay.click();
					} else if (i == 5) {
						
						WindowsElement PurchaseAddPayment = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PurchaseAddPayment"));
						PurchaseAddPayment.click();

						WindowsElement PaymentOpt = (WindowsElement) driver
								.findElementByAccessibilityId(OR.getProperty("PaymentOpt"));
						PaymentOpt.click();
						WindowsElement Card = (WindowsElement) driver.findElementByName(OR.getProperty("Card"));
						Card.click();

						WindowsElement CardPayOpt = (WindowsElement) driver
								.findElementByAccessibilityId(OR.getProperty("CardType"));
						CardPayOpt.click();
						WindowsElement CreditCard = (WindowsElement) driver.findElementByName(OR.getProperty("CreditCard"));
						CreditCard.click();
					} else if (i == 6) {
						
						WindowsElement PurchaseAddPayment = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PurchaseAddPayment"));
						PurchaseAddPayment.click();

						WindowsElement PaymentOpt = (WindowsElement) driver
								.findElementByAccessibilityId(OR.getProperty("PaymentOpt"));
						PaymentOpt.click();
						WindowsElement Card = (WindowsElement) driver.findElementByName(OR.getProperty("Card"));
						Card.click();

						WindowsElement CardPayOpt = (WindowsElement) driver
								.findElementByAccessibilityId(OR.getProperty("CardType"));
						CardPayOpt.click();
						WindowsElement DebitCard = (WindowsElement) driver.findElementByName(OR.getProperty("DebitCard"));
						DebitCard.click();
					}
				WindowsElement PayAmount = (WindowsElement) driver.findElementByName(OR.getProperty("AMT"));
				PayAmount.clear();
				PayAmount.sendKeys(PurchaseTotal);

				WindowsElement TransactionId = (WindowsElement) driver
						.findElementByName(OR.getProperty("TransactionId"));
				TransactionId.clear();
				TransactionId.sendKeys("Test");

				WindowsElement Description = (WindowsElement) driver.findElementByName(OR.getProperty("Description"));
				Description.clear();
				Description.sendKeys("Test");
				Description.sendKeys(Keys.TAB);
				
				
				WindowsElement PaymentOptSave = (WindowsElement) driver.switchTo().activeElement();
				PaymentOptSave.click();

				WindowsElement Save = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PBillSave"));
				Save.click();
				
				WindowsElement PurchaseInvoiceNo = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PurchaseInvoiceNo"));
				PurchaseInvoiceNo.clear();
				PurchaseInvoiceNo.sendKeys("Invoice"+PNN);
				
				WindowsElement PurchaseOK = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PrimaryButton"));
				PurchaseOK.click();

				log.debug("Bill Saved successfully!!!");
			}
				
				if (i == 7) {
					WindowsElement PurchaseAddPayment = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PurchaseAddPayment"));
					PurchaseAddPayment.click();
					
					WindowsElement PaymentOpt = (WindowsElement) driver
							.findElementByAccessibilityId(OR.getProperty("PaymentOpt"));
					PaymentOpt.click();
					
					WindowsElement Cheque = (WindowsElement) driver.findElementByName(OR.getProperty("Cheque"));
					Cheque.click();

					WindowsElement BankName = (WindowsElement) driver
							.findElementByAccessibilityId(OR.getProperty("BankName"));
					BankName.click();
					WindowsElement SBI = (WindowsElement) driver.findElementByName(OR.getProperty("SBI"));
					SBI.click();
					WindowsElement PayAmount = (WindowsElement) driver.findElementByName(OR.getProperty("AMT"));
					PayAmount.clear();
					PayAmount.sendKeys(PurchaseTotal);
					WindowsElement ChequeNum = (WindowsElement) driver.findElementByName(OR.getProperty("ChequeNum"));
					ChequeNum.clear();
					ChequeNum.sendKeys("test123");
					WindowsElement ChequeDate = (WindowsElement) driver.findElementByName(OR.getProperty("ChequeDate"));
					ChequeDate.click();
					WindowsElement Calendar = (WindowsElement) driver
							.findElementByAccessibilityId(OR.getProperty("Calendar"));
					Calendar.click();

					WindowsElement Description = (WindowsElement) driver.findElementByName(OR.getProperty("Description"));
					Description.clear();
					Description.sendKeys("Test");
					Description.sendKeys(Keys.TAB);
					
					WindowsElement PaymentOptSave = (WindowsElement) driver.switchTo().activeElement();
					PaymentOptSave.click();

					WindowsElement Save = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PBillSave"));
					Save.click();
					
					WindowsElement PurchaseInvoiceNo = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PurchaseInvoiceNo"));
					PurchaseInvoiceNo.clear();
					PurchaseInvoiceNo.sendKeys("Invoice"+PNN);
					
					WindowsElement PurchaseOK = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PrimaryButton"));
					PurchaseOK.click();
					
					log.debug("Bill Saved successfully!!!");

				}
				if (i == 8) {
					
					PurchaseCashBox.clear();
					PurchaseCashBox.sendKeys("0");
					WindowsElement Save = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PBillSave"));
					Save.click();
					
					WindowsElement PurchaseInvoiceNo = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PurchaseInvoiceNo"));
					PurchaseInvoiceNo.clear();
					PurchaseInvoiceNo.sendKeys("Invoice"+PNN);
					
					WindowsElement PurchaseOK = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PrimaryButton"));
					PurchaseOK.click();
					
					
					log.debug("Bill Saved successfully!!!");

				}

				if (i >8) {
					WindowsElement Save = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PBillSave"));
					Save.click();
					
					WindowsElement PurchaseInvoiceNo = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PurchaseInvoiceNo"));
					PurchaseInvoiceNo.clear();
					PurchaseInvoiceNo.sendKeys("Invoice"+PNN);
					
					WindowsElement PurchaseOK = (WindowsElement) driver.findElementByAccessibilityId(OR.getProperty("PrimaryButton"));
					PurchaseOK.click();
					
				
					log.debug("Bill Saved successfully!!!");

				}
			

			}
			
		}

		//Logging out
		@Test(priority = 7)
		public void Logout() throws InterruptedException{
		
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
	
	