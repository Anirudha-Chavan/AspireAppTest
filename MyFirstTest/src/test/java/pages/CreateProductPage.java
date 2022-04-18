package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateProductPage extends BasePage {

	public CreateProductPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.XPATH, using = "//input[@name='name']")
	WebElement ProductNameTxtBx;

	@FindBy(how=How.CSS, using = "button[title='Save record']")
	WebElement SaveBtn;

	@FindBy(how=How.CSS, using = "div[class='o_Message_prettyBody'] p")
	WebElement MessageBody;


	public void CreateProduct(String productName) {
		ProductNameTxtBx.sendKeys(productName);
		SaveBtn.click();
	}

	public String GetMessageAfterCreatingProduct() {
		return MessageBody.getText();
	}
}
