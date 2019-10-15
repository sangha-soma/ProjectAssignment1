package com.training.sanity.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_020_AddNewTagPOM;
import com.training.pom.RETC_019_DeleteCategoryPOM;

public class RETC_020_AddNewTag extends LoginTests {
	
	private RETC_020_AddNewTagPOM AddNewTagtest;
	public ScreenShot screenShot;
  
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
  }

