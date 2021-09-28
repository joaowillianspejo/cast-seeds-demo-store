package teste;

import org.openqa.selenium.WebDriver;

import configuracoes.DriverFactory;
import configuracoes.Configuracoes;
import pageObject.CheckoutPagina;
import pageObject.DetalhesComprasPagina;
import pageObject.MenuPrincipalPagina;
import pageObject.ProdutoPagina;
import pageObject.SalePagina;

public class ClasseBasseTeste {
	protected WebDriver driver;
	protected MenuPrincipalPagina menuPrincipalPagina;
	protected SalePagina salePagina;
	protected ProdutoPagina produtoPagina;
	protected DetalhesComprasPagina detalhesComprasPagina;
	protected CheckoutPagina checkoutPagina;
	
	public void iniciaAplicacao() {
		driver = DriverFactory.createDriver(Configuracoes.BROWSER);
		driver.manage().window().maximize();
		driver.get(Configuracoes.URL_APLICACAO);
		
		menuPrincipalPagina = new MenuPrincipalPagina(driver);
		salePagina = new SalePagina(driver);
		produtoPagina = new ProdutoPagina(driver);
		detalhesComprasPagina = new DetalhesComprasPagina(driver);
		checkoutPagina = new CheckoutPagina(driver);
	}
	
	public void finalizaAplicacao() {
		driver.quit();
	}
}
