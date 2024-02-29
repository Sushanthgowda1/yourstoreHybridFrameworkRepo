package com.Lumen.YourStore.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

	WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Apple Cinema 30\"']")
	private WebElement productBreadCrum;
	@FindBy(xpath = "//h1[@class='h1-product']")
	private WebElement productName;
	@FindBy(xpath = "(//div[@id=\"input-option218\"]//input[@name=\"option[218]\"])[1]")
	private WebElement smallOptionRadioBtn;
	@FindBy(xpath = "(//div[@id=\"input-option218\"]//input[@name=\"option[218]\"])[2]")
	private WebElement mediumOptionRadioBtn;
	@FindBy(xpath = "(//div[@id=\"input-option218\"]//input[@name=\"option[218]\"])[3]")
	private WebElement largeOptionRadioBtn;
	@FindBy(xpath = "//input[@value='8']")
	private WebElement checkBox1;
	@FindBy(xpath = "//input[@value='9']")
	private WebElement checkBox2;
	@FindBy(xpath = "//input[@value='10']")
	private WebElement checkBox3;
	@FindBy(xpath = "//input[@value='11']")
	private WebElement checkBox4;
	@FindBy(xpath = "//input[@id='input-option208']")
	private WebElement textBox;
	@FindBy(xpath = "//select[@id='input-option217']")
	private WebElement selectDropDown;
	@FindBy(xpath = "//textarea[@id='input-option209']")
	private WebElement textAreaBox;
	@FindBy(xpath = "//button[@id='button-upload222']")
	private WebElement uploadFileBTN;
	@FindBy(xpath = "//div[@class='input-group date']//i[@class='fa fa-calendar']")
	private WebElement dateCalenderBTN;
	@FindBy(xpath = "//div[@class='input-group time']//button[@type='button']")
	private WebElement timeCalenderBTN;
	@FindBy(xpath = "//div[@class='input-group datetime']//button[@type='button']")
	private WebElement dateTimeCalenderBTN;
	@FindBy(xpath = "//input[@id='input-quantity']")
	private WebElement qantityTextBox;
	@FindBy(xpath = "//button[@id='button-cart']")
	private WebElement addToCartBTN;

	public boolean verifyRightProductisDisplayed() {
		boolean isTrue = false;
		if (productBreadCrum.getText() == productName.getText()) {
			isTrue = true;
		}
		return isTrue;
	}

	public void selectRadioBtn(String option) {
		switch (option) {
		case "Small":
			smallOptionRadioBtn.click();
			break;
		case "Medium":
			mediumOptionRadioBtn.click();
			break;
		case "Large":
			largeOptionRadioBtn.click();
			break;
		}
	}

	public void selectCheckBox(String option) {

		switch (option) {
		case "cheackbox1":
			checkBox1.click();
			break;
		case "cheackbox2":
			checkBox2.click();
			break;
		case "cheackbox3":
			checkBox3.click();
			break;
		case "cheackbox4":
			checkBox4.click();
			break;

		default:
			break;
		}
	}

	public void enterTextIntotextBox(String text) {
		textBox.clear();
		textBox.sendKeys(text);
	}

	public void enterTextintoTextAreaBox(String text) {
		textAreaBox.clear();
		textAreaBox.sendKeys(text);

	}

	public void selectOptionInDropDown(String option) {

		Select select = new Select(selectDropDown);
		select.deselectByVisibleText(option);

	}

	public void upLoadFile(String filePath) {
		uploadFileBTN.sendKeys(filePath);

	}
	
	

}
