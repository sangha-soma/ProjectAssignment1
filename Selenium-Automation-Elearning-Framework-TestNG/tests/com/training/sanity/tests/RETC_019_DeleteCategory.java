package com.training.sanity.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_019_DeleteCategoryPOM;

public class RETC_019_DeleteCategory extends LoginTests{
	private RETC_019_DeleteCategoryPOM DeleteCategorytest;
	private ScreenShot screenShot;
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
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
}
