package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage{

	@FindBy(how=How.XPATH, using = "//input[@name='login']")
	WebElement EmailTextBox;

	@FindBy(how=How.XPATH, using = "//input[@name='password']")
	WebElement PasswordTextBox;

	@FindBy(how=How.XPATH, using = "//button[@type='submit']")
	WebElement LoginButton;

	public LoginPage(WebDriver driver){
		super(driver);
	}


	public MenuSelectionPage Login(String email, String password) {
		EmailTextBox.sendKeys(email);
		PasswordTextBox.sendKeys(password);
		LoginButton.click();
		return new MenuSelectionPage(driver);
	}
}
