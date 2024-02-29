package com.Lumen.YourStore.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//h1[normalize-space()='My Account']")
	private WebElement myAccPageHeader;
	
	@FindBy(xpath="//li[@class='list-group-item']//a[contains(text(),'My Account')]")
	private WebElement myaccLink;
	
	@FindBy(xpath="//li[@class='list-group-item']//a[contains(text(),'Edit Account')]")
	private WebElement editAccLink;
	
	@FindBy(xpath="//li[@class='list-group-item']//a[contains(text(),'Password')]")
	private WebElement paaswordRestLink;
	
	@FindBy(xpath="//li[@class='list-group-item']//a[contains(text(),'Logout')]")
	private WebElement logoutLink;
	
	@FindBy(xpath="//div[@class='content']//a[contains(text(),'Order History')]")
	private WebElement orderHistoryLink;
	
	@FindBy(xpath="//a[normalize-space()='Address Book']")
	private WebElement addressBookLink;
	
	@FindBy(xpath= "//a[normalize-space()='Home']")
	private WebElement homeBreadCrumbLink;
	
	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageHeader() {
		return myAccPageHeader.getText();
	}
	
	public LandingPage clickOnHomeBreadCrumb() {
		homeBreadCrumbLink.click();
		return new LandingPage(driver);
	}
	
	
	
	
	

}
