package com.page;

import java.io.File;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.ReadPropertyFile;

public class AmazonPageLoad {
	public static WebDriver driver = null;
	public static ExtentReports report = null;
	public static ExtentSparkReporter spark = null;
	public static ExtentTest test = null;
	public static Logger log = Logger.getLogger("AmazonPageLoad");
	static File src;
	public void initalization() {
		log.info("browser initialization");
		String browser=ReadPropertyFile.readPropertyFile("browser");
		if (browser.equals("chrome")) 
		{
		System.setProperty("webdriver.chrome.driver", "chromedriver98.exe");
		driver=new ChromeDriver();
		} 
		  if (browser.equals("firefox")) 
		  {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		  }
		   
		driver.get(ReadPropertyFile.readPropertyFile("url"));
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}
	
	 public static String takeScreenshots (String name) 
	 {
	    TakesScreenshot ts=(TakesScreenshot) driver;
	    System.out.println("screenshot generated");
	     try {
			src =  ts.getScreenshotAs(OutputType.FILE);
		} catch (WebDriverException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   System.out.println("hello");
	   String path= System.getProperty("user.dir")+"/screenshots/"+name+".jpg";
	   File des = new File(path);
	   try {
		   FileUtils.copyFile(src, des);
	   }
	   catch (IOException e) {
		   System.out.println("File not found");
	   }
	   return path;
	 }
	 
	 public static void reportsinit() {
		 report = new ExtentReports();
		 spark = new ExtentSparkReporter (System.getProperty("user.dir")+"/target/ExtentReports.html");
		 report.attachReporter(spark);
	 }
}

