package com.OnlineTravel;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page_Objects.Home_Page;

public class Train extends Driver {

@BeforeTest
public void Opening_Page() throws IOException 
{
	driver=initializeDriver();
	driver.get(Prop.getProperty("Url"));
	driver.manage().window().maximize();
	

}

/*@AfterTest
public void Closing_Page()
{
   driver.close();
   driver=null;
}*/

@Test(enabled=false)
public void Train_Travel() throws InterruptedException
{
	Home_Page HP = new Home_Page(driver);
	/*WebElement Next_Button = HP.Next_Button_Click();
	System.out.println(Next_Button.getTagName());
	Wait=Add_Wait();
	Wait.until*/
	Thread.sleep(2000);
    //HP.Next_Button_Click().click();
    HP.Train_Click().click();
    HP.Train_Origin().click();
}

}
