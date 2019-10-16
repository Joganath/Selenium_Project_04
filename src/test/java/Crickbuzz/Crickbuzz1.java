package Crickbuzz;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page_Objects.Crickbuzz;

public class Crickbuzz1 extends com.OnlineTravel.Driver  {

	
	
	
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
	public void Scoreboard() 
	{
		Crickbuzz CB = new Crickbuzz(driver);
	    System.out.println(CB.getScoreTable().findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).size());
	}    
	
}
