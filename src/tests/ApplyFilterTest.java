package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.FilterPage;

public class ApplyFilterTest extends BasicTest {

	
	private String baseUrl = "https://www.officeshoes.rs/";
	
	@Test
	public void isFilterChecked() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
		FilterPage filterPage = PageFactory.initElements(driver, FilterPage.class);
		
		filterPage.clickWomenShoes();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		filterPage.clickCookieButton();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		filterPage.scrollDownPage();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		filterPage.clickBuffaloFilter();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		boolean b = filterPage.isFilterApplied();
		
		Assert.assertTrue(b);
	}
}
