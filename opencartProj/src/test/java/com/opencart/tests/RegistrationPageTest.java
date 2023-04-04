package com.opencart.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencart.base.BaseClass;
import com.opencart.driverfactory.DriverFactory;
import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;
import com.opencart.pages.RegistrationPage;

public class RegistrationPageTest extends BaseClass {

	@BeforeTest
	public void load() {
		df = new DriverFactory();
		prop = df.init_prop();
		prop.setProperty("browser", prop.getProperty("browser"));
		driver = df.initializeDriver(prop.getProperty("browser"));
		loginPage = new LoginPage(driver);
		regPage = new RegistrationPage(driver);
		homePage = new HomePage(driver);

	}

	@Test
	public void doRegister() throws Exception {
		homePage.selectMyAccount();
		homePage.selectMyAccountOptions("Register");
		regPage.doRegister();
		Thread.sleep(2000);
	}

	@AfterMethod
	public void tearDown() {
		endExecution();
	}

}
