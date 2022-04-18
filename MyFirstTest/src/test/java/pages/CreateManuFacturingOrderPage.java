package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateManuFacturingOrderPage extends BasePage {

	public CreateManuFacturingOrderPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//div[@name='product_id']//div[@class='o_input_dropdown']/input")
	WebElement ProductSelectionDropDown;

	@FindBy(how = How.XPATH, using = "(//div//input[@name='product_qty'])[1]")
	WebElement QuantityDropDown;

	@FindBy(how = How.XPATH, using = "//div//input[@name='qty_producing']")
	WebElement QuantityDropDownAfterClear;

	@FindBy(how = How.XPATH, using = "//button[@name='action_confirm']")
	WebElement ConfirmButton;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary']")
	WebElement MarkAsDoneBtn;

	@FindBy(how = How.XPATH, using = "//button[@title='Current state']")
	WebElement OrderCurrentState;
	
	@FindBy(how = How.XPATH, using = "//li[@class='ui-menu-item'] ")
	List<WebElement> ProductList;
	
	@FindBy(how = How.CSS, using = "button[title='Save record']")
	WebElement SaveBtn;
	
	

	public void SelectProductAndConfirm(String productName, String quantity) {
		ProductSelectionDropDown.sendKeys(productName);
		wait.until(ExpectedConditions.elementToBeClickable(ProductList.get(0)));
		ProductList.get(0).click();

		QuantityDropDown.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
		QuantityDropDown.sendKeys(quantity);
		wait.until(ExpectedConditions.elementToBeClickable(ConfirmButton)).click();
		wait.until(ExpectedConditions.elementToBeClickable(MarkAsDoneBtn));
	}

	public ConfirmationModalPage ClickOnMarkAsDone() {
		wait.until(ExpectedConditions.elementToBeClickable(MarkAsDoneBtn)).click();
		return new ConfirmationModalPage(driver);
	}

	public String GetCurrentOrderState() {
		String currentOrderState = OrderCurrentState.getAttribute("data-value");
		return currentOrderState;
	}

	public void WaitForMarkAsDoneBtnToDisapper() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfAllElements(MarkAsDoneBtn));
	}
	
	public void ClickOnSaveBtn() {
		SaveBtn.click();
	}
}
