package Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page {
    
	
	public WebDriver driver;
	//Flight
	By Flight =By.cssSelector("span[class='demo-icon icon-flights']");
	By Origin = By.cssSelector("input[name='flight_origin']");
	By Airport_Name = By.xpath("//*[text()='Indira Gandhi International']");
	By Destination = By.cssSelector("input[name='flight_destination']");
	By Depart_Date = By.cssSelector("input[name='flight_origin_date']");
	By Departure_Date = By.cssSelector("td[title='Monday, 30 September 2019']");
	By Traveller = By.cssSelector("label[class='travellerLabel']");
	By No_Of_Traveller = By.cssSelector("span[class='ddSpinnerPlus']");
	By Traveller_Count = By.cssSelector("span[class='adultcount']");
	By Submit = By.cssSelector("input[id='BE_flight_flsearch_btn']");
	By Flight_Count = By.xpath("//span[@class='dstp']");
	//Cruise
	By Cruise_Travel = By.xpath("//a[@id='booking_engine_cruise']/span");
	By River = By.xpath("//div[@class='multiselect__tags']/span");
	By Heading = By.cssSelector("span[class='main-heading']");
	By Singapore_Malaysia_Cruise = By.xpath("//a[@title='SINGAPORE MALAYSIA DREAM CRUISE ']/div/img");
	By Heading2 = By.cssSelector("h2[class='ng-binding']");
	By Singapore_Cruise_Price = By.cssSelector("span[class='price ng-binding']");
	
	//Train
	By NextButton = By.xpath("//span[@class='listTransformBtn buttonNext']");
	By Train_Button = By.cssSelector("span[class='demo-icon icon-trains']");
	By Train_Origin = By.cssSelector("input[id='BE_train_from_station']");
	
	
	
	//Flight
	public Home_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public WebElement Flight_Click() 
	{
		return driver.findElement(Flight);
	}
	
	public WebElement Origin_Selector()
	{
		return driver.findElement(Origin);
	}
	
	public WebElement Airport_Validation()
	{
		return driver.findElement(Airport_Name);
	}

    public WebElement Destination_Selector() 
    {
    	return driver.findElement(Destination);
    }

    public WebElement Depart_Date_Selector()
    {
    	return driver.findElement(Depart_Date);
    }
    
    public WebElement Departure_Date_Selector()
    {
    	return driver.findElement(Departure_Date);
    }
    public WebElement Traveller_Selector()
    {
    	return driver.findElement(Traveller);
    }

    public WebElement No_OF_Traveller()
    {
    	return driver.findElement(No_Of_Traveller);
    }

    public WebElement Traveller_Count_validate()
    {
    	return driver.findElement(Traveller_Count);
    }

   public WebElement Submit() 
   {
	   return driver.findElement(Submit);
   }

   public WebElement Flight_Count()
   {
	   return driver.findElement(Flight_Count);
   }

   //Cruise
   public WebElement Cruise_Travel()
   {
	   return driver.findElement(Cruise_Travel);
   }

   public WebElement River_Selector() 
   {
	   return driver.findElement(River);
   }
   public WebElement Main_Heading()
   {
	   return driver.findElement(Heading);
   }

   public WebElement Singapore_Malaysia_Cruise()
   {
	   return driver.findElement(Singapore_Malaysia_Cruise);
   }

   public WebElement Singapore_Cruise_Page()
		   {
	         return driver.findElement(Heading2);
		   }


   public WebElement Singapore_Cruise_Price()
   {
	   return driver.findElement(Singapore_Cruise_Price);
   }

 //Train
  public WebElement Next_Button_Click()
  {
	  return driver.findElement(NextButton);
  }
  public WebElement Train_Click()
  {
	  return driver.findElement(Train_Button);
  }

  public WebElement Train_Origin() 
  {
	  return driver.findElement(Train_Origin);
  }

}
