package com.Lumen.YourStore.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[normalize-space()='Search']")
	private WebElement searchBradcrumb;
	
	public SearchPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getsearchPageBreadCrumb() {
		return searchBradcrumb.getText();
		
	}
	
	
	
	

}
