package com.WebOrder.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.WebOrder.common.WebOrder_BasePage;
import com.WebOrder.home.WebOrder_HomePage;
import com.WebOrder.home.WebOrders_SignInPage;
import com.WebOrder.common.WebOrder_BaseSetup;

public class WebOrder_Login extends WebOrder_BaseSetup{
	WebOrders_SignInPage signIn;
	WebOrder_HomePage homePage;
	WebOrder_BasePage basePage;
	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
		basePage = new WebOrder_BasePage(driver);
	}

	@Test(description = "Login and validate the WebOrder Homepage Text", priority = 1)
	public void loginTest() throws Exception {
		test = extent.createTest("Test Case 1", "Verify Text after login");
		signIn = basePage.GoToHomePageAndSignIn("Tester", "test");
		Thread.sleep(3000);
		signIn.verifySignInPageText();
		basePage.logout();
	}

	@Test(description = "validateURL() method call for URL verification", priority = 2)
	public void urlTest() throws Exception {
		test = extent.createTest("Test Case 2", "Verify URL after login");
		signIn = basePage.GoToHomePageAndSignIn("Tester", "tes");
		Thread.sleep(3000);
		signIn.verifySignInPageURL();
		basePage.logout();
	}

	@Test(description = "validateURL() method call for URL verification", priority = 3)
	public void verifyText() throws Exception {
		test = extent.createTest("Test Case 3", "Verify Text after login");
		signIn = basePage.GoToHomePageAndSignIn("Tester", "test");
		Thread.sleep(3000);
		signIn.verifySignInPageText();
		basePage.logout();
	}
}

