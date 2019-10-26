package Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Game_Of_Life {

	
	public WebDriver driver;
public Game_Of_Life(WebDriver driver)
{
	this.driver=driver;
}

//Game_Of_Life
By New_Game_Button = By.xpath("//div[@class='action-button']/a");

	
public WebElement  GOL_Button()
{
	return driver.findElement(New_Game_Button);
}
	
}
