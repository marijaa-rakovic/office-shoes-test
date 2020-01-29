package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasicPage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.CSS, using = ".text-input")
	WebElement searchInput;
	
	@FindBy(how = How.CSS, using = "a[href='https://www.officeshoes.rs/obuca-svi-modeli/3781']")
	WebElement sale;
	
	
	public void searchItem(String item) {
		this.searchInput.sendKeys(item);
		this.searchInput.sendKeys(Keys.ENTER);
	}
	
	public void clickOnSale() {
		sale.click();
	}

}
