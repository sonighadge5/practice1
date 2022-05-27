package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;
import com.page.AmazonPageLoad;

public class Listener extends AmazonPageLoad implements ITestListener {

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "test case is passed");
		
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "test case is failed"+ result.getName());
		String path = takeScreenshots(result.getName());
		test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "test case skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		
		
	}

}
