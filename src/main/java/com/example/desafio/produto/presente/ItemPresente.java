package com.example.desafio.produto.presente;

import com.example.desafio.produto.Produto;

import javax.persistence.*;

@Entity
@Table(name = "presente_item")
public class ItemPresente {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "presente_id", nullable = false, foreignKey = @ForeignKey(name = "presente_item_presente_fk"))
    private Presente presente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_id", nullable = false, foreignKey = @ForeignKey(name = "presente_item_produto_fk"))
    private Produto produto;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Presente getPresente() {
        return presente;
    }

    public void setPresente(Presente presente) {
        this.presente = presente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
