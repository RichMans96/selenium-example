package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatsWikiPage {
	
	@FindBy(id = "firstHeading")
	private WebElement firstHeading;

	public String getFirstHeading() {
		return firstHeading.getText();
	}
	
	
}
