package com.amazonassignment.testcases.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.amazonassignment.util.AmazonWebsiteConstants;
import com.amazonassignment.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {
	
	public WebDriver driver;
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;

	
	public void init(String bType)
	{
		
		
		        test.log(LogStatus.INFO, "Opening browser:- "+bType);
			    if(bType.equals("Mozilla"))
			    {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+AmazonWebsiteConstants.FIREFOX_DRIVER_EXE);
			    driver = new FirefoxDriver();
			    }
			    else if(bType.equals("Chrome"))
			    {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+AmazonWebsiteConstants.CHROME_DRIVER_EXE);
			    driver = new ChromeDriver();
			    }
			    else if(bType.equals("IE"))
			    {
			    System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+AmazonWebsiteConstants.IE_DRIVER_EXE);
			    driver = new InternetExplorerDriver();
			    }
			    else if(bType.equals("MicrosoftEdge"))
			    {
			    System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+AmazonWebsiteConstants.EDGE_DRIVER_EXE);
			    driver = new EdgeDriver();
			    }
			
		        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		        driver.manage().window().maximize();
		        test.log(LogStatus.INFO, "Opened browser successfully:- "+bType);
     }

}
