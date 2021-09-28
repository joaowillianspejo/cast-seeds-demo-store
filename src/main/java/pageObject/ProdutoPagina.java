package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import massaTeste.MassaTeste;
import massaTeste.Mensagens;

public class ProdutoPagina extends ClasseBasePageObjec{

	public ProdutoPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "purple")
	private WebElement botaoColor;
	
	@FindBy(name = "l")
	private WebElement botaoSize;
	
	@FindBy(name = "qty")
	private WebElement campoQty;
	
	@FindBy(xpath = "//*/div[@class='add-to-cart-buttons']/button[@title='Add to Cart']")
	private WebElement botaoAddToCard;
	
	@FindBy(className = "success-msg")
	private WebElement msgSucessoAddToCard;
	
	public void selecionaAtributos() {
		botaoColor.click();
		botaoSize.click();
		campoQty.clear();
		campoQty.sendKeys(MassaTeste.QTD);
	}
	
	public void clicaAddToCard() {
		botaoAddToCard.click();
	}
	
	public boolean verificaAddToCard() {
		return verificaMensagem(msgSucessoAddToCard, Mensagens.MSG_SUCESSO_ADD_TO_CARD);
	}

}
