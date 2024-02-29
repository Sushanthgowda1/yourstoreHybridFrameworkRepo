package com.Lumen.YourStore.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Lumen.YourStore.BaseClass.Base;
import com.Lumen.YourStore.Pages.LandingPage;
import com.Lumen.YourStore.Pages.LoginPage;
import com.Lumen.YourStore.Pages.RegistrationPage;

import com.Lumen.YourStore.utils.customUtils;

public class RegistrationPageTest extends Base {

	WebDriver driver;
	LandingPage landingPage;
	LoginPage loginPage;
	RegistrationPage registerPage;

	public RegistrationPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		driver = launchDriver(prop.getProperty("browser"));
		landingPage = new LandingPage(driver);

	}

	@Test(priority = 1)
	public void verifyRegistrationPagewithMandatoryFields() {

		landingPage.lanuchApplication(prop.getProperty("url"));
		String actualTitle = landingPage.titleOfHomePage();
		Assert.assertEquals(actualTitle, prop.getProperty("title"));
		loginPage = landingPage.clickOnLoginlink();
		registerPage = loginPage.clickOnRegisterBTN();
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmail(customUtils.generateEmailWithtimeStamp());
		registerPage.enterPhoneNum(dataProp.getProperty("phone"));
		registerPage.enterPassword(dataProp.getProperty("password"));
		registerPage.enterconfirmpassword(dataProp.getProperty("password"));
		registerPage.clickOnPolicy();
		registerPage.clickOnsubmit();
		String actualMsg = registerPage.verifyConfirmationMsg();
		Assert.assertEquals(actualMsg, dataProp.getProperty("accSuccesullyCreatedMsg"));
		String actualBreadCrumb = registerPage.verifyBreadCrumb();
		Assert.assertEquals(actualBreadCrumb, "Success");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
