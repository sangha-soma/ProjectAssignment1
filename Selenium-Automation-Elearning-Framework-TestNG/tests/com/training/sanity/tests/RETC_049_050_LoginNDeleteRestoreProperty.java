package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_049_DeletePropertyPOM;
import com.training.pom.LoginPOM;
import com.training.pom.RETC_050_RestorePropertyPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_049_050_LoginNDeleteRestoreProperty {
	public WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private RETC_049_DeletePropertyPOM DeletePropertytest;
	private RETC_050_RestorePropertyPOM RestorePropertytest;
	private static Properties properties;
	private ScreenShot screenShot;
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver); 
		RestorePropertytest = new RETC_050_RestorePropertyPOM(driver);
		DeletePropertytest = new RETC_049_DeletePropertyPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	/*
	 * @AfterTest public void tearDown() throws Exception { Thread.sleep(1000);
	 * driver.quit(); }
	 */
	@Test(priority=0)
	public void validLoginTest() {
		loginPOM.ClickLogInLink();
		loginPOM.sendUserName("manipal");
		loginPOM.sendPassword("manipal@123");
		loginPOM.clickSigninBtn(); 
		screenShot.captureScreenShot("First");
	}
	@Test(priority=1)
	  public void DeletePropertyTrash() throws InterruptedException {
		  DeletePropertytest.ClickPropertiesLink();
		  DeletePropertytest.ClickAllPropertiesLink();
		  DeletePropertytest.MouseOverPropertyLink();
		  DeletePropertytest.ClickTrashTab();
		  DeletePropertytest.MouseOverTrashPropertyLink();
		  DeletePropertytest.AssertDelPropertyVerification();
		  //screenShot.captureScreenShot("Second");
	  }

	@Test(priority=2)
	  public void RestorePropertyTrash() throws InterruptedException, AWTException {
		  RestorePropertytest.ClickPropertiesLink();
		  RestorePropertytest.ClickAllPropertiesLink();
		  RestorePropertytest.ClickTrashTab();
		  RestorePropertytest.MouseOverTrashPropertyLink();
		  RestorePropertytest.AssertRestorePropertyVerification();
		  RestorePropertytest.OpenPropertyInNewWindow();
		  RestorePropertytest.RestoredPropertySearch();
		  //screenShot.captureScreenShot("Third");
	  }
	
  }
