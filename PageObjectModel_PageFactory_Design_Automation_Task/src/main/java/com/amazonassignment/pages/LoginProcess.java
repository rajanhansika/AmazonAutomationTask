package com.amazonassignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazonassignment.base.BasePage;
import com.amazonassignment.util.AmazonWebsiteConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginProcess extends BasePage

  {
	
       //In PageFactory we can make use of annotations which are available in 'PajeObjectModelPagefactory'
		
		@FindBy(xpath = AmazonWebsiteConstants.LOGIN_USERNAME)
		public WebElement email;
		
		@FindBy(xpath = AmazonWebsiteConstants.CONTINUE_TAB)
		public WebElement continueTab;
		
		@FindBy(xpath = AmazonWebsiteConstants.LOGIN_PASSWORD)
		public WebElement password;
		
		@FindBy(xpath = AmazonWebsiteConstants.SIGN_IN_SUBMIT )
		public WebElement signInSubmit;
		
			
		public LoginProcess(WebDriver driver, ExtentTest test)
		{
			super(driver,test);
			
		
		}
		
		//Object - SuperClass
		
		public Object doLogin(String usName, String pWord)
		{
			test.log(LogStatus.INFO, "Logging in to amazon website with " +usName+ "/" +pWord);
			email.sendKeys(usName);
			takeScreenshot();
		    continueTab.click();
		    takeScreenshot();
	        password.sendKeys(pWord);
	        signInSubmit.click();
	        
	   
	        boolean loginSuccess = isElementPresent(AmazonWebsiteConstants.TOP_MENU_LINK);
	        boolean loginFailure = isElementPresent(AmazonWebsiteConstants.FAILED_AUNTHENTICATION);
			
		
			
			 
			
			if (loginSuccess)
			{   
				
				test.log(LogStatus.INFO, "Logging successful");
				ProfilePage profilePage = new ProfilePage(driver,test);
				PageFactory.initElements(driver, profilePage);
				test.log(LogStatus.INFO, "Profile Page screenshot captured");
				return profilePage;
			}
			
			
			   
			else if (loginFailure) 
				
			{
				test.log(LogStatus.INFO, "Logging not successful");
				SignInPage loginPage = new SignInPage(driver,test);
				PageFactory.initElements(driver, loginPage);
				test.log(LogStatus.FAIL, "Login Process Failed");
				return loginPage;
				
			}
	        return loginFailure;
	
		}
		
  }	
		
		
	



