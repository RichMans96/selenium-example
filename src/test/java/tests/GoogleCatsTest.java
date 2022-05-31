package tests;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleCatsTest {

	private final String URL = "https://images.google.com/";
	private static WebDriver driver;
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Before
	public void setup() {
		driver.get(URL);
	}
	
	
	@Test
	public void searchCatsTest() {
		WebElement accept = driver.findElement(By.id("L2AGLb"));
		WebElement search = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
		
		accept.click();
		search.sendKeys("cats");
		search.submit();
		
		WebElement image = driver.findElement(By.xpath("//*[@id=\"islrg\"]/div[1]/div[1]/a[1]/div[1]/img"));
		String imageAlt = image.getDomProperty("alt");
		
		assertTrue(imageAlt.contains("cat"));
	}
	
	
	@AfterClass
	public static void end() {
		driver.quit();
	}
}
