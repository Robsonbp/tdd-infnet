package br.edu.infnet.robsonpedidoapi.model.domain;

import java.math.BigDecimal;


public class Produto {
	
	private Integer id;
	
	private String nome;
	
	private String descricao;
	
	private BigDecimal valor;
	
	private boolean ativo;
	
	private int qtdEstoque;
	
	
	public Produto(String nome, String descricao, BigDecimal valor, boolean ativo, int qtdEstoque) {
		setNome(nome);
		setDescricao(descricao);
		setValor(valor);
		setAtivo(ativo);
		setQtdEstoque(qtdEstoque);
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	
}
