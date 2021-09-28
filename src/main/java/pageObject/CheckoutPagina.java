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

public class CheckoutPagina extends ClasseBasePageObjec{

	public CheckoutPagina(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "onepage-guest-register-button")
	private WebElement botaoContinue1;
	
	@FindBy(id = "opc-billing")
	private WebElement sessao2;
	
	@FindBy(name = "billing[firstname]")
	private WebElement campoNome;
	
	@FindBy(name = "billing[middlename]")
	private WebElement campoNomeDoMeio;
	
	@FindBy(name = "billing[lastname]")
	private WebElement campoSobrenome;
	
	@FindBy(name = "billing[company]")
	private WebElement campoEmpresa;
	
	@FindBy(name = "billing[email]")
	private WebElement campoEmail;
	
	@FindBy(id = "billing:street1")
	private WebElement campoEndereco;
	
	@FindBy(id = "billing:street2")
	private WebElement campoEndereco2;
	
	@FindBy(name = "billing[city]")
	private WebElement campoCidade;
	
	@FindBy(name = "billing[region_id]")
	private WebElement comboEstado;
	
	@FindBy(name = "billing[region]")
	private WebElement campoEstado;
	
	@FindBy(name = "billing[postcode]")
	private WebElement campoCEP;
	
	@FindBy(name = "billing[country_id]")
	private WebElement comboPais;
	
	@FindBy(name = "billing[telephone]")
	private WebElement campoTelefone;
	
	@FindBy(name = "billing[fax]")
	private WebElement campoFax;
	
	@FindBy(xpath = "//*/div[@id = 'billing-buttons-container']/button")
	private WebElement botaoContinueBilling;
	
	@FindBy(id = "checkout-step-shipping_method")
	private WebElement sessao4;
	
	@FindBys({@FindBy(name = "shipping_method")})
	private List<WebElement> radioFrete;
	
	@FindBy(name = "allow_gift_messages")
	private WebElement checkAddGift;
	
	@FindBy(name = "allow_gift_messages_for_order")
	private WebElement checkForOrder;
	
	@FindBy(name = "allow_gift_messages_for_items")
	private WebElement checkForItems;
	
	@FindBy(xpath = "//*/div[@id = 'shipping-method-buttons-container']/button")
	private WebElement botaoContinueShipping;
	
	@FindBy(id = "dt_method_cashondelivery")
	private WebElement sessao5;
	
	@FindBy(xpath = "//*[@id='payment-buttons-container']/button")
	private WebElement botaoContinuePayment;
	
	public void clicaContinue() {
		botaoContinue1.click();
	}
	
	public boolean verificaContinueCheckout() {
		return verificaMensagem(sessao2, Mensagens.MSG_SUCESSO_BILLINGINFORMATION);
	}
	
	public void preencheBillingInformation() {
		String pais = MassaTeste.PAIS;
		
		campoNome.sendKeys(MassaTeste.NOME);
		campoNomeDoMeio.sendKeys(MassaTeste.NOME_DO_MEIO);
		campoSobrenome.sendKeys(MassaTeste.SOBRENOME);
		campoEmpresa.sendKeys(MassaTeste.EMPRESA);
		campoEmail.sendKeys(MassaTeste.EMAIL);
		campoEndereco.sendKeys(MassaTeste.ENDERECO);
		campoEndereco2.sendKeys(MassaTeste.ENDERECO2);
		campoCidade.sendKeys(MassaTeste.CIDADE);
		
		Select select = new Select(comboPais);
		select.selectByVisibleText(pais);
		
		select = new Select(comboEstado);
		
		if(pais.contains("United States") || pais.contains("Canada") || pais.contains("France") || pais.contains("Spain") || pais.contains("Germany") || pais.contains("Estonia") || pais.contains("Lithuania") || pais.contains("Romania") || pais.contains("Finland") || pais.contains("Latvia") || pais.contains("Switzerland")) {
			select.selectByVisibleText(MassaTeste.ESTADO);
		}else {
			campoEstado.sendKeys(MassaTeste.ESTADO);
		}
		
		campoCEP.sendKeys(MassaTeste.CEP);
		campoTelefone.sendKeys(MassaTeste.TELEFONE);
		campoFax.sendKeys(MassaTeste.FAX);
		botaoContinueBilling.click();
		
	}
	
	public boolean verificaContinueBilling() {
		return verificaMensagem(sessao4, Mensagens.MSG_SUCESSO_SHIPPING_METHOD);
	}
	
	public int selecionaFreteRandomica() {
		Random random = new Random();
		return (random.nextInt(radioFrete.size()));
	}
	
	public void preencheShippingMethod() {
		radioFrete.get(selecionaFreteRandomica()).click();
		checkAddGift.click();
		checkForOrder.click();
		checkForItems.click();
		botaoContinueShipping.click();
	}

	public boolean verificaContinueShipping() {
		return verificaMensagem(sessao5, Mensagens.MSG_SUCESSO_PAYMENT_INFORMATION);
	}
	
	public void clicaContinuePayment() {
		botaoContinuePayment.click();
	}
	
}
