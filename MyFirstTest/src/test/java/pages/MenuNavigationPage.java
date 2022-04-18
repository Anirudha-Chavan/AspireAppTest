package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuNavigationPage extends BasePage{


	public MenuNavigationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.CSS, using = "button[title='Products']")
	WebElement ProductsButton;

	@FindBy(how=How.XPATH, using = "//a[text()='Products']")
	WebElement ProductsMenuOption;

	@FindBy(how=How.XPATH, using = "//a[@title='Home menu']")
	WebElement HomeMenu;


	public ProductsListPage ClickOnProductsMenuOption() {
		ProductsButton.click();
		ProductsMenuOption.click();
		return new ProductsListPage(driver);
	}

	public MenuSelectionPage ClickOnApplicationsIcon() {
		HomeMenu.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='listbox']")));
		return new MenuSelectionPage(driver);
	}
}
