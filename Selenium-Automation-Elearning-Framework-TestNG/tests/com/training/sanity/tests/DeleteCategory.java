package com.training.sanity.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.DeleteCategoryPOM;

public class DeleteCategory extends LoginTests{
	private WebDriver driver;
	private DeleteCategoryPOM DeleteCategory;
	private ScreenShot screenShot;
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
  @Test(priority=1)
  public void SelectDeleteCategory() throws InterruptedException {
	  //DeleteCategory = new DeleteCategoryPOM(driver);
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
}
