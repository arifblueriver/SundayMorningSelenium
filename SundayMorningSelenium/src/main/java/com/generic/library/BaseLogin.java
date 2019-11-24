package com.generic.library;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import com.config.ObjectMap;
import com.master.pagefactory.MasterPageFactory;
import com.util.HighLighter;
import com.util.TakeScreenShot;

public class BaseLogin {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		// chromeOptions.addArguments("--headless");
		WebDriver driver = new ChromeDriver(chromeOptions);// upcasting
		driver.manage().window().maximize();// maximum size
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// HTML load
		ObjectMap obj = new ObjectMap();
		driver.get(obj.getconfig("URL"));
		MasterPageFactory pf = PageFactory.initElements(driver, MasterPageFactory.class);
		HighLighter.color(driver, pf.getMyaccount());
		pf.getMyaccount().click();
		pf.getEmail().sendKeys(obj.getconfig("Name"));
		HighLighter.color(driver, pf.getEmail());
		pf.getPassword().sendKeys(obj.getconfig("Password"));
		TakeScreenShot.captureScreenShot(driver, "GCRSHOP during login");
		HighLighter.color(driver, pf.getPassword());
		pf.getPassword().submit();
		TakeScreenShot.captureScreenShot(driver, "GCRSHOP login page");
		driver.quit();
		

	}

}
