package pageObject;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import massaTeste.MassaTeste;
import massaTeste.Mensagens;

public class DetalhesComprasPagina extends ClasseBasePageObjec{

	public DetalhesComprasPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "country_id")
	private WebElement comboPais;
	
	@FindBy(name = "region_id")
	private WebElement comboEstado;
	
	@FindBy(name = "region")
	private WebElement campoEstado;
	
	@FindBy(name = "estimate_city")
	private WebElement campoCidade;
	
	@FindBy(name = "estimate_postcode")
	private WebElement campoCEP;

	@FindBy(xpath = "//*/div/button[@title='Estimate']")
	private WebElement botaoEstimate;
	
	@FindBy(id = "co-shipping-method-form")
	private WebElement formEscolhaFrete;
	
	@FindBys({@FindBy(name = "estimate_method")})
	private List<WebElement> radioFrete;
	
	@FindBy(name = "do")
	private WebElement botaoUpdateTotal;
	
	@FindBy(xpath = "//*/td[contains(text()='Shipping & Handling')]")
	private WebElement valorFrete;
	
	@FindBy(xpath = "//*/button[@title='Proceed to Checkout']")
	private WebElement botaoProceedToCheckout;
	
	@FindBy(className = "page-title")
	private WebElement tituloCheckout;
	
	public void estimaFrete() {
		String pais = MassaTeste.PAIS;
		
		Select selectPais = new Select(comboPais);
		Select selectEstado = new Select(comboEstado);
		
		selectPais.selectByVisibleText(pais);
		
		if(pais.contains("United States")) {
			selectEstado.selectByVisibleText(MassaTeste.ESTADO);
		}else {
			campoEstado.sendKeys(MassaTeste.ESTADO);
		}
		
		campoCidade.sendKeys(MassaTeste.CIDADE);
		campoCEP.sendKeys(MassaTeste.CEP);
		botaoEstimate.click();
	}
	
	public boolean verificaEstimaFrete() {
		return verificaMensagem(formEscolhaFrete, Mensagens.MSG_SUCESSO_ESTIMA_FRETE);
	}
	
	private int selecionaFreteRandomica() {
		Random random = new Random();
		return (random.nextInt(radioFrete.size()));
	}
		
	public void selecionaFrete() {
		radioFrete.get(selecionaFreteRandomica()).click();
	}
	
	public void clicaUpdateTotal() {
		botaoUpdateTotal.click();
	}
	
	public boolean verificaUpdateTotal() {
		return verificaMensagem(valorFrete, Mensagens.MSG_SUCESSO_UPDATE_TOTAL);
	}
	
	public void clicaProceedToCheckout() {
		botaoProceedToCheckout.click();
	}
	
	public boolean verificaCheckout() {
		return verificaMensagem(tituloCheckout, Mensagens.MSG_SUCESSO_CHECKOUT);
	}
}
