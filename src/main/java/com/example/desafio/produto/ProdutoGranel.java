package com.example.desafio.produto;

import javax.persistence.Column;

public abstract class ProdutoGranel extends Produto {

	 @Column(name = "peso", nullable = false)
	 private Double peso;
	 
	 @Column(name = "precoPorQuilograma", nullable = false)
	 private Double precoPorQuilograma;

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getPrecoPorQuilograma() {
		return precoPorQuilograma;
	}

	public void setPrecoPorQuilograma(Double precoPorQuilograma) {
		this.precoPorQuilograma = precoPorQuilograma;
	}   
}
