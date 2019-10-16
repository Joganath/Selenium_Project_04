package com.OnlineTravel;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import java.util.Date;

public class Driver {

	public static WebDriver  driver;
	public Properties Prop=null;
	public Actions Action = null;
	public WebDriverWait Wait = null;  
	public FluentWait FW_Wait=null;
	
	
	
    public WebDriver initializeDriver() throws IOException
    {
    	FileInputStream fis = new FileInputStream("D:\\Selenium_Automation\\WebUIAutomation\\Conf_Details.properties");
    	Prop = new Properties();
    	Prop.load(fis);
    	System.out.println(Prop.getProperty("Browser")+" Is Running");
    	
    	if (Prop.getProperty("Browser").equalsIgnoreCase("Firefox"))
    			{
    		     System.setProperty("webdriver.gecko.driver","D:\\Selenium_Downloads\\geckodriver.exe");
    		     FirefoxOptions Option = new FirefoxOptions();
    		     Option.addPreference("dom.webnotificatinos.enabled",false);
    		     driver = new FirefoxDriver(Option);
    		     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    		     System.out.println("Browser Is Firefox");
    		     
    			}
    	else if (Prop.getProperty("Browser").equalsIgnoreCase("InternetExplorer"))
    	{
    		    System.setProperty("webdriver.ie.driver","D:\\Selenium_Downloads\\IEDriverServer");
    		    driver = new InternetExplorerDriver();
    		    
    	}
    	
    	else if(Prop.getProperty("Browser").equalsIgnoreCase("Chrome"))
    	{
    		System.setProperty("webdriver.chrome.driver","D:\\Chrome_Driver\\Chromedriver.exe");
		    ChromeOptions Option = new ChromeOptions();
		    Option.addArguments("disable-infobars");
    		driver = new ChromeDriver(Option);
		    System.out.println("Browser Is Chrome");
		    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    	}
    	return driver;
    }


    public WebDriverWait Add_Wait()
    {
    	Wait = new WebDriverWait(driver,20);
    	return Wait;
    }

    public Actions Add_Action()
    {
    	Action = new Actions(driver);
    	return Action;
    	
    }

  public void getScreenshot(String result) throws IOException
  {
	//driver=initializeDriver();
	  if (driver.equals(null))
	{
		System.out.println("Driver is null");
	}
	else
	{
			System.out.println("Driver is not null");
	}
	  Date Dt = new Date();
	  SimpleDateFormat Formatter = new SimpleDateFormat("yyyy-MM-dd hh_mm_ss");
	  String StrDT= Formatter.format(Dt);
	  
	  
	  System.out.println("Today is"+StrDT);
	  
	  File Scrn = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(Scrn,new File("D:\\Selenium_Automation\\Screenshots\\"+result+StrDT+".jpeg"));
    
  }

}
