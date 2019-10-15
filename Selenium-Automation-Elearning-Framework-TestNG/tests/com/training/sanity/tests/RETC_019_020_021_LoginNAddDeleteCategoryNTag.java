package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_020_AddNewTagPOM;
import com.training.pom.RETC_019_DeleteCategoryPOM;
import com.training.pom.RETC_021_DeleteTagPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_019_020_021_LoginNAddDeleteCategoryNTag {

	public WebDriver driver;
	private String baseUrl;
	public LoginPOM loginPOM;
	private RETC_019_DeleteCategoryPOM DeleteCategorytest;
	private RETC_020_AddNewTagPOM AddNewTagtest;
	private RETC_021_DeleteTagPOM DeleteTagtest;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	/*
	 * @BeforeMethod public void setUp() throws Exception { driver =
	 * DriverFactory.getDriver(DriverNames.CHROME); loginPOM = new LoginPOM(driver);
	 * baseUrl = properties.getProperty("baseURL"); screenShot = new
	 * ScreenShot(driver); // open the browser driver.get(baseUrl); }
	 */
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(priority=0)
	public void validLoginTest() {
		loginPOM.ClickLogInLink();
		loginPOM.sendUserName("manipal");
		loginPOM.sendPassword("manipal@123");
		loginPOM.clickSigninBtn(); 
		screenShot.captureScreenShot("First");
	}

	@Test(priority=1)
	public void SelectDeleteCategory() throws InterruptedException {
		  DeleteCategorytest = new RETC_019_DeleteCategoryPOM(driver);
		  DeleteCategorytest.ClickPostsLink();
		  DeleteCategorytest.ClickCategoryLink();
		  DeleteCategorytest.SelectCategoryDelete();
		  Thread.sleep(3000);
		  DeleteCategorytest.ClickBulkActionsDrop();
		  Thread.sleep(3000);
		  DeleteCategorytest.ClickApplyButton();
		  DeleteCategorytest.GetDelConfMsg();
		  screenShot.captureScreenShot("Second");
		  }
	
	@Test(priority=2)
	public void SelectAddNewTags() throws InterruptedException {
		AddNewTagtest = new RETC_020_AddNewTagPOM(driver);
		AddNewTagtest.ClickPostsLink();
		AddNewTagtest.ClickTagsLink();
		AddNewTagtest.SendNameText();
		AddNewTagtest.SendSlugText();
		AddNewTagtest.SendDescriptionText();
		AddNewTagtest.ClickAddTagButton();
		screenShot.captureScreenShot("Third");
	  }
	
	@Test(priority=3)
	public void TagDeletion() throws InterruptedException {
		DeleteTagtest = new RETC_021_DeleteTagPOM(driver);
		DeleteTagtest.ClickPostsLink();
		DeleteTagtest.ClickTagsLink();
		DeleteTagtest.SelectTagDelete();
		DeleteTagtest.ClickBulkActionsDrop();
		DeleteTagtest.ClickApplyButton();
		DeleteTagtest.GetDelConfMsg();
		screenShot.captureScreenShot("Fourth");
		  }
}
