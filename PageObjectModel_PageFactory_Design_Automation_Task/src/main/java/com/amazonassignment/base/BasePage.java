package com.amazonassignment.base;

import java.io.File;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.amazonassignment.util.AmazonWebsiteConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage {
	
	@FindBy(xpath = AmazonWebsiteConstants.CLICK_ON_CART_ON_PROFILE_PAGE)
	public WebElement ProfilePageCartClick;
	
	@FindBy(xpath = AmazonWebsiteConstants.CLICK_ON_DELETE_ITEM)
	public WebElement DeleteItem;
	
	@FindBy(xpath = AmazonWebsiteConstants.NAVIGATION_LABEL)
	public WebElement NAVIGATION_LABEL;
	
	@FindBy(xpath = AmazonWebsiteConstants.SIGN_OUT_OPTION)
	public WebElement SIGN_OUT_LINK;
	
	public WebDriver driver;
	public ExtentTest test;
	
	
	
	public BasePage() {}
	
	public BasePage(WebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		
	
	}
	
	public void clickOnCart()
	{
		test.log(LogStatus.INFO, "Navigation to - Click on cart");
		ProfilePageCartClick.click();
		test.log(LogStatus.INFO, "Clciked on cart successfully");
			
	}
	
	public void identifyItemsInYourCart()
	{
		 
		 
		 List<WebElement> listOfElements = driver.findElements(By.xpath(AmazonWebsiteConstants.ITEMS_IN_THE_CART));
		 test.log(LogStatus.INFO, "Total items in user profile cart:- " + listOfElements.size());
		 
		 for (int i=1;i<=listOfElements.size();i++)
		 {
			    test.log(LogStatus.INFO, "Clicking on delete item hyperlink");
				DeleteItem.click();
				test.log(LogStatus.INFO,"Item deleted successfully");
				driver.findElements(By.xpath(AmazonWebsiteConstants.ITEMS_IN_THE_CART));
				
		 }
		
		
	}
	
	public void navigation()
	{
		test.log(LogStatus.INFO, "Navigation to - Signout Option");
		Actions action = new Actions(driver);
		WebElement element = NAVIGATION_LABEL;
		action.moveToElement(element).build().perform();
		test.log(LogStatus.INFO, "Navigation to - Signout Option successful");
		takeScreenshot();
		test.log(LogStatus.INFO, "Clcik on signout link");
		SIGN_OUT_LINK.click();
		
		
		
	}
	
	
	
	

	
	
	public boolean isElementPresent(String locator)
	
	
	{
		
		test.log(LogStatus.INFO,"Trying to find the element: "+locator);
		int s = driver.findElements(By.xpath(locator)).size();
		
		if(s==0)
		{
			test.log(LogStatus.INFO,"Element not found");
			return false;
			
		}
		else
		{
			
			   test.log(LogStatus.INFO,"Element found");
			   String text = driver.findElement(By.xpath(locator)).getText();
			   test.log(LogStatus.INFO,"Element found : " + text);
		       return true;
			
		}
		
	}
	
	public void takeScreenshot()
	{
		Date d = new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		String filePath = System.getProperty("user.dir")+AmazonWebsiteConstants.REPORTS_PATH+ "Screenshots//"+screenshotFile;
		
		
		// store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
				
				try {
					FileUtils.copyFile(scrFile, new File(filePath));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				test.log(LogStatus.INFO,test.addScreenCapture(filePath));
	 }
		
	}


