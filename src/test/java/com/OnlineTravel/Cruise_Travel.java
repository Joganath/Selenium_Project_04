package com.OnlineTravel;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page_Objects.Home_Page;

public class Cruise_Travel extends com.OnlineTravel.Driver {

	
	private static  Logger log = LogManager.getLogger(Cruise_Travel.class.getName());
	
	@BeforeTest
	public void Opening_Page() throws IOException  
	{
	   driver = initializeDriver();
	   log.info("Driver is initialized");
	   driver.get(Prop.getProperty("Url"));
	   log.error("Webpage is launched");
	   driver.manage().window().maximize();
	   
	   
	   
	}
	
	@AfterTest
	public void Closing_Browser()
	{
		driver.close();
		driver= null;
		
	}


@Test
public void Cruise_Travel()
{
	Home_Page HP = new Home_Page(driver);
	HP.Cruise_Travel().click();
	Wait = Add_Wait();
	Wait.until(ExpectedConditions.elementToBeClickable(HP.River_Selector()));
	Wait.until(ExpectedConditions.elementToBeClickable(HP.Singapore_Malaysia_Cruise()));
	String Heading = HP.Main_Heading().getText();
	Assert.assertEquals(Heading, "Cruise Offline Booking");
    
	
}

@Test(dependsOnMethods= {"Cruise_Travel"})
public void Singapore_malaysia() throws InterruptedException
{
	Thread.sleep(2000);
	Home_Page HP = new Home_Page(driver);
	Action=Add_Action();
	Action.click(HP.Singapore_Malaysia_Cruise()).perform();
	
	Thread.sleep(3000);
	System.out.println(HP.Singapore_Cruise_Page().getText().substring(0, 31));
	System.out.println(HP.Singapore_Cruise_Price().getText());
	if (HP.Singapore_Cruise_Page().getText().substring(0, 31).equalsIgnoreCase("Singapore Malaysia Dream Cruise"))
	{
		Integer Amount = Integer.valueOf(HP.Singapore_Cruise_Price().getText().replaceAll(",","").replaceAll("Rs.",""));
		System.out.println(Amount);
		int Amnt=(Integer)Amount;
		
		Assert.assertEquals(Amnt, 21000);
	    log.info("PLease check the Price");
	}
	else
	{
		System.out.println("Wrong Page Selected");
	}

}


}
