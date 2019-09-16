package com.OnlineTravel;

import java.awt.Window;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page_Objects.Home_Page;

public class Yatra_Auomation_01 extends com.OnlineTravel.Driver
{
    
    	
     
   
	
	@BeforeTest
	public void Opening_Page() throws IOException
	{
	 System.out.println("Before Test is running");
	 driver = initializeDriver();
	 
	 driver.get(Prop.getProperty("Url"));
	 driver.manage().window().maximize();
			 
	}
	
	@AfterTest
	public void Browser_Close()
	{
		driver.close();
		driver =null;
	}
	
	@Test
	public void Flight_Count() throws IOException, InterruptedException
	{
		
		Home_Page HP = new Home_Page(driver);
		HP.Flight_Click().click();
		HP.Origin_Selector().click();
		Wait = Add_Wait();
		
		HP.Origin_Selector().sendKeys("BLR");
	    Wait.until(ExpectedConditions.textToBePresentInElement(HP.Airport_Validation(), "Kempegowda International"));
		//Thread.sleep(3000);
		Action = Add_Action();
		Action.sendKeys(Keys.ENTER).perform();
		
		HP.Destination_Selector().click();
		Thread.sleep(2000);
		HP.Destination_Selector().sendKeys("BBI");
		Wait.until(ExpectedConditions.textToBePresentInElement(HP.Airport_Validation(), "Biju Patnaik"));
		
		
		//Thread.sleep(3000);
		Action.sendKeys(Keys.ENTER).perform();
		HP.Depart_Date_Selector().click();
		HP.Departure_Date_Selector().click();
		Thread.sleep(2000);
		HP.Traveller_Selector().click();
		int Passenger = Integer.valueOf(Prop.getProperty("No_Of_Traveller"));
		Wait.until(ExpectedConditions.textToBePresentInElement(HP.Traveller_Count_validate(), String.valueOf(1)));
		System.out.println(Passenger);
		//Thread.sleep(5000);
		for (int i=1;i<=Passenger-1;i++)
		{
			System.out.println(HP.No_OF_Traveller().isEnabled());
			
			HP.No_OF_Traveller().click();
			Wait.until(ExpectedConditions.textToBePresentInElement(HP.Traveller_Count_validate(), String.valueOf(i+1)));
			
			}
		
		HP.Submit().click();
		//WebElement Book_Now = driver.findElement(By.cssSelector("span[class='ecash-txt fs-11']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*")));
		
		
		
		//js.executeScript("history.go(0)");
		Thread.sleep(5000);
		int ht0=0;
		while (!(js.executeScript("return document.body.scrollHeight").equals(0)))
		{
			
		 js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		 
		 
		 int ht1 = Integer.parseInt(js.executeScript("return document.body.scrollHeight").toString());
		 if (ht0==ht1)
		 {
			 break;
		 }
		 ht0=ht1;
		 
		}
		int N = driver.findElements(By.xpath("//span[@class='dstp']")).size();
		System.out.println("Total Number of Flight are"+N);
				
		
		
		
	}
	
   
}
