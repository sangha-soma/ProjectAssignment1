package com.training.sanity.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.DeleteCategoryPOM;
import com.training.pom.DeleteTagPOM;

public class DeleteTag {
	
	private WebDriver driver;
	private DeleteTagPOM DeleteTag;
	private ScreenShot screenShot;
	
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
