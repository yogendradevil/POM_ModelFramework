package com.WebOrder.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.WebOrder.home.WebOrder_HomePage;
import com.WebOrder.home.WebOrders_EditOrderPage;
import com.WebOrder.home.WebOrders_OrdersPage;
import com.WebOrder.home.WebOrders_SignInPage;
import com.WebOrder.home.WebOrders_ViewAllOrdersPage;
import com.WebOrder.utils.WebOrder_TestData;
import com.WebOrder.common.WebOrder_BasePage;
import com.WebOrder.common.WebOrder_BaseSetup;

public class WebOrder_Orders_Test extends WebOrder_BaseSetup{
	WebOrders_SignInPage signIn;
	WebOrder_HomePage homePage;
	WebOrder_BasePage basePage;
	WebOrders_OrdersPage orderPage;
	WebOrders_ViewAllOrdersPage allOrderPage;
	private WebDriver driver;


	@BeforeClass
	public void setUp() {
		driver = getDriver();
		basePage = new WebOrder_BasePage(driver);
	}

	@Test(description = "Validate reset button", dataProvider = "Reset Form", dataProviderClass = WebOrder_TestData.class, priority = 1, enabled = false)
	public void verifyCheckAll(String product, String qty, String custName, String street, String city, String state,
			String zip, String card, String cardNr, String expiry, String expectedResult) throws Exception {
		test = extent.createTest("Test Case 1", "Verify if all fields are cleared after clicking reset button");
		signIn = basePage.GoToHomePageAndSignIn("Tester", "test");
		signIn.verifySignInPageText();
		homePage = new WebOrder_HomePage(driver);
		orderPage = homePage.clickOnOrdersTab();
		orderPage.resetForm(product, qty, custName, street, city, state, zip, card, cardNr, expiry, expectedResult);
		basePage.logout();

	}
	
	@Test(description = "create and verify new Orders", dataProvider = "OrdersExcelData", dataProviderClass = WebOrder_TestData.class, priority = 2, enabled = true)
	public void createAndVerifyOrder(String product, String qty, String custName, String street, String city, String state,
			String zip, String card, String cardNr, String expiry, String expectedResult) throws Exception {
		test = extent.createTest("Test Case 2", "Create and Verify if order is created successfully");
		signIn = basePage.GoToHomePageAndSignIn("Tester", "test");
		signIn.verifySignInPageText();
		homePage = new WebOrder_HomePage(driver);
		orderPage = homePage.clickOnOrdersTab();
		orderPage.createOrder(product, qty, custName, street, city, state, zip, card, cardNr, expiry, expectedResult);
		
		if(expectedResult.equalsIgnoreCase("success")) 
		{
		allOrderPage = homePage.clickOnAllOrdersTab();
		allOrderPage.verifyUpdatedOrder(product, qty, custName, street, city, state, zip, card, cardNr, expiry);
		}
		basePage.logout();

		
	}
}
