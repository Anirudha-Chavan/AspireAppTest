package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductsListPage extends BasePage {

	public ProductsListPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.CSS, using = "button[title='Create record']")
	WebElement CreateProductBtn;

	public CreateProductPage CreateProduct() {
		CreateProductBtn.click();
		return new CreateProductPage(driver);
	}

}
