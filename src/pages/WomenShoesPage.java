package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class WomenShoesPage extends BasicPage {

	public WomenShoesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "a[href='/obuca-zenska-obuca/1/48/order_asc']")
	WebElement womenShoes;

	@FindBy(className = "pagination_options_select")
	WebElement pagination;
	
	@FindBy(name = "order")
	WebElement sortShoes;

	@FindBy(className = "product-article")
	List<WebElement> shoes;

	@FindBy(how = How.CSS, using = ".product-article .price")
	List<WebElement> shoePrices;

	public void clickOnWomenShoes() {
		womenShoes.click();
	}

	public void selectPagination96() {
		Select selectPag = new Select(pagination);
		selectPag.selectByVisibleText("96 proizvoda");
	}

	public int countShoes() {
		return shoes.size();
	}
	
	public void selectOrderHighestFirst() {
		Select selectOrder = new Select(sortShoes);
		selectOrder.selectByValue("price_desc");
	}

	public double findHighestPrice() {
		double[] doublePrices = new double[shoePrices.size()];
		double highestPrice = 0;

		for (int i = 0; i < shoePrices.size(); i++) {
			String s = shoePrices.get(i).getText();
			doublePrices[i] = Double.parseDouble(s.replace(',', '.').substring(0, s.length() - 3));
		}

		for (int i = 1; i < doublePrices.length; i++) {
			highestPrice = doublePrices[0];

			if (doublePrices[i] > highestPrice) {
				highestPrice = doublePrices[i];
			}
		}

		return highestPrice;
	}
	
	public boolean isSortingWorking() {
		
		selectOrderHighestFirst();
		double highestPrice = findHighestPrice();
		
		String s = shoePrices.get(0).getText();
				
		double firstShoesPrice = Double.parseDouble(s.replace(',', '.').substring(0, s.length() - 3));
		
		return highestPrice == firstShoesPrice;
	}
	
	public void clickOnShoe() {
		shoes.get(0).click();
	}

}
