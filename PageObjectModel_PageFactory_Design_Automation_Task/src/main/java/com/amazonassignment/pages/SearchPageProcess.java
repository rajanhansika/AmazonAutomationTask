package com.amazonassignment.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazonassignment.base.BasePage;
import com.amazonassignment.util.AmazonWebsiteConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SearchPageProcess extends BasePage {
	
	@FindBy(xpath = AmazonWebsiteConstants.SEARCH_BOX)
	public WebElement searchBox;
	
	@FindBy(xpath = AmazonWebsiteConstants.SEARCH_ICON_CLICK)
	public WebElement searchIcon;
	
	@FindBy(xpath = AmazonWebsiteConstants.SERACH_RESULTS_SPAN)
	public WebElement searchResultsSpan;
	
	@FindBy(xpath = AmazonWebsiteConstants.ADD_TO_CART_BUTTON)
	public WebElement addToCartButton;
	
	public SearchPageProcess(WebDriver driver, ExtentTest test)
	{
		super(driver,test);
		
	
	}
	
	public Object searchResultsDisplay()
	{
		test.log(LogStatus.INFO, "Search Results display process started");
		searchBox.sendKeys(AmazonWebsiteConstants.TEXT_TO_ENTER_IN_SEARCH_BOX);
		searchIcon.click();
		takeScreenshot();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
        test.log(LogStatus.INFO, "Screenshot captured after scrolling down the list: ");
        takeScreenshot();
        
        List<WebElement> listOfElements = searchResultsSpan.findElements(By.xpath(AmazonWebsiteConstants.LIST_OF_ELEMENTS_DIAPLAYED));
        
        test.log(LogStatus.INFO, "Total elements displayed in the Search Result - " + listOfElements.size());
        
      //Random Number Generation

        Random rand = new Random();
        int rand_int = rand.nextInt(listOfElements.size());
        test.log(LogStatus.INFO,"Random number generated to click within the search result webpage:-  "+ rand_int);
        listOfElements.get(rand_int).click();
        test.log(LogStatus.INFO, "Random item clicked from the search result display");
        takeScreenshot();
		test.log(LogStatus.PASS, "Clicked item from the search Results screenshot captured");
		
		//Add to cart
		addToCartButton.click();
		
		clickOnCart();
		identifyItemsInYourCart();
		takeScreenshot();
		
		navigation();
		
		
		
		
        
       
        
   
		boolean clickSuccess = true;
		if(clickSuccess)
		{
			ProfilePage profilePage = new ProfilePage(driver,test);
			PageFactory.initElements(driver, profilePage);
			return profilePage;
		}
		return clickSuccess;
		
	}
		
		 
		

}
