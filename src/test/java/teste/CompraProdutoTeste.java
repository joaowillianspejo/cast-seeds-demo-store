package teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CompraProdutoTeste extends ClasseBasseTeste{
	
	@Before
	public void antesDoTeste() {
		iniciaAplicacao();
	}
	
	@Test
	public void comprarProduto() {
		menuPrincipalPagina.selecionaMenu();
		salePagina.selecionaProduto();
		produtoPagina.selecionaAtributos();
		produtoPagina.clicaAddToCard();
		Assert.assertTrue(produtoPagina.verificaAddToCard());
		detalhesComprasPagina.estimaFrete();
		Assert.assertTrue(detalhesComprasPagina.verificaEstimaFrete());
		detalhesComprasPagina.selecionaFrete();
		detalhesComprasPagina.clicaUpdateTotal();
		//Assert.assertTrue(detalhesComprasPagina.verificaUpdateTotal());
		detalhesComprasPagina.clicaProceedToCheckout();
		//Assert.assertTrue(detalhesComprasPagina.verificaCheckout());
		checkoutPagina.clicaContinue();
		//Assert.assertTrue(checkoutPagina.verificaContinueCheckout());
		checkoutPagina.preencheBillingInformation();
		Assert.assertTrue(checkoutPagina.verificaContinueBilling());
		checkoutPagina.preencheShippingMethod();
		//Assert.assertTrue(checkoutPagina.verificaContinueShipping());
		checkoutPagina.clicaContinuePayment();
	}
}
