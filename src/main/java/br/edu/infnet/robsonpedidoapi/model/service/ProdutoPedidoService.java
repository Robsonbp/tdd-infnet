package br.edu.infnet.robsonpedidoapi.model.service;

import br.edu.infnet.robsonpedidoapi.model.domain.ProdutoPedido;

public class ProdutoPedidoService {
	
	public boolean verificarDisponibilidade(ProdutoPedido produtoPedido) {
		
		if (produtoPedido.getProduto() == null) {
			throw new IllegalArgumentException("Não é possível verificar disponibilidade, pois o Produto está nulo");
		}
		
		if (produtoPedido.getProduto().getQtdEstoque() < produtoPedido.getQuantidade()) {
			return false;
		}
		
		return true;
	}
}
