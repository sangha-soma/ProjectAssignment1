package com.training.sanity.tests;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_080_AddPropertyPOM;

public class RETC_080_AddProperty extends LoginTests {
	
	private RETC_080_AddPropertyPOM AddPropertyTest;
	private ScreenShot screenShot;
	
  @Test(priority=1)
  public void addProperty() throws AWTException, InterruptedException {
	  AddPropertyTest= new RETC_080_AddPropertyPOM(driver);
	  AddPropertyTest.ClickPropertiesLink();
	  AddPropertyTest.ClickAddNewPropertiesLink();
	  AddPropertyTest.sendPropertyTitle();
	  AddPropertyTest.sendPropertyDesc();
	  AddPropertyTest.EnterPrice();
	  AddPropertyTest.EnterPricePerSqFt();
	  AddPropertyTest.ClickMainDetailsLink();
	  AddPropertyTest.EnterStatus();
	  AddPropertyTest.EnterLocation();
	  AddPropertyTest.EnterPossession();
	  AddPropertyTest.ClickLocationTab();
	  AddPropertyTest.EnterAddress();
	  AddPropertyTest.EnterGoogleMapAddress();
	  AddPropertyTest.EnterLatitude();
	  AddPropertyTest.EnterLongitude();
	  AddPropertyTest.ClickDetailsTab();
	  AddPropertyTest.EnterStorageRoom();
	  AddPropertyTest.SelectKeywordCheckBox();
	  AddPropertyTest.SelectFeaturesCheckBox();
	  AddPropertyTest.SelectRegionsCheckBox();
	  AddPropertyTest.ClickPublishButton();
	  AddPropertyTest.AssertAddedPropertyVerification();
	  AddPropertyTest.MouseOverLogOutButtonClick();
	  AddPropertyTest.ClickRealEstateLink();
	  AddPropertyTest.SendRealEstateSearch();
  }
}
