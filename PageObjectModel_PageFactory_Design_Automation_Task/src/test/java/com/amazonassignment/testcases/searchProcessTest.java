package com.amazonassignment.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.amazonassignment.pages.LaunchPage;
import com.amazonassignment.pages.LoginProcess;
import com.amazonassignment.pages.SearchPageProcess;
import com.amazonassignment.pages.SignInPage;
import com.amazonassignment.testcases.base.BaseTest;
import com.amazonassignment.util.AmazonWebsiteConstants;
import com.relevantcodes.extentreports.LogStatus;


public class searchProcessTest extends BaseTest{
	
	@Test
	public void searcResults()
	{
		
		test = extent.startTest("SearchProcess Test");
		test.log(LogStatus.INFO, "Starting SearchProcess Test");
		test.log(LogStatus.INFO, "Openeing Browser");
		
		init("Chrome");
		
		LaunchPage launchPage = new LaunchPage(driver,test);
		PageFactory.initElements(driver, launchPage);
		
		launchPage.goToAmazonWebsite();
		
		SignInPage signInPage = new SignInPage(driver,test);
		PageFactory.initElements(driver, signInPage);
		
		signInPage.goToSignInPage();
		
		LoginProcess loginProcess = new LoginProcess(driver,test);
		PageFactory.initElements(driver, loginProcess);
		
	    test.log(LogStatus.INFO, "Logging in with valid user credentials");
		
		loginProcess.doLogin(AmazonWebsiteConstants.usName, AmazonWebsiteConstants.pWord);
		
		SearchPageProcess searchPageProcess = new SearchPageProcess(driver,test);
		PageFactory.initElements(driver, searchPageProcess);
		
		searchPageProcess.searchResultsDisplay();
		
		
		searchPageProcess.takeScreenshot();
		test.log(LogStatus.PASS, "SearchProcess and Logout of User account - Success and Test Passed");
		
		
		
	
	 
			
		
		
		
		
	}
		
		@AfterMethod
		public void quit()
		{
			if(extent!=null)
			{
				extent.endTest(test);
				extent.flush();
			}
			if(driver!=null)
				driver.quit();
		}
		

}
