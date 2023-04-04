package com.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	// Locators
	private By usernameEle = By.id("input-email");
	private By passwordEle = By.id("input-password");
	private By loginButtonEle = By.xpath("//input[@type='submit']");

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public AccountsPage doLogin(String userName, String password)

	{
		elementUtil.doSendKeys(usernameEle, userName);
		elementUtil.doSendKeys(passwordEle, password);
		elementUtil.doClick(loginButtonEle);
		return new AccountsPage(driver);

	}

}
