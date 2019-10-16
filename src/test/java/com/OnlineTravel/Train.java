package com.OnlineTravel;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page_Objects.Home_Page;

public class Train extends Driver {

@BeforeTest(enabled=false)
public void Opening_Page() throws IOException 
{
	driver=initializeDriver();
	driver.get(Prop.getProperty("Url"));
	//driver.manage().window().maximize();
	

}

@AfterTest(enabled=false)
public void Closing_Page()
{
   driver.close();
   driver=null;
}

@Test(enabled=false)
public void Train_Travel() throws InterruptedException
{
	Home_Page HP = new Home_Page(driver);
    Wait=Add_Wait();
	Wait.until(ExpectedConditions.elementToBeClickable(HP.Train_Click()));
	//Thread.sleep(2000);
    Action = Add_Action();
    //Action.moveToElement(Next_Button).click().perform();
    System.out.println(HP.Train_Click().isEnabled());
	HP.Train_Click().click();
    driver.manage().window().maximize();
	Wait.until(ExpectedConditions.elementToBeClickable(HP.Train_Origin()));
    HP.Train_Origin().click();
    HP.Train_Origin().sendKeys("SBC");
    Wait.until(ExpectedConditions.textToBePresentInElement(HP.Station_Code(), "SBC"));
    Action.sendKeys(Keys.ENTER).perform();
    HP.Destination_Selection().click();
    HP.Destination_Selection().sendKeys("BBS");
    Wait.until(ExpectedConditions.textToBePresentInElement(HP.Station_Code(),"BBS"));
    Action.sendKeys(Keys.ENTER).perform();
}

}
