package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RETC_080_AddPropertyPOM {
private WebDriver driver; 
	
	public RETC_080_AddPropertyPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Properties']")
	private WebElement PropertiesLink;
	
	@FindBy(xpath="//a[@class='page-title-action' and text()='Add New']")
	private WebElement AddNewPropertiesLink;
	
	@FindBy(name="post_title")
	private WebElement PropertiesTitle; 
	
	@FindBy(xpath="(//body[@id='tinymce'])[1]")
	private WebElement PropertiesDescText;
	
	@FindBy(id="_price")
	private WebElement PriceBox; 
	
	@FindBy(id="_price_per")
	private WebElement PricePerSqFtBox; 
	
	@FindBy(xpath="//a[contains(text(),'Main Details')]")
	//@FindBy(xpath="//a[contains(text(),'Main Details') and @id= 'ui-id-2']")
	private WebElement MainDetailsTabLink;
	
	@FindBy(id="_status")
	private WebElement StatusTextBox; 
	
	@FindBy(id="_location")
	private WebElement LocationTextBox; 
	
	@FindBy(id="_possession")
	private WebElement PossessionTextBox; 
	
	@FindBy(xpath="//a[contains(text(),'Location')]")
	//@FindBy(xpath="//a[contains(text(),'Location') and @id= 'ui-id-3']")
	private WebElement LocationTabLink;
	
	@FindBy(id="_friendly_address")
	private WebElement AddressTextBox; 
	
	@FindBy(id="_address")
	private WebElement GoogleAddressMapTextBox; 
	
	@FindBy(id="_geolocation_lat")
	private WebElement LatitudeTextBox; 
	
	@FindBy(id="_geolocation_long")
	private WebElement LongitudeTextBox; 
	
	@FindBy(xpath="//a[text()='Details']")
	//@FindBy(xpath="//a[text()='Details' and @id= 'ui-id-4']")
	private WebElement DetailsTabLink;
	
	@FindBy(id="_storage_room")
	private WebElement StorageRoomTextBox; 
	
	@FindBy(xpath="(//span[text()='Central Bangalore'])[1]")
	private WebElement KeywordCheckBox;
	
	@FindBy(id="in-property_feature-431")
	private WebElement FeaturesCheckBox;
	
	@FindBy(xpath="(//li//label[text()=' Central Bangalore'])[1]")
	private WebElement RegionsCheckBox;
	
	@FindBy(id="publish")
	private WebElement PublishButton;
	
	@FindBy(xpath="//p[contains(text(),'Post published. ')]")
	private WebElement VerifyAddedPropertyConf;
	
	@FindBy(xpath="//img[@class='avatar avatar-26 photo']")
	private WebElement UserLogInImg;
	
	@FindBy(xpath="//li[@id='wp-admin-bar-logout']")
	private WebElement LogOutButtonClick;
	
	@FindBy(xpath="//a[text()='Real Estate']")
	private WebElement RealEstateLink;
	
	@FindBy(xpath="(//input[@name='phrase'])[1]")
	private WebElement RealEstateSearchTextBox;
	
	public void ClickPropertiesLink() {
		this.PropertiesLink.click();
	}
	
	public void ClickAddNewPropertiesLink() {
		this.AddNewPropertiesLink.click();
	}
	
	public void sendPropertyTitle() {
		this.PropertiesTitle.clear(); 
		this.PropertiesTitle.sendKeys("new launch"); 
		driver.switchTo().frame("content_ifr");
	}
	
	public void sendPropertyDesc() {
		this.PropertiesDescText.clear(); 
		this.PropertiesDescText.sendKeys("new launch"); 
		driver.switchTo().defaultContent();
	}
	
	public void EnterPrice() {
		this.PriceBox.clear(); 
		this.PriceBox.sendKeys("50000"); 
	}
	
	public void EnterPricePerSqFt() {
		this.PricePerSqFtBox.clear(); 
		this.PricePerSqFtBox.sendKeys("200"); 
	}
	public void ClickMainDetailsLink() {
		this.MainDetailsTabLink.click();
	}
	
	public void EnterStatus() {
		this.StatusTextBox.sendKeys("New"); 
	}
	
	public void EnterLocation() {
		this.LocationTextBox.sendKeys("Electronic city"); 
	}
	
	public void EnterPossession() {
		this.PossessionTextBox.sendKeys("immediate"); 
	}
	
	public void ClickLocationTab() {
		this.LocationTabLink.click();
	}
	
	public void EnterAddress() {
		this.AddressTextBox.sendKeys("yeshwanthapur"); 
	}
	
	public void EnterGoogleMapAddress() {
		this.GoogleAddressMapTextBox.sendKeys("yeshwanthapur"); 
	}
	
	public void EnterLatitude() {
		this.LatitudeTextBox.sendKeys("120"); 
	}
	
	public void EnterLongitude() {
		this.LongitudeTextBox.sendKeys("56"); 
	}
	
	public void ClickDetailsTab() {
		this.DetailsTabLink.click();
	}
	
	public void EnterStorageRoom() {
		this.StorageRoomTextBox.sendKeys("2");
	}
	
	public void SelectKeywordCheckBox() throws AWTException, InterruptedException {
		Robot robot = new Robot(); // TO SCROLL DOWN
		robot.keyPress(KeyEvent.VK_PAGE_DOWN); // TO SCROLL DOWN
		robot.keyPress(KeyEvent.VK_PAGE_DOWN); // TO SCROLL DOWN
		Thread.sleep(4000);
		this.KeywordCheckBox.click();
		robot.keyPress(KeyEvent.VK_PAGE_UP); // TO SCROLL UP
		robot.keyPress(KeyEvent.VK_PAGE_UP); // TO SCROLL UP
		
	}
	
	public void SelectFeaturesCheckBox() {
		this.FeaturesCheckBox.click();
	}
	
	public void SelectRegionsCheckBox() {
		this.RegionsCheckBox.click();
	}
	
	public void ClickPublishButton() {
		this.PublishButton.click();
	}
	
	public void AssertAddedPropertyVerification() {
		System.out.println(this.VerifyAddedPropertyConf.getText());
		//String actualTag= this.VerifyAddedPropertyConf.getText();
		this.VerifyAddedPropertyConf.isDisplayed();
		//String expectedTag=("Post published. ");
		//Assert.assertTrue(actualTag.contains(expectedTag));
	}
	
	public void MouseOverLogOutButtonClick() throws InterruptedException {
		Actions act = new Actions(driver); 
		act.moveToElement(UserLogInImg).build().perform();
		Thread.sleep(3000);
		act.moveToElement(LogOutButtonClick).click().build().perform(); 		
	}
	
	public void ClickRealEstateLink() {
		this.RealEstateLink.click();
	}
	
	public void SendRealEstateSearch() {
		this.RealEstateSearchTextBox.sendKeys("new launch"); 
		}
}