package com.amazonassignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import com.amazonassignment.base.BasePage;
import com.amazonassignment.util.AmazonWebsiteConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LaunchPage extends BasePage{
	
    
	
	public LaunchPage(WebDriver driver,ExtentTest test)
	{
		super(driver,test);
		
	
	}
	
	public Object goToAmazonWebsite()
	{
		  
		
		  test.log(LogStatus.INFO,"Opening the URL - " + AmazonWebsiteConstants.HOMEPAGE_URL);
		  driver.get(AmazonWebsiteConstants.HOMEPAGE_URL);
		  
		  
		  
		  SignInPage signInPage = new SignInPage(driver,test);
		  PageFactory.initElements(driver, signInPage);
          return signInPage;
	}

}
