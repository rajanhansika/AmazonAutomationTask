package com.amazonassignment.testcases;



import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.amazonassignment.pages.LaunchPage;
import com.amazonassignment.testcases.base.BaseTest;
import com.amazonassignment.util.AmazonWebsiteConstants;
import com.relevantcodes.extentreports.LogStatus;

public class LaunchPageTest extends BaseTest {
	@Test
	public void testLaunchPage()
	{
	test = extent.startTest("LaunchPageTest");
	test.log(LogStatus.INFO,"Starting LaunchPage Test");
	test.log(LogStatus.INFO,"Opening Browser");
	init("Chrome");
	
	
	LaunchPage launchPage = new LaunchPage(driver,test);
	PageFactory.initElements(driver,launchPage);

	
	launchPage.goToAmazonWebsite();
	test.log(LogStatus.INFO,"Navigating to Amazon Ecommerce Website");
	test.log(LogStatus.PASS,"Navigation to the URL -Successful - " + AmazonWebsiteConstants.HOMEPAGE_URL);
	
	launchPage.takeScreenshot();
	test.log(LogStatus.PASS,"LaunchPage screenshot captured");
	
	if(launchPage instanceof LaunchPage)
		test.log(LogStatus.PASS, "Launch Page Test PASSED");
	else 
		test.log(LogStatus.FAIL, "Launch Page Test FAILED");
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


