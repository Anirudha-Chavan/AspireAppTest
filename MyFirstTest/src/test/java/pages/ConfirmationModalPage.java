package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ConfirmationModalPage extends BasePage {

	public ConfirmationModalPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how=How.XPATH, using = "//div[@class='modal-content']//button[span[normalize-space()='Ok']]")
	WebElement OKBtn;
		
	@FindBy(how=How.XPATH, using = "//div[@class='modal-content']//button[span[normalize-space()='Cancel']]")
	WebElement CancelBtn;

	
	public ImmediateProductionConfirmationPage ClickOnOkButton() {
		OKBtn.click();
		return new ImmediateProductionConfirmationPage(driver);
	}
}
