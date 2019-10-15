package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RETC_081_AddMultipleNewFeaturePOM {
private WebDriver driver; 
	
	public RETC_081_AddMultipleNewFeaturePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Properties']")
	private WebElement PropertiesLink; 
	
	@FindBy(xpath="//a[text()='Features']")
	private WebElement FeaturesLink;
	
	@FindBy(id="tag-name")
	private WebElement NameTextBox;
	
	@FindBy(id="tag-slug")
	private WebElement SlugTextBox;
	
	@FindBy(id="parent")
	private WebElement ParentFeatureDropDown;
	
	@FindBy(id="tag-description")
	private WebElement DescTextBox;
	
	@FindBy(id="submit")
	private WebElement AddNewFeatureButn;
	
	@FindBy(id="tag-search-input")
	private WebElement FeatureSearchText;
	
	@FindBy(id="search-submit")
	private WebElement FeatureSearchBtn;
	
	@FindBy(xpath="//table[@class='wp-list-table widefat fixed striped tags']")
	private WebElement VerifyFeature;
	
	public void ClickPropertiesLink() {
		this.PropertiesLink.click();
	}
	
	public void ClickFeaturesLink() {
		this.FeaturesLink.click();
	}
	
	public void SendNameText() {
		this.NameTextBox.sendKeys("New Launches");
	}
	
	public void SendSlugText() {
		this.SlugTextBox.sendKeys("launch");
	}
	
	public void SelectParentFeature() {
		WebElement ParentFeaturelist= this.ParentFeatureDropDown;
		Select ParentFeatureValue=new Select(ParentFeaturelist);
		ParentFeatureValue.selectByVisibleText("Exiting Offer");
	}
	
	public void SendDescriptionText() {
		this.DescTextBox.sendKeys("New Launches of vilas, apartments, flats");
		}
	
	public void ClickAddFeatureButton() {
		this.AddNewFeatureButn.click();
	}
	
	/*
	 * public void AddedFeatureSearch(String Name) {
	 * this.FeatureSearchText.sendKeys(Name); this.FeatureSearchBtn.click(); }
	 */
	
	/*
	 * public void AssertFeatureVerification() { String actualFeature=
	 * this.VerifyFeature.getText(); String expectedFeature=;
	 * Assert.assertEquals(actualFeature,expectedFeature); }
	 */
}
