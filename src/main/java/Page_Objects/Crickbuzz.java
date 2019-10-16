package Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Crickbuzz {

public WebDriver driver;

public Crickbuzz(WebDriver driver)
{
	this.driver=driver;
}
//Homepage
By Score_Table1=By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']");








//HOmepage_Methods

public WebElement getScoreTable()
{
	return driver.findElement(Score_Table1);
}

}
