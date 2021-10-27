package com.example.desafio.produto.presente;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.desafio.produto.ProdutoPreco;

@Entity
@Table(name = "presente")
public class Presente extends ProdutoPreco {

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<ItemPresente> itensPresente = new ArrayList<>();

    public List<ItemPresente> getItensPresente() {
        return itensPresente;
    }
}
