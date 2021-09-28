package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPrincipalPagina extends ClasseBasePageObjec{

	public MenuPrincipalPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*/a[@href='http://demo-store.seleniumacademy.com/sale.html']")
	private WebElement menuSale;
	
	@FindBy(linkText = "View All Sale")
	private WebElement subMenuSale;
	
	public void selecionaMenu() {
		new Actions(driver).moveToElement(menuSale).perform();
		subMenuSale.click();
	}
	
}
