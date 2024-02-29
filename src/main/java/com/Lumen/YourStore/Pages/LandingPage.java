package com.Lumen.YourStore.Pages;



import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage {

	WebDriver driver;

	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement myAccLink;

	@FindBy(xpath = "//a[@id='wishlist-total']")
	private WebElement wishListLink;

	@FindBy(xpath = "//a[@title='Checkout']")
	private WebElement checkOutLink;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	private WebElement loginLink;

	@FindBy(xpath = "//div[@class='col-sm-4']//div//input")
	private WebElement searchTextBox;

	@FindBy(xpath = "//img[@src='catalog/view/theme/salestore/image/button-search.png']")
	private WebElement searchBtn;

	@FindBy(xpath = "//div[@id='logo']//img[@class='img-responsive']")
	private WebElement logo;
	
	@FindBy(xpath = "//a[normalize-space()='Desktops']")
	private WebElement desktopDropdown;
	
	@FindBy(xpath = "//a[normalize-space()='Laptops & Notebooks']")
	private WebElement laptopsAndNoteBooksDropdown;
	
	@FindBy(xpath = "//a[normalize-space()='Components']")
	private WebElement componentsDropdown;
	
	@FindBy(xpath = "//a[normalize-space()='Tablets']")
	private WebElement tabletsLink;
	
	@FindBy(xpath = "//div[3]//div[2]//div[1]//div[1]//div[1]//a[1]//img[1]")
	private WebElement appleCenima;
	

	public LandingPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void lanuchApplication(String url) {

		 driver.get(url);

	}

	public String titleOfHomePage() {

		return driver.getTitle();

	}
	
	public ProductPage clickOnAppleCenimaProduct() {
		appleCenima.click();
		return new ProductPage(driver);
	}

	public boolean verifyLogo() {

		boolean isdisplayed = false;
		try {
			isdisplayed = logo.isDisplayed();
		} catch (Throwable e) {

			e.printStackTrace();
		}
		return isdisplayed;

	}

	public SearchPage searchingvalidProd(String prodName) {
		
		searchTextBox.click();
		try {
			searchTextBox.sendKeys(prodName);
		} catch (Throwable e) {

			e.printStackTrace();
		}
		searchBtn.click();
		return new SearchPage(driver);
	}
	
	public SearchPage searchInvalidProd(String prodName) {
		
		searchTextBox.click();
		try {
			searchTextBox.sendKeys(prodName);
		} catch (Throwable e) {

			e.printStackTrace();
		}
		searchBtn.click();
		return new SearchPage(driver);
	}

	public LoginPage clickOnLoginlink() {

		loginLink.click();
		return new LoginPage(driver);

	}

}
