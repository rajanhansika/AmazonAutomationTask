package com.amazonassignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazonassignment.base.BasePage;
import com.amazonassignment.util.AmazonWebsiteConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SignInPage extends BasePage {
	

	@FindBy(xpath = AmazonWebsiteConstants.SIGN_IN_LINK)
    public WebElement signIn;
	
	
	public SignInPage(WebDriver driver, ExtentTest test)
	{
		super(driver,test);
	
	}
	
	
	
	public Object goToSignInPage()
	{
	
		
		
		test.log(LogStatus.INFO, "Clicking signIn hyperlink");
		signIn.click();
		
		//signIn- hyperlink click validation
		boolean clickSuccess = true;
		if(clickSuccess)
		{
			SignInPage signInPage = new SignInPage(driver,test);
			PageFactory.initElements(driver, signInPage);
			return signInPage;
		}
		else
		{
			LaunchPage launchPage = new LaunchPage(driver,test);
			PageFactory.initElements(driver, launchPage);
			return launchPage;
		}
	
	}
	
	

}
	
