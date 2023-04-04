package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencart.base.BaseClass;
import com.opencart.driverfactory.DriverFactory;
import com.opencart.pages.LoginPage;

public class LoginPageTest extends BaseClass {

	@BeforeTest
	public void load() {
		df = new DriverFactory();
		prop = df.init_prop();
		prop.setProperty("browser", prop.getProperty("browser"));
		driver = df.initializeDriver(prop.getProperty("browser"));
		loginPage = new LoginPage(driver);
	}

	@Test
	public void doLoginTest() throws Exception{
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
		Assert.assertEquals("My Account", driver.getTitle());
	}

	@AfterMethod
	public void tearDown() {
		endExecution();
	}

}
