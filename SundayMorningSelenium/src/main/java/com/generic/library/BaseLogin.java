package com.generic.library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import com.master.pagefactory.MasterPageFactory;

public class BaseLogin {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		// chromeOptions.addArguments("--headless");
		WebDriver driver = new ChromeDriver(chromeOptions);// upcasting
		driver.manage().window().maximize();// maximum size
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// HTML load
		driver.get("http://www.gcrit.com/build3/");
		MasterPageFactory pf = PageFactory.initElements(driver, MasterPageFactory.class);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid green'", pf.getMyaccount());
		pf.getMyaccount().click();

		pf.getEmail().sendKeys("sarowerny@gmail.com");
		jse.executeScript("arguments[0].style.border='3px solid red'", pf.getEmail());

		pf.getPassword().sendKeys("student");
		TakeScreenShot.captureScreenShot(driver, "GCRSHOP during login");
		jse.executeScript("arguments[0].style.border='3px solid blue'", pf.getPassword());
		pf.getPassword().submit();

		TakeScreenShot.captureScreenShot(driver, "GCRSHOP login page");

	}

}
