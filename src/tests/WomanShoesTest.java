package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.WomenShoesPage;

public class WomanShoesTest extends BasicTest {
	private String baseUrl = "https://www.officeshoes.rs/";

	@Test(priority = 1)
	public void countShoes() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WomenShoesPage womenShoesPage = PageFactory.initElements(driver, WomenShoesPage.class);

		womenShoesPage.clickOnWomenShoes();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		womenShoesPage.selectPagination96();

		int numOfShoes = womenShoesPage.countShoes();

		Assert.assertEquals(numOfShoes, 96);

	}

	@Test(priority = 2)
	public void highestPrice() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WomenShoesPage womenShoesPage = PageFactory.initElements(driver, WomenShoesPage.class);

		womenShoesPage.clickOnWomenShoes();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		double price = womenShoesPage.findHighestPrice();
		System.out.println(price + " je najveca cena");
	}
	
	@Test (priority = 3)
	public void isSortingByPriceWorking() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WomenShoesPage womenShoesPage = PageFactory.initElements(driver, WomenShoesPage.class);
		
		womenShoesPage.clickOnWomenShoes();
		
		boolean b = womenShoesPage.isSortingWorking();
		
		Assert.assertTrue(b);
	}

}
