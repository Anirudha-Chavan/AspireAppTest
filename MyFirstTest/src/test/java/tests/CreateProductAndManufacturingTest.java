package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browserHelper.BaseTest;
import browserHelper.GetBrowser;
import pages.ConfirmationModalPage;
import pages.CreateManuFacturingOrderPage;
import pages.CreateProductPage;
import pages.ImmediateProductionConfirmationPage;
import pages.LoginPage;
import pages.ManufacturingOrdersListPage;
import pages.MenuNavigationPage;
import pages.MenuSelectionPage;
import pages.ProductsListPage;

public class CreateProductAndManufacturingTest extends BaseTest {

	WebDriver driver;

	@BeforeTest
	public void Setup() {
		GetBrowser browser = new GetBrowser();
		driver = browser.GetDriver("chrome");
		driver.get("https://aspireapp.odoo.com");
	}

	@Test
	@Parameters({"ProductName"})
	public void VerifyCreateProduct(String ProductName) {

		LoginPage loginPage = new LoginPage(driver);
		MenuSelectionPage menuSelectionPage = loginPage.Login("user@aspireapp.com", "@sp1r3app");
		menuSelectionPage.SelectInventoryMenu("Inventory");

		MenuNavigationPage navigationPage = new MenuNavigationPage(driver);
		ProductsListPage productsPage = navigationPage.ClickOnProductsMenuOption();
		CreateProductPage createProduct =productsPage.CreateProduct();
		createProduct.CreateProduct(ProductName);
		String actualMessage = createProduct.GetMessageAfterCreatingProduct();

		Assert.assertEquals(actualMessage, "Product Template created", "Product is not created");
	}

	@Test(dependsOnMethods = {"VerifyCreateProduct"})
	@Parameters({"ProductName", "Quantity"})
	public void VerifyCreateManufacturingOrder(String ProductName, String Quantity) {
		MenuNavigationPage navigationPage = new MenuNavigationPage(driver);
		MenuSelectionPage menuSelectionPage = navigationPage.ClickOnApplicationsIcon();
		ManufacturingOrdersListPage manufacturingPage = menuSelectionPage.SelectManufacturingMenu("Manufacturing");
		String actualBreadcrumbText = manufacturingPage.GetManufacturingOrdersBreadcrumbText();
		Assert.assertEquals(actualBreadcrumbText, "Manufacturing Orders");

		CreateManuFacturingOrderPage orderPage = manufacturingPage.ClickOnCreateOrderBtn();
		orderPage.SelectProductAndConfirm(ProductName, Quantity);
		
		String currentOrderState = orderPage.GetCurrentOrderState();
		Assert.assertEquals(currentOrderState, "confirmed", "Order is not marked as confirmed");
		
		ConfirmationModalPage modalPage = orderPage.ClickOnMarkAsDone();
		
		ImmediateProductionConfirmationPage productionConfirmPage = modalPage.ClickOnOkButton();
		orderPage = productionConfirmPage.ClickOnOkButton();
		orderPage.WaitForMarkAsDoneBtnToDisapper();
		
		currentOrderState = orderPage.GetCurrentOrderState();
		
		Assert.assertEquals(currentOrderState, "done", "Order is not marked as Done");
		
	}

	@AfterTest
	public void TearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}
}
