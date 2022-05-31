package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiepediaHomepage {
	
	private static final String URL = "https://en.wikipedia.org/wiki/Main_Page";
	
	@FindBy(id = "searchInput")
	private WebElement searchBar;
	
	@FindBy(id = "Welcome_to_Wikipedia")
	private WebElement pageTitle;
	
	public void runSearch(String input) {
		searchBar.sendKeys(input);
		searchBar.submit();
	}

	public WebElement getSearchBar() {
		return searchBar;
	}

	public String getPageTitle() {
		return pageTitle.getText();
	}

	public static String getUrl() {
		return URL;
	}

}
