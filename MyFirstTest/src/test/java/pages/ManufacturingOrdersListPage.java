package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ManufacturingOrdersListPage extends BasePage {

	public ManufacturingOrdersListPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.CSS, using = ".breadcrumb-item.active span")
	WebElement ManufacturingOrdersText;

	@FindBy(how=How.XPATH, using = "//button[normalize-space()='Create']")
	WebElement CreateOrderBtn;



	public String GetManufacturingOrdersBreadcrumbText() {
		return ManufacturingOrdersText.getText();
	}

	public CreateManuFacturingOrderPage ClickOnCreateOrderBtn() {
		CreateOrderBtn.click();
		return new CreateManuFacturingOrderPage(driver);
	}

}
