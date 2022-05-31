package tests;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import pages.CatsWikiPage;
import pages.WikiepediaHomepage;

public class GettingStartedTests {

	private static WebDriver driver;
	private WikiepediaHomepage home;
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(false);
		driver = new ChromeDriver(options);
	}

	@Before
	public void setup() {
		driver.get(WikiepediaHomepage.getUrl());
		this.home = PageFactory.initElements(driver, WikiepediaHomepage.class);
	}

	@Test
	public void webpageTitleTest() {
		assertEquals("Welcome to Wikipedia", home.getPageTitle());
	}

	@Test
	public void searchForCats() throws InterruptedException {
		home.runSearch("Cats");
		
		CatsWikiPage catsPage = PageFactory.initElements(driver, CatsWikiPage.class);
		
		assertEquals("Cat", catsPage.getFirstHeading());
	}

	@AfterClass
	public static void end() {
		driver.quit();
	}

}
