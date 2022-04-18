package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ImmediateProductionConfirmationPage extends BasePage {

	public ImmediateProductionConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how=How.XPATH, using = "//button[span[normalize-space()='Apply']]")
	WebElement ApplyBtn;
	
	@FindBy(how=How.XPATH, using = "//div[@class='modal-content']//button[span[normalize-space()='Cancel']]")
	WebElement CancelBtn;

	
	public CreateManuFacturingOrderPage ClickOnOkButton() {
		ApplyBtn.click();
		return new CreateManuFacturingOrderPage(driver);
	}
}
