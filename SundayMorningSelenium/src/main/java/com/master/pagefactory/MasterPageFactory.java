package com.master.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MasterPageFactory {
	

	@FindBy(xpath = "(//*[@class='ui-button-text'])[3]")
	private WebElement myaccount;
	@FindBy(xpath = "//*[@name='email_address']")
	private WebElement email;
	@FindBy(xpath = "//*[@name='password']")
	private WebElement password;

	public WebElement getMyaccount() {
		return myaccount;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getPassword() {
		return password;
	}
	
	
	
	
	
}