package br.edu.infnet.robsonpedidoapi.model.domain;

import java.util.List;

public class Pedido {
	private String nomeCliente;
	private String nomeVendedor;
	private List<ProdutoPedido> produtosPedido;
	
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getNomeVendedor() {
		return nomeVendedor;
	}
	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}
	public List<ProdutoPedido> getProdutosPedido() {
		return produtosPedido;
	}
	public void setProdutosPedido(List<ProdutoPedido> produtosPedido) {
		this.produtosPedido = produtosPedido;
	}
}
