package com.Lumen.YourStore.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CustomListner implements ITestListener {

	WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest logger;

	public static void getExtentReport(String testName) {
		extent = new ExtentReports();
		File reportFile = new File(
				System.getProperty("user.dir") + "\\reports\\QAReport\\" +testName+ System.currentTimeMillis() + ".html");
		ExtentSparkReporter spark = new ExtentSparkReporter(reportFile);
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("YOUR STORE Automation Report");
		spark.config().setReportName("Sushanth s");

	}
	
	public static String getScreenShot(String testname, WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\Screenshots" + File.separator + testname + System.currentTimeMillis() + ".png");

		try {
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dest.getAbsolutePath();
	}

	

	@Override
	public void onStart(ITestContext context) {
		String testName = context.getName();
		getExtentReport(testName);
	}

	@Override
	public void onTestStart(ITestResult result) {

		String testName = result.getName();
		logger = extent.createTest(testName);
		logger.createNode(testName);
		logger.log(Status.INFO, testName + "execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		logger.log(Status.PASS, MarkupHelper.createLabel(testName + " Sucessfully Executed", ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			if (result.getStatus() == ITestResult.FAILURE) {
				logger.log(Status.FAIL,
						MarkupHelper.createLabel(result.getTestName() + " Failed to Execute", ExtentColor.RED));
				logger.log(Status.FAIL,
						MarkupHelper.createLabel(result.getThrowable() + " Case Failed to Execute", ExtentColor.RED));
				logger.addScreenCaptureFromPath(getScreenShot(result.getTestName(), driver));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		String testName = result.getName();
		logger.log(Status.SKIP, MarkupHelper.createLabel(testName + " Case Got Skipped", ExtentColor.ORANGE));
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
