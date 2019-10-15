package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_051_BlogPostPOM;
import com.training.pom.LoginPOM;
import com.training.pom.RETC_050_RestorePropertyPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_051_BlogPost {
	public WebDriver driver;
	public String baseUrl;
	public String adminUrl;
	public LoginPOM loginPOM;
	private RETC_051_BlogPostPOM BlogPostTest;
	private static Properties properties;
	public ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		BlogPostTest = new RETC_051_BlogPostPOM(driver);
		loginPOM = new LoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		adminUrl = properties.getProperty("adminURL");
		// open the browser 
		driver.get(baseUrl);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		screenShot = new ScreenShot(driver);
	}
  @Test(priority=0)
  public void BlogPostReply() throws AWTException, InterruptedException {
	  BlogPostTest.ClickBlogLink();
	  BlogPostTest.ClickReadMoreLink();
	  BlogPostTest.SendPostComment();
	  BlogPostTest.EnterNameTextBox();
	  BlogPostTest.EnterEmailTextBox();
	  BlogPostTest.SubmitBlogPost();
	  Thread.sleep(3000);
	  driver.navigate().to(adminUrl);
  }
  
  @Test(priority=1)
	public void validLoginTest() throws InterruptedException {
		loginPOM.ClickLogInLink();
		loginPOM.sendUserName("manipal");
		loginPOM.sendPassword("manipal@123");
		loginPOM.clickSigninBtn(); 
		screenShot.captureScreenShot("First");
		BlogPostTest.ClickDashboardLink();
		BlogPostTest.MouseOverRecentComment();
		BlogPostTest.SendReplyCommentText();
		BlogPostTest.ClickReplyButton();
		driver.navigate().refresh();
		driver.quit();
	}
  
}
