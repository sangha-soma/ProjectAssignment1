package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RETC_021_DeleteTagPOM {
private WebDriver driver;
	
	public RETC_021_DeleteTagPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Posts']")
	private WebElement PostsLink; 
	
	@FindBy(xpath="(//a[text()='Tags'])[1]")
	private WebElement TagsLink; 
	
	@FindBy(id="cb-select-848")
	private WebElement SelectTag;
	
	@FindBy(id="bulk-action-selector-top")
	private WebElement BulkActionsList;
	
	@FindBy(id="doaction")
	private WebElement ApplyButton;
	
	@FindBy(id="message")
	private WebElement GetDelMsg;

	public void ClickPostsLink() {
		this.PostsLink.click();
	}
	
	public void ClickTagsLink() {
		this.TagsLink.click();
	}
	
	public void SelectTagDelete() {
		this.SelectTag.click();
	}
	
	public void ClickBulkActionsDrop() {
		this.BulkActionsList.click();
		Select sel= new Select(this.BulkActionsList);
		sel.selectByValue("delete");
	}
	
	public void ClickApplyButton() {
		this.ApplyButton.click();
	}

	public void GetDelConfMsg() {
		String actualmsg= GetDelMsg.getText();
		System.out.println(actualmsg);
		String expectedmsg=("Tags deleted.");
		Assert.assertTrue(actualmsg.contains(expectedmsg));
		//Assert.assertEquals(actualmsg,expectedmsg);
	}

}

