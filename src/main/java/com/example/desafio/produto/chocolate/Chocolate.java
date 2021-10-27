package com.example.desafio.produto.chocolate;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.desafio.produto.ProdutoGranel;

@Entity
@Table(name = "chocolate")
public class Chocolate extends ProdutoGranel {

}
