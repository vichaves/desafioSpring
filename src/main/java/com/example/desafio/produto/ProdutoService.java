package com.example.desafio.produto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio.produto.dto.CatalogoDTO;

@Service
@Transactional
public class ProdutoService {

    @Autowired private ProdutoRepository repository;

    public List<CatalogoDTO> getTop10Notas() {
        final List<Produto> listaProdutos = new ArrayList<>();
    	final List<CatalogoDTO> listaCatalogo = new ArrayList<>();
        repository.findAll().forEach(listaProdutos::add);
        listaProdutos.stream().forEach((produto) -> {
        	CatalogoDTO catalogo = new CatalogoDTO();
        	catalogo.setMediaNotas(produto.getNota().stream().mapToDouble(Double::doubleValue).average().getAsDouble());
        	catalogo.setNome(produto.getNome());
        	listaCatalogo.add(catalogo);
        });
        return listaCatalogo.stream()
        	.sorted((c1, c2) -> c2.getMediaNotas().compareTo(c1.getMediaNotas())).limit(10)
        	.collect(Collectors.toList());
    }
}
