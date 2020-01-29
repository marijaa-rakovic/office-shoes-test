package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddToCartPage;
import pages.WomenShoesPage;

public class AddToCartTest extends BasicTest {

	private String baseUrl = "https://www.officeshoes.rs/";
	
	@Test (priority = 1)
	public void addShoeToCart() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
		WomenShoesPage womenShoesPage = PageFactory.initElements(driver, WomenShoesPage.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AddToCartPage addToCartPage = PageFactory.initElements(driver, AddToCartPage.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		womenShoesPage.clickOnWomenShoes();
		womenShoesPage.clickOnShoe();
		addToCartPage.scrollDownPage();
		
		addToCartPage.addToCart();
	}
	
	@Test (priority = 2)
	public void isItemsInCart() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
		AddToCartPage addToCartPage = PageFactory.initElements(driver, AddToCartPage.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		addToCartPage.goToCart();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		boolean b = addToCartPage.isCartNotEmpty();
		
		Assert.assertTrue(b);
	}
	
	
	
}
