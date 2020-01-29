package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddToCartPage extends BasicPage {
	
	JavascriptExecutor js;

	public AddToCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.CSS, using = "li[data-product-size]") 
	List<WebElement> shoesSizes;
	
	@FindBy(className = "submit_button")
	WebElement addToCartBtn;
	
	@FindBy(how = How.CSS, using = "li a[title='Korpa']")
	WebElement cart;
	
	@FindBy(how = How.CSS, using = "table tr td .product_name")
	List<WebElement> itemsInCartTitles;
	
	public void addToCart() {
		shoesSizes.get(0).click();
		addToCartBtn.click();
	}
	
	public void scrollDownPage() {
		if (driver instanceof JavascriptExecutor) {
			js = (JavascriptExecutor) driver;
		}
		js.executeScript("window.scrollBy(0,250)");
	}
	
	public void goToCart() {
		cart.click();
	}
	
	public boolean isCartNotEmpty() {
		return itemsInCartTitles.size() > 0;
	}

}
