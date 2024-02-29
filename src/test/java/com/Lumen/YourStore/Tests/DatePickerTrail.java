package com.Lumen.YourStore.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerTrail {

	WebDriver driver;

	@Test
	public void datePicker() {

		String targetMonth = "july";
		String targetDay = "34";
		String targetYear = "2020";

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.demoopencart.in/themes/salestore/oc3/index.php?route=product/product&product_id=42");

		driver.findElement(By.xpath("//div[@class='input-group date']//i[@class='fa fa-calendar']")).click();

		while (true) {
			String monthYear = driver
					.findElement(By.xpath("(//div[@class='datepicker']//th[@class='picker-switch'])[1]")).getText();

			String[] arr = monthYear.split(" ");
			String month = arr[0];
			String year = arr[1];

			if (month.equalsIgnoreCase(targetMonth) && year.equalsIgnoreCase(targetYear)) {

				break;

			} else {

				driver.findElement(By.xpath("(//div[@class='datepicker']//th[@class='next'])[1]")).click();
			}

		}// Date Selection

			List<WebElement> alldates = driver
					.findElements(By.xpath("//table[@class='table-condensed']//td[@class='day']"));

			for (WebElement ele : alldates) {
				String dt = ele.getText();
				if ( dt.equals(targetDay)) {
					ele.click();
					break;
			}
		}

		driver.quit();

	}

}
