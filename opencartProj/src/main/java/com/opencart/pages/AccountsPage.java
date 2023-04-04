package com.opencart.pages;

import org.openqa.selenium.WebDriver;

import com.opencart.utils.ElementUtil;

public class AccountsPage {
	
	
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	
	public AccountsPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtil= new ElementUtil(driver);
	}
	


}
