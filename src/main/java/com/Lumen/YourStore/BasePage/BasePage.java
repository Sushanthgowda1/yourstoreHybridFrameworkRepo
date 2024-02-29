package com.Lumen.YourStore.BasePage;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected static WebDriver driver;
	protected static WebDriverWait wait;

	public BasePage(WebDriver driver) {

		BasePage.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofMillis(1000));
		PageFactory.initElements(driver, this);
	}

	public static void waitForEle(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void clickOnEle(WebElement ele) {
		waitForEle(ele);
		ele.click();
	}

	public String getText(WebElement ele) throws Throwable {

		waitForEle(ele);
		String ActualText = ele.getText();

		System.out.println("Actual Text :" + ActualText);

		return ActualText;
	}

	public void sendKeys(WebElement ele, String text) throws Throwable {

		clickOnEle(ele);
		ele.clear();
		ele.sendKeys(text);

	}

	public String getBreadCrumbText(WebElement ele) throws Throwable {

		String actualBreadCrum = "";

		List<WebElement> breadCrumElements = ele.findElements(By.tagName("li"));

		for (WebElement breadCrumElement : breadCrumElements) {

			actualBreadCrum = breadCrumElement.getText();
		}

		return actualBreadCrum;
	}

	public static void scrollByVisibilityOfElement(WebElement ele) throws Throwable {
		waitForEle(ele);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView()", ele);
	}

	public static boolean jsClick(WebElement ele) throws Throwable {

		waitForEle(ele);
		boolean flag = false;
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", ele);
			flag = true;
			return flag;

		} catch (Exception e) {
			return flag;

		} finally {

			if (flag) {
				System.out.println("js click is performed");
			} else {
				System.out.println("js click failure");
			}
		}

	}

	public static void mouseHoverusingJS(WebElement ele) throws Throwable {
		waitForEle(ele);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "var event = document.createEvent('MouseEvents');" + "event.initEvent('mouseover', true, true);"
				+ "arguments[0].dispatchEvent(event);";
		js.executeScript(script, ele);
	}

	public static void mouseHoverUsingActions(WebElement ele) throws Throwable {

		waitForEle(ele);
		try {
			Actions act = new Actions(driver);
			act.moveToElement(ele).build().perform();
		} catch (Exception e) {
			System.out.println("mouse hover failed");
		}
	}

	public static boolean isDisplayed(WebElement ele) throws Throwable {

		waitForEle(ele);
		try {

			return ele.isDisplayed();
		} catch (Exception e) {
			System.out.println("failed to verify");
			return false;
		}
	}

	public static boolean isSelected(WebElement ele) throws Throwable {

		waitForEle(ele);
		try {

			return ele.isSelected();
		} catch (Exception e) {
			System.out.println("failed to verify");
			return false;
		}
	}

	public static boolean isEnabled(WebElement ele) throws Throwable {

		waitForEle(ele);
		try {

			return ele.isEnabled();
		} catch (Exception e) {
			System.out.println("failed to verify");
			return false;
		}
	}

	public static void selectByIndex(WebElement ele, int i) throws Throwable {

		waitForEle(ele);
		try {

			Select select = new Select(ele);
			select.selectByIndex(i);
		} catch (Exception e) {
			System.out.println("failed to select");
		}

	}

	public static void selectByVisibleText(WebElement ele, String value) throws Throwable {

		waitForEle(ele);
		try {

			Select select = new Select(ele);
			select.selectByVisibleText(value);
		} catch (Exception e) {
			System.out.println("failed to select");
		}
	}

}
