package com.opencart.driverfactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	WebDriver driver;
	Properties prop;

	public static String highlight = null;

	/**
	 * 
	 * @param browserName
	 * @return this method will return webdriver
	 */
	public WebDriver initializeDriver(String browserName) {

		highlight = prop.getProperty("highlight");

		System.out.println("browser name is : " + browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("please pass the correct browser : " + browserName);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url").trim());
		return driver;
	}

	public Properties init_prop() {

		FileInputStream ip = null;
		prop = new Properties();

		String env = System.getProperty("env");
		if (env == null) {
			System.out.println("Running on Environment : --> on PROD");
			try {
				ip = new FileInputStream("./src/test/resources/config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Running on Environment : --> " + env);
			try {
				switch (env) {
				case "qa":
					ip = new FileInputStream("./src/test/resources/qa.config.properties");
					break;
				case "stage":
					ip = new FileInputStream("./src/test/resources/stage.config.properties");
					break;
				case "dev":
					ip = new FileInputStream("./src/test/resources/dev.config.properties");
					break;
				default:
					break;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}
		try {
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
