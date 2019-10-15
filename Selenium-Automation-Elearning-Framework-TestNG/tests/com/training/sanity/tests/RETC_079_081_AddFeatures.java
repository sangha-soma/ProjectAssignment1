package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_079_AddNewFeaturePOM;
import com.training.pom.RETC_081_AddMultipleNewFeaturePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_079_081_AddFeatures {
	public WebDriver driver;
	public String adminUrl;
	public LoginPOM loginPOM;
	public RETC_081_AddMultipleNewFeaturePOM AddMultipleNewFeatureTest;
	private static Properties properties;
	public ScreenShot screenShot;
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver);
		AddMultipleNewFeatureTest = new RETC_081_AddMultipleNewFeaturePOM(driver);
		adminUrl = properties.getProperty("adminURL");
		// open the browser 
		driver.get(adminUrl);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		screenShot = new ScreenShot(driver);
	}
  @Test(priority=0)
  public void adminLogin() {
	  	loginPOM.ClickLogInLink();
		loginPOM.sendUserName("manipal");
		loginPOM.sendPassword("manipal@123");
		loginPOM.clickSigninBtn(); 
		screenShot.captureScreenShot("First");
  }
  
  @Test(priority=1)
	public void addFeatureTest() throws InterruptedException {
	  	AddMultipleNewFeatureTest.ClickPropertiesLink();
	  	AddMultipleNewFeatureTest.ClickFeaturesLink();
	  	AddMultipleNewFeatureTest.SendNameText();
	  	AddMultipleNewFeatureTest.SendSlugText();
	  	AddMultipleNewFeatureTest.SelectParentFeature();
	  	AddMultipleNewFeatureTest.SendDescriptionText();
	  	AddMultipleNewFeatureTest.ClickAddFeatureButton();
	  	driver.navigate().refresh();
		}
}
