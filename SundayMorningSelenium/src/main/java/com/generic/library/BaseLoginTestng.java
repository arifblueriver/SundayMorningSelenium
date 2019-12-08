package com.generic.library;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.config.ObjectMap;
import com.master.pagefactory.MasterPageFactory;
import com.report.ExtentReport;
import com.util.HighLighter;
import com.util.TakeScreenShot;

public class BaseLoginTestng extends ExtentReport {
	private WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		// chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(chromeOptions);// upcasting
		driver.manage().window().maximize();// maximum size
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// HTML load
	}

	@Test
	public void login() throws Throwable {

		ObjectMap obj = new ObjectMap();

		driver.get(obj.getconfig("URL"));
		MasterPageFactory pf = PageFactory.initElements(driver, MasterPageFactory.class);

		HighLighter.color(driver, pf.getMyaccount());
		pf.getMyaccount().click();

		pf.getEmail().sendKeys(obj.getconfig("Name"));
		HighLighter.color(driver, pf.getEmail());
		pf.getPassword().sendKeys(obj.getconfig("Password"));

		HighLighter.color(driver, pf.getPassword());
		pf.getPassword().submit();

		// TakeScreenShot.captureScreenShot(driver, "GCRSHOP login page");

		// long id = Thread.currentThread().getId();
		// System.out.println("Sample test-method One. Thread id is: " + id);
	}

	@AfterTest
	public void teardown() {

		driver.quit();

	}

}
