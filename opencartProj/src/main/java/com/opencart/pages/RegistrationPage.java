package com.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.utils.ElementUtil;

public class RegistrationPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	// Locators
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By passwordConfirm = By.id("input-confirm");
	private By continueBtn = By.xpath("//input[@value='Continue']");
	private By checkBox = By.xpath("//input[@type='checkbox']");

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public void doRegister() {
		elementUtil.doSendKeys(firstName, "Aditya");
		elementUtil.doSendKeys(lastName, "Raj");
		elementUtil.doSendKeys(email, "aditya456@gmail.com");
		elementUtil.doSendKeys(telephone, "53953250");
		elementUtil.doSendKeys(password, "password123");
		elementUtil.doSendKeys(passwordConfirm, "password123");
		elementUtil.doClick(checkBox);
		elementUtil.doClick(continueBtn);
	}

}
