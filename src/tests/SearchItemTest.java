package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.HomePage;

public class SearchItemTest extends BasicTest {

	private String baseUrl = "https://www.officeshoes.rs/";

	@Test (priority = 1)
	public void searchForItem() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		HomePage hpage = PageFactory.initElements(driver, HomePage.class);

		hpage.searchItem("kitten");
	}
	
	@Test (priority = 2)
	public void openSalePage() {
		driver.get(baseUrl);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		HomePage hpage = PageFactory.initElements(driver, HomePage.class);
		hpage.clickOnSale();
		
	}
	
}
