package tests;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.ClothesShop;

public class TshirtTests {

	private static WebDriver driver;
	private ClothesShop shop;

	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(false);
		driver = new ChromeDriver(options);
	}

	@Before
	public void setup() {
		driver.get(ClothesShop.URL);
		shop = PageFactory.initElements(driver, ClothesShop.class);
	}

	@Test
	public void tshirtToCheckoutTest() {
		shop.tshirtsBtnClick();
		shop.tshirtClick();
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.visibilityOf(shop.getAddToCart()));
		shop.addToCartClick();
		shop.proceedCheckoutClick();
		assertEquals("Faded Short Sleeve T-shirts", shop.getTshirtItem().getText());
	}

	@AfterClass
	public static void end() {
		driver.quit();
	}

}
