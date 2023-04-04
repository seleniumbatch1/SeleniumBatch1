package com.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.utils.ElementUtil;

public class HomePage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	// Locators
	private By myAccount = By.xpath("//span[text()='My Account']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public void selectMyAccount() throws Exception {
		elementUtil.doClick(myAccount);
		Thread.sleep(2000);
	}

	public RegistrationPage selectMyAccountOptions(String optionName) throws Exception{
		driver.findElement(By.xpath("//a[text()='" + optionName + "']")).click();
		Thread.sleep(2000);
		return new RegistrationPage(driver);
	}

}
