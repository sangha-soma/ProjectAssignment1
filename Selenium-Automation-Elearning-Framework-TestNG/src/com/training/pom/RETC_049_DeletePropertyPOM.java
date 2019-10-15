package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RETC_049_DeletePropertyPOM {
private WebDriver driver; 
	
	public RETC_049_DeletePropertyPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Properties']")
	private WebElement PropertiesLink; 
	
	@FindBy(xpath="(//a[text()='All Properties'])[1]")
	private WebElement AllPropertiesLink;

	@FindBy(xpath="(//a[text()='PRESTIGE'])[1]")
	private WebElement MouseOpProperty;

	@FindBy(xpath="(//a[text()='Trash'])[1]")
	private WebElement IndvPropertyTrash;
	
	@FindBy(xpath="(//a[text()='Trash '])")
	private WebElement PropertyTrashTab;
	
	@FindBy(xpath="//tbody[@id='the-list']/tr[1]/td[1]")
	private WebElement MouseOpTrashProperty;

	@FindBy(xpath="(//a[@class='submitdelete'])[1]")
	//@FindBy(xpath="(//div//span//a[text()='Delete Permanently'])[1]")
	private WebElement DeletePermanentlyLink;
	
	@FindBy(xpath="//div[@id='message']")
	private WebElement VerifyDeleteConf;
	
	public void ClickPropertiesLink() {
		this.PropertiesLink.click();
	}
	
	public void ClickAllPropertiesLink() {
		this.AllPropertiesLink.click();
	}
	
	public void MouseOverPropertyLink() throws InterruptedException {
		WebElement propertyTitle=this.MouseOpProperty;
		Actions act= new Actions(driver);
	    act.moveToElement(propertyTitle).build().perform();
	    Thread.sleep(3000);
	    this.IndvPropertyTrash.click();
	    }
	
	public void ClickTrashTab() {
		this.PropertyTrashTab.click();
	}
	
	public void MouseOverTrashPropertyLink() throws InterruptedException {
		WebElement TrashpropertyTitle=this.MouseOpTrashProperty;
		Actions act= new Actions(driver);
	    act.moveToElement(TrashpropertyTitle).build().perform();
	    Thread.sleep(3000);
	    this.DeletePermanentlyLink.click();
	    }
	
	public void AssertDelPropertyVerification() {
		System.out.println(this.VerifyDeleteConf.getText());
		String actualTag= this.VerifyDeleteConf.getText();
		this.VerifyDeleteConf.isDisplayed();
		String expectedTag=("1 post permanently deleted.");
		Assert.assertTrue(actualTag.contains(expectedTag));
	}
}
