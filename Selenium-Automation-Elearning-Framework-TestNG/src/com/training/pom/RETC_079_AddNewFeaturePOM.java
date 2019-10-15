package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RETC_079_AddNewFeaturePOM {
private WebDriver driver; 
	
	public RETC_079_AddNewFeaturePOM(WebDriver driver) {
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
	
	public void SendNameText(String Name) {
		this.NameTextBox.sendKeys(Name);
	//public void SendNameText() {
		//this.NameTextBox.sendKeys("Brigade");
	}
	
	public void SendSlugText(String Slug) {
		this.SlugTextBox.sendKeys(Slug);
	//public void SendSlugText() {
		//this.SlugTextBox.sendKeys("launch");
	}
	
	public void SelectParentFeature(String ParentFeature) {
	//public void SelectParentFeature() {
		WebElement ParentFeaturelist= this.ParentFeatureDropDown;
		Select ParentFeatureValue=new Select(ParentFeaturelist);
		ParentFeatureValue.selectByVisibleText(ParentFeature);
		//ParentFeatureValue.selectByVisibleText("Exiting Offer");
	}
	
	public void SendDescriptionText(String Description) {
	//public void SendDescriptionText() {
		//this.DescTextBox.sendKeys("New flats for sale");
		this.DescTextBox.sendKeys(Description);
	}
	
	public void ClickAddFeatureButton() {
		this.AddNewFeatureButn.click();
	}
	
	public void AddedFeatureSearch(String Name) {
		this.FeatureSearchText.sendKeys(Name);
		this.FeatureSearchBtn.click();
		}
	
	/*
	 * public void AssertFeatureVerification() { String actualFeature=
	 * this.VerifyFeature.getText(); String expectedFeature=;
	 * Assert.assertEquals(actualFeature,expectedFeature); }
	 */
	}
