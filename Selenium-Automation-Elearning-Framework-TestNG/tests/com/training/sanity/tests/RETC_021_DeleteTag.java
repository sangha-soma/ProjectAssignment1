package com.training.sanity.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_019_DeleteCategoryPOM;
import com.training.pom.RETC_021_DeleteTagPOM;

public class RETC_021_DeleteTag extends RETC_020_AddNewTag{
	
	private RETC_021_DeleteTagPOM DeleteTagtest;
	private ScreenShot screenShot;
	
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
