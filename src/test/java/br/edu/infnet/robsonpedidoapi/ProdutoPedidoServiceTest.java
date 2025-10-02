package br.edu.infnet.robsonpedidoapi;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.infnet.robsonpedidoapi.model.domain.Pedido;
import br.edu.infnet.robsonpedidoapi.model.domain.Produto;
import br.edu.infnet.robsonpedidoapi.model.domain.ProdutoPedido;
import br.edu.infnet.robsonpedidoapi.model.service.ProdutoPedidoService;

public class ProdutoPedidoServiceTest {

	private ProdutoPedidoService produtoPedidoService;
	
	@BeforeEach
	void setUp() {
		produtoPedidoService = new ProdutoPedidoService();
	}
	
	@Test
	@DisplayName("Deve lançar erro IllegalArgumentsException quando Produto for nulo.")
	void deveRetornarIllegalArgumentsException_QuandoProdutoForNulo() {
		//Dado
		Produto produto = null;
		
		Pedido pedido = new Pedido();
		pedido.setNomeCliente("Cliente 1");
		pedido.setNomeVendedor("Vendedor 1");
		
		ProdutoPedido produtoPedido = new ProdutoPedido();
		produtoPedido.setProduto(produto);
		produtoPedido.setPedido(pedido);
		produtoPedido.setQuantidade(2);
		
		//Quando
		//Então
		assertThrows(IllegalArgumentException.class, () -> produtoPedidoService.verificarDisponibilidade(produtoPedido));
	}
	
	@Test
	@DisplayName("Deve verificar a disponibilidade quando o qtdEstoque for maior que a quantidade ProdutoPedido.")
	void deveVerificarDisponibilidade_QuandoQuantidadeEstoqueForMaiorQueQuantidadeDoProdutoPedido() {
		//Dado
		Produto produto = new Produto("Empadão", "Massa com recheio saboroso.", new BigDecimal(10.5), true, 3);
		
		Pedido pedido = new Pedido();
		pedido.setNomeCliente("Cliente 1");
		pedido.setNomeVendedor("Vendedor 1");
		
		ProdutoPedido produtoPedido = new ProdutoPedido();
		produtoPedido.setProduto(produto);
		produtoPedido.setPedido(pedido);
		produtoPedido.setQuantidade(2);
		
		//Quando
		boolean resultado = produtoPedidoService.verificarDisponibilidade(produtoPedido);
		
		//Então
		assertTrue(resultado);
	}
	
	@Test
	@DisplayName("Deve verificar a disponibilidade quando o qtdEstoque for menor que a quantidade ProdutoPedido.")
	void deveVerificarDisponibilidade_QuandoQuantidadeEstoqueForMenorQueQuantidadeDoProdutoPedido() {
		//Dado
		Produto produto = new Produto("Empadão", "Massa com recheio saboroso.", new BigDecimal(10.5), true, 1);
		
		Pedido pedido = new Pedido();
		pedido.setNomeCliente("Cliente 1");
		pedido.setNomeVendedor("Vendedor 1");
		
		ProdutoPedido produtoPedido = new ProdutoPedido();
		produtoPedido.setProduto(produto);
		produtoPedido.setPedido(pedido);
		produtoPedido.setQuantidade(2);
		
		//Quando
		boolean resultado = produtoPedidoService.verificarDisponibilidade(produtoPedido);
		
		//Então
		assertFalse(resultado);
	}
	
	@Test
	@DisplayName("Deve verificar a disponibilidade quando o qtdEstoque for igual que a quantidade ProdutoPedido.")
	void deveVerificarDisponibilidade_QuandoQuantidadeEstoqueForIgualQueQuantidadeDoProdutoPedido() {
		//Dado
		Produto produto = new Produto("Empadão", "Massa com recheio saboroso.", new BigDecimal(10.5), true, 2);
		
		Pedido pedido = new Pedido();
		pedido.setNomeCliente("Cliente 1");
		pedido.setNomeVendedor("Vendedor 1");
		
		ProdutoPedido produtoPedido = new ProdutoPedido();
		produtoPedido.setProduto(produto);
		produtoPedido.setPedido(pedido);
		produtoPedido.setQuantidade(2);
		
		//Quando
		boolean resultado = produtoPedidoService.verificarDisponibilidade(produtoPedido);
		
		//Então
		assertTrue(resultado);
	}
	
}
