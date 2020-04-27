package com.amazonassignment.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.amazonassignment.pages.LaunchPage;
import com.amazonassignment.pages.SignInPage;
import com.amazonassignment.testcases.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class SignInPageTest extends BaseTest {
	
	@Test
	public void testSignInPage()
	{
	test = extent.startTest("SignInPageTest");
	test.log(LogStatus.INFO,"Starting signInPage Test");
	test.log(LogStatus.INFO,"Opening Browser");
	init("Chrome");
	
	LaunchPage launchPage = new LaunchPage(driver,test);
	PageFactory.initElements(driver,launchPage);
	
	test.log(LogStatus.PASS, "signIn-Page loaded successfully");
	
	
	
	SignInPage signInPage = (SignInPage) launchPage.goToAmazonWebsite();

	signInPage.goToSignInPage();
	
	test.log(LogStatus.INFO,"Navigating to SignIn Page");
	
   
   signInPage.takeScreenshot();
   test.log(LogStatus.PASS,"Sign In Page loaded successfully");
   test.log(LogStatus.PASS, "SignInPage Screenshot Captured");
   
   if(signInPage instanceof SignInPage)
		test.log(LogStatus.PASS, "SignIn Page Test PASSED");
	else 
		test.log(LogStatus.FAIL, "SignInIn Page Test FAILED");
		
	
}
	@AfterMethod
	public void quit()
	{
		if(extent!=null)
	{		extent.endTest(test);
		extent.flush();
	}
	if(driver!=null)
		driver.quit();
	}

}
