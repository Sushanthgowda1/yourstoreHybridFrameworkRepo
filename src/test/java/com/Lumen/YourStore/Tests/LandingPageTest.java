package com.Lumen.YourStore.Tests;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Lumen.YourStore.BaseClass.Base;
import com.Lumen.YourStore.Pages.LandingPage;

public class LandingPageTest extends Base {

	WebDriver driver;
	LandingPage landing;

	public LandingPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		driver = launchDriver(prop.getProperty("browser"));
		landing = new LandingPage(driver);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void verifyLandingPageTitle() {

		landing.lanuchApplication(prop.getProperty("url"));
		boolean isDiplayed = landing.verifyLogo();
		Assert.assertTrue(isDiplayed);
		landing.titleOfHomePage();
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Your Store");

	}

}
