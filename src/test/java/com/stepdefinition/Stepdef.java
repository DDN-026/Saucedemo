package com.stepdefinition;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.reusablemethods.Baseclass;
import com.reusablemethods.sauceObject;

public class Stepdef extends Baseclass {
	ExtentReports extent;
	ExtentTest logger;

// valid and invalid username password combinations
	@BeforeClass
	public void login_to_saucedemo_app() throws Throwable {

		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter("extentreports.html");

		ExtentReports extend = new ExtentReports();
		extend.attachReporter(htmlreporter);
		ExtentTest test = extend.createTest("Mfirsttest", "sample");
		test.log(Status.INFO, "opening browser");
		for (int i = 1; i <= 5; i++) {
			InitialiseSelenium(getData(1, 4));
			sendkeys(sauceObject.username, getData(i, 0));
			sendkeys(sauceObject.password, getData(1, 2));
			click(sauceObject.login_btn);
			takeSnapShot();
			Thread.sleep(200);
			test.pass("successfully logged");
			quitBrowser();
		}
	}

// Two Items to cart from home page
	@BeforeMethod
	public void entercredts() throws Throwable {
		InitialiseSelenium(getData(1, 4));
		sendkeys(sauceObject.username, getData(1, 0));
		sendkeys(sauceObject.password, getData(1, 2));
		click(sauceObject.login_btn);
		maximize();
		for (int i = 1; i <= 2; i++) {
			click(sauceObject.Addtocart_1);
		}

		takeSnapShot();
	}

//checkout the items,place and complete the order and verify the bill
	@Test
	public void test() throws Throwable {
		click(sauceObject.shop_baskt);
		click(sauceObject.shop_baskt);
		click(sauceObject.checkout);
		sendkeys(sauceObject.first_name, getData(1, 5));
		sendkeys(sauceObject.last_name, getData(1, 6));
		sendkeys(sauceObject.postal_code, getData(1, 7));
		click(sauceObject.continue_btn);
		takeSnapShot();
		String Actual_text = getText(sauceObject.verify_billamt);
		Assert(Actual_text, getData(1, 8));
		click(sauceObject.finish_btn);
		takeSnapShot();

	}

	@AfterMethod
	public void logout() {
		javascriptclick(sauceObject.home_btn);
		javascriptclick(sauceObject.logout_btn);
	}

	@AfterClass
	public void quit() {
		quitBrowser();
	}
}
