package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RETC_051_BlogPostPOM {
private WebDriver driver; 
	
	public RETC_051_BlogPostPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
}
	@FindBy(id="menu-item-617")
	//@FindBy(linkText="Blog")
	private WebElement BlogLink;

	@FindBy(xpath="(//a[@class='read-more'])[2]")
	private WebElement ReadMoreLink;
	
	@FindBy(name="comment")
	private WebElement PostComment;
	
	@FindBy(id="author")
	private WebElement AddName;
	
	@FindBy(id="email")
	private WebElement AddEmail;
	
	@FindBy(id="submit")
	private WebElement SubmitPost;
	
	@FindBy(xpath="//div[text()='Dashboard']")
	private WebElement DashboardLink; 
	
	@FindBy(xpath="//ul[@id='the-comment-list']/li[1]")
	private WebElement MouseOpRecentComments;

	@FindBy(xpath="(//a[text()='Reply'])[1]")
	private WebElement ReplyRecentCommentsLink;
	
	@FindBy(id="replycontent")
	private WebElement SubmitReplyToComment;
	
	@FindBy(id="replybtn")
	private WebElement SubmitComment;
	
	@FindBy(xpath="(//div[@class=\"dashboard-comment-wrap has-row-actions\"])[1]")
	private WebElement VerifyComment;
	
	public void ClickBlogLink() throws AWTException, InterruptedException {
		this.BlogLink.click();
		Robot robot = new Robot(); 
	    robot.keyPress(KeyEvent.VK_PAGE_DOWN); 
	    Thread.sleep(3000);
	    robot.keyPress(KeyEvent.VK_PAGE_DOWN); 
	    Thread.sleep(3000);
	}
	
	public void ClickReadMoreLink() {
		this.ReadMoreLink.click();
	}
	
	public void SendPostComment() throws InterruptedException, AWTException {
		Robot robot = new Robot(); 
	    robot.keyPress(KeyEvent.VK_PAGE_DOWN); 
	    Thread.sleep(3000);
	    robot.keyPress(KeyEvent.VK_PAGE_DOWN); 
	    Thread.sleep(3000);
		this.PostComment.sendKeys("Beautiful");
		Thread.sleep(3000);
	}
	
	public void EnterNameTextBox() {
		this.AddName.sendKeys("ManipalTesting");
	}
	
	public void EnterEmailTextBox() {
		this.AddEmail.sendKeys("ManipalTesting@gmail.com");
	}
	
	public void SubmitBlogPost() {
		this.SubmitPost.click();
		}
	
	public void ClickDashboardLink() {
		this.DashboardLink.click();
	}
	
	public void MouseOverRecentComment() throws InterruptedException {
		WebElement RecentCommentTitle=this.MouseOpRecentComments;
		Actions act= new Actions(driver);
	    act.moveToElement(RecentCommentTitle).build().perform();
	    Thread.sleep(3000);
	    this.ReplyRecentCommentsLink.click();
	}
	
	public void SendReplyCommentText() {
		this.SubmitReplyToComment.sendKeys("Thank You!");
		//String expectedCommentReply = this.SubmitReplyToComment.getText();
	}
	
	public void ClickReplyButton() {
		this.SubmitComment.click();
	}
	
	public void AssertReplyVerification() {
		String actualCommentReply= this.VerifyComment.getText();
		String expectedCommentReply=("Thank You");
		Assert.assertEquals(actualCommentReply,expectedCommentReply);
	}
}
