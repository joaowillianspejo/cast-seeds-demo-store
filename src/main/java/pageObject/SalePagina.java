package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalePagina extends ClasseBasePageObjec{

	public SalePagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*/a[@title='Racer Back Maxi Dress']")
	private WebElement linkProduto;
	
	public void selecionaProduto() {
		linkProduto.click();
	}
}
