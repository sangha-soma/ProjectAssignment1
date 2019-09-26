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
import com.training.pom.AddNewTagPOM;
import com.training.pom.DeleteCategoryPOM;
import com.training.pom.DeleteTagPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginNAddDeleteCategoryNTag {

	public WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private DeleteCategoryPOM DeleteCategory;
	private AddNewTagPOM AddNewTag;
	private DeleteTagPOM DeleteTag;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
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
		  DeleteCategory = new DeleteCategoryPOM(driver);
		  DeleteCategory.ClickPostsLink();
		  DeleteCategory.ClickCategoryLink();
		  DeleteCategory.SelectCategoryDelete();
		  Thread.sleep(3000);
		  DeleteCategory.ClickBulkActionsDrop();
		  Thread.sleep(3000);
		  DeleteCategory.ClickApplyButton();
		  DeleteCategory.GetDelConfMsg();
		  screenShot.captureScreenShot("Second");
		  }
	
	@Test(priority=2)
	public void SelectAddNewTags() throws InterruptedException {
		AddNewTag = new AddNewTagPOM(driver);
		AddNewTag.ClickPostsLink();
		AddNewTag.ClickTagsLink();
		AddNewTag.SendNameText();
		AddNewTag.SendSlugText();
		AddNewTag.SendDescriptionText();
		AddNewTag.ClickAddTagButton();
		screenShot.captureScreenShot("Third");
	  }
	
	@Test(priority=3)
	public void TagDeletion() throws InterruptedException {
		DeleteTag = new DeleteTagPOM(driver);
		DeleteTag.ClickPostsLink();
		DeleteTag.ClickTagsLink();
		DeleteTag.SelectTagDelete();
		DeleteTag.ClickBulkActionsDrop();
		DeleteTag.ClickApplyButton();
		DeleteTag.GetDelConfMsg();
		screenShot.captureScreenShot("Fourth");
		  }
}
