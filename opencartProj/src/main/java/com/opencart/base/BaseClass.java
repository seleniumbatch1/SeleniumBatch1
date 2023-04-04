package com.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.opencart.driverfactory.DriverFactory;
import com.opencart.pages.AccountsPage;
import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;
import com.opencart.pages.RegistrationPage;

public class BaseClass {

	protected DriverFactory df;
	public WebDriver driver;
	public Properties prop;
	
	public LoginPage loginPage;
	public AccountsPage accPage;
	public RegistrationPage regPage;
	public HomePage homePage;


	
	public void setup(String browserName) {
		df = new DriverFactory();
		prop = df.init_prop();
		prop.setProperty("browser", browserName);
		driver = df.initializeDriver(browserName);
		loginPage = new LoginPage(driver);
	}

	public void endExecution() {
		driver.quit();
	}

	
}
