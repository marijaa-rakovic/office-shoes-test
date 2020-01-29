package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FilterPage extends BasicPage {

	public FilterPage(WebDriver driver) {
		super(driver);
	}
	
	JavascriptExecutor js;
	
	@FindBy(how = How.CSS, using = "a[href='/obuca-zenska-obuca/1/48/order_asc']")
	WebElement womenShoes;
	
	@FindBy (how = How.CSS, using = ".brand li[rel='brand:Buffalo;']")
	WebElement brandFilterBuffalo;
	
	@FindBy (how = How.CSS, using = ".product-article .img-responsive")
	List<WebElement> title;
	
	@FindBy (className = "cookie-button")
	WebElement cookieButton;
	
	public void clickWomenShoes() {
		womenShoes.click();
	}
	
	public void clickBuffaloFilter() {
		brandFilterBuffalo.click();
	}
	
	public void clickCookieButton() {
		cookieButton.click();
	}
	
	public boolean isFilterApplied() {
		String[] titles = new String[title.size()];
		
		for (int i = 0; i < title.size(); i++) {
			titles[i] = title.get(0).getAttribute("alt").toString();
		}
		
		boolean isTitleStartingWithBuffalo = false;
		
		for (int i = 0; i < titles.length; i++) {
			if (titles[i].startsWith("Buffalo")) {
				isTitleStartingWithBuffalo = true;
			}
		}
		
		return isTitleStartingWithBuffalo;
	}
	
	public void scrollDownPage() {
		if (driver instanceof JavascriptExecutor) {
			js = (JavascriptExecutor) driver;
		}
		js.executeScript("window.scrollBy(0,1000)");
	}

}
