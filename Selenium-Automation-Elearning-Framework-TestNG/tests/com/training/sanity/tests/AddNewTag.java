package com.training.sanity.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddNewTagPOM;
import com.training.pom.DeleteCategoryPOM;

public class AddNewTag extends DeleteCategory {
	
	private AddNewTagPOM AddNewTag;
	private ScreenShot screenShot;
  
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
  }

