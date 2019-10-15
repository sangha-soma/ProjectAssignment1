package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_049_DeletePropertyPOM;

public class RETC_049_DeleteProperty extends LoginTests {
	
	private RETC_049_DeletePropertyPOM DeletePropertytest;
	private ScreenShot screenShot;
	
  @Test(priority=1)
  public void DeletePropertyTrash() throws InterruptedException {
	  DeletePropertytest = new RETC_049_DeletePropertyPOM(driver);
	  DeletePropertytest.ClickPropertiesLink();
	  DeletePropertytest.ClickAllPropertiesLink();
	  DeletePropertytest.MouseOverPropertyLink();
	  DeletePropertytest.ClickTrashTab();
	  DeletePropertytest.MouseOverTrashPropertyLink();
	  DeletePropertytest.AssertDelPropertyVerification();
	  //screenShot.captureScreenShot("Second");
  }
}
