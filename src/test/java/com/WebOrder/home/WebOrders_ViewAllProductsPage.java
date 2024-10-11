package com.WebOrder.home;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebOrders_ViewAllProductsPage {
	WebDriver driver;
	WebDriverWait wait;

	public WebOrders_ViewAllProductsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

}
