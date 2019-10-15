package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RETC_020_AddNewTagPOM {
	private WebDriver driver;
	
	public RETC_020_AddNewTagPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Posts']")
	private WebElement PostsLink; 
	
	@FindBy(xpath="(//a[text()='Tags'])[1]")
	private WebElement TagsLink; 
	
	@FindBy(id="tag-name")
	private WebElement NameTextBox;
	
	@FindBy(id="tag-slug")
	private WebElement SlugTextBox;
	
	@FindBy(id="tag-description")
	private WebElement DescTextBox;
	
	@FindBy(id="submit")
	private WebElement AddTagButn;
	
	@FindBy(xpath="//table[@class='wp-list-table widefat fixed striped tags']")
	private WebElement VerifyTag;
	
	public void ClickPostsLink() {
		this.PostsLink.click();
	}
	
	public void ClickTagsLink() {
		this.TagsLink.click();
	}
	
	public void SendNameText() {
		this.NameTextBox.sendKeys("New Launches");
	}
	
	public void SendSlugText() {
		this.SlugTextBox.sendKeys("launch");
	}
	
	public void SendDescriptionText() {
		this.DescTextBox.sendKeys("New Launches of vilas, apartments, flats");
	}
	
	public void ClickAddTagButton() {
		this.AddTagButn.click();
	}
	
	public void AssertTagVerification() {
		String actualTag= this.VerifyTag.getText();
		this.VerifyTag.isDisplayed();
		String expectedTag=("New Launches");
		Assert.assertEquals(actualTag,expectedTag);
	}
}
