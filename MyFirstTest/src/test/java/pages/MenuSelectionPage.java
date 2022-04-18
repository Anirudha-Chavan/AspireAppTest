package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MenuSelectionPage extends BasePage{
	@FindBy(how=How.XPATH, using = "//a[div[text()='Inventory']]")
	WebElement InVentoryMenuOption;

	@FindBy(how=How.XPATH, using = "//a[div[text()='Manufacturing']]")
	WebElement ManufacturingMenuOption;

//	String optionMenuXpath = "//div[text()='{replaceText}']";

	public MenuSelectionPage(WebDriver driver) {
		super(driver);
	}

	public InventoryOverviewPage SelectInventoryMenu(String menuOptionName) {
//		optionMenuXpath = optionMenuXpath.replace("{replaceText}", menuOptionName);
//		driver.findElement(By.xpath(optionMenuXpath)).click();
		InVentoryMenuOption.click();
		return new InventoryOverviewPage(driver);
	}

	public ManufacturingOrdersListPage SelectManufacturingMenu(String menuOptionName) {
		ManufacturingMenuOption.click();
		return new ManufacturingOrdersListPage(driver);
	}

}
