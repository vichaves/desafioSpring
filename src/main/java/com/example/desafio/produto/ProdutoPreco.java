package com.example.desafio.produto;

import javax.persistence.Column;

public abstract class ProdutoPreco extends Produto{
    @Column(name = "preco", nullable = false)
    private Double preco;

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
